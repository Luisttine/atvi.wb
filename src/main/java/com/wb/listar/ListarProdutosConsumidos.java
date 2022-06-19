package com.wb.listar;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Produto;

public class ListarProdutosConsumidos extends Listagem {
	private List<Cliente> clientes;
	int i=0;

	public ListarProdutosConsumidos(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	@Override
	public void listar() {
		Entrada entrada = new Entrada();
		System.out.println("\nLista de todos os Clientes:");
		for(Cliente clientes : clientes) {
			System.out.println("Cliente " + i);
			System.out.println("Nome: " + clientes.nome);
			System.out.println("CPF: " + clientes.getCpf());			
		}
		System.out.println("Digite o n�mero do cliente para listar seu consumo de Produtos");
		int numCli = entrada.receberNumeroInteiro();
		System.out.println("Lista de todos os produtos consumidos:");
		for (Produto produtosConsumidos: clientes.get(numCli).getProdutosConsumidos()) {
			System.out.println("Produto " + i);
			System.out.println("Nome do produto: " + produtosConsumidos.nome);
			System.out.println("Quantidade: "+ produtosConsumidos.quantidade);
			System.out.println("--------------------------------------");
			i+=1;
		}
	}
}