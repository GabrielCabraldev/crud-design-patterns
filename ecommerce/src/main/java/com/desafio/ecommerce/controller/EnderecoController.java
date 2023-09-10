package com.desafio.ecommerce.controller;


import com.desafio.ecommerce.dto.EnderecoDTO;
import com.desafio.ecommerce.factory.EnderecoFactory;
import com.desafio.ecommerce.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/ecommerce")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @Autowired
    public EnderecoController(EnderecoService enderecoService, EnderecoFactory enderecoFactory) {
        this.enderecoService = enderecoService;

    }

    @PostMapping("/salvar")
    public ResponseEntity<String> salvarEnderecos(@RequestBody List<EnderecoDTO> enderecos) {
        enderecoService.salvarEnderecos(enderecos);
        return ResponseEntity.status(HttpStatus.CREATED).body("Endereços salvos com sucesso.");
    }

    @GetMapping("/{email}")
    public ResponseEntity<List<EnderecoDTO>> buscarEnderecosPorEmail(@PathVariable String email) {
        List<EnderecoDTO> enderecosDTO = enderecoService.buscarEnderecosPorEmail(email);
        return ResponseEntity.ok(enderecosDTO);
    }


}
