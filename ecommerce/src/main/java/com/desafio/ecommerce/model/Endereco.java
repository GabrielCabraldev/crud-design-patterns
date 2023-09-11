package com.desafio.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "enderecos")
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    //usando serialVersionUID para garantir que as versões
    // serializadas e deserializadas da classe tenham a mesma versão.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "Logradouro")
    private String logradouro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cep")
    private String cep;

    @Column(name = "bairro")
    private String bairro;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
