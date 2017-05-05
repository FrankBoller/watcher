package com.stuff2ponder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OperationsPerInvocation;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
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
public class Perf_fjb02 {
  static final Logger logger     = (Logger) LoggerFactory.getLogger(Perf_fjb02.class);
  static final Logger rootLogger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

  static {
    rootLogger.setLevel(Level.INFO);
    logger.setLevel(Level.DEBUG);
  }

  public volatile int           LIST_SIZE = 1_000_000;
  public volatile List<Integer> list      = null;
  // public volatile String volatileString;

  @Setup
  public void setup() {
    list = IntStream.rangeClosed(1, LIST_SIZE)
      .boxed()
      .collect(Collectors.toList());
  }

  // measure Loop sum
  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OperationsPerInvocation(1000000)
  public long evalLoopEmpty() {
    long sum;
    for (sum = 0; sum < LIST_SIZE; sum++) {}
    return LIST_SIZE;
  }

  // eval Loop For Sum Long
  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OperationsPerInvocation(1000000)
  public long evalLoopForSumLong() {
    long sum = 0;

    for (Long l = 0L; l < LIST_SIZE; l++) {
      sum += l;
    }
    return LIST_SIZE;
  }

  // eval Loop For Sum Integer
  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OperationsPerInvocation(1000000)
  public long evalLoopForSumInteger() {
    long sum = 0;

    for (Integer i = 0; i < LIST_SIZE; i++) {
      sum += i;
    }
    return LIST_SIZE;
  }

  // eval Loop Foreach Sum
  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OperationsPerInvocation(1000000)
  public long evalLoopForeachSum() {
    long sum = 0;

    for (Integer i : list) {
      sum += i;
    }
    return LIST_SIZE;
  }

  // eval Stream Boxed Collect
  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OperationsPerInvocation(1000000)
  public long evalStreamBoxedCollect() {
    List<Integer> streamedList = IntStream.rangeClosed(1, LIST_SIZE)
      .boxed()
      .collect(Collectors.toList());

    return LIST_SIZE;
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder().include(Perf_fjb02.class.getSimpleName())
      .forks(1)
      .build();

    new Runner(opt).run();
  }

}
