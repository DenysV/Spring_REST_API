FROM openjdk:8-jdk-alpine
MAINTAINER denzelSpain.com
COPY target/REST_API-0.0.1-SNAPSHOT.jar /opt/spring-cloud/lib/
ENV SPRING_APPLICATION_JSON='{"spring": {"cloud": {"config": {"server": \
    {"git": {"uri": "/var/lib/spring-cloud/config-repo", "clone-on-start": true}}}}}}'
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/spring-cloud/lib/REST_API-0.0.1-SNAPSHOT.jar"]
VOLUME /var/lib/spring-cloud/config-repo
EXPOSE 8080