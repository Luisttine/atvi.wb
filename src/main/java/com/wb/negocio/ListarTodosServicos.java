package com.wb.negocio;

import java.util.List;
import com.wb.modelo.Servico;

public class ListarTodosServicos extends Listagem {
	private List<Servico> servico;

	public ListarTodosServicos(List<Servico> servico) {
		this.servico = servico;
	}

	@Override
	public void listar() {
		System.out.println("\nLista de todos os produtos:");
		for (Servico servico : servico) {
			System.out.println("Serviço: " + servico.nome);
			System.out.println("--------------------------------------");
		}
	}
}
