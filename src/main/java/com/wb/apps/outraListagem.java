package com.wb.apps;

import com.wb.io.Entrada;
import com.wb.listar.Listagem;
import com.wb.listar.*;
import com.wb.modelo.Empresa;
import com.wb.outralistagem.ListarCliGenero;
import com.wb.outralistagem.ListarConsGenero;

public class outraListagem extends Execucao{
	private Empresa empresa;
	
	public outraListagem(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@Override
	public void executar() {
		
		boolean  op = true;
		
		while ( op ) {
			System.out.println("\nQue tipo de listagem voc� deseja realizar:");
			System.out.println("1 - Listar todos os Clientes por G�nero");
			System.out.println("2 - Listar Produtos/Servi�os mais consumidos por G�nero");
			System.out.println("3 - Listar os 10 clientes que mais consumiram Prdoutos/Servi�os (quantidade)");
			System.out.println("4 - Listar os 10 clientes que menos consumiram Produtos/Servi�os");
			System.out.println("5 - Listar os 5 clientes que mais consumiram Produtos/Servi�os (valor)");
			System.out.println("6 - Listar os Produtos/Servi�os mais consumidos");
			System.out.println("0 - Voltar");
		
			Entrada entradaList = new Entrada();
			int listagens = entradaList.receberNumeroInteiro();
		
			switch ( listagens ) {
			case 0:
				System.out.println("Voltando para o menu inicial.");
				op = false;
				break;
			case 1:
				Listagem listagemCliGen = new ListarCliGenero(empresa.getClientes());
				listagemCliGen.listar();
				break;
		
			case 2:
				Listagem listagemProdGen = new ListarConsGenero(empresa.getClientes());
				listagemProdGen.listar();
				break;
		
			case 3:
				Listagem listagemServ = new ListarTodosServicos(empresa.getServicos());
				listagemServ.listar();
				break;
			case 4:
				Listagem listagemProdCons = new ListarProdutosConsumidos(empresa.getClientes());
				listagemProdCons.listar();
				break;
			case 5:
				break;
			default:
				System.out.println("\nOpera��o n�o entendida");
			}
		}
	}
}
