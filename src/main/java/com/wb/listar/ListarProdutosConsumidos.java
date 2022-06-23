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
		while (true) {
			if (clientes.size() == 0) {
				System.out.println("Não há Clientes suficientes cadastrados para este tipo de listagem!\nPor favor cadastre algum cliente ou tente outro tipo de listagem.");
				break;
			}
			Entrada entrada = new Entrada();
			System.out.println("\nLista de todos os Clientes:");
			for(Cliente clientes : clientes) {
				System.out.println("Cliente " + i);
				System.out.println("Nome: " + clientes.nome);
				System.out.println("CPF: " + clientes.getCpf().getValor());	
				System.out.println("--------------------------------------");
				i+=1;
			}
			System.out.println("Digite o número do cliente para listar seu consumo de Produtos");
			int numCli = entrada.receberNumeroInteiro();
			if (clientes.get(numCli).getServicosConsumidos().size() == 0) {
				System.out.println("Não há Produtos adicionados no carrinho para consumo do Cliente"+numCli+".\nPor favor adicione algum Produto ao carrinho do cliente.");
				break;
			}
			System.out.println("\nLista de todos os produtos consumidos do cliente "+numCli+":");
			for (ProdutoConsumido produtosConsumidos: clientes.get(numCli).getProdutosConsumidos()) {
				System.out.println("Produto " + x);
				System.out.println("Nome do produto: " + produtosConsumidos.nome.nome);
				System.out.println("Quantidade: "+ produtosConsumidos.quantidade);
				System.out.println("--------------------------------------");
				x+=1;
			}
		}
	}
}
