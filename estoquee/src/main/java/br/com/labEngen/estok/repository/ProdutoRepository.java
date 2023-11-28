package br.com.labEngen.estok.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.labEngen.estok.models.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>{
	
}