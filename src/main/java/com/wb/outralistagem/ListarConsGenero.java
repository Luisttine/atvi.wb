package com.wb.outralistagem;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.wb.io.Entrada;
import com.wb.listar.Listagem;
import com.wb.modelo.Cliente;
import com.wb.modelo.ProdutoConsumido;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;

public class ListarConsGenero extends Listagem{
	private List<Cliente> clientes;
	int i = 0;
	
	public ListarConsGenero(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void listar() {		
		System.out.println("\nVocê deseja listar o consumo de Produto/Serviço por Gênero:");
		System.out.println("1 - Masculino");
		System.out.println("2 - Feminino");
		Entrada entrada = new Entrada();
		int gen = entrada.receberNumeroInteiro();
        Map <String, Integer> dict = new HashMap<String, Integer>();

		
		switch ( gen ) {
		
		case 1:
			System.out.println("Listagem de clientes Masculinos\n");
			
			for (Cliente cliente : clientes) {
				if (cliente.getGenero().equals("Masculino")) {
					for (ProdutoConsumido produtosConsumidos: clientes.get(i).getProdutosConsumidos()) {
						String produto = produtosConsumidos.nome.nome;
						int x = 0;
						
						if (dict.containsKey(produto)) {
							dict.replace(produto, dict.get(produto)+1);
						}
						else {
							dict.put(produto, x+=1);
						}
						
					}
					
					i+=1;
				}
				continue;
			}
			String ProdMaisCons;
			for (String i : dict.keySet()) {
				if(dict.get(i) != null) {
					
				}
			}
			break;
			
		case 2:
			System.out.println("Listagem de clientes Femininos\n");
			
			for (Cliente cliente : clientes) {
				if (cliente.getGenero().equals("Feminino")) {
				
					System.out.println("Cliente " + i);
					System.out.println("Nome: " + cliente.nome);
					System.out.println("Nome social: " + cliente.nomeSocial);
					System.out.println("CPF: " + cliente.getCpf().getValor());
					for (RG rgs : cliente.getRgs()) {
						System.out.println("RG: " + rgs.getValor());
					}
					for (Telefone telefone : cliente.getTelefones()) {
						System.out.println("Telefone: " + telefone.getDdd() + telefone.getNumero());
					}
					
					i+=1;
				}
				continue;
			}
			break;
		}
	}
}
