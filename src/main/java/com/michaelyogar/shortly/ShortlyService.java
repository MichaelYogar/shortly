package com.michaelyogar.shortly;

public interface ShortlyService {
    ShortlyUrl addShortlyUrl(String url, long seconds);

    String getLongUrl(String shortUrl);

    int deleteExpiredLinks();
}
