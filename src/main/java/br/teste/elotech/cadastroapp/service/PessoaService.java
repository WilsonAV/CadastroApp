package br.teste.elotech.cadastroapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.teste.elotech.cadastroapp.entity.Pessoa;
import br.teste.elotech.cadastroapp.repository.PessoaRepository;
import jakarta.persistence.EntityExistsException;

@Service
public class PessoaService {

    @Autowired
	private PessoaRepository pessoaRepository;
	
	public  Pessoa getPessoaById(Long id) {
        return verificarPessoa(id);
    }

	public List<Pessoa> getAllPessoas(){
		return pessoaRepository.findAll();
	}

    public Pessoa savePessoa(Pessoa pessoa) {
		pessoa.getContatos().forEach(c -> c.setPessoa(pessoa));
		return pessoaRepository.save(pessoa);
	}

    public Pessoa updatePessoa (Long id, Pessoa pessoa) {
		Pessoa pessoaSalva = verificarPessoa(id);
		return pessoaRepository.save(pessoaSalva);
	}
	
	public void deletePessoa(Long id) {
		Pessoa pessoa = verificarPessoa(id);
		pessoaRepository.delete(pessoa);
	}
	
	private Pessoa verificarPessoa(Long id) {
		return pessoaRepository.findById(id).orElseThrow(() -> new EntityExistsException("Pessoa não Localizada"));
        
	}
    
}
