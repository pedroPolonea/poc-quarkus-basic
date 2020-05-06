package br.com.qp.entity.mapper;

import br.com.qp.entity.ProductEntity;
import br.com.qp.entity.enums.ProductType;
import br.com.qp.entity.vo.ProductVO;

public interface ProductMapper {

    public static ProductEntity voToEntity(final ProductVO vo) {
        return ProductEntity.builder()
                .id(vo.getId())
                .name(vo.getName())
                .description(vo.getDescription())
                .acquisitionValue(vo.getAcquisitionValue())
                .amount(vo.getAmount())
                .unitaryValue(vo.getUnitaryValue())
                .productType(ProductType.fromValue(vo.getProductType()))
                .build();
    }
}
