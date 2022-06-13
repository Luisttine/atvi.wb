package com.wb;

import com.wb.io.Entrada;
import com.wb.modelo.Empresa;
import com.wb.negocio.Cadastro;
import com.wb.negocio.CadastroCliente;
import com.wb.negocio.CadastroProduto;
import com.wb.negocio.CadastroServico;
import com.wb.negocio.Listagem;
import com.wb.negocio.ListarTodosClientes;
import com.wb.negocio.ListarTodosProdutos;
import com.wb.negocio.ListarTodosServicos;

public class App {
	public static void main(String[] args) {
		System.out.println("Bem-vindo ao cadastro de clientes do Grupo World Beauty");
		Empresa empresa = new Empresa();
		boolean execucao = true;
		while (execucao) {
			System.out.println("\nQue tipo de operação você deseja fazer:");
			System.out.println("1 - Cadastros");
			System.out.println("2 - Listagens");
			System.out.println("0 - Sair");

			Entrada entrada = new Entrada();
			int operacao = entrada.receberNumeroInteiro();

			switch (operacao) {
			case 0:
				execucao = false;
				System.out.println("Até mais!\n");
				break;
			case 1:
				System.out.println("\nQue tipo de cadastro você deseja realizar:");
				System.out.println("1 - Cadastro de Clientes");
				System.out.println("2 - Cadastro de Produtos");
				System.out.println("3 - Cadastro de Serviços");
				System.out.println("0 - Voltar");

				Entrada entradaCad = new Entrada();
				int cadastros = entradaCad.receberNumeroInteiro();
				
				switch ( cadastros ) {
				case 0:
					System.out.println("Voltando para o menu inicial.");
					break;
				case 1:
					Cadastro cadastroCli = new CadastroCliente(empresa.getClientes());
					cadastroCli.cadastrar();
					break;
				case 2:
					Cadastro cadastroProd = new CadastroProduto(empresa.getProdutos());
					cadastroProd.cadastrar();
					break;
				case 3:
					Cadastro cadastroServ = new CadastroServico(empresa.getServicos());
					cadastroServ.cadastrar();
					break;
				default:
					System.out.println("\nOperação não entendida");
				}
			break;
			case 2:
				System.out.println("\nQue tipo de listagem você deseja realizar:");
				System.out.println("1 - Listar todos os Clientes");
				System.out.println("2 - Listar todos os Produtos");
				System.out.println("3 - Listar todos os Serviços");
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
					System.out.println("\nOperação não entendida");
				}
			break;
				
			default:
				System.out.println("\nOperação não entendida");
			}
		}
	}
}