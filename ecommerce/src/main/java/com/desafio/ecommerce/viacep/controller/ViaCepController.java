package com.desafio.ecommerce.viacep.controller;


import com.desafio.ecommerce.viacep.dto.EnderecoViaCepDTO;
import com.desafio.ecommerce.viacep.exception.EnderecoNaoEncontradoException;
import com.desafio.ecommerce.viacep.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/viacep")
public class ViaCepController {
    private final CepService cepService;

    @Autowired
    public ViaCepController(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<Object> buscarPorCep(@PathVariable String cep) {
        try {
            EnderecoViaCepDTO enderecoDTO = cepService.buscarPorCep(cep);

            if (enderecoDTO == null || cep.length() != 8) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado ou invalido para o CEP: " + cep);
            } else {
                return ResponseEntity.ok(enderecoDTO);
            }
        } catch (EnderecoNaoEncontradoException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado para o CEP: " + cep);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao buscar o endereço.");
        }
    }
}
