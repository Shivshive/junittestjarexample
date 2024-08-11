FROM amazoncorretto
WORKDIR /junittestjarexample
COPY ./junit-platform-console-standalone-1.9.3.jar /junittestjarexample
COPY ./target/application-0.0.1-SNAPSHOT-shaded.jar /junittestjarexample
COPY ./target/junittestjarexample-0.0.1-SNAPSHOT.jar /junittestjarexample
COPY ./target/junittestjarexample-0.0.1-SNAPSHOT-tests.jar /junittestjarexample
COPY ./target/lib /junittestjarexample/lib
CMD ["tail", "-f", "/dev/null"]