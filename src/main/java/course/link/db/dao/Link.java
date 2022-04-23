package course.link.db.dao;

import javax.persistence.*;

@Entity
@Table(name = "links")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "original")
    private String originalUrl;
    @Column(name = "counter")
    private int counter;

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @Column(name = "shortUrl")
    private String shortUrl;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getShortUrl() {
        return shortUrl;
    }
}
