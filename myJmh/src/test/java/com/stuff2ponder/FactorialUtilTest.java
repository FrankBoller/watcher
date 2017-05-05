package com.stuff2ponder;

import org.junit.Assert;
import org.junit.Test;

public class FactorialUtilTest extends FactorialUtil {

  @Test
  public void testDifferentFactorials() {

    for (long lv = 1; lv < 36; lv++) {
      Double factorialLog10 = factorialAsLog10(lv);
      Double factorialLoop = factorialBigIntLoopFallbackLog10(lv);
      int compareTo12 = factorialLoop.compareTo(factorialLog10);

      String format = String.format(" %20s(%s)=%-25s\n\t %20s(%s)=%-25s\n#######################", "factorialLoop", lv,
          factorialLoop, "factorialLog10", lv, factorialLog10);
      Assert.assertTrue(format, compareTo12 <= 0);
    }
  }

  @Test
  public void testCombination() {
    double c = combination(10, 3);
    Assert.assertEquals(120, (int) c);
  }

  @Test
  public void testPermutaion() {
    double p = permutation(10, 3);
    Assert.assertEquals(720, (int) p);
  }
}
