package com.template.service.impl;

import com.template.exception.CacheNotFoundException;
import com.template.exception.KeyNotFoundException;
import com.template.service.CacheService;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CacheServiceImpl implements CacheService {

    private Map<String, Map<String, String>> cache;

    public CacheServiceImpl() {
        this.cache = new HashMap<>();
    }

    @Override
    public boolean putIntoCache(String cache, String key, String value) {
        if (!this.cache.containsKey(cache)) {
            this.cache.put(cache, new HashMap<>());
        }
        this.cache.get(cache).put(key, value);
        log.info(this.cache.toString());
        return true;
    }

    @Override
    public String getFromCache(String cache, String key) {
        if (!this.cache.containsKey(cache)) {
            throw new CacheNotFoundException(String.format("Could not found cache : %s", cache));
        }
        if (!this.cache.get(cache).containsKey(key)) {
            throw new KeyNotFoundException(
                    String.format("Could not found key : %s in cache : %s", key, cache));
        }
        return this.cache.get(cache).get(key);
    }
}
