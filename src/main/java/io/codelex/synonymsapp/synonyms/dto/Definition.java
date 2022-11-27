package io.codelex.synonymsapp.synonyms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Definition {

    private String definition;
    private List<String> synonyms;
    private List<String> antonyms;
    private String example;
}
