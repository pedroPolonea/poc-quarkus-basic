package br.com.qp.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.qp.entity.ProductEntity;
import br.com.qp.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.opentracing.Traced;

@Slf4j
@Traced
@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    public List<ProductEntity> getProdutos() {
        return productRepository.listAll();
    }

    public void addProdutos(final ProductEntity product) {
        log.info("M=addProdutos product={}", product);

        productRepository.persist(product);
    }

}
