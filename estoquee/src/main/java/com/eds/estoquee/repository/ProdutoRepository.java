package com.eds.estoquee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eds.estoquee.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
