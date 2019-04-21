package com.pedrohnf688.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrohnf688.api.modelo.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {

}
