package com.stuff2ponder;

import java.io.IOException;
import java.io.StringWriter;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationUtils {
  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  public String serializePojo(Object pojo) throws JsonGenerationException, JsonMappingException, IOException {
    StringWriter stringWriter = new StringWriter();

    OBJECT_MAPPER.writeValue(stringWriter, pojo);

    return stringWriter.toString();
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public Object deserializeObject(String serializedPojo) throws JsonParseException, JsonMappingException, IOException {
    return OBJECT_MAPPER.readValue(serializedPojo, Object.class);
  }
}
