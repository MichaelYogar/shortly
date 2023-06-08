package com.michaelyogar.shortly;

public interface ShortlyService {
    public ShortlyUrl addShortlyUrl(String url);

    String getLongUrl(String shortUrl);
}
