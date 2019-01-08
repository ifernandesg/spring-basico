package prodam.springbasico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prodam.springbasico.model.Pessoa;

@Repository
	public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
