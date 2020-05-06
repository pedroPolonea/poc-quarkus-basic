package br.com.qp.client;

import br.com.qp.entity.vo.AddressVO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/address")
@RegisterRestClient
public interface AddressInternalClient {

    @GET
    @Path("/{postalCod}")
    @Produces(MediaType.APPLICATION_JSON)
    AddressVO getAddressByCep(@PathParam("postalCod") String postalCod);

}
