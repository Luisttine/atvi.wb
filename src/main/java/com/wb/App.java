package com.wb;

import com.wb.apps.Cadastrar;
import com.wb.apps.Deletar;
import com.wb.apps.Execucao;
import com.wb.apps.Listar;
import com.wb.editar.Editar;
import com.wb.io.Entrada;
import com.wb.modelo.Empresa;

public class App {
	public static void main(String[] args) {
		System.out.println("Bem-vindo ao cadastro de clientes do Grupo World Beauty");
		Empresa empresa = new Empresa();
		boolean execucao = true;
		while (execucao) {
			System.out.println("\nQue tipo de opera��o voc� deseja fazer:");
			System.out.println("1 - Cadastros");
			System.out.println("2 - Listagens");
			System.out.println("3 - Editar Cadastros");
			System.out.println("4 - Excluir Cadastros");
			System.out.println("5 - Outros");
			System.out.println("0 - Sair");

			Entrada entrada = new Entrada();
			int operacao = entrada.receberNumeroInteiro();

			switch (operacao) {
			case 0:
				execucao = false;
				System.out.println("At� mais!\n");
				break;
			case 1:
				Execucao Cadastrar = new Cadastrar(empresa);
				Cadastrar.executar();
			break;
			
			case 2:
				Execucao Listar = new Listar(empresa);
				Listar.executar();
			break;
			
			case 4:
				Execucao Deletar = new Deletar(empresa);
				Deletar.executar();
				
			default:
				System.out.println("\nOpera��o n�o entendida");
			}
		}
	}
}