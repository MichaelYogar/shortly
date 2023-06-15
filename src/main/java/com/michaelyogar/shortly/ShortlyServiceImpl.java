package com.michaelyogar.shortly;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortlyServiceImpl implements ShortlyService {
    private final ShortlyRepository repository;

    @Autowired
    public ShortlyServiceImpl(ShortlyRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShortlyUrl addShortlyUrl(String url, long seconds) {
        ShortlyUrl shortlyUrl = new ShortlyUrl();

        shortlyUrl.setLongUrl(url);
        if (seconds > 0)
            shortlyUrl.setDuration(seconds);

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

    @Override
    @Transactional
    public int deleteExpiredLinks() {
        return repository.deleteExpiredLinks();
    }
}
