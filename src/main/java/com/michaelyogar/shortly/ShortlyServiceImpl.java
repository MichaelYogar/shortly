package com.michaelyogar.shortly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ShortlyServiceImpl implements ShortlyService {
    private final ShortlyRepository repository;

    @Autowired
    public ShortlyServiceImpl(ShortlyRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShortlyUrl addShortlyUrl(String url) {
        ShortlyUrl shortlyUrl = new ShortlyUrl();
        shortlyUrl.setLongUrl(url);

        shortlyUrl = repository.save(shortlyUrl);

        String shortUrl = Base36.encode((int) shortlyUrl.getId());

        shortlyUrl.setShortUrl(shortUrl);

        return repository.save(shortlyUrl);
    }

    @Override
    public String getLongUrl(String shortUrl) {
        int decoded = Base36.decode(shortUrl);
        return repository.findByShortUrl(String.valueOf(decoded)).getLongUrl();
    }
}
