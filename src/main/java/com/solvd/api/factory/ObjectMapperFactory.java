package com.solvd.api.factory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperFactory {
    public static ObjectMapper buildNew() {
        return new ObjectMapper();
    }
}