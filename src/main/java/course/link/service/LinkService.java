package course.link.service;

import course.link.db.dao.Link;
import course.link.db.dao.LinkRepository;
import course.link.model.LinkRequest;
import course.link.model.LinkResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;

@Service
public class LinkService {

    Logger logger = LoggerFactory.getLogger(LinkService.class);

    @Autowired
    LinkRepository repository;
    @Autowired
    LinkGenerator linkGenerator;

    public LinkResponse generateShortLink(LinkRequest request) {
        logger.info("Original url is "+ request.getOriginal());
        if (!requestIsValid(request)) {
            logger.info("Url is not valid");
            return new LinkResponse();
        }
        Optional<Link> byOriginalUrl = repository.findByOriginalUrl(request.getOriginal());
        if (byOriginalUrl.isPresent()) {
            return new LinkResponse(byOriginalUrl.get().getShortUrl());
        }
        String shortUrl = linkGenerator.getRandomValue();
        Link link = createLink(request.getOriginal(), shortUrl);
        logger.info("Short link is " + shortUrl);
        repository.save(link);
        return new LinkResponse(shortUrl);
    }

    private Link createLink(String original, String shortUrl) {
        Link link = new Link();
        link.setOriginalUrl(original);
        link.setCounter(1);
        link.setShortUrl(shortUrl);
        return link;
    }

    private boolean requestIsValid(LinkRequest request) {
        if (request != null && request.getOriginal() != null) {
            try {
                URL obj = new URL(request.getOriginal());
                obj.toURI();
                return true;
            } catch (MalformedURLException | URISyntaxException e) {
                return false;
            }
        }
        return false;
    }

    public String getOriginalUrl(String shortLink) {
        var optionalLink = repository.findByShortURL(shortLink);
        if (optionalLink.isEmpty()) {
            return null;
        }
        Link link = optionalLink.get();
        int counter = link.getCounter() + 1;
        link.setCounter(counter);
        repository.save(link);

        return link.getOriginalUrl();
    }
}
