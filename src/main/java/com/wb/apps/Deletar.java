package com.wb.apps;


import com.wb.io.Entrada;
import com.wb.listar.Listagem;
import com.wb.listar.ListarTodosClientes;
import com.wb.listar.ListarTodosProdutos;
import com.wb.listar.ListarTodosServicos;
import com.wb.modelo.Empresa;

public class Deletar extends Execucao{
	private Empresa empresa;
	
	public Deletar(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@Override
	public void executar() {
		
		boolean delete = true;
		
		while ( delete ) {
			System.out.println("\nQual cadastro você deseja deletar");
			System.out.println("1 - Clientes");
			System.out.println("2 - Produtos");
			System.out.println("3 - Serviços");
			System.out.println("0 - Voltar");
			
			Entrada entrada = new Entrada();
			int deletar = entrada.receberNumeroInteiro();
			
			switch (deletar) {
			case 1:
				Listagem listagemCli = new ListarTodosClientes(empresa.getClientes());
				listagemCli.listar();				
				
				int numCliente = 0;
				while (true) {
					System.out.println("Digite o número do cliente que você deseja deletar:");
					numCliente = entrada.receberNumeroInteiro();
					if (numCliente >= 0 && numCliente < empresa.getClientes().size()) {
						break;
					}
					System.out.println("Número de cliente inválido! Verifique se o número inserido está correto.");
				}
				
				this.empresa.getClientes().remove(numCliente);
				System.out.println("Cliente excluído com sucesso!");
				break;
			
			case 2:
				Listagem listagemProd = new ListarTodosProdutos(empresa.getProdutos());
				listagemProd.listar();
				
				int numProd = 0;
				while (true) {
					System.out.println("Digite o número do produto que você deseja deletar:");
					numProd = entrada.receberNumeroInteiro();
					if (numProd >= 0 && numProd < empresa.getProdutos().size()) {
						break;
					}
					System.out.println("Número de produto inválido! Verifique se o número inserido está correto.");
				}
				this.empresa.getProdutos().remove(numProd);
				System.out.println("Produto excluído com sucesso!");
				break;
				
			case 3:
				Listagem listagemServ = new ListarTodosServicos(empresa.getServicos());
				listagemServ.listar();
				
				int numServ = 0;
				while (true) {
					System.out.println("Digite o número do serviço que você deseja deletar:");
					numServ = entrada.receberNumeroInteiro();
					if (numServ >= 0 && numServ < empresa.getServicos().size()) {
						break;
					}
					System.out.println("Número de serviço inválido! Verifique se o número inserido está correto.");
				}
				this.empresa.getServicos().remove(numServ);
				System.out.println("Serviço excluído com sucesso!");	
				break;
			
			case 0:
				System.out.println("Voltando para o menu inicial!");
				delete = false;
				break;
			}
		}
	}
	
}