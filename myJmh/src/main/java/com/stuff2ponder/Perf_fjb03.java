package com.stuff2ponder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OperationsPerInvocation;
import org.openjdk.jmh.annotations.Param;
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
public class Perf_fjb03 {
  static final Logger logger     = (Logger) LoggerFactory.getLogger(Perf_fjb03.class);
  static final Logger rootLogger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

  static {
    rootLogger.setLevel(Level.INFO);
    logger.setLevel(Level.DEBUG);
  }

  @Param({ "a", "abcd", "abcdefghijklmnopqrstuvwxyz" })
  public String                 baseString;

  public volatile int           LIST_SIZE = 1_000;
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
  @OperationsPerInvocation(1000)
  public long evalLoopEmpty() {
    long sum = 0;
    for (sum = 0; sum < LIST_SIZE; sum++) {}
    return sum;
  }

  // measure Loop StringBuffer operations
  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OperationsPerInvocation(1000)
  public long evalLoopStringBuffer() {
    StringBuffer stringBuffer = new StringBuffer();
    long sum = 0;

    for (Integer i : list) {
      sum += i;
      stringBuffer.append(baseString)
        .append(i);
    }
    return sum;
  }

  // measure Loop StringBuilder operations
  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OperationsPerInvocation(1000)
  public long evalLoopStringBuilder() {
    StringBuilder stringBuilder = new StringBuilder();
    long sum = 0;

    for (Integer i : list) {
      sum += i;
      stringBuilder.append(baseString)
        .append(i);
    }
    return sum;
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder().include(Perf_fjb03.class.getSimpleName())
      .forks(1)
      .build();

    new Runner(opt).run();
  }

}
