package br.edu.ifba.sistema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Administrativa {

	protected Funcionario funcionario;
	protected Cargo cargos;
	protected Empresa empresa;
	protected Pagamento pagamento;

	protected void darFerias() throws IOException {
		File arquivo = new File("funcionarios");
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<String> nomelist = new ArrayList<String>();
		ArrayList<String> cpflist = new ArrayList<String>();
		ArrayList<String> datalist = new ArrayList<String>();
		ArrayList<String> sexolist = new ArrayList<String>();
		ArrayList<String> cargolist = new ArrayList<String>();
		ArrayList<String> salariolist = new ArrayList<String>();
		ArrayList<String> dataAdlist = new ArrayList<String>();
		ArrayList<String> statuslist = new ArrayList<String>();
		String linha = br.readLine();
		String linha2 = br.readLine();
		String linha3 = br.readLine();
		String linha4 = br.readLine();
		String linha5 = br.readLine();
		String linha6 = br.readLine();
		String linha7 = br.readLine();
		String linha8 = br.readLine();
		System.out.println("\tQual funcionario deseja mudar estado para: Inativo?\n");
		String str = new Scanner(System.in).nextLine();
		for (int i = 0; linha != null; i++) {
			if (linha.equalsIgnoreCase(str)) {
				nomelist.add(linha);
				cpflist.add(linha2);
				datalist.add(linha3);
				sexolist.add(linha4);
				cargolist.add(linha5);
				salariolist.add(linha6);
				dataAdlist.add(linha7);
				statuslist.add("Inativo");

			} else {
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
		br.close();
		fr.close();
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
		System.out.println("Funcionario inativo");

	}

	protected void clean() throws IOException {
		File arquivo = new File("funcionarios");
		File arquivoC = new File("cargos");
		File arquivoE = new File("empresa");
		FileWriter fw = new FileWriter(arquivo, false);
		BufferedWriter bw = new BufferedWriter(fw);
		FileWriter fw1 = new FileWriter(arquivoC, false);
		BufferedWriter bw1 = new BufferedWriter(fw);
		FileWriter fw2 = new FileWriter(arquivoE, false);
		BufferedWriter bw2 = new BufferedWriter(fw);
		bw.newLine();
		bw1.newLine();
		bw2.newLine();
		fw.close();
		fw1.close();
		fw2.close();		
	}

	protected void tirarFerias() throws IOException {
		File arquivo = new File("funcionarios");
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<String> nomelist = new ArrayList<String>();
		ArrayList<String> cpflist = new ArrayList<String>();
		ArrayList<String> datalist = new ArrayList<String>();
		ArrayList<String> sexolist = new ArrayList<String>();
		ArrayList<String> cargolist = new ArrayList<String>();
		ArrayList<String> salariolist = new ArrayList<String>();
		ArrayList<String> dataAdlist = new ArrayList<String>();
		ArrayList<String> statuslist = new ArrayList<String>();
		String linha = br.readLine();
		String linha2 = br.readLine();
		String linha3 = br.readLine();
		String linha4 = br.readLine();
		String linha5 = br.readLine();
		String linha6 = br.readLine();
		String linha7 = br.readLine();
		String linha8 = br.readLine();
		System.out.println("\tQual funcionario deseja mudar estado para: Ativo?\n");
		String str = new Scanner(System.in).nextLine();
		for (int i = 0; linha != null; i++) {
			if (linha.equalsIgnoreCase(str)) {
				nomelist.add(linha);
				cpflist.add(linha2);
				datalist.add(linha3);
				sexolist.add(linha4);
				cargolist.add(linha5);
				salariolist.add(linha6);
				dataAdlist.add(linha7);
				statuslist.add("Ativo");

			} else {
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
		br.close();
		fr.close();
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
		System.out.println("Funcionario ativo");

	}

	protected void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void setCargos(Cargo cargos) {
		this.cargos = cargos;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
