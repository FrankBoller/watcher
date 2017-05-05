package com.stuff2ponder;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OperationsPerInvocation;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.RunnerException;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
public class Factorial_fjb04 extends FactorialUtil {
  protected static final Logger LOGGER      = (Logger) LoggerFactory.getLogger(Factorial_fjb04.class);
  protected static final Logger ROOT_LOGGER = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
  protected static final int    LOOP_SIZE   = 1_000;

  static {
    ROOT_LOGGER.setLevel(Level.INFO);
    LOGGER.setLevel(Level.DEBUG);
  }

  @Param({ "2", "19", "20", "21", "32", "64", "128", "256" })
  public Long baseLong;

  public static void main(String[] args) throws RunnerException {
    new Factorial_fjb04().verifyFactorial();

//    Options opt = new OptionsBuilder().include(JMHSample_01_HelloWorld.class.getSimpleName())
//      .forks(1)
//      .measurementIterations(2)
//      .warmupIterations(2)
//      .build();
//
//    new Runner(opt).run();
  }

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

}
