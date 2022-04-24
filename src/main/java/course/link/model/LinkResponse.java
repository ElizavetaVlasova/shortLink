package course.link.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class LinkResponse {

    private String link;

    public LinkResponse(String link) {
        this.link = link;
    }

    public LinkResponse() {
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
