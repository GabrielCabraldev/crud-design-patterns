package com.desafio.ecommerce.dto;

public class EnderecoDTOBuilder {
    private EnderecoDTO enderecoDTO = new EnderecoDTO();

    public EnderecoDTOBuilder logradouro(String logradouro) {
        enderecoDTO.setLogradouro(logradouro);
        return this;
    }

    public EnderecoDTOBuilder cidade(String cidade) {
        enderecoDTO.setCidade(cidade);
        return this;
    }

    public EnderecoDTOBuilder estado(String estado) {
        enderecoDTO.setEstado(estado);
        return this;
    }

    public EnderecoDTOBuilder cep(String cep) {
        enderecoDTO.setCep(cep);
        return this;
    }

    public EnderecoDTOBuilder bairro(String bairro) {
        enderecoDTO.setBairro(bairro);
        return this;
    }

    public EnderecoDTOBuilder emailRelacionado(String emailRelacionado) {
        enderecoDTO.setEmailRelacionado(emailRelacionado);
        return this;
    }

    public EnderecoDTOBuilder numero(Integer numero) {
        enderecoDTO.setNumero(numero);
        return this;
    }

    public EnderecoDTO build() {
        return enderecoDTO;
    }
}
