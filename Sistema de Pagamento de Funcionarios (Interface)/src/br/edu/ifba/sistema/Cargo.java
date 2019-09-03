package br.edu.ifba.sistema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cargo {
	private double Salario;
	private String Cargo;
	private Scanner txt = new Scanner(System.in);
	private Scanner num = new Scanner(System.in);
	ArrayList<String> CargoList = new ArrayList<String>();
	ArrayList<String> SalarioList = new ArrayList<String>();

	protected void registrarCargo() throws IOException {
		System.out.println("Digite quantos Cargos deseja registrar");
		int quantidade = num.nextInt();
		File arquivo = new File("cargos");
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		FileWriter fw = new FileWriter(arquivo, true);
		BufferedWriter bw = new BufferedWriter(fw);
		for (int i = 0; i < quantidade; i++) {
			System.out.println("\tRegistro de Cargo: " +(i+1));
			System.out.println("Digite o Cargo.");
			Cargo = txt.nextLine();
			System.out.println("Digite o salario.");
			Salario = num.nextDouble();
			bw.write(Cargo);
			bw.newLine();
			bw.write("" + Salario);
			bw.newLine();
			System.out.println("**********************************");
		}
		bw.close();
		fw.close();
		System.out.println("Cargo registrado com sucesso");
	}

	protected void verCargo() throws IOException {
		File arquivo = new File("cargos");
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		System.out.println("\tCargos Registrados.\n");
		while (br.ready()) {
			String Cargo = br.readLine();			
			System.out.println("Cargo - " + Cargo);
			String Salario = br.readLine();
			double salarioDouble = Double.parseDouble(Salario);
			System.out.printf("Salario: R$%.2f\n",salarioDouble);
			System.out.println("**********************************");
		}
		br.close();
		fr.close();
	}

	protected void deletarCargo() throws IOException {
		verCargo();
		File arquivo = new File("cargos");
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		String linha = br.readLine();
		String linha2 = br.readLine();
		System.out.println("\tQual cargo que quer excluir?\n");
		String str = txt.nextLine();
		for (int i = 0; linha != null; i++) {
			if (!linha.equals(str)) {
				CargoList.add(linha);
				SalarioList.add(linha2);
			}
			linha = br.readLine();
			linha2 = br.readLine();
		}
		br.close();
		fr.close();

		FileWriter fw = new FileWriter(arquivo);
		BufferedWriter bw = new BufferedWriter(fw);

		for (int i = 0; i < CargoList.size(); i++) {
			bw.write(CargoList.get(i));
			bw.newLine();
			bw.write(SalarioList.get(i));
			bw.newLine();
		}
		bw.close();
		fw.close();
		System.out.println("Pronto! Realizada a exclusão");

	}

	private void registrarCargoAux() throws IOException {
		File arquivo = new File("cargos");
		FileWriter fw = new FileWriter(arquivo, true);
		BufferedWriter bw = new BufferedWriter(fw);
		System.out.println("Digite o Cargo.");
		Cargo = txt.nextLine();
		System.out.println("Digite o salario.");
		Salario = num.nextDouble();
		bw.write(Cargo);
		bw.newLine();
		bw.write("" + Salario);
		bw.newLine();
		bw.close();
		fw.close();

	}

	protected void editarCargo() throws IOException {
		verCargo();
		File arquivo = new File("cargos");
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		String linha = br.readLine();
		String linha2 = br.readLine();
		System.out.println("\tQual cargo que deseja editar?");
		String str = txt.nextLine();
		for (int i = 0; linha != null; i++) {
			if (!linha.equals(str)) {
				CargoList.add(linha);
				SalarioList.add(linha2);
			}
			linha = br.readLine();
			linha2 = br.readLine();
		}
		br.close();
		fr.close();

		FileWriter fw = new FileWriter(arquivo);
		BufferedWriter bw = new BufferedWriter(fw);

		for (int i = 0; i < CargoList.size(); i++) {
			bw.write(CargoList.get(i));
			bw.newLine();
			bw.write(SalarioList.get(i));
			bw.newLine();
		}
		bw.close();
		fw.close();
		registrarCargoAux();
	}

}
