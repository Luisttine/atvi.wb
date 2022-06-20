package com.wb.listar;

import java.util.List;
import com.wb.modelo.Servico;

public class ListarTodosServicos extends Listagem {
	private List<Servico> servico;
	int i=0;

	public ListarTodosServicos(List<Servico> servico) {
		this.servico = servico;
	}

	@Override
	public void listar() {
		System.out.println("\nLista de todos os serviços:");
		for (Servico servico : servico) {
			System.out.println("Serviço " + i);
			System.out.println("Nome do serviço: " + servico.nome);
			System.out.println("Valor: "+ servico.preco);
			System.out.println("--------------------------------------");
			i+=1;
		}
	}
}
