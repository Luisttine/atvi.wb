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
		int masc = 1;
		while (masc != 15) {
			String nome = "Cliente " + masc;
			String nomeSocial = "Cliente " + masc;
			String genero = "Masculino";
			String valorCPF = "000000" + masc;
			String dataCPF = masc + "/01/2000";
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dataEmissaoCPF = LocalDate.parse(dataCPF, formato);
			CPF cpf = new CPF(dataEmissaoCPF, valorCPF);
			Cliente cliente = new Cliente(nome, nomeSocial, cpf, genero);

			String valorRG = "000000" + masc;
			String dataRG = masc + "/01/2000";
			LocalDate dataEmissaoRG = LocalDate.parse(dataRG, formato);
			RG rgs = new RG(dataEmissaoRG, valorRG);
			cliente.getRgs().add(rgs);
			
			String ddd = "12";
			String numero = "0000000" + masc;
			Telefone telefone = new Telefone(ddd, numero);
			cliente.getTelefones().add(telefone);
			
			this.clientes.add(cliente);
			
			String nomeP = "Produto" + masc;
			double precoP = masc;
			Produto produto = new Produto(nomeP, precoP);
			this.produtos.add(produto);
			
			String nomeS = "Serviço" + masc;
			double precoS = masc;
			Servico servico = new Servico(nomeS, precoS);
			this.servicos.add(servico);
			
			ProdutoConsumido prodCons = new ProdutoConsumido((empresa.getProdutos().get(masc-1)), masc);
			empresa.getClientes().get(masc-1).getProdutosConsumidos().add(prodCons);
			ProdutoConsumido prodCons1 = new ProdutoConsumido((empresa.getProdutos().get(masc-1)), masc);
			empresa.getClientes().get(masc-1).getProdutosConsumidos().add(prodCons1);
			
			ServicoConsumido servCons = new ServicoConsumido((empresa.getServicos().get(masc-1)), masc);
			empresa.getClientes().get(masc-1).getServicosConsumidos().add(servCons);
			
			masc+=1;
		}
		
		int fem = 16;
		while (fem != 30) {
			String nome = "Cliente " + masc;
			String nomeSocial = "Cliente " + masc;
			String genero = "Feminino";
			String valorCPF = "000000" + masc;
			String dataCPF = masc + "/01/2000";
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dataEmissaoCPF = LocalDate.parse(dataCPF, formato);
			CPF cpf = new CPF(dataEmissaoCPF, valorCPF);
			Cliente cliente = new Cliente(nome, nomeSocial, cpf, genero);

			String valorRG = "000000" + masc;
			String dataRG = masc + "/01/2000";
			LocalDate dataEmissaoRG = LocalDate.parse(dataRG, formato);
			RG rgs = new RG(dataEmissaoRG, valorRG);
			cliente.getRgs().add(rgs);
			
			String ddd = "12";
			String numero = "0000000" + masc;
			Telefone telefone = new Telefone(ddd, numero);
			cliente.getTelefones().add(telefone);
			
			this.clientes.add(cliente);
			fem+=1;
		}
		
		
	}
	
}
