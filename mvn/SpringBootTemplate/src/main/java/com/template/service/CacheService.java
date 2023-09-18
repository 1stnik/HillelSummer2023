package com.template.service;

public interface CacheService {

    public boolean putIntoCache(String cache, String key, String value);
    public String getFromCache(String cache, String key);
}
