package com.stuff2ponder;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OperationsPerInvocation;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
public class SortPerf_fjb05 {
  protected static final Logger LOGGER      = (Logger) LoggerFactory.getLogger(SortPerf_fjb05.class);
  protected static final Logger ROOT_LOGGER = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
  protected static final int    LOOP_SIZE   = 1_000;
  private static final int[]    INT_ARRAY_1 = IntStream.rangeClosed(0, LOOP_SIZE)
    .toArray();



  static {
    ROOT_LOGGER.setLevel(Level.INFO);
    LOGGER.setLevel(Level.DEBUG);
  }

  @Param({ "1000", "10000", "100000" })
  public Long baseLong;

  public static void main(String[] args) throws RunnerException {
    // int[] arrayReversed = IntStream.of(INT_ARRAY_1)
    // .map(a -> Integer.MAX_VALUE - a)
    // .toArray();
    //
    // for(int i=0; i<10; i++) System.out.print(" " + arrayReversed[i]);

    Options opt = new OptionsBuilder().include(SortPerf_fjb05.class.getSimpleName())
      .forks(1)
      .measurementIterations(2)
      .warmupIterations(2)
      .build();

    new Runner(opt).run();
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
  public long evalArrayCopyInt() {
    int[] arrayReversed = IntStream.of(INT_ARRAY_1)
      .map(a -> Integer.MAX_VALUE - a)
      .toArray();
    for (long sum = 0; sum < LOOP_SIZE; sum++) {
      int[] copyOf = Arrays.copyOf(arrayReversed, baseLong.intValue());
    }

    return LOOP_SIZE;
  }

  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OperationsPerInvocation(1000)
  public long evalArrayCopyIntAndSort() {
    int[] arrayReversed = IntStream.of(INT_ARRAY_1)
      .map(a -> Integer.MAX_VALUE - a)
      .toArray();
    for (long sum = 0; sum < LOOP_SIZE; sum++) {
      int[] copyOf = Arrays.copyOf(arrayReversed, baseLong.intValue());
      Arrays.sort(copyOf);
    }

    return LOOP_SIZE;
  }


  // @Benchmark
  // @BenchmarkMode(Mode.Throughput)
  // @OperationsPerInvocation(1000)
  // public long evalArrayCreateInt() {
  // for (long sum = 0; sum < LOOP_SIZE; sum++) {
  // int[] ints = IntStream.rangeClosed(0, baseLong.intValue())
  // .toArray();
  // }
  //
  // return LOOP_SIZE;
  // }

}
