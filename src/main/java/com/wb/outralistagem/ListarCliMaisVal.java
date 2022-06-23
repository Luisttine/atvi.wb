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

public class ListarCliMaisVal extends Listagem{
	private List<Cliente> clientes;
    Map <String, Double> dict = new HashMap<>();
	int i = 0;
	
	public ListarCliMaisVal(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void listar() {	
		while (true) {
			if (clientes.size() == 0 || clientes.size() < 5) {
				System.out.println("Não há Clientes suficientes cadastrados para este tipo de listagem!\nPor favor cadastre algum cliente com gênero Masculino/Feminino ou tente outro tipo de listagem.");
				break;
			}
			System.out.println("\nListagem dos 10 clientes que mais consumiram Produtos/Serviços por quantidade:");
			
			for (Cliente cliente : clientes) {
				int tot = 0;
				if(cliente.getProdutosConsumidos() == null) {
					continue;
				}
				for (ProdutoConsumido produtosConsumidos: clientes.get(i).getProdutosConsumidos()) {
					String clienteAtual = clientes.get(i).nome;
					double x = produtosConsumidos.getNome().getPreco();
					
					if (dict.containsKey(clienteAtual)) {
						dict.replace(clienteAtual, (tot+x));
					}
					else {
						dict.put(clienteAtual, (tot+x));
					}
					
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
					 String clienteAtual = clientes.get(i).nome;
					 double x = servicosConsumidos.getNome().getPreco();
					
					 if (dict.containsKey(clienteAtual)) {
							dict.replace(clienteAtual, (tot+x));
						}
						else {
							dict.put(clienteAtual, (tot+x));
						}
				 }
				i+=1;
			}
			 
			
			 List<Entry<String, Double>> listMS = new LinkedList<>(dict.entrySet());
	         Collections.sort(listMS, new Comparator<Object>() {
	            @SuppressWarnings("unchecked")
	            public int compare(Object o1, Object o2) {
	                    return ((Comparable<Double>) ((Map.Entry<String, Double>) (o2)).getValue()).compareTo(((Map.Entry<String, Double>) (o1)).getValue());
	                }
	            });
	            Map<String, Double> resultMS = new LinkedHashMap<>();
	            for (Iterator<Entry<String, Double>> it = listMS.iterator(); it.hasNext();) {
	                Map.Entry<String, Double> entry = (Map.Entry<String, Double>) it.next();
	                resultMS.put(entry.getKey(), entry.getValue());
	            }
	            int stopS=1;
	            for(String j : resultMS.keySet()) {
                    if (stopS == 6) {
                    	break;
                    }
                    else {
            		double primeiro = resultMS.get(j);
                    System.out.println("O cliente " + j + " foi o  " + stopS + " consumindo Produtos/Serviços no valor " + primeiro);
    	            System.out.println("--------------------------------------------------------------");
                	stopS+=1;
            		}
                }
		}
            
	}
}