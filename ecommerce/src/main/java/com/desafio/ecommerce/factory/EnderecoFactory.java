package com.desafio.ecommerce.factory;


import com.desafio.ecommerce.dto.EnderecoDTO;
import com.desafio.ecommerce.model.Endereco;
import org.springframework.stereotype.Component;

@Component
public class EnderecoFactory {

    public Endereco salvarEnderecos(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco();
        endereco.setLogradouro(enderecoDTO.getLogradouro());
        endereco.setCidade(enderecoDTO.getCidade());
        endereco.setCep(enderecoDTO.getCep());
        endereco.setEstado(enderecoDTO.getEstado());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setBairro(enderecoDTO.getBairro());
        return endereco;
    }
}
