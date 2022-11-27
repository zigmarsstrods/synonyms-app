package io.codelex.synonymsapp.synonyms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotFoundError {

    private String title;
    private String message;
    private String resolution;
}
