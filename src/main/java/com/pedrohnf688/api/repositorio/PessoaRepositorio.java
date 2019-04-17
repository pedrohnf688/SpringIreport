package com.pedrohnf688.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrohnf688.api.modelo.Pessoa;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Integer> {

}
