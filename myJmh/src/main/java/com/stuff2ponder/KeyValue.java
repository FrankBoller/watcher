package com.stuff2ponder;

public class KeyValue {
  private String[] keyValues;

  public KeyValue(String s) {
    keyValues = s.split("=");
  }

  public String key() {
    return keyValues[0];
  }

  public String value() {
    return keyValues[1];
  }

}
