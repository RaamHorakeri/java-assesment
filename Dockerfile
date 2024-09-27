
FROM ubuntu:20.04
WORKDIR /app
COPY pom.xml ./
ADD https://dlcdn.apache.org/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.tar.gz ./
RUN tar -xzvf apache-maven-3.9.9-bin.tar.gz 
RUN mvn clean install
COPY src ./
EXPOSE 8080
CMD ['JAVA' '-JAR' ]
