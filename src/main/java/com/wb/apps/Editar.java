package com.wb.apps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.wb.io.Entrada;
import com.wb.listar.Listagem;
import com.wb.listar.ListarRgs;
import com.wb.listar.ListarTelefones;
import com.wb.listar.ListarTodosClientes;
import com.wb.listar.ListarTodosProdutos;
import com.wb.listar.ListarTodosServicos;
import com.wb.modelo.Empresa;

public class Editar extends Execucao{
	private Empresa empresa;
	
	public Editar(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@Override
	public void executar() {
		
		boolean edit = true;
		
		while ( edit ) {
			System.out.println("\nQual cadastro voc� deseja editar");
			System.out.println("1 - Clientes");
			System.out.println("2 - Produtos");
			System.out.println("3 - Servi�os");
			System.out.println("0 - Voltar");
			
			Entrada entrada = new Entrada();
			int editar = entrada.receberNumeroInteiro();
			
			switch (editar) {
			case 1:									
				Listagem listagemCli = new ListarTodosClientes(empresa.getClientes());
				listagemCli.listar();				
					
				int numCliente = 0;
				boolean ope = true;
				
				while (ope) {
					System.out.println("Digite o n�mero do cliente que voc� deseja editar:");
					numCliente = entrada.receberNumeroInteiro();
					if (numCliente >= 0 && numCliente < empresa.getClientes().size()) {
						break;
					}
					System.out.println("N�mero de cliente inv�lido! Verifique se o n�mero inserido est� correto.");
				
				System.out.println("\nQual informa��o voc� deseja editar");
				System.out.println("1 - Nome");
				System.out.println("2 - CPF");
				System.out.println("3 - RG");
				System.out.println("4 - Telefone");
				System.out.println("0 - Voltar");
				System.out.println("\nDigite o n�mero do cliente que voc� deseja editar");
				int cli = entrada.receberNumeroInteiro();
				
				int editarCli = entrada.receberNumeroInteiro();

				switch ( editarCli ) {
				case 1:
					System.out.println("Por favor informe o nome do cliente:");
					String nome = entrada.receberTexto();
					this.empresa.getClientes().get(numCliente).nome = nome;
					
					System.out.println("Por favor informe o nome social do cliente:");
					String nomeSocial = entrada.receberTexto();
					this.empresa.getClientes().get(numCliente).nome = nomeSocial;
					
					System.out.println("CPF editado com sucesso");
					break;
				
				case 2:
					System.out.println("Por favor informe o CPF do cliente:");
					String cpf = entrada.receberTexto();
					this.empresa.getClientes().get(numCliente).getCpf().setValor(cpf);
					
					System.out.println("Por favor informe a data de emiss�o do CPF:");
					String dataEmissaoCpf = entrada.receberTexto();
					DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate dataEmissao1 = LocalDate.parse(dataEmissaoCpf, formato);
					this.empresa.getClientes().get(numCliente).getCpf().setDataEmissao(dataEmissao1);
					
					System.out.println("CPF editado com sucesso");
					break;
				case 3:
					
					Listagem listagemRg = new ListarRgs(empresa.getClientes());
					listagemRg.listar();	
					
					int numRg = 0;
					while (true) {
						System.out.println("Digite o n�mero do RG que voc� deseja editar:");
						numRg = entrada.receberNumeroInteiro();
						if (numRg>= 0 && numRg < empresa.getClientes().get(numCliente).getRgs().size()) {
							System.out.println("Por favor informe o RG do cliente:");
							String valor = entrada.receberTexto();
							/*this.empresa.getClientes().get(cli).getRgs().setValor(valor);*/
							
							System.out.println("Por favor informe a data de emiss�o do RG:");
							String dataEmissaoRg = entrada.receberTexto();
							DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							LocalDate dataEmissao2 = LocalDate.parse(dataEmissaoRg, formato1);
							/*this.empresa.getClientes().get(cli).getRgs().setDataEmissao(dataEmissao2);*/
							
							System.out.println("RG editado com sucesso");
							break;
						}
						System.out.println("N�mero de RG inv�lido! Verifique se o n�mero inserido est� correto.");
					
					}
				case 4:
					
					Listagem listagemTel = new ListarTelefones(empresa.getClientes());
					listagemTel.listar();	
					
					int numTel = 0;
					while (true) {
						System.out.println("Digite o n�mero do Telefone que voc� deseja editar:");
						numTel = entrada.receberNumeroInteiro();
						if (numTel>= 0 && numTel < empresa.getClientes().get(numCliente).getTelefones().size()) {
							System.out.println("Por favor informe o DDD do telefone:");
							String ddd = entrada.receberTexto();
							/*this.empresa.getClientes().get(cli).getTelefones().setDdd(ddd);*/
							
							System.out.println("Por favor informe o novo n�mero:");
							String numero = entrada.receberTexto();
							/*this.empresa.getClientes().get(cli).getTelefones().setNumero()numero;*/
							
							System.out.println("CPF editado com sucesso");
							break;
						}
						System.out.println("N�mero de Telefone inv�lido! Verifique se o n�mero inserido est� correto.");
						}
				case 0:
					ope = false;
					break;
				}
			}
				break;
				
			
			case 2:
				Listagem listagemProd = new ListarTodosProdutos(empresa.getProdutos());
				listagemProd.listar();
				
				int numProd = 0;
				while (true) {
					System.out.println("Digite o n�mero do produto que voc� deseja deletar:");
					numProd = entrada.receberNumeroInteiro();
					if (numProd >= 0 && numProd < empresa.getProdutos().size()) {
						break;
					}
					System.out.println("N�mero de produto inv�lido! Verifique se o n�mero inserido est� correto.");
				}
				this.empresa.getProdutos().remove(numProd);
				System.out.println("Produto exclu�do com sucesso!");
				break;
				
			case 3:
				Listagem listagemServ = new ListarTodosServicos(empresa.getServicos());
				listagemServ.listar();
				
				int numServ = 0;
				while (true) {
					System.out.println("Digite o n�mero do servi�o que voc� deseja deletar:");
					numServ = entrada.receberNumeroInteiro();
					if (numServ >= 0 && numServ < empresa.getServicos().size()) {
						break;
					}
					System.out.println("N�mero de servi�o inv�lido! Verifique se o n�mero inserido est� correto.");
				}
				this.empresa.getServicos().remove(numServ);
				System.out.println("Servi�o exclu�do com sucesso!");	
				break;
			
			case 0:
				System.out.println("Voltando para o menu inicial!");
				edit = false;
				break;
			}
		}
	}
}