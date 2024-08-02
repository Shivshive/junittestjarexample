java -cp target\lib\*;target\junittestjarexample-0.0.1-SNAPSHOT.jar;target\junittestjarexample-0.0.1-SNAPSHOT-tests.jar; org.junit.platform.console.ConsoleLauncher --select-class com.example.StudentTest


java -cp lib\*;junittestjarexample-0.0.1-SNAPSHOT.jar;junittestjarexample-0.0.1-SNAPSHOT-tests.jar; org.junit.platform.console.ConsoleLauncher --select-class com.example.Runner

---- OLD way 👆 --------------

java -cp lib\*;junittestjarexample-0.0.1-SNAPSHOT.jar;junittestjarexample-0.0.1-SNAPSHOT-tests.jar; org.junit.platform.console.ConsoleLauncher --select-class com.example.Runner


working -- > 
java -jar junit-platform-console-standalone-1.9.3.jar --class-path application-0.0.1-SNAPSHOT-shaded.jar;junittestjarexample-0.0.1-SNAPSHOT-tests.jar -c com.example.Runner
