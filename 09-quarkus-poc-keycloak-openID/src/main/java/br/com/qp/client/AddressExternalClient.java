package br.com.qp.client;

import br.com.qp.entity.vo.AddressVO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ws")
@RegisterRestClient
public interface AddressExternalClient {

    @GET
    @Path("/{postalCode}/json/")
    @Produces(MediaType.APPLICATION_JSON)
    AddressVO getAddressByCep(@PathParam("postalCode") String postalCode);

}
