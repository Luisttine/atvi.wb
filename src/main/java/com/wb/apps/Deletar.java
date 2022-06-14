package com.wb.apps;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.listar.Listagem;
import com.wb.listar.ListarTodosClientes;
import com.wb.modelo.Cliente;
import com.wb.modelo.Empresa;

public class Deletar extends Execucao{
	private List<Cliente> clientes;
	private Empresa empresa;
	
	public Deletar(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@Override
	public void executar() {
	
		while ( true) {
			System.out.println("\nQual cadastro voc� deseja deletar");
			System.out.println("1 - Clientes");
			System.out.println("2 - Produtos");
			System.out.println("3 - Servi�os");
			System.out.println("0 - Voltar");
			
			Entrada entrada = new Entrada();
			int deletar = entrada.receberNumeroInteiro();
			
			switch (deletar) {
			case 1:
				Listagem listagemCli = new ListarTodosClientes(empresa.getClientes());
				listagemCli.listar();				
				
				int numCliente = 0;
				while (true) {
					System.out.println("Digite o n�mero do cliente que voc� deseja deletar:");
					numCliente = entrada.receberNumeroInteiro();
					if (numCliente > 0 && numCliente <= clientes.size()) {
						break;
					}
					System.out.println("N�mero de cliente inv�lido! Verifique se o n�mero inserido est� correto.");
				}
				
				this.clientes.remove(numCliente - 1);
				System.out.println("Cliente exclu�do com sucesso!");
			
			case 0:
				System.out.println("Voltando para o menu inicial!");
				break;
			}
		}
	}
	
}