# quarkus-poc

### Executar aplicação
./mvnw compile quarkus:dev
./mvnw compile quarkus:dev -Dquarkus.profile=dev

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
|Flyway|./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-flyway"|
|OpenID Connect|./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-oidc"|
|Lombok|-|


### Acessando o OpenAPI - Swagger
O OpenAPI Specification(anteriormente Swagger Specification) é um formato de descrição de API para APIs RES, conforme o [site oficial](https://swagger.io/docs/specification/about/).

    http://localhost:8080/swagger-ui/

### Health Check

    http://localhost:8080/health 
    http://localhost:8080/health/live
    http://localhost:8080/health/ready

## Rastreabilidade
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
    
## Base
### Postgres
    docker network create --driver bridge postgres-network
    
    docker run --ulimit memlock=-1:-1 \
        --network=postgres-network \
        --rm=true \
        --memory-swappiness=0 \
        --name my-postgres \
        -e POSTGRES_USER=postgres \
        -e POSTGRES_PASSWORD=postgres \
        -e POSTGRES_DB=orders \
        -p 5432:5432 \
        -d postgres:10.5    

    docker run --name pgadmin4 \
        --network=postgres-network \
        -p 15432:80 \
        -e "PGADMIN_DEFAULT_EMAIL=my-mail@gmail.com" \
        -e "PGADMIN_DEFAULT_PASSWORD=postgres" \
        -d dpage/pgadmin4   
        

Acesso ao pgadmin4:
http://localhost:15432/browser

## Segurança
### Keycloak
O Keycloak é uma solução de gerenciamento de acesso e identidade de código aberto voltada para aplicativos e serviços modernos. Facilita a proteção de aplicativos e serviços com pouco ou nenhum código, conforme o [site oficial](https://www.keycloak.org/about.html)..

    docker run -d -p 8180:8080 \
  	    -e KEYCLOAK_USER=admin \
  	    -e KEYCLOAK_PASSWORD=admin \
  	    jboss/keycloak
  	    
**Importar realm "quarkus-quickstart.json" no Keycloak**

Acesso:

http://localhost:8180/auth

Exemplo de usuário:

    alice
    alice 
    frontend-service
   
### OpenID
O OpenID Connect é uma camada de identidade simples sobre o protocolo OAuth 2.0. Ele permite que os Clientes verifiquem a identidade do Usuário Final com base na autenticação realizada por um Servidor de Autorização, bem como obtenham informações básicas de perfil sobre o Usuário Final de maneira interoperável e semelhante ao REST, conforme o [site oficial](https://openid.net/connect/).