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

import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class SynonymsControllerTest {

    @Mock
    SynonymsService synonymsService;

    @InjectMocks
    SynonymsController synonymsController;

    @Test
    public void allSynonymsShouldBeReturned() {
        Set<String> expected = Set.of("lay", "put");
        Mockito.doAnswer(invocation -> expected)
                .when(synonymsService)
                .getAllSynonyms(Mockito.any(String.class));
        String name = "set";
        Set<String> result = synonymsController.getAllSynonyms(name);
        Assertions.assertEquals(expected, result);
    }
}