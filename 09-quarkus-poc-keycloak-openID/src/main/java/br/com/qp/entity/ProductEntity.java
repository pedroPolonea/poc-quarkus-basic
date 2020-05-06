package br.com.qp.entity;

import br.com.qp.entity.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_PRODUCT", nullable = false, unique = true)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 100)
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

    @Enumerated(EnumType.STRING)
    @Column(name = "PRODUCT_TYPE", nullable = false, length = 50)
    private ProductType productType;

}
