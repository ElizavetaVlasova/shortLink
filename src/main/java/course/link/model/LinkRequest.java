package course.link.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class LinkRequest {
    private String original;

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }
}
