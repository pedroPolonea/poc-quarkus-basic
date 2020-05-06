package br.com.qp.resource;

import br.com.qp.client.AddressExternalClient;
import br.com.qp.client.AddressInternalClient;
import br.com.qp.entity.vo.AddressVO;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Slf4j
@Path("/address")
@Tag(name = "Address")
public class AddressResource {

    @Inject
    @RestClient
    AddressExternalClient addressExternalClient;

    @Inject
    @RestClient
    AddressInternalClient addressInternalClient;

    @GET
    @Path("/{postalCod}/external")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Buscar externa endereço por CEP", summary = "getAddresExternalsByCep")
    public AddressVO getAddresExternalsByCep(@PathParam("postalCod") final String postalCod) {
        log.info("M=getAddressByCep postalCod={}", postalCod);
        return addressExternalClient.getAddressByCep(postalCod);
    }

    @GET
    @Path("/{postalCod}/internal")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Buscar interna endereço por CEP", summary = "getAddresInternalsByCep")
    public AddressVO getAddresInternalsByCep(@PathParam("postalCod") final String postalCod) {
        log.info("M=getAddressByCep postalCod={}", postalCod);
        return addressInternalClient.getAddressByCep(postalCod);
    }
}
