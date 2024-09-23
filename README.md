# Cucumber Demo

This project demonstrates a bug introduced in IntelliJ IDEA 2024 where
the running a Cucumber scenario or feature from the IDE fails to locate
the context configuration class.

The run configuration "Scenario: Demo Scenario" fails with the exception:

```text
Exception in thread "main" io.cucumber.core.backend.CucumberBackendException: Please annotate a glue class with some context configuration.

For example:

   @CucumberContextConfiguration
   @SpringBootTest(classes = TestConfig.class)
   public class CucumberSpringConfiguration { }
Or: 

   @CucumberContextConfiguration
   @ContextConfiguration( ... )
   public class CucumberSpringConfiguration { }
```

This works with IntelliJ IDEA 2023.3.8.  It fails with 2024.2.2 and also
earlier versions of 2024.1 (I can't recall exact version).

# Notes
       
The structure of this project is a cut down version of one we use to be
able to select modules when running the full build usig Gradle. We
either run against the application running in the same JVM using
`@SpringBootTest` ot against the built docker container using
`@ContextConfiguration`.

