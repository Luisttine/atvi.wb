package com.wb.apps;

import com.wb.io.Entrada;
import com.wb.listar.Listagem;
import com.wb.listar.ListarTodosClientes;
import com.wb.listar.ListarTodosProdutos;
import com.wb.listar.ListarTodosServicos;
import com.wb.modelo.Empresa;

public class Listar extends Execucao{
	private Empresa empresa;
	
	public Listar(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@Override
	public void executar() {
		
		while ( true ) {
			System.out.println("\nQue tipo de listagem voc� deseja realizar:");
			System.out.println("1 - Listar todos os Clientes");
			System.out.println("2 - Listar todos os Produtos");
			System.out.println("3 - Listar todos os Servi�os");
			System.out.println("0 - Voltar");
		
			Entrada entradaList = new Entrada();
			int listagens = entradaList.receberNumeroInteiro();
		
			switch ( listagens ) {
			case 0:
				System.out.println("Voltando para o menu inicial.");
				break;
			case 1:
				Listagem listagemCli = new ListarTodosClientes(empresa.getClientes());
				listagemCli.listar();
				break;
		
			case 2:
				Listagem listagemProd = new ListarTodosProdutos(empresa.getProdutos());
				listagemProd.listar();
				break;
		
			case 3:
				Listagem listagemServ = new ListarTodosServicos(empresa.getServicos());
				listagemServ.listar();
				break;
			default:
				System.out.println("\nOpera��o n�o entendida");
			}
			break;
		}
	}
}
