package com.desafio.ecommerce.viacep.service;

import com.desafio.ecommerce.viacep.dto.EnderecoViaCepDTO;

public interface CepService {
    EnderecoViaCepDTO buscarPorCep(String cep);
}
