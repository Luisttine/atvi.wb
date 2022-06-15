package com.wb.listar;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Servico;

public class ListarServicosConsumidos extends Listagem {
	private List<Cliente> clientes;
	int i=0;

	public ListarServicosConsumidos(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	@Override
	public void listar() {
		Entrada entrada = new Entrada();
		System.out.println("\nLista de todos os Clientes:");
		for(Cliente cliente : clientes) {
			System.out.println("Cliente " + i);
			System.out.println("Nome: " + cliente.nome);
			System.out.println("CPF: " + cliente.getCpf());			
		}
		System.out.println("Digite o número do cliente para listar seu consumo de Produtos");
		int numCli = entrada.receberNumeroInteiro();
		for (Servico servicosConsumidos: clientes.get(numCli).getServicosConsumidos()) {
			System.out.println("Produto " + i);
			System.out.println("Nome do produto: " + servicosConsumidos.nome);
			System.out.println("Quantidade: "+ servicosConsumidos.quantidade);
			System.out.println("--------------------------------------");
			i+=1;
		}
	}
}
