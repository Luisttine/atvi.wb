package com.wb.listar;

import java.util.List;
import com.wb.modelo.Produto;

public class ListarTodosProdutos extends Listagem {
	private List<Produto> produtos;
	int i=0;

	public ListarTodosProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public void listar() {
		while (true) {
			if (produtos.size() == 0) {
				System.out.println("Não há Produtos suficientes cadastrados para este tipo de listagem!\nPor favor cadastre algum Produto ou tente outro tipo de listagem.");
				break;
			}
			System.out.println("\nLista de todos os produtos:");
			for (Produto produto : produtos) {
				System.out.println("Produto " + i);
				System.out.println("Nome do produto: " + produto.nome);
				System.out.println("Valor: "+ produto.preco);
				System.out.println("--------------------------------------");
				i+=1;
			}
		}
	}
}
