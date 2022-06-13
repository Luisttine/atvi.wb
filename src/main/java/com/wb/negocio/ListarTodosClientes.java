package com.wb.negocio;

import java.util.List;

import com.wb.modelo.Cliente;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;

public class ListarTodosClientes extends Listagem {
	private List<Cliente> clientes;

	public ListarTodosClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void listar() {
		System.out.println("\nLista de todos os clientes:");
		for (Cliente cliente : clientes) {
			System.out.println("Nome: " + cliente.nome);
			System.out.println("Nome social: " + cliente.nomeSocial);
			System.out.println("CPF: " + cliente.getCpf().getValor());
			for (RG rgs : cliente.getRgs()) {
				System.out.println("RG: " + rgs.getValor());
			}
			for (Telefone telefone : cliente.getTelefones()) {
				System.out.println("Telefone: " + telefone.getDdd() + telefone.getNumero());
			}
			System.out.println("--------------------------------------");
		}
	}
}
