package com.wb.modelo;

public class ProdutoConsumido {
	public ProdutoConsumido(Produto produto, int quant) {
		this.nome = produto;
		this.quantidade = quant;
	}
	public int quantidade;
	public Produto nome;

	public Produto getNome() {
		return nome;
	}
	public void setNome(Produto nome) {
		this.nome = nome;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getQuantidade() {
		return quantidade;
	}
}
