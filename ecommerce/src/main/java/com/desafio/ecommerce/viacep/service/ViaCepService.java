package com.desafio.ecommerce.viacep.service;


import com.desafio.ecommerce.viacep.dto.EnderecoViaCepDTO;
import com.desafio.ecommerce.viacep.exception.EnderecoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService implements CepService{

    private static final String VIA_CEP_URL = "https://viacep.com.br/ws/";

    private final RestTemplate restTemplate;

    @Autowired
    public ViaCepService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    /**
     * Busca um endereço através do CEP usando a API Via CEP.
     *
     * @param cep O CEP a ser pesquisado.
     * @return Um objeto EnderecoViaCepDTO com os dados do endereço correspondente ao CEP.
     * @throws EnderecoNaoEncontradoException Se o endereço não for encontrado para o CEP colocado.
     * @throws RuntimeException Se ocorrer um erro ao chamar a API Via CEP.
     */
    public EnderecoViaCepDTO buscarPorCep(String cep) {
        try {
            ResponseEntity<EnderecoViaCepDTO> response = restTemplate.getForEntity(VIA_CEP_URL + cep + "/json", EnderecoViaCepDTO.class);

            // Verifica se a resposta da API tem um status de sucesso (código 2xx).
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            } else {
                throw new EnderecoNaoEncontradoException("Endereço não encontrado para o CEP: " + cep);
            }
        } catch (HttpClientErrorException.NotFound ex) {
            throw new EnderecoNaoEncontradoException("Endereço não encontrado para o CEP: " + cep);
        } catch (RestClientException ex) {
            throw new RuntimeException("Erro ao chamar a API Via CEP: " + ex.getMessage(), ex);
        }
    }
}