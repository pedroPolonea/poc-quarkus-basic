package br.com.qp.entity.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO {

    private Long id;

    @NotEmpty
    private String name;

    private String description;

    @NotEmpty
    private Integer amount;

    @NotEmpty
    private BigDecimal unitaryValue;

    @NotEmpty
    private BigDecimal acquisitionValue;

    private LocalDateTime dateAcquisition;

    @NotEmpty
    private String productType;

}
