package br.com.qp.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.qp.entity.enums.ProductType;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "products")
public class ProductEntity extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_PRODUCT", nullable = false, unique = true)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AMOUNT", nullable = false)
    private Integer amount;

    @Column(name = "UNITARY_VALUE", nullable = false)
    private BigDecimal unitaryValue;

    @Column(name = "ACQUISITION_VALUE", nullable = false)
    private BigDecimal acquisitionValue;

    @Column(name = "DAT_ACQUISITION")
    private LocalDateTime dateAcquisition;

    @CreationTimestamp
    @Column(name = "DAT_CREATION")
    private LocalDateTime dateCreation;

    @Builder.Default
    @Column(name = "ACTIVE", nullable = false)
    private Boolean active = true;

    @Column(name = "PRODUCT_TYPE", nullable = false)
    private ProductType productType;

}
