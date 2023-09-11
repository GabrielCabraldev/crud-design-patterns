package com.desafio.ecommerce.service;

import com.desafio.ecommerce.dto.ClienteDTO;
import com.desafio.ecommerce.dto.ClienteDTOBuilder;
import com.desafio.ecommerce.dto.EnderecoDTO;
import com.desafio.ecommerce.dto.EnderecoDTOBuilder;
import com.desafio.ecommerce.repositories.ClienteRepository;
import com.desafio.ecommerce.repositories.EnderecoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class EnderecoServiceTest {

    @Mock
    private EnderecoRepository enderecoRepository;

    @Mock private ClienteRepository clienteRepository;

    @InjectMocks
    private EnderecoService enderecoService;

    @Test
    public void testSalvarEnderecos() {
        ClienteDTO clienteDTO = new ClienteDTOBuilder()
                .email("cliente@teste.com")
                .build();

        assertEquals("cliente@teste.com", clienteDTO.getEmail());
    }

    @Test
    public void testCriarEnderecoDTO() {
        EnderecoDTO enderecoDTO = new EnderecoDTOBuilder()
                .logradouro("Rua teste")
                .cidade("Cotia")
                .estado("MG")
                .cep("12345-678")
                .bairro("Novo bairro")
                .numero(1)
                .emailRelacionado("cliente@teste.com")
                .build();

        assertEquals("Rua teste", enderecoDTO.getLogradouro());
        assertEquals("Cotia", enderecoDTO.getCidade());
        assertEquals("MG", enderecoDTO.getEstado());
        assertEquals("12345-678", enderecoDTO.getCep());
        assertEquals("Novo bairro", enderecoDTO.getBairro());
        assertEquals(1, enderecoDTO.getNumero());
        assertEquals("cliente@teste.com", enderecoDTO.getEmailRelacionado());


    }
}
