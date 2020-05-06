package br.com.qp.repository;


import javax.enterprise.context.ApplicationScoped;

import br.com.qp.entity.ProductEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<ProductEntity> {
}
