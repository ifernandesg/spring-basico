package prodam.springbasico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prodam.springbasico.model.Pessoa;
import prodam.springbasico.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	
	public List<Pessoa> listar(){
		return repository.findAll();
	}
	
	public void salvar(Pessoa p) {
		repository.save(p);
	}
	
	public void update(Pessoa p) {
		repository.save(p);
	}
	
	public Pessoa getPessoaPorId(Long id) {
		Optional<Pessoa>opPessoa =  repository.findById(id);
		return opPessoa.get();
	}

	public void deletePessoaPorId(Long id) {
		repository.deleteById(id);
	}
	
}
