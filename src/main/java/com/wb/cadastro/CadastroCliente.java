package com.wb.cadastro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;

public class CadastroCliente extends Cadastro {
	private List<Cliente> clientes;
	private Entrada entrada;

	public CadastroCliente(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("Início do cadastro do cliente");
		
		System.out.println("Por favor informe o nome do cliente:");
		String nome = entrada.receberTexto();
		
		System.out.println("Por favor informe o nome social do cliente:");
		String nomeSocial = entrada.receberTexto();
		
		String genero = "";
		boolean execucaoGenero = true;
		while(execucaoGenero) {
			System.out.println("Por favor informe o gênero do cliente");
			System.out.println("1 - Masculino");
			System.out.println("2 - Feminino");
			int generoNum = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			if (generoNum == 1) {
				genero = "Masculino";
				execucaoGenero = false;
			} else {
				if (generoNum == 2) {
					genero = "Feminino";
					execucaoGenero = false;
				}
				else {
				System.out.println("Valor inválido! Verifique se você digitou corretamente!");
				}
			}
		}
		
		System.out.println("Por favor informe o número do cpf:");
		String valor1 = entrada.receberTexto();
		System.out.println("Por favor informe a data de emissão do cpf, no padrão dd/mm/yyyy:");
		String data1 = entrada.receberTexto();
		DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao1 = LocalDate.parse(data1, formato1);
		CPF cpf = new CPF(dataEmissao1, valor1);
		
		Cliente cliente = new Cliente(nome, nomeSocial, cpf, genero);
		
		String outroRg = "sim";
		
		while (outroRg.equals("sim")) {
			System.out.println("Por favor informe o número do RG:");
			String valor2 = entrada.receberTexto();
			System.out.println("Por favor informe a data de emissão do rg, no padrão dd/mm/yyyy:");
			String data2 = entrada.receberTexto();
			DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dataEmissao2 = LocalDate.parse(data2, formato2);
			RG rgs = new RG(dataEmissao2, valor2);
			cliente.getRgs().add(rgs);
			
			System.out.println("Digite sim para cadastrar outro RG e nao para continuar");
			outroRg = entrada.receberTexto();
			
		}
		
		String outroTel = "sim";
		while (outroTel.equals("sim")) {
			System.out.println("Por favor informe seu ddd:");
			String ddd = entrada.receberTexto();
			System.out.println("Por favor informe seu telefone para contato:");
			String numero = entrada.receberTexto();
			Telefone telefone = new Telefone(ddd, numero);
			cliente.getTelefones().add(telefone);	
			
			System.out.println("Digite sim para cadastrar outro Telefone e nao para continuar");
			outroTel = entrada.receberTexto();
		}
		
		this.clientes.add(cliente);
	}
}