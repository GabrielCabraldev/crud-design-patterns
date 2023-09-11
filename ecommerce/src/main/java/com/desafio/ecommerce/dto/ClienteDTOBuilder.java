package com.desafio.ecommerce.dto;

public class ClienteDTOBuilder {
    private ClienteDTO clienteDTO = new ClienteDTO();

    public ClienteDTOBuilder email(String email) {
        clienteDTO.setEmail(email);
        return this;
    }

    public ClienteDTO build() {
        return clienteDTO;
    }
}
