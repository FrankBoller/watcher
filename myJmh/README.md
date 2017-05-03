# jmh
test harness:
[Code Tools: jmh](http://openjdk.java.net/projects/code-tools/jmh/) 

* JMH is a Java harness for building, running, and analysing nano/micro/milli/macro benchmarks written in Java and other languages targetting the JVM.

also:
[Java Performance Tuning Guide](http://java-performance.info/jmh/)

* various tips on improving performance of your Java code

details:

| h1 | h2 |
| ------------------- | --------------------------- |
| build | mvn clean package|
| jmh help | java -jar target/benchmarks.jar -h |
| jmh list tests | java -jar target/benchmarks.jar -l |
