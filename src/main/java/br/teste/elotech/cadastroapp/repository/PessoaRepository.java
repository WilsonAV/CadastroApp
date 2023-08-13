package br.teste.elotech.cadastroapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.teste.elotech.cadastroapp.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> { }