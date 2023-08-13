package br.teste.elotech.cadastroapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;

import br.teste.elotech.cadastroapp.entity.Pessoa;
import br.teste.elotech.cadastroapp.service.PessoaService;

@Validated
@CrossOrigin
@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List < Pessoa > findAllPessoa() {
        return pessoaService.getAllPessoas();
    }

    @GetMapping(value = "/{id}")
    public Pessoa findPessoaById(@PathVariable("id") Long id) {
        return pessoaService.getPessoaById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa createPessoa(@RequestBody Pessoa pessoa) {
        Preconditions.checkNotNull(pessoa);
        return pessoaService.savePessoa(pessoa);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePessoa(@PathVariable("id") Long id, @RequestBody Pessoa pessoa) {
        Preconditions.checkNotNull(pessoa);
        pessoaService.updatePessoa(id, pessoa);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        pessoaService.deletePessoa(id);
    }
}