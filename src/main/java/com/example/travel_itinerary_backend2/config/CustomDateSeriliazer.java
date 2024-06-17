package com.example.travel_itinerary_backend2.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomDateSeriliazer extends com.fasterxml.jackson.databind.ser.std.StdSerializer<LocalDateTime>{

    public  CustomDateSeriliazer() {
        this(null);
    }

    public CustomDateSeriliazer(Class<LocalDateTime> t) {
        super(t);
    }

    @Override
    public void serialize(LocalDateTime localDateTime,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeString(localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));

    }
}
