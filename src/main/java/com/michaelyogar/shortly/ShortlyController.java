package com.michaelyogar.shortly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ShortlyController {
    private final ShortlyService service;

    @Autowired
    ShortlyController(ShortlyService service) {
        this.service = service;
    }

    @GetMapping("/{shortUrl}")
    RedirectView getLongUrl(@PathVariable String shortUrl) {
        RedirectView redirectView = new RedirectView();
        String longUrl = service.getLongUrl(shortUrl);
        redirectView.setUrl(longUrl);
        return redirectView;
    }

    @PostMapping("/url")
    ShortlyUrl createUrl(@RequestParam("url") String url, @RequestParam(value = "seconds", required = false) Long seconds) {
        long s = (seconds != null) ? seconds : -1;
        return service.addShortlyUrl(url, s);
    }
}

