package br.com.qp.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.qp.entity.ProductEntity;
import br.com.qp.entity.mapper.ProductMapper;
import br.com.qp.entity.vo.ProductVO;
import br.com.qp.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Slf4j
@Path("/products")
@Tag(name = "Product")
public class ProductResource {

    @Inject
    ProductService productService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Buscar todos os produtos", summary = "getProductAll")
    public List<ProductEntity> getAll() {
        return productService.getProdutos();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Adiciona novo produto", summary = "addProduct")
    public void addProduct(@RequestBody final ProductVO productVO) {
        log.info("M=addProdutos productVO={}", productVO);
        productService.addProdutos(ProductMapper.voToEntity(productVO));
    }

}
