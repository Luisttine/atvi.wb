package com.wb.negocio;

import java.util.List;
import com.wb.io.Entrada;
import com.wb.modelo.Produto;


public class CadastroProduto extends Cadastro {
	private List<Produto> produtos;
	private Entrada entrada;

	public CadastroProduto(List<Produto> produto) {
		this.produtos = produto;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("Início do cadastro de um produto");
		
		System.out.println("Por favor informe o nome do produto:");
		String nome = entrada.receberTexto();
		System.out.println("Por favor informe o preço do produto:");
		double preco = entrada.receberNumeroDouble();		
		
		Produto produto = new Produto(nome, preco);
		
		this.produtos.add(produto);
	}
}