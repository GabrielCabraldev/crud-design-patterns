package com.desafio.ecommerce.viacep.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EnderecoViaCepDTO {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;

    @JsonProperty("uf")
    private String estado;
}
