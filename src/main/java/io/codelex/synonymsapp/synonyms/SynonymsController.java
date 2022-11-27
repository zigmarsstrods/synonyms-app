package io.codelex.synonymsapp.synonyms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class SynonymsController {

    private final SynonymsService synonymsService;

    public SynonymsController(SynonymsService synonymsService) {
        this.synonymsService = synonymsService;
    }

    @GetMapping("/synonyms/{word}")
    public Set<String> getAllSynonyms(@PathVariable String word) {
        return synonymsService.getAllSynonyms(word);
    }
}
