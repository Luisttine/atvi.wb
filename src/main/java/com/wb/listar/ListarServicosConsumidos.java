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
		for(Cliente clientes : clientes) {
			System.out.println("Cliente " + i);
			System.out.println("Nome: " + clientes.nome);
			System.out.println("CPF: " + clientes.getCpf());			
		}
		System.out.println("Digite o n�mero do cliente para listar seu consumo de Produtos");
		System.out.println("Lista de todos os servi�os consumidos:");
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
