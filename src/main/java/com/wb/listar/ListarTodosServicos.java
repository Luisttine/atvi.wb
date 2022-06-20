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
		System.out.println("\nLista de todos os servi�os:");
		for (Servico servico : servico) {
			System.out.println("Servi�o " + i);
			System.out.println("Nome do servi�o: " + servico.nome);
			System.out.println("Valor: "+ servico.preco);
			System.out.println("--------------------------------------");
			i+=1;
		}
	}
}
