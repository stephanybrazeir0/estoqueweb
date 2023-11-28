package br.com.labEngen.estok.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.labEngen.estok.models.Produto;
import br.com.labEngen.estok.repository.ProdutoRepository;

@SpringBootTest
class EstokControllerTest {

	private static final int quantidade = 1;
	private static final float valor = 5.5f;
	private static final String descricao = "gabinete";
	private static final long codProduto = 1;

	@InjectMocks
	private EstokController estokController;
	
	@Mock
	private ProdutoRepository repository;
	
	private Produto produto;
	
	private void startProduto() {
		produto = new Produto(codProduto, descricao, valor, quantidade);
		produto.setCodProduto(codProduto);
		produto.setDescricao(descricao);
		produto.setValor(valor);
		produto.setQtd(quantidade);
	}
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		startProduto();
	}

	@Test
	void testMensagem() {
		String response = estokController.mensagem();
		
		assertNotNull(response);
		assertEquals("Hello World!", response);
	}

	@Test
	void whenSaveThenReturnAProduto() {
		when(repository.save(any())).thenReturn(produto);
		
		Produto response = estokController.cadastrarProduto(produto);
		
		assertNotNull(response);
		assertEquals(Produto.class, response.getClass());
		assertEquals(codProduto, response.getCodProduto());
		assertEquals(descricao, response.getDescricao());
		assertEquals(valor, response.getValor());
		assertEquals(quantidade, response.getQtd());
	}

	@Test
	void whenFindAllThenReturnAListOfProdutos() {
		when(repository.findAll()).thenReturn(List.of(produto));
		
		List<Produto> response = estokController.listarProdutos();
		
		assertNotNull(response);
		assertEquals(1, response.size());
		assertEquals(Produto.class, response.get(0).getClass());
		assertEquals(codProduto, response.get(0).getCodProduto());
		assertEquals(descricao, response.get(0).getDescricao());
		assertEquals(valor, response.get(0).getValor());
		assertEquals(quantidade, response.get(0).getQtd());
		
	}
	
	@Test
	void whenDeleteByIdThenReturnNothing() {
		doNothing().when(repository).deleteById(anyLong());
		estokController.deletarProduto(codProduto);
		verify(repository, times(1)).deleteById(anyLong());
	}

}
