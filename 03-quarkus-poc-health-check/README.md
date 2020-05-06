# quarkus-poc

### Executar aplicação
./mvnw compile quarkus:dev

### Adicionando bibliotecas via terminal

| Bibliotecas        | Comando           |
| ------------- |:-------------:|
|Hibernate ORM  |./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-hibernate-orm"|
|Hibernate ORM with Panache|./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-hibernate-orm-panache"|
|JDBC Driver - H2|./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-jdbc-h2"|
|RESTEasy JSON-B|./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-resteasy-jsonb"|
|SmallRye OpenAPI|./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-smallrye-openapi"|
|JDBC Driver - PostgreSQL|./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-jdbc-postgresql"|
|SmallRye Health|./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-smallrye-health"|
|Lombok|-|


### Acessando o OpenAPI - Swagger
O OpenAPI Specification(anteriormente Swagger Specification) é um formato de descrição de API para APIs RES, conforme o [site oficial](https://swagger.io/docs/specification/about/).

http://localhost:8080/swagger-ui/

### Health Check

    http://localhost:8080/health 
    http://localhost:8080/health/live
    http://localhost:8080/health/ready



