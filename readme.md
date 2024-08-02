### JunitTestJarExample [ Run Junit 5 Test Case via Command Line using Console Launcher API ]

- Exzmple to show case use of Console Launcher introduced in **Junit5**.

***About***
Here we are trying to run Junit 5 Test Cases which are archived in the JAR, via command line using Junit 5 [Console Launcher API](https://junit.org/junit5/docs/current/user-guide/#running-tests-console-launcher) 

##### Project Directory Structure

```
📦junittestjarexample
 ┣ 📂src
 ┃ ┣ 📂main
 ┃ ┃ ┣ 📂java
 ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┗ 📂example
 ┃ ┃ ┃ ┃ ┃ ┗ 📜Student.java
 ┃ ┃ ┗ 📂resources
 ┃ ┗ 📂test
 ┃ ┃ ┣ 📂java
 ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┗ 📂example
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Runner.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜SeleniumTest.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜StudentTest.java
 ┃ ┃ ┗ 📂resources
 ┣ 📂target
 ┃ ┣ 📂classes
 ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┗ 📂example
 ┃ ┃ ┃ ┃ ┗ 📜Student.class
 ┃ ┣ 📂generated-sources
 ┃ ┃ ┗ 📂annotations
 ┃ ┣ 📂generated-test-sources
 ┃ ┃ ┗ 📂test-annotations
 ┃ ┣ 📂lib
 ┃ ┃ ┣ 📜apiguardian-api-1.1.2.jar
 ┃ ┃ ┣ 📜auto-service-annotations-1.1.1.jar
 ┃ ┃ ┣ 📜byte-buddy-1.14.18.jar
 ┃ ┃ ┣ 📜checker-qual-3.42.0.jar
 ┃ ┃ ┣ 📜commons-exec-1.4.0.jar
 ┃ ┃ ┣ 📜error_prone_annotations-2.26.1.jar
 ┃ ┃ ┣ 📜failsafe-3.3.2.jar
 ┃ ┃ ┣ 📜failureaccess-1.0.2.jar
 ┃ ┃ ┣ 📜guava-33.2.1-jre.jar
 ┃ ┃ ┣ 📜hamcrest-core-1.3.jar
 ┃ ┃ ┣ 📜j2objc-annotations-3.0.0.jar
 ┃ ┃ ┣ 📜jsr305-3.0.2.jar
 ┃ ┃ ┣ 📜junit-4.13.2.jar
 ┃ ┃ ┣ 📜junit-jupiter-5.10.3.jar
 ┃ ┃ ┣ 📜junit-jupiter-api-5.10.3.jar
 ┃ ┃ ┣ 📜junit-jupiter-engine-5.10.3.jar
 ┃ ┃ ┣ 📜junit-jupiter-params-5.10.3.jar
 ┃ ┃ ┣ 📜junit-platform-commons-1.10.3.jar
 ┃ ┃ ┣ 📜junit-platform-console-1.10.3.jar
 ┃ ┃ ┣ 📜junit-platform-console-standalone-1.10.3.jar
 ┃ ┃ ┣ 📜junit-platform-engine-1.10.3.jar
 ┃ ┃ ┣ 📜junit-platform-launcher-1.10.3.jar
 ┃ ┃ ┣ 📜junit-platform-reporting-1.10.3.jar
 ┃ ┃ ┣ 📜junit-platform-runner-1.10.3.jar
 ┃ ┃ ┣ 📜junit-platform-suite-api-1.10.3.jar
 ┃ ┃ ┣ 📜junit-platform-suite-commons-1.10.3.jar
 ┃ ┃ ┣ 📜junit-vintage-engine-5.10.3.jar
 ┃ ┃ ┣ 📜listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar
 ┃ ┃ ┣ 📜opentelemetry-api-1.40.0.jar
 ┃ ┃ ┣ 📜opentelemetry-api-incubator-1.40.0-alpha.jar
 ┃ ┃ ┣ 📜opentelemetry-context-1.40.0.jar
 ┃ ┃ ┣ 📜opentelemetry-exporter-logging-1.40.0.jar
 ┃ ┃ ┣ 📜opentelemetry-sdk-1.40.0.jar
 ┃ ┃ ┣ 📜opentelemetry-sdk-common-1.40.0.jar
 ┃ ┃ ┣ 📜opentelemetry-sdk-extension-autoconfigure-1.40.0.jar
 ┃ ┃ ┣ 📜opentelemetry-sdk-extension-autoconfigure-spi-1.40.0.jar
 ┃ ┃ ┣ 📜opentelemetry-sdk-logs-1.40.0.jar
 ┃ ┃ ┣ 📜opentelemetry-sdk-metrics-1.40.0.jar
 ┃ ┃ ┣ 📜opentelemetry-sdk-trace-1.40.0.jar
 ┃ ┃ ┣ 📜opentelemetry-semconv-1.25.0-alpha.jar
 ┃ ┃ ┣ 📜opentest4j-1.3.0.jar
 ┃ ┃ ┣ 📜selenium-api-4.23.0.jar
 ┃ ┃ ┣ 📜selenium-chrome-driver-4.23.0.jar
 ┃ ┃ ┣ 📜selenium-chromium-driver-4.23.0.jar
 ┃ ┃ ┣ 📜selenium-devtools-v125-4.23.0.jar
 ┃ ┃ ┣ 📜selenium-devtools-v126-4.23.0.jar
 ┃ ┃ ┣ 📜selenium-devtools-v127-4.23.0.jar
 ┃ ┃ ┣ 📜selenium-devtools-v85-4.23.0.jar
 ┃ ┃ ┣ 📜selenium-edge-driver-4.23.0.jar
 ┃ ┃ ┣ 📜selenium-firefox-driver-4.23.0.jar
 ┃ ┃ ┣ 📜selenium-http-4.23.0.jar
 ┃ ┃ ┣ 📜selenium-ie-driver-4.23.0.jar
 ┃ ┃ ┣ 📜selenium-java-4.23.0.jar
 ┃ ┃ ┣ 📜selenium-json-4.23.0.jar
 ┃ ┃ ┣ 📜selenium-manager-4.23.0.jar
 ┃ ┃ ┣ 📜selenium-os-4.23.0.jar
 ┃ ┃ ┣ 📜selenium-remote-driver-4.23.0.jar
 ┃ ┃ ┣ 📜selenium-safari-driver-4.23.0.jar
 ┃ ┃ ┗ 📜selenium-support-4.23.0.jar
 ┃ ┣ 📂maven-archiver
 ┃ ┃ ┗ 📜pom.properties
 ┃ ┣ 📂maven-status
 ┃ ┃ ┗ 📂maven-compiler-plugin
 ┃ ┃ ┃ ┣ 📂compile
 ┃ ┃ ┃ ┃ ┗ 📂default-compile
 ┃ ┃ ┃ ┃ ┃ ┣ 📜createdFiles.lst
 ┃ ┃ ┃ ┃ ┃ ┗ 📜inputFiles.lst
 ┃ ┃ ┃ ┗ 📂testCompile
 ┃ ┃ ┃ ┃ ┗ 📂default-testCompile
 ┃ ┃ ┃ ┃ ┃ ┣ 📜createdFiles.lst
 ┃ ┃ ┃ ┃ ┃ ┗ 📜inputFiles.lst
 ┃ ┣ 📂test-classes
 ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┗ 📂example
 ┃ ┃ ┃ ┃ ┣ 📜Runner.class
 ┃ ┃ ┃ ┃ ┣ 📜SeleniumTest.class
 ┃ ┃ ┃ ┃ ┗ 📜StudentTest.class
 ┃ ┣ 📜application-0.0.1-SNAPSHOT-shaded.jar
 ┃ ┣ 📜junit-platform-console-standalone-1.9.3.jar
 ┃ ┣ 📜junittestjarexample-0.0.1-SNAPSHOT-tests.jar
 ┃ ┗ 📜junittestjarexample-0.0.1-SNAPSHOT.jar
 ┣ 📜.classpath
 ┣ 📜.project
 ┣ 📜junit-platform-console-standalone-1.9.3.jar
 ┣ 📜pom.xml
 ┣ 📜readme.txt
 ┗ 📜Screenshot 2024-08-02 002919.jpg
```
**Used POM.xml**
```xml
	<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>sample.junit5.jarexample</groupId>
	<artifactId>junittestjarexample</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<properties>
		<java.version>17</java.version>
		<maven.compiler.source>17</maven.compiler.source>
		<maven.compiler.target>17</maven.compiler.target>
	</properties>
	<build>
		<plugins>
			<plugin> 
				<groupId>org.apache.maven.plugins</groupId> <!-- Plugin to copy dependencies to a certain location like here in the target\lib folder -->
				<artifactId>maven-dependency-plugin</artifactId>
				<version>3.7.1</version>
				<executions>
					<execution>
						<id>copy-dependencies</id>
						<phase>package</phase>
						<goals>
							<goal>copy-dependencies</goal>
						</goals>
						<configuration>
							<outputDirectory>${project.build.directory}/lib</outputDirectory>
							<overWriteReleases>false</overWriteReleases>
							<overWriteSnapshots>false</overWriteSnapshots>
							<overWriteIfNewer>true</overWriteIfNewer>
						</configuration>
					</execution>
				</executions>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId> <!-- Plugin to create a src\test JAR-->
				<artifactId>maven-jar-plugin</artifactId>
				<version>2.4</version>
				<executions>
					<execution>
						<goals>
							<goal>test-jar</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-shade-plugin</artifactId> <!-- Plugin to create a FAT JAR with all dependencies -->
				<version>3.2.2</version>
				<configuration>
					<transformers>
						<transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
						</transformer>
					</transformers>
					<shadedArtifactAttached>true</shadedArtifactAttached>
					<shadedArtifactId>application</shadedArtifactId>
				</configuration>
				<executions>
					<execution>
						<phase>package</phase>
						<goals>
							<goal>shade</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
	<dependencies>
		<dependency>
			<groupId>org.junit.jupiter</groupId>
			<artifactId>junit-jupiter</artifactId>
			<version>5.10.3</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.junit.vintage</groupId>
			<artifactId>junit-vintage-engine</artifactId>
			<version>5.10.3</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.junit.platform</groupId>
			<artifactId>junit-platform-launcher</artifactId>
			<version>1.10.3</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.junit.platform</groupId>
			<artifactId>junit-platform-runner</artifactId>
			<version>1.10.3</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.junit.platform</groupId>
			<artifactId>junit-platform-commons</artifactId>
			<version>1.10.3</version>
		</dependency>
		<dependency>
			<groupId>org.junit.platform</groupId>
			<artifactId>junit-platform-console</artifactId>
			<version>1.10.3</version>
		</dependency>
		<dependency>
			<groupId>org.junit.platform</groupId>
			<artifactId>junit-platform-console-standalone</artifactId> <!-- Dependency for executing junit test via command line using console launcher api -->
			<version>1.10.3</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>4.23.0</version>
		</dependency>
	</dependencies>
</project>
```

**Command for Console Launcher To Execute Tests**
**Old way** -- When we need to supply jars externally which are placed inside target\lib\* folder
```shell
cd target
java -cp lib\*;junittestjarexample-0.0.1-SNAPSHOT.jar;junittestjarexample-0.0.1-SNAPSHOT-tests.jar; org.junit.platform.console.ConsoleLauncher --select-class com.example.Runner
```
Output from above command
```console
Thanks for using JUnit! Support its development at https://junit.org/sponsoring

Google
.
+-- JUnit Jupiter [OK]
+-- JUnit Vintage [OK]
'-- JUnit Platform Suite [OK]
  '-- Runner [OK]
    '-- JUnit Jupiter [OK]
      +-- StudentTest [OK]
      | '-- checkPassed(Student) [OK]
      |   +-- [1] com.example.Student@52e7a6b2 [OK]
      |   +-- [2] com.example.Student@7d898981 [OK]
      |   '-- [3] com.example.Student@48d61b48 [OK]
      '-- SeleniumTest [OK]
        '-- runBrowser() [OK]

Test run finished after 3403 ms
[         8 containers found      ]
[         0 containers skipped    ]
[         8 containers started    ]
[         0 containers aborted    ]
[         8 containers successful ]
[         0 containers failed     ]
[         4 tests found           ]
[         0 tests skipped         ]
[         4 tests started         ]
[         0 tests aborted         ]
[         4 tests successful      ]
[         0 tests failed          ]


WARNING: Delegated to the 'execute' command.
         This behaviour has been deprecated and will be removed in a future release.
         Please use the 'execute' command directly.
```

**Recommended new way** -- when we have created a fat jar and using that to run our test cases
```shell
cd target
java -jar junit-platform-console-standalone-1.9.3.jar --class-path application-0.0.1-SNAPSHOT-shaded.jar;junittestjarexample-0.0.1-SNAPSHOT-tests.jar -c com.example.Runner
```
Output from above command
```console
Aug 02, 2024 10:14:15 AM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 127, returning the closest version; found: 125; Please update to a Selenium version that supports CDP version 127
Google

Thanks for using JUnit! Support its development at https://junit.org/sponsoring

.
+-- JUnit Jupiter [OK]
+-- JUnit Vintage [OK]
'-- JUnit Platform Suite [OK]
  '-- Runner [OK]
    '-- JUnit Jupiter [OK]
      +-- StudentTest [OK]
      | '-- checkPassed(Student) [OK]
      |   +-- [1] com.example.Student@740cae06 [OK]
      |   +-- [2] com.example.Student@2a693f59 [OK]
      |   '-- [3] com.example.Student@3f4faf53 [OK]
      '-- SeleniumTest [OK]
        '-- runBrowser() [OK]

Test run finished after 2462 ms
[         8 containers found      ]
[         0 containers skipped    ]
[         8 containers started    ]
[         0 containers aborted    ]
[         8 containers successful ]
[         0 containers failed     ]
[         4 tests found           ]
[         0 tests skipped         ]
[         4 tests started         ]
[         0 tests aborted         ]
[         4 tests successful      ]
[         0 tests failed          ]

```
*Note*:
- application-0.0.1-SNAPSHOT-shaded.jar is a shaded jar (with all dependencies)
- junittestjarexample-0.0.1-SNAPSHOT-tests.jar  contains all src\test classes.
- junittestjarexample-0.0.1-SNAPSHOT.jar contains all src\main\java classes (without external dependencies).
- when using shaded jar we dont need to supply path for target\lib\* as fat jar contains all dependencies also we dont need to use the junittestjarexample-0.0.1-SNAPSHOT.jar as the fat jar contains all classes from src\main\java









