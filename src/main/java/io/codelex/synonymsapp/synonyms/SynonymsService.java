package io.codelex.synonymsapp.synonyms;

import io.codelex.synonymsapp.synonyms.dto.Word;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.*;

@Service
public class SynonymsService {

    @Value("${synonyms.external-api-url}")
    private String externalApiUrl;

    public Set<String> getAllSynonyms(String word) {
        try {
            Word[] fullWordInfoArray = getDataFromExternalApi(word);
            Word fullWordInfo = fullWordInfoArray[0];
            return getSynonymsFromWord(fullWordInfo);
        } catch (WebClientResponseException e) {
            return Set.of("Word not found");
        }
    }

    public Word[] getDataFromExternalApi(String word) {
        return WebClient.create(externalApiUrl + word)
                .get()
                .retrieve()
                .bodyToMono(Word[].class)
                .block();
    }

    private Set<String> getSynonymsFromWord(Word fullWordInfo) {
        Set<String> synonyms = new HashSet<>();
        fullWordInfo.getMeanings()
                .forEach(m -> synonyms.addAll(m.getSynonyms()));
        fullWordInfo.getMeanings()
                .forEach(m -> m.getDefinitions().forEach(d -> synonyms.addAll(d.getSynonyms())));
        return synonyms;
    }
}