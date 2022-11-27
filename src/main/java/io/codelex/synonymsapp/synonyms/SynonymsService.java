package io.codelex.synonymsapp.synonyms;

import io.codelex.synonymsapp.synonyms.dto.Definition;
import io.codelex.synonymsapp.synonyms.dto.Meaning;
import io.codelex.synonymsapp.synonyms.dto.Word;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SynonymsService {

    public Set<String> getAllSynonyms(String word) {
        WebClient webClient = WebClient.create();
        String resourceUrl = "https://api.dictionaryapi.dev/api/v2/entries/en/" + word;
        Word[] fullWordInfo;
        try {
            fullWordInfo = webClient.get()
                    .uri(resourceUrl)
                    .retrieve()
                    .bodyToMono(Word[].class)
                    .block();
        } catch (WebClientResponseException e) {
            String responseBody = e.getResponseBodyAsString();
            String err = StringUtils.substringBetween(responseBody, ":\"", "\"");
            return Collections.singleton(err);
        }
        if (fullWordInfo == null) {
            return new HashSet<>();
        } else {
            return getSynonymsFromWord(fullWordInfo);
        }
    }

    private Set<String> getSynonymsFromWord(Word[] word) {
        Set<String> outerSynonyms = word[0].getMeanings()
                .stream()
                .map(Meaning::getSynonyms)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        Set<String> innerSynonyms = word[0].getMeanings()
                .stream()
                .map(Meaning::getDefinitions)
                .flatMap(Collection::stream)
                .map(Definition::getSynonyms)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        return Stream.of(outerSynonyms, innerSynonyms)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }
}
