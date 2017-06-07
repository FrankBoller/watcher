package com.stuff2ponder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class SerializationUtilsTest {
//  private static final String             E_SIGN                  = "=";
  private static final String             KEY_VALUE_PAIRS         = "2=ABC, 3=DEF, 4=GHI, 5=JKL, 6=MNO, 7=PQR, 8=STU, 9=VXYZ";
  private static final Map<String, String> KEY_VALUE_MAP = Arrays.stream(KEY_VALUE_PAIRS.split("\\W*,\\W*"))
    .map(a -> Arrays.asList(a.split("=")))
    .collect(Collectors.toMap(key -> key.get(0), value -> value.get(1)));
  private static final SerializationUtils SERIALIZATION_UTILS     = new SerializationUtils();
//  private static final String             _1_2_3_4                = "[[1,2],[3,4]]";
//  private static final String             _3_7_4_8_10_4_6_9_12_13 = "[-3, [7,4,[8], 10],[4,[6,[9]],12], 13]";
//  private static final int[][]            INTS                    = new int[][] { { 1, 2 }, { 3, 4 } };

  private static final String             KEY_VALUE_INIT           = "{\"2\":\"ABC\",\"3\":\"DEF\",\"4\":\"GHI\",\"5\":\"JKL\",\"6\":\"MNO\",\"7\":\"PQR\",\"8\":\"STU\",\"9\":\"VXYZ\"}";

  // public static <T> Collector<T, ?, Map<String, T>> toMap() {
  // return Collector.of(HashMap::new, (map, t) -> map.put(k, t), (m1, m2) -> {
  // String s = "" + m1.size();
  // m2.forEach((k, v) -> m1.put(k + s, v));
  // return m1;
  // });
  // }

  int                                     i;

  @SuppressWarnings("serial")
  @Test
  public void testMap() throws JsonGenerationException, JsonMappingException, IOException {
//    Function<String, String[]> function1 = a -> a.split(",");
//    Function<String, List<String>> function2 = a -> Arrays.asList(a.split("="));
//    Function<String, Iterator<String>> functionIterator = a -> Arrays.asList(a.split("="))
//      .iterator();
//    String[] split = KEY_VALUE_PAIRS.split("\\W*,\\W*");

//    Map<String, String> map1 = Arrays.stream(split)
//      .map(a -> new KeyValue(a))
//      .collect(Collectors.toMap(kv -> kv.key(), kv -> kv.value()));
//    System.out.println("collect2:" + map1);


    System.out.println("KEY_VALUE_MAP:" + KEY_VALUE_MAP);
    System.out.println("KEY_VALUE_MAP.get(\"5\"):" + KEY_VALUE_MAP.get("5"));

    // Map<Iterator<String>, Iterator<String>> collect = Arrays.stream(split)
    // .map(functionIterator::apply)
    // .collect(Collectors.toMap(key -> key, value -> value));
    // System.out.println(collect);
    // System.out.println(collect.getClass()
    // .getName());

  }

  // @Test
  public void testExample() {
    BiFunction<String, String, String> bi = (x, y) -> {
      return x + y;
    };

    System.out.println(bi.apply("java2s.com", " tutorial"));
  }

  void impl1() throws JsonParseException, JsonMappingException, IOException {
    String serializedPojo;
    Object deserializeObject;
    Map<String, String> map1 = new HashMap<String, String>() {};
    Map<String, String> test = new HashMap<String, String>() {
      {
        put("test", "test");
        put("test", "test");
      }
    };
    System.out.println(test);

    map1.put("2", "ABC");
    map1.put("3", "DEF");
    map1.put("4", "GHI");
    map1.put("5", "JKL");
    map1.put("6", "MNO");
    map1.put("7", "PQR");
    map1.put("8", "STU");
    map1.put("9", "VXYZ");
    // serializedPojo = SERIALIZATION_UTILS.serializePojo(hashMap);
    // System.out.println(serializedPojo);

    // deserializeObject = SERIALIZATION_UTILS.deserializeObject(serializedPojo);
    // System.out.println(deserializeObject);
    deserializeObject = SERIALIZATION_UTILS.deserializeObject(KEY_VALUE_INIT);
    System.out.println(deserializeObject);

    System.out.println(map1.entrySet());
    System.out.println("KEY_VALUE_PAIRS:" + KEY_VALUE_PAIRS);

    Collection<String> collection = new ArrayList<String>();
    collection.add("123");
    collection.add("456");
    Iterator<String> iterator = collection.iterator();
    while (iterator.hasNext()) {
      String string = (String) iterator.next();
    }
  }

}
