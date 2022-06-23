package com.wb.apps;

import com.wb.io.Entrada;
import com.wb.listar.Listagem;
import com.wb.modelo.Empresa;
import com.wb.outralistagem.*;


public class outraListagem extends Execucao{
	private Empresa empresa;
	
	public outraListagem(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@Override
	public void executar() {
		
		boolean  op = true;
		
		while ( op ) {
			System.out.println("\nQue tipo de listagem você deseja realizar:");
			System.out.println("1 - Listar todos os Clientes por Gênero");
			System.out.println("2 - Listar Produtos/Serviços mais consumidos por Gênero");
			System.out.println("3 - Listar os 10 clientes que mais consumiram Prdoutos/Serviços (quantidade)");
			System.out.println("4 - Listar os 10 clientes que menos consumiram Produtos/Serviços");
			System.out.println("5 - Listar os 5 clientes que mais consumiram Produtos/Serviços (valor)");
			System.out.println("6 - Listar os Produtos/Serviços mais consumidos");
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
				Listagem listagemCliMaisCons = new ListarCliMaisCons(empresa.getClientes());
				listagemCliMaisCons.listar();
				break;
			case 4:
				Listagem listagemCliMenosCons = new ListarCliMenosCons(empresa.getClientes());
				listagemCliMenosCons.listar();
				break;
			case 5:
				Listagem listagemCliMaisVal = new ListarCliMaisVal(empresa.getClientes());
				listagemCliMaisVal.listar();
				break;
			case 6:
				Listagem listagemProdServCons = new ListarProdServCons(empresa.getClientes());
				listagemProdServCons.listar();
				break;
			default:
				System.out.println("\nOperação não entendida");
			}
		}
	}
}
