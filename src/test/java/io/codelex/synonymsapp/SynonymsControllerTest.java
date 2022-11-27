package io.codelex.synonymsapp;

import io.codelex.synonymsapp.synonyms.SynonymsController;
import io.codelex.synonymsapp.synonyms.SynonymsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class SynonymsControllerTest {

    private final Set<String> expected = new HashSet<>();

    @Mock
    SynonymsService synonymsService;

    @InjectMocks
    SynonymsController synonymsController;

    @Test
    public void allSynonymsShouldBeReturned() {
        setupStringSet();
        Mockito.doAnswer(invocation -> expected)
                .when(synonymsService)
                .getAllSynonyms(Mockito.any(String.class));
        String name = "set";
        Set<String> result = synonymsController.getAllSynonyms(name);
        Assertions.assertEquals(expected, result);
    }

    private void setupStringSet() {
        expected.add("set down");
        expected.add("lay");
        expected.add("light");
        expected.add("put");
    }
}
