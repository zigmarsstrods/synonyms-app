package io.codelex.synonymsapp.synonyms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phonetic {

    private String text;
    private String audio;
    private String sourceUrl;
    private License license;
}
