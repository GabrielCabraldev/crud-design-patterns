package com.desafio.ecommerce.service;


import com.desafio.ecommerce.dto.EnderecoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoServiceFacade enderecoServiceFacade;

    @Autowired
    public EnderecoService(EnderecoServiceFacade enderecoServiceFacade) {
        this.enderecoServiceFacade = enderecoServiceFacade;
    }

    public void salvarEnderecos(List<EnderecoDTO> enderecos) {
        enderecoServiceFacade.salvarEnderecos(enderecos);
    }

    public List<EnderecoDTO> buscarEnderecosPorEmail(String email) {
        return enderecoServiceFacade.buscarEnderecosPorEmail(email);
    }

}
