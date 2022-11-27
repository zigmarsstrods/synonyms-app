package io.codelex.synonymsapp.synonyms.dto;

public class NotFoundError {

    private String title;
    private String message;
    private String resolution;

    public NotFoundError() {
    }

    public NotFoundError(String title, String message, String resolution) {
        this.title = title;
        this.message = message;
        this.resolution = resolution;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
}
