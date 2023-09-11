package com.desafio.ecommerce.controller;


import com.desafio.ecommerce.dto.EnderecoDTO;
import com.desafio.ecommerce.exceptions.EmailValidationException;
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
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;

    }

    /**
     * Salva uma lista de endereços relacionados a um email.
     *
     * @param enderecos Lista de endereços a serem salvos.
     * @return ResponseEntity com uma mensagem de sucesso .
     */
    @PostMapping("/salvar")
    public ResponseEntity<String> salvarEnderecos(@RequestBody List<EnderecoDTO> enderecos) {
        try {
            enderecoService.salvarEnderecos(enderecos);
            return ResponseEntity.status(HttpStatus.CREATED).body("Endereços salvos com sucesso.");
        } catch (EmailValidationException e){
            throw new EmailValidationException("Erro na validação do email");
        }

    }

    /**
     * Busca a lista de endereços relacionados a um email.
     *
     * @param email O email do cliente que deseja buscar os endereços.
     * @return ResponseEntity com a lista de endereços encontrados .
     */
    @GetMapping("/{email}")
    public ResponseEntity<List<EnderecoDTO>> buscarEnderecosPorEmail(@PathVariable String email) {
            List<EnderecoDTO> enderecosDTO = enderecoService.buscarEnderecosPorEmail(email);
            if (enderecosDTO.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(enderecosDTO);

    }


}
