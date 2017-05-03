package com.stuff2ponder;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
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
  static final Logger      logger       = (Logger) LoggerFactory.getLogger(Factorial_fjb04.class);
  static final Logger      rootLogger   = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
  static final MathContext MATH_CONTEXT = new MathContext(7, RoundingMode.UP);

  static {
    rootLogger.setLevel(Level.INFO);
    logger.setLevel(Level.DEBUG);
  }

  public static void main(String[] args) throws RunnerException {
    new Factorial_fjb04().checkFactorial();

    Options opt = new OptionsBuilder().include(JMHSample_01_HelloWorld.class.getSimpleName())
      .forks(1)
      .measurementIterations(2)
      .warmupIterations(2)
      .build();

    new Runner(opt).run();
  }

  @Param({ "19", "20", "21", "55", "56", "57" })
  public Long         baseLong;

  public volatile int LOOP_SIZE = 1_000;

  // ######################################

  public void checkFactorial() {
    for (long lv = 1; lv < 36; lv++) {
      Double factorialLog10 = factorialLog10(lv);
      Double factorialLoop = factorialLoop(lv);
      int compareTo12 = factorialLoop.compareTo(factorialLog10);

      if ((compareTo12 > 0)) {// || lv % 5 == 0) {
        String format = String.format(" %20s(%s)=%-25s\n\t %20s(%s)=%-25s\n#######################", "factorialLoop",
            lv, factorialLoop, "factorialLog10", lv, factorialLog10);
        logger.info(format);
      }
    }
  }

  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OperationsPerInvocation(1000)
  public long evalLoopEmpty() {
    for (long sum = 0; sum < LOOP_SIZE; sum++) {}
    return LOOP_SIZE;
  }

  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OperationsPerInvocation(1000)
  public long evalLoopFactorialLoop() {
    for (long sum = 0; sum < LOOP_SIZE; sum++) {
      factorialLoop(baseLong);
    }
    return LOOP_SIZE;
  }

  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OperationsPerInvocation(1000)
  public long evalLoopFactorialStream() {

    for (long sum = 0; sum < LOOP_SIZE; sum++) {
      factorialStream(baseLong);
    }
    return LOOP_SIZE;
  }

  public double factorialLog10(long n) {
    ArrayList<Double> arrayList = new ArrayList();
    double exponent = 0;

    for (long lv = 2; lv <= n; lv++) {
      double log10 = Math.log10(lv);
      arrayList.add(log10);
      exponent += log10;
    }
    int integerPart = (int) exponent; // like: 6.559763032876794
    BigDecimal powerOf10 = BigDecimal.valueOf(Math.pow(10., integerPart));
    BigDecimal significand = BigDecimal.valueOf(Math.pow(10., exponent - integerPart)); // like: 3.628800000000001801936377887614071369171142578125
    BigDecimal bdFactorial = significand.multiply(powerOf10); // like: 3628800.000000001801936377887614071369171142578125000000
    double factorial = Math.ceil(bdFactorial.doubleValue());

    return factorial;
  }

  // ##################################################

  public double factorialLoop(long n) {
    BigInteger biFactorial = new BigInteger("1");
    double factorial;

    if (n > 20) {
      factorial = factorialLog10(n);
    } else {
      for (long i = 2; i <= n; i++) {
        biFactorial = biFactorial.multiply(BigInteger.valueOf(i));
      }
      factorial = biFactorial.doubleValue();
    }

    return factorial;
  }

  public double factorialStream(long n) {
    double factorial;
    if (n > 20) {
      factorial = LongStream.rangeClosed(1, n)
        .mapToDouble(l -> l)
        .reduce(1, (a, b) -> a * b);
    } else {
      factorial = LongStream.rangeClosed(1, n)
        .reduce(1, (a, b) -> Math.multiplyExact(a, b));
    }

    return factorial;
  }

  @Setup()
  public void setup() {
  }

  @TearDown
  public void teardown() {
  }

}
