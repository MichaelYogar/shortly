package com.michaelyogar.shortly;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ShortlyRepository extends CrudRepository<ShortlyUrl, Long> {
    ShortlyUrl findByShortUrl(String shortUrl);

    @Modifying
    @Query(value = "DELETE FROM shortly_url WHERE created_date < date_sub(now(), INTERVAL ?1 MINUTE)", nativeQuery = true)
    int deleteExpiredLinks(int minutes);
}
