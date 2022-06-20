package com.wb.modelo;

public class Servico {
	public Servico(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	public double preco;
	public String nome;
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}