package com.michaelyogar.shortly;

public interface ShortlyService {
    ShortlyUrl addShortlyUrl(String url);

    String getLongUrl(String shortUrl);

    int deleteExpiredLinks(int minute);
}
