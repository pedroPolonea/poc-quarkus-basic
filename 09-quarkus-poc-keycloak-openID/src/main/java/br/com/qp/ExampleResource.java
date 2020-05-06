package br.com.qp;

import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.OAuthFlow;
import org.eclipse.microprofile.openapi.annotations.security.OAuthFlows;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@SecurityScheme(securitySchemeName = "quarkus-oauth",
        type = SecuritySchemeType.OAUTH2,
        flows = @OAuthFlows(password = @OAuthFlow(tokenUrl = "http://localhost:8180/auth/realms/quarkus-quickstart/protocol/openid-connect/token")))
public class ExampleResource {

    @GET
    @RolesAllowed("user")
    @SecurityRequirement(name = "quarkus-oauth")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
}