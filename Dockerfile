FROM openjdk:17
EXPOSE 8082
ADD target/product.jar product.jar
ENTRYPOINT ["java","jar","/product.jar"]