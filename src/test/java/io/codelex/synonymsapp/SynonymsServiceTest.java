package io.codelex.synonymsapp;

import io.codelex.synonymsapp.synonyms.SynonymsService;
import io.codelex.synonymsapp.synonyms.dto.Definition;
import io.codelex.synonymsapp.synonyms.dto.Meaning;
import io.codelex.synonymsapp.synonyms.dto.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class SynonymsServiceTest {

    private final String synonym1 = "plus-size";
    private final String synonym2 = "jumbo";
    private final String synonym3 = "large";
    private final String synonym4 = "busty";

    @Spy
    SynonymsService synonymsService;

    @Test
    public void allSynonymsShouldBeReturned() {
        Word[] expectedWordArray = setupWordArray();
        Mockito.doAnswer(invocation -> expectedWordArray)
                .when(synonymsService)
                .getDataFromExternalApi(Mockito.any(String.class));
        String name = "big";
        Set<String> result = synonymsService.getAllSynonyms(name);
        Set<String> expectedResult = Set.of(synonym1, synonym2, synonym3, synonym4);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void errorMessageShouldBeReturnedWhenWordNotFound() {
        Mockito.doThrow(WebClientResponseException.class)
                .when(synonymsService)
                .getDataFromExternalApi(Mockito.any(String.class));
        String name = "cupakabra";
        ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class,
                () -> synonymsService.getAllSynonyms(name));
        Assertions.assertEquals(404, exception.getRawStatusCode());
    }

    private Word[] setupWordArray() {
        List<String> expectedSynonymListInDefinition = List.of(synonym1, synonym2, synonym3);
        Definition expectedDefinition = new Definition();
        expectedDefinition.setSynonyms(expectedSynonymListInDefinition);
        List<Definition> expectedDefinitionList = List.of(expectedDefinition);
        List<String> expectedSynonymListInMeaning = List.of(synonym2, synonym3, synonym4);
        Meaning expectedMeaning = new Meaning();
        expectedMeaning.setDefinitions(expectedDefinitionList);
        expectedMeaning.setSynonyms(expectedSynonymListInMeaning);
        List<Meaning> expectedMeaningList = List.of(expectedMeaning);
        Word expectedWord = new Word();
        expectedWord.setMeanings(expectedMeaningList);
        return new Word[]{expectedWord};
    }
}