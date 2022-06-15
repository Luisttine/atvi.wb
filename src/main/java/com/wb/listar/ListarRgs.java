package com.wb.listar;

import java.util.List;

import com.wb.modelo.Cliente;
import com.wb.modelo.RG;

public class ListarRgs extends Listagem {
	private List<Cliente> clientes;
	int i = 0;
	
	public ListarRgs(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void listar() {
		System.out.println("\nLista de todos os RGs:");
		
		for (Cliente cliente : clientes) {
			
			for (RG rgs : cliente.getRgs()) {
				System.out.println("RG " + i);
				System.out.println("RG: " + rgs.getValor());
				System.out.println("--------------------------------------");
				i+=1;
			}			
		}
	}
}
