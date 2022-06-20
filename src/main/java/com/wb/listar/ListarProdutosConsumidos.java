package com.wb.listar;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.ProdutoConsumido;

public class ListarProdutosConsumidos extends Listagem {
	private List<Cliente> clientes;
	int i=0;
	int x=0;

	public ListarProdutosConsumidos(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	@Override
	public void listar() {
		Entrada entrada = new Entrada();
		System.out.println("\nLista de todos os Clientes:");
		for(Cliente clientes : clientes) {
			System.out.println("\nCliente " + i);
			System.out.println("Nome: " + clientes.nome);
			System.out.println("CPF: " + clientes.getCpf().getValor());	
			i+=1;
		}
		System.out.println("Digite o número do cliente para listar seu consumo de Produtos");
		int numCli = entrada.receberNumeroInteiro();
		System.out.println("Lista de todos os produtos consumidos:");
		for (ProdutoConsumido produtosConsumidos: clientes.get(numCli).getProdutosConsumidos()) {
			System.out.println("\nProduto " + i);
			System.out.println("Nome do produto: " + produtosConsumidos.nome.nome);
			System.out.println("Quantidade: "+ produtosConsumidos.quantidade);
			System.out.println("--------------------------------------");
			x+=1;
		}
	}
}
