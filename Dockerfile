FROM openjdk:7
COPY ./src/ /tmp
WORKDIR /tmp
RUN javac Main.java
ENTRYPOINT ["java","Main"]