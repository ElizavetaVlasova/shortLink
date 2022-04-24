package course.link.controller;

import course.link.model.LinkRequest;
import course.link.model.LinkResponse;
import course.link.model.LinkStatisticResponse;
import course.link.service.LinkService;
import course.link.service.LinkStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
public class LinkController {

    @Autowired
    LinkService linkService;

    @Autowired
    LinkStatisticService statisticService;

    @PostMapping(path = "/generate", consumes = APPLICATION_JSON_VALUE)
    public LinkResponse createShortUrl(@RequestBody LinkRequest request) {
        return linkService.generateShortLink(request);
    }

    @GetMapping (path = "/l/{shortLink}")
    public Object redirectToOriginalUrl(@PathVariable ("shortLink") String shortLink) {
        String link =  linkService.getOriginalUrl(shortLink);
        if (link == null) {
            return "There is no link";
        }
        return new RedirectView(link);
    }

    @GetMapping (path = "/stats/{shortLink}")
    public LinkStatisticResponse getInfoForLink(@PathVariable ("shortLink") String shortLink) {
            return statisticService.getStatisticForOneLink(shortLink);
    }

    @GetMapping (path = "/stats")
    public List<LinkStatisticResponse> getStatisticForAllLinks(@RequestParam int page, @RequestParam int limit) {
        return statisticService.getStatisticForAllLinks(page, limit);
    }
}
