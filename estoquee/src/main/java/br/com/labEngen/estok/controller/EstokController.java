package br.com.labEngen.estok.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.labEngen.estok.models.Produto;
import br.com.labEngen.estok.repository.ProdutoRepository;

@RestController
public class EstokController{
	
	@Autowired
	private ProdutoRepository rep;
	
	@GetMapping("")
	public String mensagem() {
		return "Hello World!";
	}
	
	@CrossOrigin(origins = "null")
	@PostMapping("/cadastrarProduto")
	public Produto cadastrarProduto(@RequestBody Produto p) {
		return rep.save(p);
	}
	
	@CrossOrigin(origins = "null")
	@GetMapping("/listarProdutos")
	public List<Produto> listarProdutos() {
		return (List<Produto>) rep.findAll();
	}
	
	@CrossOrigin(origins = "null")
	@DeleteMapping("/deletarProduto/{id}")
	public void deletarProduto(@PathVariable Long id) {
		rep.deleteById(id);
	}
	
}