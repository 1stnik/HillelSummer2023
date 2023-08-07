package com.sparkjava;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class JsonToYamlConverter {
    public static void main(String[] args) {
        String jsonInput = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";

        try {
            // Create ObjectMapper for JSON
            ObjectMapper jsonMapper = new ObjectMapper();
            // Parse JSON string to JsonNode
            JsonNode jsonNode = jsonMapper.readTree(jsonInput);

            // Create YAMLMapper for YAML
            YAMLMapper yamlMapper = new YAMLMapper();
            // Convert JsonNode to YAML string
            String yamlOutput = yamlMapper.writeValueAsString(jsonNode);

            System.out.println("YAML Output:");
            System.out.println(yamlOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
