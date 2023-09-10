package com.desafio.ecommerce.repository;

import com.desafio.ecommerce.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByEmail(String email);
}