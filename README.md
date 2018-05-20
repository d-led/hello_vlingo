# Hello Vlingo

> checking out the [Vlingo Actor Model](https://github.com/vlingo/vlingo-actors) platform

[![Build Status](https://travis-ci.org/d-led/hello_vlingo.svg?branch=master)](https://travis-ci.org/d-led/hello_vlingo)

```
gradle run
```

or

```
mvn clean compile exec:exec
```

or

```
gradle shadowJar && java -jar build/libs/hello_vlingo.jar
```

## Structure

- [main: App](src/main/java/github/dled/demo/App.java)
- [protocol/interface: Greeter](src/main/java/github/dled/demo/Greeter.java)
- [implementation: ConsoleGreeter](src/main/java/github/dled/demo/ConsoleGreeter.java)
- the proxy class is generated upon first run at: [`target/.../Greeter__Proxy.java`](target/generated-sources/github/dled/demo/Greeter__Proxy.java)

## Dependencies

- [vlingo-actors](https://github.com/vlingo/vlingo-actors) MPL-2.0
- [humanize](https://github.com/mfornos/humanize) Apache-2.0
- more: [build.gradle](build.gradle)
