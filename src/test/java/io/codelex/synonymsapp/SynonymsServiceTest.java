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

import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class SynonymsServiceTest {

    @Spy
    private final SynonymsService synonymsService = new SynonymsService();

    @Test
    public void allSynonymsShouldBeReturned() {
        String synonym1 = "plus-size";
        String synonym2 = "jumbo";
        String synonym3 = "large";
        String synonym4 = "busty";
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
        Word[] expectedWordArray = {expectedWord};
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
        Set<String> result = synonymsService.getAllSynonyms(name);
        Set<String> expected = Set.of("Word not found");
        Assertions.assertEquals(expected, result);
    }
}