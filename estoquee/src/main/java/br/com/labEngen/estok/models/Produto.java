package br.com.labEngen.estok.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codProduto;
	private String descricao;
	private float valor;
	private int qtd;
	
	public Produto() {
	}
	
	public Produto(Long codProduto, String descricao, float valor, int qtd) {
		this.codProduto = codProduto;
		this.descricao = descricao;
		this.valor = valor;
		this.qtd = qtd;
	}
	
	public Long getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(Long codProduto) {
		this.codProduto = codProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	
}