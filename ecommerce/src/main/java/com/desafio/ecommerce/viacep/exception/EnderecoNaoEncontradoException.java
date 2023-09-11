package com.desafio.ecommerce.viacep.exception;

public class EnderecoNaoEncontradoException extends RuntimeException {
    public EnderecoNaoEncontradoException(String cep) {
        super("Endereço não encontrado para o CEP: " + cep);
    }
}