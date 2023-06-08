package com.michaelyogar.shortly;

import org.springframework.data.repository.CrudRepository;

public interface ShortlyRepository extends CrudRepository<ShortlyUrl, Long> {
    ShortlyUrl findByShortUrl(String shortUrl);
}
