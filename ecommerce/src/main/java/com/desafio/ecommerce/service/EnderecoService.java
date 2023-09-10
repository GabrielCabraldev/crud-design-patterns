package com.desafio.ecommerce.service;


import com.desafio.ecommerce.dto.EnderecoDTO;
import com.desafio.ecommerce.model.Cliente;
import com.desafio.ecommerce.model.Endereco;
import com.desafio.ecommerce.repository.ClienteRepository;
import com.desafio.ecommerce.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final ClienteRepository clienteRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository, ClienteRepository clienteRepository) {
        this.enderecoRepository = enderecoRepository;
        this.clienteRepository = clienteRepository;
    }

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

    public List<EnderecoDTO> buscarEnderecosPorEmail(String email) {
        Cliente cliente = clienteRepository.findByEmail(email);

        if (cliente == null) {
            return Collections.emptyList(); // Retorna uma lista vazia se o cliente não for encontrado
        }

        List<Endereco> enderecos = enderecoRepository.findByCliente(cliente);
        List<EnderecoDTO> enderecosDTO = new ArrayList<>();

        for (Endereco endereco : enderecos) {
            EnderecoDTO enderecoDTO = new EnderecoDTO();
            enderecoDTO.setLogradouro(endereco.getLogradouro());
            enderecoDTO.setCidade(endereco.getCidade());
            enderecoDTO.setEstado(endereco.getEstado());
            enderecoDTO.setCep(endereco.getCep());
            enderecoDTO.setBairro(endereco.getBairro());
            enderecoDTO.setNumero(endereco.getNumero());
            enderecoDTO.setEmailRelacionado(email);
            enderecosDTO.add(enderecoDTO);
        }

        return enderecosDTO;
    }

}
