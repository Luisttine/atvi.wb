package com.wb.outralistagem;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.wb.listar.Listagem;
import com.wb.modelo.Cliente;
import com.wb.modelo.ProdutoConsumido;
import com.wb.modelo.ServicoConsumido;

public class ListarCliMenosCons extends Listagem{
	private List<Cliente> clientes;
    Map <String, Integer> dict = new HashMap<>();
	int i = 0;
	
	public ListarCliMenosCons(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void listar() {		
		System.out.println("\nListagem dos 10 clientes que mais consumiram Produtos/Serviços por quantidade:");
		
		for (Cliente cliente : clientes) {
			int tot = 0;
			if(cliente.getProdutosConsumidos() == null) {
				continue;
			}
			for (ProdutoConsumido produtosConsumidos: clientes.get(i).getProdutosConsumidos()) {
				String clienteAtual = clientes.get(i).nome;
				int x = produtosConsumidos.getQuantidade();
				
				if (dict.containsKey(clienteAtual)) {
					dict.replace(clienteAtual, (tot+x));
				}
				else {
					dict.put(clienteAtual, (tot+x));
				}
				
			}
			
			i+=1;
		}
				
		 for (Cliente cliente : clientes) {
			 int tot = 0;
			 if (cliente.getServicosConsumidos() == null) {
				 continue;
			 }
			 for (ServicoConsumido servicosConsumidos: clientes.get(i).getServicosConsumidos()) {
				 String clienteAtual = clientes.get(i).nome;
				 int x = servicosConsumidos.getQuantidade();
				
				 if (dict.containsKey(clienteAtual)) {
						dict.replace(clienteAtual, (tot+x));
					}
					else {
						dict.put(clienteAtual, (tot+x));
					}
			 }
			i+=1;
		}

		
		 List<Entry<String, Integer>> listMS = new LinkedList<>(dict.entrySet());
         Collections.sort(listMS, new Comparator<Object>() {
            @SuppressWarnings("unchecked")
            public int compare(Object o1, Object o2) {
                    return ((Comparable<Integer>) ((Map.Entry<String, Integer>) (o1)).getValue()).compareTo(((Map.Entry<String, Integer>) (o2)).getValue());
                }
            });
            Map<String, Integer> resultMS = new LinkedHashMap<>();
            for (Iterator<Entry<String, Integer>> it = listMS.iterator(); it.hasNext();) {
                Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
                resultMS.put(entry.getKey(), entry.getValue());
            }
            int stopS=1;
            while (stopS != 10) {
            	for(String j : resultMS.keySet()) {
                    Integer primeiro = resultMS.get(j);
                    System.out.println("O cliente " + j + " foi o  " + stopS + " consumindo " + primeiro + " Produto/Serviços.");
    	            System.out.println("------------------------------------------------------\n");
    	            break;
                }
            	stopS+=1;
            }
	}
}