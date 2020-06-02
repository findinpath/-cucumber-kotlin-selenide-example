Cucumber with Selenide example
==============================

This project represents a port to Kotlin of the Java project https://github.com/selenide-examples/cucumber
that illustrates how [Selenide](https://selenide.org/) integrates with [Cucumber](https://cucumber.io/docs/installation/java/).

On top of the existing functionality, this project has a showcase on how to use the integrated
proxy functionality in the Selenium webdriver for capturing the content of HTTP requests/responses
made during the tests.

Run the tests by executing 

```
mvn clean test
```


## Troubleshooting

### Firefox proxy issues
By default, the Chrome browser is being used by Selenide for tests.
Running the tests with `-Dselenide.browser=firefox` causes the following issue:

```
org.openqa.selenium.WebDriverException: Reached error page: about:neterror?e=proxyResolveFailure&u=https%3A//google.com/ncr&c=UTF-8&f=regular&d=Firefox%20is%20configured%20to%20use%20a%20proxy%20server%20that%20can%E2%80%99t%20be%20found.
```

due to the inability of the browser to work with a proxy.

### Maven repository
Selenide works with [webdrivermanager](https://github.com/bonigarcia/webdrivermanager) for downloading
the browser executables.
In case that your maven repository doesn't match to the location `~/.m2/repository`: 

```
wdm.cachePath=~/.m2/repository/webdriver
```

then add a corresponding entry `-Dwdm.cachePath` on the command line when running the tests.

