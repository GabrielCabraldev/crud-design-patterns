package com.desafio.ecommerce.service;

import com.desafio.ecommerce.dto.EnderecoDTO;
import com.desafio.ecommerce.dto.EnderecoDTOBuilder;
import com.desafio.ecommerce.model.Cliente;
import com.desafio.ecommerce.model.Endereco;
import com.desafio.ecommerce.repositories.ClienteRepository;
import com.desafio.ecommerce.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EnderecoServiceFacade {

    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoServiceFacade(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
    }


    /**
     * Este método salva endereços com base em uma lista de objetos EnderecoDTO.
     * se já existe um cliente com o mesmo e-mail, o endereco é associado a ele;
     * se nao existir cria um novo cliente e associa o endereco a ele.
     *
     * @param enderecos A lista de endereços que serão salvos.
     */
    public void salvarEnderecos(List<EnderecoDTO> enderecos) {
        for (EnderecoDTO enderecoDTO : enderecos) {
            Cliente cliente = clienteRepository.findByEmail(enderecoDTO.getEmailRelacionado());

            if (cliente == null) {
                cliente = new Cliente();
                cliente.setEmail(enderecoDTO.getEmailRelacionado());
                clienteRepository.save(cliente);
            }

            Endereco endereco = new Endereco();
            endereco.setLogradouro(enderecoDTO.getLogradouro());
            endereco.setCidade(enderecoDTO.getCidade());
            endereco.setEstado(enderecoDTO.getEstado());
            endereco.setCep(enderecoDTO.getCep());
            endereco.setBairro(enderecoDTO.getBairro());
            endereco.setNumero(enderecoDTO.getNumero());
            endereco.setCliente(cliente);

            enderecoRepository.save(endereco);
        }
    }

    /**
     * Esse método busca endereços que estão associados a um cliente pelo e-mail.
     *
     * @param email O e-mail do cliente para buscar os endereços.
     * @return Uma lista de objetos EnderecoDTO relacionados ao cliente encontrado ou uma lista vazia se o cliente não for encontrado.
     */
    public List<EnderecoDTO> buscarEnderecosPorEmail(String email) {
        Cliente cliente = clienteRepository.findByEmail(email);

        if (cliente == null) {
            return Collections.emptyList();
        }

        List<Endereco> enderecos = enderecoRepository.findByCliente(cliente);
        List<EnderecoDTO> enderecosDTO = new ArrayList<>();

        for (Endereco endereco : enderecos) {
            EnderecoDTO enderecoDTO = new EnderecoDTOBuilder()
                    .logradouro(endereco.getLogradouro())
                    .cidade(endereco.getCidade())
                    .estado(endereco.getEstado())
                    .cep(endereco.getCep())
                    .bairro(endereco.getBairro())
                    .numero(endereco.getNumero())
                    .emailRelacionado(email)
                    .build();

            enderecosDTO.add(enderecoDTO);
        }

        return enderecosDTO;
    }
}
