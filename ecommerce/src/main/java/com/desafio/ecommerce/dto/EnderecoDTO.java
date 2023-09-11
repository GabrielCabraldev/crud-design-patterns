package com.desafio.ecommerce.dto;

import lombok.Data;

@Data
public class EnderecoDTO {
    private String logradouro;
    private String cidade;
    private String estado;
    private String cep;
    private String bairro;
    private String emailRelacionado;
    private Integer numero;

    public EnderecoDTO(){
        //construtor usado apenas para instanciar
    }

}
