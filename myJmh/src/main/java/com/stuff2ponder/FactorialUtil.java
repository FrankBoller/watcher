package com.stuff2ponder;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.stream.LongStream;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class FactorialUtil {
  protected static final Logger LOGGER              = (Logger) LoggerFactory.getLogger(FactorialUtil.class);
  protected static final Logger ROOT_LOGGER         = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
  protected static final double DOUBLE_VALUE_10     = 10.;
  protected static final int    LONG_LIMIT_FOR_MULT = 20;

  public double combination(int n, int k) {// c(n,k) = n! / ((n - k)! * k!)
    double denominator = factorialBigIntLoopFallbackLog10(k);
    return permutation(n, k) / denominator;
  }

  public double factorialAsLog10(long n) {
    double exponent = 0;

    for (long lv = 2; lv <= n; lv++) {
      exponent += Math.log10(lv);
  }

    int integerPart = (int) exponent; // like: 6.559763032876794
    // BigDecimal powerOf10 = BigDecimal.valueOf(Math.pow(DOUBLE_VALUE_10, integerPart));
    BigDecimal powerOf10 = BigDecimal.valueOf(DOUBLE_VALUE_10)
      .pow(integerPart);
    double significand = Math.pow(DOUBLE_VALUE_10, exponent - integerPart); // Math allows double arg, BigDecimal does not
    BigDecimal bdSignificand = BigDecimal.valueOf(significand); // like: 3.628800000000001801936377887614071369171142578125
    BigDecimal bdFactorial = bdSignificand.multiply(powerOf10); // like: 3628800.000000001801936377887614071369171142578125000000
    double factorial = Math.ceil(bdFactorial.doubleValue());

    return factorial;
  }

  public double factorialBigIntLoopFallbackLog10(long n) {
    BigInteger biFactorial = BigInteger.ONE;
    double factorial;

    if (n <= LONG_LIMIT_FOR_MULT) {
      for (long i = 2; i <= n; i++) {
        biFactorial = biFactorial.multiply(BigInteger.valueOf(i));
      }
      factorial = biFactorial.doubleValue();
    } else {
      factorial = factorialAsLog10(n);
    }

    return factorial;
  }

  public double factorialLongStreamFallbackDouble(long n) {
    double factorial;

    if (n <= LONG_LIMIT_FOR_MULT) {
      factorial = LongStream.rangeClosed(1, n)
        .reduce(1, (a, b) -> Math.multiplyExact(a, b));
    } else {

      factorial = LongStream.rangeClosed(1, n)
        .mapToDouble(l -> l)
        .reduce(1, (a, b) -> a * b);
  }

    return factorial;
  }

  public double permutation(int n, int k) { // P(n,k) = n! / (n - k)!
    double numerator = factorialBigIntLoopFallbackLog10(n);
    double denominator = factorialBigIntLoopFallbackLog10(n - k);
    return numerator / denominator;
  }

  @SuppressWarnings("unused")
  public void verifyFactorial() {

    for (long lv = 1; lv < 36; lv++) {
      Double factorialLog10 = factorialAsLog10(lv);
      Double factorialLoop = factorialBigIntLoopFallbackLog10(lv);
      int compareTo12 = factorialLoop.compareTo(factorialLog10);

      if ((compareTo12 > 0)) {// || lv % 5 == 0) {
        String format = String.format(" %20s(%s)=%-25s\n\t %20s(%s)=%-25s\n#######################", "factorialLoop",
            lv, factorialLoop, "factorialLog10", lv, factorialLog10);
        LOGGER.info(format);
      }
    }
  }

}
