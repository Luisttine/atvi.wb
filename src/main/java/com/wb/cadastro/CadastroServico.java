package com.wb.cadastro;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Servico;

public class CadastroServico extends Cadastro {
	private List<Servico> servico;
	private Entrada entrada;

	public CadastroServico(List<Servico> servico) {
		this.servico = servico;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("Início do cadastro de serviços");
		
		System.out.println("Por favor informe o nome do serviço:");
		String nome = entrada.receberTexto();	
		
		System.out.println("Por favor informe o valor do serviço:");
		double preco = entrada.receberNumeroDouble();
		
		Servico servico = new Servico(nome, preco);
		
		this.servico.add(servico);
	}

	public List<Servico> getServicos() {
		return servico;
	}

}