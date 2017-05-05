package com.stuff2ponder;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.stream.LongStream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OperationsPerInvocation;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.samples.JMHSample_01_HelloWorld;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
public class Factorial_fjb04 {
  static final Logger logger              = (Logger) LoggerFactory.getLogger(Factorial_fjb04.class);
  static final Logger rootLogger          = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

  static final double DOUBLE_VALUE_10     = 10.;
  static final int    LONG_LIMIT_FOR_MULT = 20;

  static {
    rootLogger.setLevel(Level.INFO);
    logger.setLevel(Level.DEBUG);
  }

  public static void main(String[] args) throws RunnerException {
    new Factorial_fjb04().verifyFactorial();

    Options opt = new OptionsBuilder().include(JMHSample_01_HelloWorld.class.getSimpleName())
      .forks(1)
      .measurementIterations(2)
      .warmupIterations(2)
      .build();

    new Runner(opt).run();
  }

  @Param({ "2", "19", "20", "21", "32", "64", "128", "256" })
  public Long         baseLong;

  public volatile int LOOP_SIZE = 1_000;

  // ######################################

  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OperationsPerInvocation(1000)
  public long evalEmptyLoop() {
    for (long sum = 0; sum < LOOP_SIZE; sum++) {}
    return LOOP_SIZE;
  }

  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OperationsPerInvocation(1000)
  public long evalFactorialAsLog10() {

    for (long sum = 0; sum < LOOP_SIZE; sum++) {
      factorialAsLog10(baseLong);
    }
    return LOOP_SIZE;
  }

  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OperationsPerInvocation(1000)
  public long evalFactorialBigLongLoopFallbackLog10() {

    for (long sum = 0; sum < LOOP_SIZE; sum++) {
      factorialBigIntLoopFallbackLog10(baseLong);
    }
    return LOOP_SIZE;
  }

  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OperationsPerInvocation(1000)
  public long evalFactorialLongStreamFallbackDouble() {

    for (long sum = 0; sum < LOOP_SIZE; sum++) {
      factorialLongStreamFallbackDouble(baseLong);
    }
    return LOOP_SIZE;
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

  // ##################################################

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

  @Setup()
  public void setup() {
  }

  @TearDown
  public void teardown() {
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
        logger.info(format);
      }
    }
  }

}
