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

public class ListarProdServCons extends Listagem{
	private List<Cliente> clientes;
    Map <String, Integer> dict = new HashMap<>();
	int i = 0;
	
	public ListarProdServCons(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void listar() {		
		while (true) {
			if (clientes.size() == 0) {
				System.out.println("Não há Produtos/Serviços suficientes cadastrados para este tipo de listagem!\nPor favor cadastre algum Produto/Serviço ou tente outro tipo de listagem.");
				break;
			}
			System.out.println("\nListagem dos Produtos/Serviços mais consumidos:");
			
			for (Cliente cliente : clientes) {
				int tot = 0;
				if(cliente.getProdutosConsumidos() == null) {
					continue;
				}
				for (ProdutoConsumido produtosConsumidos: clientes.get(i).getProdutosConsumidos()) {
					String prod = produtosConsumidos.nome.nome;
					int x = produtosConsumidos.getQuantidade();
					
					if (dict.containsKey(prod)) {
						dict.replace(prod, (tot+x));
					}
					else {
						dict.put(prod, (tot+x));
					}
					
				}
				List<Entry<String, Integer>> listMS = new LinkedList<>(dict.entrySet());
		        Collections.sort(listMS, new Comparator<Object>() {
		            @SuppressWarnings("unchecked")
		            public int compare(Object o1, Object o2) {
		                    return ((Comparable<Integer>) ((Map.Entry<String, Integer>) (o2)).getValue()).compareTo(((Map.Entry<String, Integer>) (o1)).getValue());
		                }
		            });
		        Map<String, Integer> resultMS = new LinkedHashMap<>();
	            for (Iterator<Entry<String, Integer>> it = listMS.iterator(); it.hasNext();) {
	                Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
	                resultMS.put(entry.getKey(), entry.getValue());
	            }
	            
	            int contP=1;
	            for(String j : resultMS.keySet()) {
	               Integer primeiro = resultMS.get(j);
	               System.out.println("O Produto " + j + " foi o  " + contP + " mais consumido " + primeiro);
		            System.out.println("------------------------------------------------------------------------");
	            	contP+=1;
	           }
				i+=1;
			}
			 i=0;
			 for (Cliente cliente : clientes) {
				 int tot = 0;
				 if (cliente.getServicosConsumidos() == null) {
					 continue;
				 }
				 for (ServicoConsumido servicosConsumidos: clientes.get(i).getServicosConsumidos()) {
					 String serv = servicosConsumidos.nome.nome;
					 int x = servicosConsumidos.getQuantidade();
					
					 if (dict.containsKey(serv)) {
							dict.replace(serv , (tot+x));
						}
						else {
							dict.put(serv, (tot+x));
						}
				 }
				i+=1;
			}
				List<Entry<String, Integer>> listMS = new LinkedList<>(dict.entrySet());
		        Collections.sort(listMS, new Comparator<Object>() {
		           @SuppressWarnings("unchecked")
		           public int compare(Object o1, Object o2) {
		                   return ((Comparable<Integer>) ((Map.Entry<String, Integer>) (o2)).getValue()).compareTo(((Map.Entry<String, Integer>) (o1)).getValue());
		               }
		           });
	            Map<String, Integer> resultMS = new LinkedHashMap<>();
	            for (Iterator<Entry<String, Integer>> it = listMS.iterator(); it.hasNext();) {
	                Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
	                resultMS.put(entry.getKey(), entry.getValue());
	            }
	            int contS=1;
	            for(String j : resultMS.keySet()) {
	                Integer primeiro = resultMS.get(j);
	                System.out.println("O Serviço " + j + " foi o  " + contS + " mais consumido " + primeiro);
		            System.out.println("--------------------------------------------------------------");
	            	contS+=1;	
	            }
		}
		
	}
}