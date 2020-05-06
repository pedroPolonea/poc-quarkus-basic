package br.com.qp.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressVO {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String unidade;
}
