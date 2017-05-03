# jmh
test harness:
[Code Tools: jmh](http://openjdk.java.net/projects/code-tools/jmh/) 

* JMH is a Java harness for building, running, and analysing nano/micro/milli/macro benchmarks written in Java and other languages targetting the JVM.

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
    com.stuff2ponder.Factorial_fjb04.evalLoopEmpty  
    com.stuff2ponder.Factorial_fjb04.evalLoopFactorialLoop  
    com.stuff2ponder.Factorial_fjb04.evalLoopFactorialStream  
    com.stuff2ponder.Perf_fjb03.evalLoopEmpty  
    com.stuff2ponder.Perf_fjb03.evalLoopStringBuffer  
    com.stuff2ponder.Perf_fjb03.evalLoopStringBuilder  

jmh given a flag "-l 04":  
*$ java -jar target/benchmarks.jar -l 04*  
produces:

    Benchmarks:  
    com.stuff2ponder.Factorial_fjb04.evalLoopEmpty  
    com.stuff2ponder.Factorial_fjb04.evalLoopFactorialLoop  
    com.stuff2ponder.Factorial_fjb04.evalLoopFactorialStream  

example (with optional flags) {run today} :  
*$ java -jar target/benchmarks.jar -f 1 -wi 3 -i 2 -tu s -o Factorial_fjb04.txt Factorial_fjb04*  
produced file: [Factorial_fjb04.log](https://github.com/FrankBoller/watcher/blob/master/myJmh/Factorial_fjb04.log)  

given:  
*$ tail -22 Factorial_fjb04.log*  
produced:

    # Run complete. Total time: 00:01:39  
    
    Benchmark                                (baseLong)   Mode  Cnt           Score   Error  Units  
    Factorial_fjb04.evalLoopEmpty                    19  thrpt    2  1690500347.123          ops/s  
    Factorial_fjb04.evalLoopEmpty                    20  thrpt    2  1689441185.351          ops/s  
    Factorial_fjb04.evalLoopEmpty                    21  thrpt    2  1640087956.706          ops/s  
    Factorial_fjb04.evalLoopEmpty                    55  thrpt    2  1689739183.782          ops/s  
    Factorial_fjb04.evalLoopEmpty                    56  thrpt    2  1690757787.532          ops/s  
    Factorial_fjb04.evalLoopEmpty                    57  thrpt    2  1691815001.906          ops/s  
    Factorial_fjb04.evalLoopFactorialLoop            19  thrpt    2     1633049.276          ops/s  
    Factorial_fjb04.evalLoopFactorialLoop            20  thrpt    2     1524007.329          ops/s  
    Factorial_fjb04.evalLoopFactorialLoop            21  thrpt    2      705355.177          ops/s  
    Factorial_fjb04.evalLoopFactorialLoop            55  thrpt    2      295302.594          ops/s  
    Factorial_fjb04.evalLoopFactorialLoop            56  thrpt    2      343908.677          ops/s  
    Factorial_fjb04.evalLoopFactorialLoop            57  thrpt    2      352828.258          ops/s  
    Factorial_fjb04.evalLoopFactorialStream          19  thrpt    2    12864422.338          ops/s  
    Factorial_fjb04.evalLoopFactorialStream          20  thrpt    2    12288766.579          ops/s  
    Factorial_fjb04.evalLoopFactorialStream          21  thrpt    2     8540723.841          ops/s  
    Factorial_fjb04.evalLoopFactorialStream          55  thrpt    2     3692131.793          ops/s  
    Factorial_fjb04.evalLoopFactorialStream          56  thrpt    2     3617332.960          ops/s  
    Factorial_fjb04.evalLoopFactorialStream          57  thrpt    2     3582490.155          ops/s  


