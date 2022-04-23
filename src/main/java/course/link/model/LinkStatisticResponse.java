package course.link.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import course.link.db.dao.Link;

@JsonInclude
public class LinkStatisticResponse {
    public LinkStatisticResponse() {
    }

    public LinkStatisticResponse(int rank, Link link) {
        this.shortLink = link.getShortUrl();
        this.originalUrl = link.getOriginalUrl();
        this.rank = rank;
        this.count = link.getCounter();
    }

    private String shortLink;
    private String originalUrl;
    private int rank;
    private int count;

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
