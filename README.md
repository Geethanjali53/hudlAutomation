# HUDL Test Automation

This project is a maven based project and uses Selenium, junit and cucumber frameworks. This framework has two feature files, with the intention of showing parallel test execution.

**Pre-Requisites**

1) Java should be installed in the test machine. This is expected to be already installed in the test machine. If not installed, please follow the instructions: https://www3.ntu.edu.sg/home/ehchua/programming/howto/JDK_Howto.html
2) Maven should be configured in the test machine so that the 'mvn' command is recognized. If Maven is not installed/configured, please follow the instructions: https://maven.apache.org/install.html or https://www.baeldung.com/install-maven-on-windows-linux-mac
3) Latest version of Chrome and Firefox browsers should be installed. Note that v107.0.5304.62 of the chromedriver and v0.32.0 of geckodriver are bundled in this project (path: "<project root>/src/test/resources/webDrivers"). If a different version of the browser is used, the driver may not be compatible with it, and the driver compatible for that version need to be downloaded and replaced in the webDriver path specified.
   * Link to download geckodriver: https://github.com/mozilla/geckodriver/releases
   * Link to download chromedriver: https://chromedriver.chromium.org/downloads


**Executing tests from the command line**

There are 2 feature files in this project and both will be executed in parallel.

To run tests, execute the following command from the project root directory, based on the platform and browser combination:

On Windows OS, Chrome Browser:
```$xslt
mvn test -Dplatform=windows -Dbrowser=chrome
```

On Windows OS, Firefox Browser:
```$xslt
mvn test -Dplatform=windows -Dbrowser=firefox
```

On Mac OS, Chrome Browser:
```$xslt
mvn test -Dplatform=mac -Dbrowser=chrome
```

On Mac OS, Firefox Browser:
```$xslt
mvn test -Dplatform=mac -Dbrowser=firefox
```

On Linux OS, Chrome Browser:
```$xslt
mvn test -Dplatform=linux -Dbrowser=chrome
```

On Linux OS, Firefox Browser:
```$xslt
mvn test -Dplatform=linux -Dbrowser=firefox
```


**Executing tests from the editor (e.g., Intellij)**

1) Update the platform and browser values in the property file ("<project root>/src/main/resources/properties/hudl_prod.properties")
2) Run the 'JunitTestRunnerTest' class as a junit test


**Report generation**

At the end of the test, extent html reports will be generated (path: <project root>/test-output). A sample report generated in one of the test execution is intentionally included in this project for a quick view without executing any tests.

