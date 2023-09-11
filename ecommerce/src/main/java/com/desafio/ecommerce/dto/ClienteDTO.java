package com.desafio.ecommerce.dto;

import lombok.Data;

@Data
public class ClienteDTO {

    private String email;

    public ClienteDTO() {
        //usado para criar uma instancia dentro do ClienteDTOBuilder
    }
}