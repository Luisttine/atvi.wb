package com.wb.modelo;

public class ServicoConsumido {
	public ServicoConsumido(Servico servico, int quant) {
		this.nome = servico;
		this.quantidade = quant;
	}
	public int quantidade;
	public Servico nome;

	public Servico getNome() {
		return nome;
	}
	public void setNome(Servico nome) {
		this.nome = nome;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getQuantidade() {
		return quantidade;
	}
}
