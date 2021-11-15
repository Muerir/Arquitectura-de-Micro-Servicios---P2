FROM azul/zulu-openjdk:11.0.10
RUN apt update

ARG DEPENDENCY=./target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

#COPY target/ms-student-0.0.1.jar ms-student-0.0.1.jar

ENV SERVER_PORT 8181
ENV EUREKA_URI http://localhost:8763/eureka

ENTRYPOINT ["java", \
            "-cp",            \
            "app:app/lib/*",                  \
            "Arquitectura.Software.msgateway.MsGatewayApplication"]