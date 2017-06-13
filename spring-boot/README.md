## spring-boot demos
This overview is intended as a study guide.  
* highly condensed from referenced docs and sites
* configurations used:
    * [Apache Maven](https://maven.apache.org/): 3.3.9
    * [Java](http://www.oracle.com/technetwork/java/javase/downloads/index.html): 1.8.0_111
    * Windows 10 Pro 1703 15063.332
        * [Cygwin](https://www.cygwin.com): CYGWIN_NT-10.0-WOW myLocalCpu 2.8.0(0.309/5/3) 2017-04-01 20:42 i686 Cygwin
    * Ubuntu 16.04.2 LTS
* [Spring IO](https://spring.io/): Spring helps development teams everywhere build simple, portable,  fast and flexible JVM-based systems and applications.
    * [Spring Initializr](https://start.spring.io/): Spring Initializr bootstrap your application now ... Dependencies. Add Spring Boot Starters and dependencies to your application. Search for dependencies.
* [GitHub: Spring Guides](https://github.com/spring-guides): Repositories behind the Getting Started and Tutorial guides at spring.io
    * [GitHub: spring-io/initializr](https://github.com/spring-io/initializr): A web-based quickstart generator for Spring projects https://start.spring.io
        * "curl" an instance to get a *usage page* with examples (try: *curl start.spring.io*)
        * Generate a Project (try: *curl https://start.spring.io/starter.zip -o demo.zip*)
        * Grab metadata in text format (try: *curl https://start.spring.io*)
        * Grab metadata in json format (try: *curl -H 'Accept: application/json' https://start.spring.io*)
        * Metadata exposes a rich API for creating spring-boot with many dependencies and options
    * [GitHub: gs-serving-web-content](https://github.com/spring-guides): Serving Web Content with Spring MVC :: Learn how to create a web page with Spring MVC.
        * this is one-of-many projects from the Guides
        * [gs-serving-web-content](https://github.com/spring-guides/gs-serving-web-content): Serving Web Content with Spring MVC :: Learn how to create a web page with Spring MVC.
            * example: *git clone https://github.com/spring-guides/gs-serving-web-content.git*
            * 1st, just run a complete working sample
                * cd gs-serving-web-content/complete
                * build and test
                    * type: mvn test
                * run spring-boot with Tomcat in background
                    * type: mvn spring-boot:run | grep -v 'DEBUG\|INFO' &
                * make rest call on command line
                    * type: curl localhost:8080/greeting
                    * output:
                    ``` <!DOCTYPE HTML>

                        <html>
                        <head>
                            <title>Getting Started: Serving Web Content</title>
                            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
                        </head>
                        <body>
                            <p>Hello, World!</p>
                        </body>
                        </html>
                    ```

