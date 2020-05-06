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
|SmallRye OpenTracing|./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-smallrye-opentracing"|
|REST Client|./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-rest-client"|
|Lombok|-|


### Acessando o OpenAPI - Swagger
O OpenAPI Specification(anteriormente Swagger Specification) é um formato de descrição de API para APIs RES, conforme o [site oficial](https://swagger.io/docs/specification/about/).

    http://localhost:8080/swagger-ui/

### Health Check

    http://localhost:8080/health 
    http://localhost:8080/health/live
    http://localhost:8080/health/ready


### Jaeger
Jaeger, inspirado em Dapper e OpenZipkin , é um sistema de rastreamento distribuído lançado como código aberto pela Uber Technologies . É usado para monitorar e solucionar problemas de sistemas distribuídos baseados em microsserviços, conforme o [site oficial](https://www.jaegertracing.io/docs/1.14/).

Docker:

    docker run -d --name jaeger \
      -e COLLECTOR_ZIPKIN_HTTP_PORT=9411 \
      -p 5775:5775/udp \
      -p 6831:6831/udp \
      -p 6832:6832/udp \
      -p 5778:5778 \
      -p 16686:16686 \
      -p 14268:14268 \
      -p 9411:9411 \
      jaegertracing/all-in-one:1.14

Acesso:

    http://localhost:16686
    

### Postgres

    docker run --ulimit memlock=-1:-1 \
	--rm=true \
	--memory-swappiness=0 \
	--name my-postgres \
	-e POSTGRES_USER=postgres \
	-e POSTGRES_PASSWORD=postgres \
	-e POSTGRES_DB=orders \
	-p 5432:5432 \
	-d postgres:10.5    
    
