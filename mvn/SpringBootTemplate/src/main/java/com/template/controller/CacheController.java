package com.template.controller;

import com.template.dto.CacheDto;
import com.template.service.CacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1/cache")
@RequiredArgsConstructor
@Slf4j
public class CacheController {

   private final CacheService cacheService;

    @PostMapping("/{cache}/{key}/{value}")
    public boolean putToCachePath(@PathVariable("cache") String cache
            ,@PathVariable("key") String key
            ,@PathVariable("value") String value) {
        //http://localhost:8080/api/v1/cache/1/2/3
        log.info("call method put path...");
        return cacheService.putIntoCache(cache, key, value);
    }

    @PostMapping("")
    public boolean putToCacheRequest(@RequestParam("cache") String cache
            ,@RequestParam("key") String key
            ,@RequestParam("value") String value) {
        //http://localhost:8080/api/v1/cache?cache=1&key=1&value=1
        log.info("call method put request...");
        return cacheService.putIntoCache(cache, key, value);
    }

    @PostMapping("/body")
    public boolean putToCacheBdy(@RequestBody CacheDto cache) {

//        curl -X 'POST' \
//        'http://localhost:8080/api/v1/cache/body' \
//        -H 'accept: */*' \
//        -H 'Content-Type: application/json' \
//        -d '{   "cache": "curl",
//                "key": "2",
//                "value": "5"}'

        log.info("call method put request...");
        return cacheService.putIntoCache(cache.cache(), cache.key(), cache.value());
    }

    @GetMapping("/{cache}/{key}")
    public String getValue(@PathVariable("cache") String cache
            ,@PathVariable("key") String key){
        log.info("call method get from cache...");
        return cacheService.getFromCache(cache, key);
    }
}
