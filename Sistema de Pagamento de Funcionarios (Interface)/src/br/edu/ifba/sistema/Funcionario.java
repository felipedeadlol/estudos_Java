package br.edu.ifba.sistema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Funcionario extends Pessoa {
	private ArrayList<String> nomelist = new ArrayList<String>();
	private ArrayList<String> cpflist = new ArrayList<String>();
	private ArrayList<String> datalist = new ArrayList<String>();
	private ArrayList<String> sexolist = new ArrayList<String>();
	private ArrayList<String> cargolist = new ArrayList<String>();
	private ArrayList<String> salariolist = new ArrayList<String>();
	private ArrayList<String> dataAdlist = new ArrayList<String>();
	private ArrayList<String> statuslist = new ArrayList<String>();
	private Scanner txt = new Scanner(System.in);
	private Scanner num = new Scanner(System.in);
	private String cargo;
	private String salario;
	private String dia = "" + (Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
	private String mes = "" + (Calendar.getInstance().get(Calendar.MONTH) + 1);
	private String ano = "" + (Calendar.getInstance().get(Calendar.YEAR));
	private String dataAd = dia + "/" + mes + "/" + ano;

	protected void registrarFuncionario() throws IOException {
		System.out.println("\tDigite quantos funcionarios deseja registrar\n");
		int quantidade = num.nextInt();
		File arquivo = new File("funcionarios");
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		File arquivoC = new File("cargos");
		FileReader fr = new FileReader(arquivoC);
		BufferedReader br = new BufferedReader(fr);
		cargo = br.readLine();
		salario = br.readLine();
		FileWriter fw = new FileWriter(arquivo, true);
		BufferedWriter bw = new BufferedWriter(fw);
		for (int i = 0; i < quantidade; i++) {
			System.out.println("Digite o novo nome");
			nome = txt.next();
			System.out.println("Digite o novo CPF");
			cpf = new Scanner(System.in).nextLine();
			System.out.println("Digite a nova data de nacimento");
			dataNacimento = new Scanner(System.in).nextLine();
			System.out.println("Digite o novo sexo (Masculino, Feminino ou Indefinido)");
			sexo = txt.next().charAt(0);
			System.out.println("\tQual o novo cargo deseja atribuir ao funcionario?\n");
			String str = new Scanner(System.in).nextLine();
			String cargoAux = br.readLine();
			String salarioAux = br.readLine();
			for (int i1 = 0; cargoAux != null; i1++) {
				if (cargoAux.equalsIgnoreCase(str)) {
					cargo = cargoAux;
					salario = salarioAux;
				}
				cargoAux = br.readLine();
				salarioAux = br.readLine();

			}
			bw.write(nome);
			bw.newLine();
			bw.write("" + cpf);
			bw.newLine();
			bw.write("" + dataNacimento);
			bw.newLine();
			bw.write("" + sexo);
			bw.newLine();
			bw.write("" + cargo);
			bw.newLine();
			bw.write("" + salario);
			bw.newLine();
			bw.write("" + dataAd);
			bw.newLine();
			bw.write("Ativo");
			bw.newLine();
		}
		br.close();
		br.close();
		bw.close();
		fw.close();
		bw.close();
		fw.close();
		System.out.println("Registro completo");


	}

	protected void verFuncionario() throws IOException {
		File arquivo = new File("funcionarios");
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		System.out.println("\tFuncionarios registrados\n");
		while (br.ready()) {
			nome = br.readLine();
			System.out.println("Nome: " + nome);
			cpf = br.readLine();
			System.out.println("CPF: " + cpf);
			dataNacimento = br.readLine();
			System.out.println("Data de nacimento: " + dataNacimento);
			String sexo = br.readLine();
			if (sexo.equalsIgnoreCase("i")) {
				System.out.println("Sexo: Indefinido.");
			} else {
				if (sexo.equalsIgnoreCase("m")) {
					System.out.println("Sexo: Masculino.");
				} else {
					System.out.println("Sexo: Feminino.");
				}

			}
			String cargo = br.readLine();
			System.out.println("Cargo: " + cargo);
			String salario = br.readLine();
			double salarioDouble = Double.parseDouble(salario);
			System.out.printf("Salario: R$%.2f\n",salarioDouble);
			String dataAD = br.readLine();
			System.out.println("Data de admissão: " + dataAD);
			String status = br.readLine();
			if (status.equalsIgnoreCase("ativo")) {
				System.out.println("Status: Ativo.");
			} else {
				System.out.println("Status: Inativo.");
			}

			System.out.println("**********************************");
		}
		fr.close();
		br.close();

	}

	private void registrarFuncionarioAux() throws IOException {
		File arquivo = new File("funcionarios");
		File arquivoC = new File("cargos");
		FileReader fr = new FileReader(arquivoC);
		BufferedReader br = new BufferedReader(fr);
		String cargo = br.readLine();
		String salario = br.readLine();
		FileWriter fw = new FileWriter(arquivo, true);
		BufferedWriter bw = new BufferedWriter(fw);
		for (int i = 0; i < 1; i++) {
			System.out.println("Digite o novo nome");
			nome = txt.next();
			System.out.println("Digite o novo CPF");
			cpf = new Scanner(System.in).nextLine();
			System.out.println("Digite a nova data de nacimento");
			dataNacimento = new Scanner(System.in).nextLine();
			System.out.println("Digite o novo sexo (Masculino, Feminino ou Indefinido).");
			sexo = txt.next().charAt(0);
			System.out.println("\tQual o novo cargo deseja atribuir ao funcionario?\n");
			String str = new Scanner(System.in).nextLine();
			String cargoAux = br.readLine();
			String salarioAux = br.readLine();
			for (int i1 = 0; cargoAux != null; i1++) {
				if (cargoAux.equalsIgnoreCase(str)) {
					cargo = cargoAux;
					salario = salarioAux;
				}
				cargoAux = br.readLine();
				salarioAux = br.readLine();

			}
			bw.write(nome);
			bw.newLine();
			bw.write("" + cpf);
			bw.newLine();
			bw.write("" + dataNacimento);
			bw.newLine();
			bw.write("" + sexo);
			bw.newLine();
			bw.write("" + cargo);
			bw.newLine();
			bw.write("" + salario);
			bw.newLine();
			bw.write("" + dataAd);
			bw.newLine();
			bw.write("Ativo");
			bw.newLine();
		}
		br.close();
		br.close();
		bw.close();
		fw.close();
		bw.close();
		fw.close();

	}

	protected void deletarFuncionario() throws IOException {
		verFuncionario();
		File arquivo = new File("funcionarios");
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		String linha = br.readLine();
		String linha2 = br.readLine();
		String linha3 = br.readLine();
		String linha4 = br.readLine();
		String linha5 = br.readLine();
		String linha6 = br.readLine();
		String linha7 = br.readLine();
		String linha8 = br.readLine();
		System.out.println("\tQual funcionario deseja excluir?\n");
		String str = txt.nextLine();
		for (int i = 0; linha != null; i++) {
			if (!linha.equals(str)) {
				nomelist.add(linha);
				cpflist.add(linha2);
				datalist.add(linha3);
				sexolist.add(linha4);
				cargolist.add(linha5);
				salariolist.add(linha6);
				dataAdlist.add(linha7);
				statuslist.add(linha8);
			}
			linha = br.readLine();
			linha2 = br.readLine();
			linha3 = br.readLine();
			linha4 = br.readLine();
			linha5 = br.readLine();
			linha6 = br.readLine();
			linha7 = br.readLine();
			linha8 = br.readLine();
		}
		br.close();
		fr.close();

		FileWriter fw = new FileWriter(arquivo, false);
		BufferedWriter bw = new BufferedWriter(fw);

		for (int i = 0; i < nomelist.size(); i++) {
			bw.write(nomelist.get(i));
			bw.newLine();
			bw.write(cpflist.get(i));
			bw.newLine();
			bw.write(datalist.get(i));
			bw.newLine();
			bw.write(sexolist.get(i));
			bw.newLine();
			bw.write(cargolist.get(i));
			bw.newLine();
			bw.write(salariolist.get(i));
			bw.newLine();
			bw.write(dataAdlist.get(i));
			bw.newLine();
			bw.write(statuslist.get(i));
			bw.newLine();
		}
		bw.close();
		fw.close();
		System.out.println("Pronto! Realizada a exclusão.");

		nomelist.clear();
		cpflist.clear();
		datalist.clear();
		sexolist.clear();
		cargolist.clear();
		salariolist.clear();
		dataAdlist.clear();
		statuslist.clear();

	}

	protected void editarFuncionario() throws IOException {
		verFuncionario();
		File arquivo = new File("funcionarios");
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		String linha = br.readLine();
		String linha2 = br.readLine();
		String linha3 = br.readLine();
		String linha4 = br.readLine();
		String linha5 = br.readLine();
		String linha6 = br.readLine();
		String linha7 = br.readLine();
		String linha8 = br.readLine();
		System.out.println("\tQual funcionario deseja editar?\n");
		String str = new Scanner(System.in).nextLine();
		for (int i = 0; linha != null; i++) {
			if (!linha.equalsIgnoreCase(str)) {
				nomelist.add(linha);
				cpflist.add(linha2);
				datalist.add(linha3);
				sexolist.add(linha4);
				cargolist.add(linha5);
				salariolist.add(linha6);
				dataAdlist.add(linha7);
				statuslist.add(linha8);
			}
			linha = br.readLine();
			linha2 = br.readLine();
			linha3 = br.readLine();
			linha4 = br.readLine();
			linha5 = br.readLine();
			linha6 = br.readLine();
			linha7 = br.readLine();
			linha8 = br.readLine();
		}
		br.close();
		fr.close();

		FileWriter fw = new FileWriter(arquivo, false);
		BufferedWriter bw = new BufferedWriter(fw);

		for (int i = 0; i < nomelist.size(); i++) {
			bw.write(nomelist.get(i));
			bw.newLine();
			bw.write(cpflist.get(i));
			bw.newLine();
			bw.write(datalist.get(i));
			bw.newLine();
			bw.write(sexolist.get(i));
			bw.newLine();
			bw.write(cargolist.get(i));
			bw.newLine();
			bw.write(salariolist.get(i));
			bw.newLine();
			bw.write(dataAdlist.get(i));
			bw.newLine();
			bw.write(statuslist.get(i));
			bw.newLine();
		}
		bw.close();
		fw.close();
		nomelist.clear();
		cpflist.clear();
		datalist.clear();
		sexolist.clear();
		cargolist.clear();
		salariolist.clear();
		dataAdlist.clear();
		statuslist.clear();
		registrarFuncionarioAux();
		System.out.println("Funcionario editado com sucesso!");
	}

	
}
