## Welcome to Watcher
### TOC

This is a place for **spectators**

* intended to showcase technology implementation samples, bugs, links and documentation

[//]: <> (This is a comment)
### Philosopy, Frameworks, Libraries, Code Tools and Artifacts
* Philosophy / Methodology
    * [agile](#agile-toc)
    * [kanban vs. scrum](#kanban-vs-scrum-toc)
    * [user story vs job story](#user-story-vs-job-story-toc)
* Framework
    * [arquillian](#arquillian-toc)
    * [devops](#devops-toc)
    * [docker](#docker-toc)
    * [jmh](#jmh-toc)
    * [maven](#maven-toc)
    * [mindmup](#mindmup-toc)
* Platform
    * [fabric8](#fabric8-toc)
* Tool
    * [jenkins](#jenkins-toc)
    * [slack](#slack-toc)
    * [taiga](#taiga-toc)
    * [vagrant](#vagrant-toc)
    * [virtualbox](#virtualbox-toc)
* Language / Library
    * [java8](#java8-toc)
    * [scala](#scala-toc)
    * [polymer](#polymer-toc)

___
## Philosophy / Development Methodology

#### agile [(toc)](#toc)
time boxed, iterative approach to software delivery:
[Manifesto for Agile Software Development](http://agilemanifesto.org/) and [Principles behind the Agile Manifesto](http://agilemanifesto.org/principles.html)

* We are uncovering better ways of developing
software by doing it and helping others do it.

* starting new projects
![newProjectMup.png](/images/startNewProject.png "startNewProject.png")

* [Test-driven development (TDD)](https://en.wikipedia.org/wiki/Test-driven_development): relies on the repetition of a very short development cycle: requirements are turned into very specific test cases, then the software is improved to pass the new tests, only.
![devMethodology.png](/images/devMethodology.png "development methodology")

* [Behavior-driven development (BDD)](https://en.wikipedia.org/wiki/Behavior-driven_development): n software engineering, behavior-driven development (BDD) is a software development process that emerged from test-driven development (TDD)

* [tdd vs bdd](https://codeutopia.net/blog/2015/03/01/unit-testing-tdd-and-bdd/): BDD can, and should be, used together with TDD and unit testing methods

#### kanban vs. scrum [(toc)](#toc)
The question of which work method(s) works best isn’t easy
* [What are the differences?](https://leankit.com/learn/kanban/kanban-vs-scrum/): Which agile software development methodology is better suited...

    concern                        | kanban                                           | scrum
    ---                            | ---                                              | ---
    roles & responsibilities       | no pre-defined roles for a team                  | predefined roles
    due dates / delivery timelines | continious delivery                              | sprints define deliverables
    delegation & prioritization    | team members pull tasks                          | entire batch pulled each iteration
    modifications / changes        | changes can be made mid-stream                   | changes mid-sprint discouraged
    measurement of productivity    | cycle time                                       | velocity through sprints
    best applications              | best for projects with widely-varying priorities | best for teams with stable priorities

#### user story vs job story [(toc)](#toc)
Too many assumptions are dangerous

[Designing features using Job Stories](https://blog.intercom.com/using-job-stories-design-features-ui-ux/): Personas and User Stories made sense when customers and product teams were far from each other. That’s no longer the case

* Traditionally, who the customer was and what they needed fell within the responsibility of marketing, business development, or even sales. After this information was gathered, it would be synthesized into a portable format and then pitched over the fence to a product development team, who was responsible for building the product

[Replacing The User Story With The Job Story](https://jtbd.info/replacing-the-user-story-with-the-job-story-af7cdee10c27):

* We frame every design problem in a Job, focusing on the triggering event or situation, the motivation and goal, and the intended outcome:
When ... , I want to ... , so I can ... .

___
## Framework

#### arquillian [(toc)](#toc)
integration and functional testing platform:
[Dan Allen on Arquillian Testing Framework](https://www.infoq.com/articles/dan-allen-arquillian-framework)

* Arquillian is an integration and functional testing platform that can be used for Java middleware testing. With the main goal of making integration (and functional) tests as simple to write as unit tests, it brings the tests to the runtime environment, freeing developers from managing the runtime from within the test.

also:
[Arquillian Â· Write Real Tests](http://arquillian.org/)

* So you can rule your code. Not the bugs.  No more mocks. No more container lifecycle and deployment hassles. Just real tests!

also:
[BDD Behavior-driven development](https://en.wikipedia.org/wiki/Behavior-driven_development)

* In software engineering, behavior-driven development (BDD) is a software development process that emerged from test-driven development (TDD). ... The tools serve to add automation to the ubiquitous language that is a central theme of BDD.

#### devops [(toc)](#toc)
set of practices:
(DevOps - Wikipedia)[https://en.wikipedia.org/wiki/DevOps]

* DevOps (a clipped compound of "software DEVelopment" and "information technology OPerationS") is a term used to refer to a set of practices that emphasize the collaboration and communication of both software developers and information technology (IT) professionals while automating the process of software delivery and infrastructure changes. It aims at establishing a culture and environment where building, testing, and releasing software can happen rapidly, frequently, and more reliably.

#### docker [(toc)](#toc)
open platform for developers and sysadmins:
[Docker - Build, Ship, and Run Any App, Anywhere](https://www.docker.com/what-docker)

* Docker is the world's leading software container platform. Developers use Docker to eliminate â€śworks on my machineâ€ť problems when collaborating on code with co-workers. Operators use Docker to run and manage apps side-by-side in isolated containers to get better compute density. Enterprises use Docker to build agile software delivery pipelines to ship new features faster, more securely and with confidence for both Linux and Windows Server apps.

#### jmh [(toc)](#toc)
test harness:
[Code Tools: jmh](http://openjdk.java.net/projects/code-tools/jmh/) 

* JMH is a Java harness for building, running, and analysing nano/micro/milli/macro benchmarks written in Java and other languages targetting the JVM.

also:
[Java Performance Tuning Guide](http://java-performance.info/jmh/)

* various tips on improving performance of your Java code

#### maven [(toc)](#toc)
project management:
[Code Tools: maven](https://maven.apache.org/)  

* Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.

#### mindmup [(toc)](#toc)
[MindMup 2](https://drive.mindmup.com/)

* Zero-friction mind mapping, tightly integrated with Google Apps

also:
[Mind map](https://en.wikipedia.org/wiki/Mind_map)

* A mind map is hierarchical and shows relationships among pieces of the whole. It is often created around a single concept, drawn as an image in the center of a blank page, to which associated representations of ideas such as images, words and parts of words are added.

___
## Platform

#### fabric8 [(toc)](#toc)
end to end development platform:
[fabric8: open source Integrated Development Platform for Kubernetes](https://fabric8.io/)

* fabric8 is an end to end development platform spanning ideation to production for the creation of cloud native applications and microservices. You can build, test and deploy your applications via [Continuous Delivery pipelines](http://fabric8.io/guide/cdelivery.html) then [run and manage them](http://fabric8.io/guide/fabric8DevOps.html) with Continuous Improvement and [ChatOps](http://fabric8.io/guide/chat.html)

<!-- * [<img src="/images/fabric8.create-app.png" width="1161" height="963" />](https://fabric8.io/guide/console.html) -->
* [<img src="/images/fabric8.create-app.png" width="800" height="667" />](https://fabric8.io/guide/console.html)

___
## Tool

#### jenkins [(toc)](#toc)
open source automation server:
[Jenkins, Build great things at any scale](https://jenkins.io/)

* The leading open source automation server, Jenkins provides hundreds of plugins to support building, deploying and automating any project.

also:
[Jenkins (software)](https://goo.gl/W5aYnN)

* jenkins.io. Jenkins is an open source automation server written in Java. The project was forked from Hudson after a dispute with Oracle. ... It is a server-based system running in a servlet container such as Apache Tomcat.

#### slack [(toc)](#toc)
team collaboration tool:
[Slack: Where work happens](https://slack.com/)

* Whatever work means for you, Slack brings all the pieces and people you need together so you can actually get things done.

also:
[Slack (software)](https://goo.gl/tGzeQO)

* slack.com. Slack is a cloud-based team collaboration tool. The name is an acronym for "Searchable Log of All Conversation and Knowledge".

#### taiga [(toc)](#toc)
project management:
[Code Tools: taiga](https://taiga.io/)

* Taiga is a project management platform for agile developers & designers and project managers who want a beautiful tool that makes work truly enjoyable.
    * [setup-taiga-vagrant](http://taigaio.github.io/taiga-doc/dist/setup-alternatives.html): taiga-scripts primarily follows the standard installation process, but makes it more automatic

#### vagrant [(toc)](#toc)
open-source software product:
[Introduction to Vagrant](https://www.vagrantup.com/intro/index.html)

* Vagrant is a tool for building and managing virtual machine environments in a single workflow. With an easy-to-use workflow and focus on automation, Vagrant lowers development environment setup time, increases production parity, and makes the "works on my machine" excuse a relic of the past.

#### virtualbox [(toc)](#toc)
software virtualization package:
[Oracle VM VirtualBox](https://www.virtualbox.org/)

* VirtualBox is a powerful x86 and AMD64/Intel64 virtualization product for enterprise as well as home use. Not only is VirtualBox an extremely feature rich, high performance product for enterprise customers, it is also the only professional solution that is freely available as Open Source Software under the terms of the GNU General Public License (GPL) version 2. See "About VirtualBox" for an introduction.

also:
[What is VirtualBox?](https://www.computerhope.com/jargon/v/virtualbox.htm)

* A VirtualBox or VB is a software virtualization package that installs on an operating system as an application. VirtualBox allows additional operating systems to be installed on it, as a Guest OS, and run in a virtual environment. In 2010, VirtualBox was the most popular virtualization software application.

___
## Language / Library

#### java8 [(toc)](#toc)
[java8: revolutionary release of the world's #1 development platform](http://www.oracle.com/technetwork/java/javase/downloads)

* The JDK is a development environment for building applications, applets, and components using the Java programming language
 
#### scala [(toc)](#toc)
[scala: Object-Oriented Meets Functional](https://www.scala-lang.org/)

* Have the best of both worlds. Construct elegant class hierarchies for maximum code reuse and extensibility, implement their behavior using higher-order functions. Or anything in-between.

#### polymer [(toc)](#toc)
library for creating Web Components:
[Welcome - Polymer Project](https://www.polymer-project.org/)

* Unlock the Power of Web Components. Polymer is a JavaScript library that helps you create custom reusable HTML elements, and use them to build performant, maintainable apps.

also:
[Here's the difference between Polymer and Angular](http://www.binpress.com/blog/2014/06/26/polymer-vs-angular/)

* Angular is a complete framework for building webapps, whereas Polymer is a library for creating Web Components. Those components, however, can then be used to build a webapp. Angular has high-level APIs for things like services, routing, server communication and the like.
