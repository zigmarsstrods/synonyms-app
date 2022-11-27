package io.codelex.synonymsapp.synonyms.dto;

import java.util.List;

public class Definition {

    private String definition;
    private List<String> synonyms;
    private List<String> antonyms;
    private String example;

    public Definition() {
    }

    public Definition(String definition, List<String> synonyms, List<String> antonyms, String example) {
        this.definition = definition;
        this.synonyms = synonyms;
        this.antonyms = antonyms;
        this.example = example;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public List<String> getAntonyms() {
        return antonyms;
    }

    public void setAntonyms(List<String> antonyms) {
        this.antonyms = antonyms;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
