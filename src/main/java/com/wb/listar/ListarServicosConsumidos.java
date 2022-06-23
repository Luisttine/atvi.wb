package com.wb.listar;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.ServicoConsumido;

public class ListarServicosConsumidos extends Listagem {
	private List<Cliente> clientes;
	int i=0;
	int x=0;
	
	public ListarServicosConsumidos(List<Cliente> clientes) {
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
				System.out.println("Não há Serviços adicionados no carrinho para consumo do Cliente"+numCli+".\nPor favor adicione algum Serviço ao carrinho do cliente.");
				break;
			}
			System.out.println("\nLista de todos os serviços consumidos do cliente "+numCli+":");
			for (ServicoConsumido servicosConsumidos: clientes.get(numCli).getServicosConsumidos()) {
				System.out.println("Produto " + x);
				System.out.println("Nome do produto: " + servicosConsumidos.nome.nome);
				System.out.println("Quantidade: "+ servicosConsumidos.quantidade);
				System.out.println("--------------------------------------");
				x+=1;
			}
		}
		
	}
}
