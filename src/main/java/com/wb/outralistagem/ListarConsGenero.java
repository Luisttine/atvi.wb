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

import com.wb.io.Entrada;
import com.wb.listar.Listagem;
import com.wb.modelo.Cliente;
import com.wb.modelo.ProdutoConsumido;
import com.wb.modelo.ServicoConsumido;

public class ListarConsGenero extends Listagem{
	private List<Cliente> clientes;
	int i = 0;
	
	public ListarConsGenero(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void listar() {		
		while (true) {
			if (clientes.size() == 0) {
				System.out.println("N�o h� clientes cadastrados para este tipo de listagem!\nPor favor cadastre algum cliente com g�nero Masculino/Feminino ou tente outro tipo de listagem.");
				break;
	        }
			System.out.println("\nVoc� deseja listar o consumo de Produto/Servi�o por G�nero:");
			System.out.println("1 - Masculino");
			System.out.println("2 - Feminino");
			Entrada entrada = new Entrada();
			int gen = entrada.receberNumeroInteiro();
	        Map <String, Integer> dict = new HashMap<>();
	        
			switch ( gen ) {
			
			case 1:
					if (clientes.size() == 0) {
						System.out.println("N�o h� clientes Masculinos cadastrados para este tipo de listagem!\nPor favor cadastre algum cliente com g�nero Masculino ou tente outro tipo de listagem.");
					}
				
					for (Cliente cliente : clientes) {
						if (cliente.getGenero().equals("Masculino")) {
							if(cliente.getProdutosConsumidos() == null) {
								continue;
							}
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
					List<Entry<String, Integer>> listMP = new LinkedList<>(dict.entrySet());
			        Collections.sort(listMP, new Comparator<Object>() {
			           @SuppressWarnings("unchecked")
			           public int compare(Object o1, Object o2) {
			                   return ((Comparable<Integer>) ((Map.Entry<String, Integer>) (o2)).getValue()).compareTo(((Map.Entry<String, Integer>) (o1)).getValue());
			               }
			           });
			           Map<String, Integer> resultMP = new LinkedHashMap<>();
			           for (Iterator<Entry<String, Integer>> it = listMP.iterator(); it.hasNext();) {
			               Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
			               resultMP.put(entry.getKey(), entry.getValue());
			           }
			           for(String i : resultMP.keySet()) {
			               Integer primeiro = resultMP.get(i);
				           System.out.println("\nO produto mais consumido pelo G�nero Masculino � " + i + " com " + primeiro + " consumos.");
			               break;
			           }
				
		            /* SERVI�OS MASCULINOS MAIS CONSUMIDOS*/
					 i=0;
					 for (Cliente cliente : clientes) {
						 if (cliente.getGenero().equals("Masculino")) {
							 if (cliente.getServicosConsumidos() == null) {
								 continue;
							 }
							 for (ServicoConsumido servicosConsumidos: clientes.get(i).getServicosConsumidos()) {
								 String servico = servicosConsumidos.nome.nome;
								 int x = 0;
								
								 if (dict.containsKey(servico)) {
								 	 dict.replace(servico, dict.get(servico)+1);
								 }
								 else {
									 dict.put(servico, x+=1);
								 }
							 }
							i+=1;
						}
						continue;
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
			            for(String i : resultMS.keySet()) {
			                Integer primeiro = resultMS.get(i);
			                System.out.println("--------------------------------------------------------------------------");
				            System.out.println("O produto mais consumido pelo G�nero Masculino � " + i + " com " + primeiro + " consumos.");
			                break;
			            }
					
				break;
				
			case 2:
				System.out.println("N�o h� clientes Femininos cadastrados para este tipo de listagem!\nPor favor cadastre algum cliente com g�nero Feminino ou tente outro tipo de listagem.");
				i=0;
				for (Cliente cliente : clientes) {
					if (cliente.getGenero().equals("Feminino")) {
						if(cliente.getProdutosConsumidos() == null) {
							continue;
						}
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
				 List<Entry<String, Integer>> listFP = new LinkedList<>(dict.entrySet());
		         Collections.sort(listFP, new Comparator<Object>() {
		            @SuppressWarnings("unchecked")
		            public int compare(Object o1, Object o2) {
		                    return ((Comparable<Integer>) ((Map.Entry<String, Integer>) (o2)).getValue()).compareTo(((Map.Entry<String, Integer>) (o1)).getValue());
		                }
		            });
		            Map<String, Integer> resultFP = new LinkedHashMap<>();
		            for (Iterator<Entry<String, Integer>> it = listFP.iterator(); it.hasNext();) {
		                Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
		                resultFP.put(entry.getKey(), entry.getValue());
		            }
		            for(String i : resultFP.keySet()) {
		                Integer primeiro = resultFP.get(i);
			            System.out.println("\nO produto mais consumido pelo G�nero Feminino � " + i + " com " + primeiro + " consumos.");
		                break;
		            }
			
	            /* SERVI�OS FEMININO MAIS CONSUMIDOS*/
				 i=0;
				 for (Cliente cliente : clientes) {
					 if (cliente.getGenero().equals("Feminino")) {
						 if (cliente.getServicosConsumidos() == null) {
							 continue;
						 }
						 for (ServicoConsumido servicosConsumidos: clientes.get(i).getServicosConsumidos()) {
							 String servico = servicosConsumidos.nome.nome;
							 int x = 0;
							
							 if (dict.containsKey(servico)) {
							 	 dict.replace(servico, dict.get(servico)+1);
							 }
							 else {
								 dict.put(servico, x+=1);
							 }
						 }
						i+=1;
					}
					continue;
				}
				
				 List<Entry<String, Integer>> listFS = new LinkedList<>(dict.entrySet());
		         Collections.sort(listFS, new Comparator<Object>() {
		            @SuppressWarnings("unchecked")
		            public int compare(Object o1, Object o2) {
		                    return ((Comparable<Integer>) ((Map.Entry<String, Integer>) (o2)).getValue()).compareTo(((Map.Entry<String, Integer>) (o1)).getValue());
		                }
		            });
		            Map<String, Integer> resultFS = new LinkedHashMap<>();
		            for (Iterator<Entry<String, Integer>> it = listFS.iterator(); it.hasNext();) {
		                Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
		                resultFS.put(entry.getKey(), entry.getValue());
		            }
		            for(String i : resultFS.keySet()) {
		                Integer primeiro = resultFS.get(i);
		                System.out.println("--------------------------------------------------------------------------");
			            System.out.println("O produto mais consumido pelo G�nero Feminino � " + i + " com " + primeiro + " consumos.");
		                break;
		            }
				
			break;
			}
		}
	}
}
