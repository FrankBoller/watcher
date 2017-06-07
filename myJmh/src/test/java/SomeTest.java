import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class SomeTest {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  @Test
  public void test() throws JsonParseException, JsonMappingException, IOException {
    Object readValue = OBJECT_MAPPER.readValue("[[1,2],[[3,4],3,4],5,6]", ArrayList.class);
    Assert.assertTrue(readValue instanceof List<?>);
  }

}
