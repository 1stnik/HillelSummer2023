package com.exchange.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface RateService {
    void getRates() throws JsonProcessingException;
}
