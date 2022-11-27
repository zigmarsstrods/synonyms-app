package io.codelex.synonymsapp;

import io.codelex.synonymsapp.synonyms.SynonymsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class SynonymsServiceTest {

    private final SynonymsService synonymsService = new SynonymsService();
    private final Set<String> expected = new HashSet<>();

    @Test
    public void allSynonymsShouldBeReturned() {
        expected.add("set down");
        expected.add("lay");
        expected.add("light");
        expected.add("put");
        String name = "set";
        Set<String> result = synonymsService.getAllSynonyms(name);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void errorMessageShouldBeReturnedWhenWordNotFound() {
        expected.add("No Definitions Found");
        String name = "cupakabra";
        Set<String> result = synonymsService.getAllSynonyms(name);
        Assertions.assertEquals(expected, result);
    }
}
