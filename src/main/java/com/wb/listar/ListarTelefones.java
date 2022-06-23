package com.wb.listar;

import java.util.List;

import com.wb.modelo.Cliente;
import com.wb.modelo.Telefone;

public class ListarTelefones extends Listagem {
	private List<Cliente> clientes;
	int i = 0;
	
	public ListarTelefones(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void listar() {
		
		for (Cliente cliente : clientes) {
			
			for (Telefone telefone : cliente.getTelefones()) {
				System.out.println("Telefone " + i);
				System.out.println("Telefone: " + "("+telefone.getDdd()+")" + telefone.getNumero());
				System.out.println("--------------------------------------");
				i+=1;
			}
		}
	}
}
