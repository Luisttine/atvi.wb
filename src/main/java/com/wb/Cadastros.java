package com.wb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.wb.cadastro.Cadastro;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.Empresa;
import com.wb.modelo.Produto;
import com.wb.modelo.ProdutoConsumido;
import com.wb.modelo.RG;
import com.wb.modelo.Servico;
import com.wb.modelo.ServicoConsumido;
import com.wb.modelo.Telefone;

public class Cadastros extends Cadastro{
	private List<Cliente> clientes;
	private List<Produto> produtos;
	private List<Servico> servicos;
	private Empresa empresa;
	
	public Cadastros(List<Cliente> clientes, List<Produto> produtos, List<Servico> servicos, Empresa empresa) {
		this.clientes = clientes;
		this.produtos = produtos;
		this.servicos = servicos;
		this.empresa = empresa;
	}
	@Override
	public void cadastrar() {
		int masc = 0;
		int outro=0;
		while (masc < 17) {
			String nome = "Cliente " + (masc+1);
			String nomeSocial = "Cliente " + (masc+1);
			String genero = "Masculino";
			String valorCPF = "000000" + (masc+1);
			String dataCPF = "01/01/2000";
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dataEmissaoCPF = LocalDate.parse(dataCPF, formato);
			CPF cpf = new CPF(dataEmissaoCPF, valorCPF);
			Cliente cliente = new Cliente(nome, nomeSocial, cpf, genero);

			String valorRG = "000000" + (masc+1);
			String dataRG = "01/01/2000";
			LocalDate dataEmissaoRG = LocalDate.parse(dataRG, formato);
			RG rgs = new RG(dataEmissaoRG, valorRG);
			cliente.getRgs().add(rgs);
			
			String ddd = "12";
			String numero = "0000000" + (masc+1);
			Telefone telefone = new Telefone(ddd, numero);
			cliente.getTelefones().add(telefone);
			
			this.clientes.add(cliente);
			
			String nomeP = "Produto" + (masc+1);
			double precoP = masc+1;
			Produto produto = new Produto(nomeP, precoP);
			this.produtos.add(produto);
			
			String nomeS = "Serviço" + (masc+1);
			double precoS = (masc+1);
			Servico servico = new Servico(nomeS, precoS);
			this.servicos.add(servico);
			
			int prod = 0;
			ProdutoConsumido prodCons = new ProdutoConsumido((empresa.getProdutos().get(prod)), masc);
			empresa.getClientes().get(masc).getProdutosConsumidos().add(prodCons);
			String nomeP2 = "Produto" + (outro+2);
			double precoP2 = masc+2;
			Produto produto2 = new Produto(nomeP2,precoP2);
			this.produtos.add(produto2);
			ProdutoConsumido prodCons1 = new ProdutoConsumido((empresa.getProdutos().get(prod+1)), masc);
			empresa.getClientes().get(masc).getProdutosConsumidos().add(prodCons1);
			
			ServicoConsumido servCons = new ServicoConsumido((empresa.getServicos().get(prod)), masc);
			empresa.getClientes().get(masc).getServicosConsumidos().add(servCons);
			
			outro = outro + 2;
			masc+=1;
			prod+=1;
		}
		
		int fem = 16;
		outro = 30;
		while (fem < 30) {
			String nome = "Cliente " + (fem+1);
			String nomeSocial = "Cliente " + (fem+1);
			String genero = "Feminino";
			String valorCPF = "000000" + (fem+1);
			String dataCPF = "01/01/2000";
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dataEmissaoCPF = LocalDate.parse(dataCPF, formato);
			CPF cpf = new CPF(dataEmissaoCPF, valorCPF);
			Cliente cliente = new Cliente(nome, nomeSocial, cpf, genero);

			String valorRG = "000000" + (fem+1);
			String dataRG = "01/01/2000";
			LocalDate dataEmissaoRG = LocalDate.parse(dataRG, formato);
			RG rgs = new RG(dataEmissaoRG, valorRG);
			cliente.getRgs().add(rgs);
			
			String ddd = "12";
			String numero = "0000000" + (fem+1);
			Telefone telefone = new Telefone(ddd, numero);
			cliente.getTelefones().add(telefone);
			
			String nomeP = "Produto" + (fem+1);
			double precoP = (fem+1);
			Produto produto = new Produto(nomeP, precoP);
			this.produtos.add(produto);
			
			String nomeS = "Serviço" + (fem+1);
			double precoS = (fem+1);
			Servico servico = new Servico(nomeS, precoS);
			this.servicos.add(servico);
			
			int prod = 0;
			ProdutoConsumido prodCons = new ProdutoConsumido((empresa.getProdutos().get(prod)), fem);
			empresa.getClientes().get(fem).getProdutosConsumidos().add(prodCons);
			String nomeP2 = "Produto" + (fem+2);
			double precoP2 = fem+2;
			Produto produto2 = new Produto(nomeP2,precoP2);
			this.produtos.add(produto2);
			ProdutoConsumido prodCons1 = new ProdutoConsumido((empresa.getProdutos().get(prod+1)), fem);
			empresa.getClientes().get(fem).getProdutosConsumidos().add(prodCons1);
			
			ServicoConsumido servCons = new ServicoConsumido((empresa.getServicos().get(prod)), fem);
			empresa.getClientes().get(fem).getServicosConsumidos().add(servCons);
			
			
			this.clientes.add(cliente);
			outro+=2;
			prod+=1;
			fem+=1;
		}
		
		
	}
}
