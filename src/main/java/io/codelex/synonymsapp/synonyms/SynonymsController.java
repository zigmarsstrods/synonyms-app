package io.codelex.synonymsapp.synonyms;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@AllArgsConstructor
public class SynonymsController {

    private final SynonymsService synonymsService;

    @ApiOperation(value = "Enter the necessary word to get its synonyms as a list in the response page")
    @GetMapping("/synonyms/{word}")
    public Set<String> getAllSynonyms(@PathVariable String word) {
        return synonymsService.getAllSynonyms(word);
    }
}