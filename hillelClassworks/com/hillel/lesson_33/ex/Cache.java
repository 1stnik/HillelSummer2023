package com.hillel.lesson_33.ex;

import java.util.HashMap;
import java.util.Map;

public class Cache {

    private Map<String, Map<String, Object>> cache;

    public Cache() {
        this.cache = new HashMap<>();
    }

    public boolean add(String cacheName, String key, String value) {
        if (!cache.containsKey(cacheName)) {
            cache.put(cacheName, new HashMap<String, Object>());
        }

        cache.get(cacheName).put(key, value);

        return true;
    }

    public Map getCache() {
        return cache;
    }

}
