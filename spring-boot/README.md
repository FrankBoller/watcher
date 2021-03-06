## spring-boot demos
This overview is intended as a study guide.  
* highly condensed from referenced docs and sites
* configurations used:
    * [Apache Maven](https://maven.apache.org/): 3.3.9
    * [Java](http://www.oracle.com/technetwork/java/javase/downloads/index.html): 1.8.0_111
    * Windows 10 Pro 1703 15063.332
        * [Cygwin](https://www.cygwin.com): CYGWIN_NT-10.0-WOW myLocalCpu 2.8.0(0.309/5/3) 2017-04-01 20:42 i686 Cygwin
    * Ubuntu 16.04.2 LTS
* [Spring IO](https://spring.io/): helps development teams everywhere build simple, portable, fast and flexible JVM-based systems and applications.
    * [Spring Initializr](https://start.spring.io/): . Add Spring Boot Starters and dependencies to your application. Search for dependencies.
* [GitHub: Spring Guides](https://github.com/spring-guides): Repositories behind the Getting Started and Tutorial guides at spring.io
    * [GitHub: spring-io/initializr](https://github.com/spring-io/initializr): A web-based quickstart generator https://start.spring.io
        * "curl" an instance to get a **usage page** with examples (try: **curl start.spring.io**)
        * Generate a Project (try: **curl https://start.spring.io/starter.zip -o demo.zip**)
        * Grab metadata in text format (try: **curl https://start.spring.io**)
        * Grab metadata in json format (try: **curl -H 'Accept: application/json' https://start.spring.io**)
        * Metadata exposes a rich API for creating spring-boot with many dependencies and options
    * [GitHub: gs-serving-web-content](https://github.com/spring-guides/gs-serving-web-content): Learn how to create a web page with Spring MVC.
        * this is one-of-many projects from the Guides
        * try this example. First clone, build, test, and run a complete working sample
            * type **git clone https://github.com/spring-guides/gs-serving-web-content.git**
            * **cd gs-serving-web-content/complete**
            * build, test and run spring-boot with Tomcat in background
                * type: **mvn test**
                * type: **mvn spring-boot:run | grep -v 'DEBUG\|INFO' &** (or don't use '&' and run in separate window)
                * note: using bash shell from [Cygwin](https://www.cygwin.com) and/or [Linux](https://www.ubuntu.com)
                    * grep will remove log messages with level DEBUG or INFO
                    * '&' will run task in background, which will continue running until killed
            * **OR** build, test and package into uber-jar and run
                * type: **mvn package**
                * type: **java -jar target/gs-serving-web-content-0.1.0.jar**
            * make rest call on command line
                * type: **curl localhost:8080/greeting** (or use URL in browser)
                * ``` <!DOCTYPE HTML>
                    <html>
                    <head>
                        <title>Getting Started: Serving Web Content</title>
                        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
                    </head>
                    <body>
                        <p>Hello, World!</p>
                    </body>
                    </html> ```
                * when finished, type: kill %1 (for example) or kill in task manager
        * next, create this same example 'from scratch'.
            * ** cd ../initial **
            * follow directions from **[gs-serving-web-content#create-a-web-controller](https://github.com/spring-guides/gs-serving-web-content#create-a-web-controller)**
            * build and test -> run spring-boot -> make rest call in browser and/or command line

