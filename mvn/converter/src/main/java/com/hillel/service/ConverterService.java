package com.hillel.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.hillel.service.exception.ConvertationFault;
import java.nio.file.Path;

public interface ConverterService {
    /**
     * this method convert file for one format to another
     * @param data - file location path
     */
    String convert (String data) throws ConvertationFault;
}
