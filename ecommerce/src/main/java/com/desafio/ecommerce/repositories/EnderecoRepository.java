package com.desafio.ecommerce.repositories;

import com.desafio.ecommerce.model.Cliente;
import com.desafio.ecommerce.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco> findByCliente(Cliente cliente);

}
