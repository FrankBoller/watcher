# jmh
#
test harness:
[Code Tools: jmh](http://openjdk.java.net/projects/code-tools/jmh/) 

* JMH is a Java harness for building, running, and analysing nano/micro/milli/macro benchmarks written in Java and other languages targetting the JVM.

also:
[jmh-samples](http://hg.openjdk.java.net/code-tools/jmh/file/tip/jmh-samples/src/main/java/org/openjdk/jmh/samples/)

also:
[Java Performance Tuning Guide](http://java-performance.info/jmh/)

* various tips on improving performance of your Java code

details:

| goal                          | command                                                        | 
| ----------------------------- | -------------------------------------------------------------- | 
| build                         | mvn clean package                                              | 
| jmh help                      | java -jar target/benchmarks.jar -h                             | 
| jmh list tests                | java -jar target/benchmarks.jar -l                             | 
| jmh list subset tests         | java -jar target/benchmarks.jar -l {subset}                    | 
| jmh test run all (with flags) | java -jar target/benchmarks.jar -f 1 -wi 3 -i 2 -tu s          | 
| jmh test run one (with flags) | java -jar target/benchmarks.jar -f 1 -wi 3 -i 2 -tu s {subset} | 

given a flag "-l":    
*$ java -jar target/benchmarks.jar -l*  
produces:
    Benchmarks:
    com.stuff2ponder.Factorial_fjb04.evalEmptyLoop
    com.stuff2ponder.Factorial_fjb04.evalFactorialAsLog10
    com.stuff2ponder.Factorial_fjb04.evalFactorialBigLongLoopFallbackLog10
    com.stuff2ponder.Factorial_fjb04.evalFactorialLongStreamFallbackDouble
    com.stuff2ponder.Perf_fjb03.evalLoopEmpty
    com.stuff2ponder.Perf_fjb03.evalLoopStringBuffer
    com.stuff2ponder.Perf_fjb03.evalLoopStringBuilder
    org.openjdk.jmh.samples.JMHSample_01_HelloWorld.wellHelloThere

jmh given a flag "-l 04":  
*$ java -jar target/benchmarks.jar -l 04*  
produces:

    Benchmarks:  
    com.stuff2ponder.Factorial_fjb04.evalEmptyLoop
    com.stuff2ponder.Factorial_fjb04.evalFactorialAsLog10
    com.stuff2ponder.Factorial_fjb04.evalFactorialBigLongLoopFallbackLog10
    com.stuff2ponder.Factorial_fjb04.evalFactorialLongStreamFallbackDouble

example (with optional flags) {run today} :  
*$ java -jar target/benchmarks.jar -f 1 -wi 3 -i 2 -tu us -o Factorial_fjb04.log 04
produced file: [Factorial_fjb04.log](https://github.com/frankboller/watcher/blob/master/myJmh/Factorial_fjb04.log)  

given:  
*$ tail -40 Factorial_fjb04.log*  
produced:

    Result "com.stuff2ponder.Factorial_fjb04.evalFactorialLongStreamFallbackDouble":
      0.875 ±(99.9%) 0.009 ops/us [Average]
      (min, avg, max) = (0.872, 0.875, 0.878), stdev = 0.002
      CI (99.9%): [0.866, 0.885] (assumes normal distribution)

    # Run complete. Total time: 00:04:33

    Benchmark                                              (baseLong)   Mode  Cnt     Score    Error   Units
    Factorial_fjb04.evalEmptyLoop                                   2  thrpt    5  1689.905 ±  8.597  ops/us
    Factorial_fjb04.evalEmptyLoop                                  19  thrpt    5  1691.440 ±  2.703  ops/us
    Factorial_fjb04.evalEmptyLoop                                  20  thrpt    5  1691.224 ±  4.018  ops/us
    Factorial_fjb04.evalEmptyLoop                                  21  thrpt    5  1690.945 ±  5.059  ops/us
    Factorial_fjb04.evalEmptyLoop                                  32  thrpt    5  1690.605 ±  2.132  ops/us
    Factorial_fjb04.evalEmptyLoop                                  64  thrpt    5  1690.599 ±  6.139  ops/us
    Factorial_fjb04.evalEmptyLoop                                 128  thrpt    5  1532.611 ±  9.029  ops/us
    Factorial_fjb04.evalEmptyLoop                                 256  thrpt    5  1639.700 ±  5.203  ops/us
    Factorial_fjb04.evalFactorialAsLog10                            2  thrpt    5     4.327 ±  0.018  ops/us
    Factorial_fjb04.evalFactorialAsLog10                           19  thrpt    5     0.433 ±  0.002  ops/us
    Factorial_fjb04.evalFactorialAsLog10                           20  thrpt    5     0.420 ±  0.002  ops/us
    Factorial_fjb04.evalFactorialAsLog10                           21  thrpt    5     0.441 ±  0.005  ops/us
    Factorial_fjb04.evalFactorialAsLog10                           32  thrpt    5     0.260 ±  0.003  ops/us
    Factorial_fjb04.evalFactorialAsLog10                           64  thrpt    5     0.157 ±  0.001  ops/us
    Factorial_fjb04.evalFactorialAsLog10                          128  thrpt    5     0.073 ±  0.001  ops/us
    Factorial_fjb04.evalFactorialAsLog10                          256  thrpt    5     0.037 ±  0.001  ops/us
    Factorial_fjb04.evalFactorialBigLongLoopFallbackLog10           2  thrpt    5    34.283 ±  0.436  ops/us
    Factorial_fjb04.evalFactorialBigLongLoopFallbackLog10          19  thrpt    5     1.785 ±  0.038  ops/us
    Factorial_fjb04.evalFactorialBigLongLoopFallbackLog10          20  thrpt    5     1.644 ±  0.033  ops/us
    Factorial_fjb04.evalFactorialBigLongLoopFallbackLog10          21  thrpt    5     0.441 ±  0.001  ops/us
    Factorial_fjb04.evalFactorialBigLongLoopFallbackLog10          32  thrpt    5     0.261 ±  0.001  ops/us
    Factorial_fjb04.evalFactorialBigLongLoopFallbackLog10          64  thrpt    5     0.157 ±  0.001  ops/us
    Factorial_fjb04.evalFactorialBigLongLoopFallbackLog10         128  thrpt    5     0.073 ±  0.001  ops/us
    Factorial_fjb04.evalFactorialBigLongLoopFallbackLog10         256  thrpt    5     0.037 ±  0.001  ops/us
    Factorial_fjb04.evalFactorialLongStreamFallbackDouble           2  thrpt    5    52.321 ±  1.101  ops/us
    Factorial_fjb04.evalFactorialLongStreamFallbackDouble          19  thrpt    5    12.779 ±  0.218  ops/us
    Factorial_fjb04.evalFactorialLongStreamFallbackDouble          20  thrpt    5    12.318 ±  0.034  ops/us
    Factorial_fjb04.evalFactorialLongStreamFallbackDouble          21  thrpt    5     8.435 ±  0.114  ops/us
    Factorial_fjb04.evalFactorialLongStreamFallbackDouble          32  thrpt    5     6.074 ±  0.053  ops/us
    Factorial_fjb04.evalFactorialLongStreamFallbackDouble          64  thrpt    5     3.197 ±  0.035  ops/us
    Factorial_fjb04.evalFactorialLongStreamFallbackDouble         128  thrpt    5     1.688 ±  0.034  ops/us
    Factorial_fjb04.evalFactorialLongStreamFallbackDouble         256  thrpt    5     0.875 ±  0.009  ops/us

----
![Factorial_fjb04.png](/myJmh/images/Factorial_fjb04.png "Factorial_fjb04.png")
