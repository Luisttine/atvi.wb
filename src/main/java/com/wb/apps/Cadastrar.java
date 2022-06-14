package com.wb.apps;

import com.wb.cadastro.Cadastro;
import com.wb.cadastro.CadastroCliente;
import com.wb.cadastro.CadastroProduto;
import com.wb.cadastro.CadastroServico;
import com.wb.io.Entrada;
import com.wb.modelo.Empresa;

public class Cadastrar extends Execucao {
	private Empresa empresa;
	
	public Cadastrar(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@Override
	public void executar() {
		
		while ( true ) {
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
		}
	}

}
