package br.edu.ifba.sistema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Empresa {
	private Scanner txt = new Scanner(System.in);
	private Scanner num = new Scanner(System.in);
	private String nome, cnpj, localizacao, dono;
	private int op;

	void registrarEmpresa() throws IOException {
		File arquivo = new File("empresa");
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		FileWriter fw = new FileWriter(arquivo, false);
		BufferedWriter bw = new BufferedWriter(fw);
		System.out.println("Digite o Nome da empresa");
		this.nome = txt.nextLine();
		System.out.println("Digite o CNPJ da empresa");
		this.cnpj = num.nextLine();
		System.out.println("Digite o Localização da empresa");
		this.localizacao = txt.nextLine();
		System.out.println("Digite o Dono da empresa");
		this.dono = num.nextLine();
		bw.write(nome);
		bw.newLine();
		bw.write(cnpj);
		bw.newLine();
		bw.write(localizacao);
		bw.newLine();
		bw.write(dono);
		bw.newLine();
		bw.close();
		fw.close();
	}

	void verEmpresa() throws IOException {
		File arquivo = new File("empresa");
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		System.out.println("Dados da empresa");
		while (br.ready()) {
			String nome = br.readLine();
			System.out.println("Nome: " + nome);
			String cnpj = br.readLine();
			System.out.println("CNPJ: " + cnpj);
			String localizacao = br.readLine();
			System.out.println("Localização: " + localizacao);
			String dono = br.readLine();
			System.out.println("Dono: " + dono);
		}
		br.close();
		fr.close();
	}

	void editarEmpresa() throws IOException {
		File arquivo = new File("empresa");
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		String linha = br.readLine(); // nome
		String linha2 = br.readLine(); // cnpj
		String linha3 = br.readLine(); // localização
		String linha4 = br.readLine(); // dono
		System.out.println("Digite 1- Localização || 2- Dono || 3 - Sair");
		op = num.nextInt();
		switch (op) {
		case 1:
			System.out.println("Digite a nova localização");
			localizacao = new Scanner(System.in).nextLine();
			linha3 =localizacao;
			break;
		case 2:
			System.out.println("Digite o novo dono");
			dono = new Scanner(System.in).nextLine();
			linha4 =dono;
			break;
		default:
			break;
		}
		FileWriter fw = new FileWriter(arquivo);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(linha);
		bw.newLine();
		bw.write(linha2);
		bw.newLine();
		bw.write("" + linha3);
		bw.newLine();
		bw.write("" + linha4);
		bw.newLine();
		bw.close();
		fw.close();
		br.close();
	}

}