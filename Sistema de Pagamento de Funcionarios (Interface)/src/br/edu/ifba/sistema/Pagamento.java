package br.edu.ifba.sistema;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class Pagamento {
	private double inss, ir, salarioLiquidoDouble, salarioBrutoDouble, acrescimos, pensao, depentes, base, descontos;
	Funcionario funcionario;
	Administrativa administrativa;
	Scanner txt = new Scanner(System.in);
	Scanner num = new Scanner(System.in);
	String dia = "" + (Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
	String mes = "" + (Calendar.getInstance().get(Calendar.MONTH) + 1);
	String ano = "" + (Calendar.getInstance().get(Calendar.YEAR));
	String dataPagamento = dia + "/" + mes + "/" + ano;

	void pagarFuncionario() throws IOException {
		File arquivo = new File("funcionarios");
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		File arquivoEmpresa = new File("empresa");
		FileReader fr1 = new FileReader(arquivoEmpresa);
		BufferedReader br1 = new BufferedReader(fr1);
		String empresa = br1.readLine();
		System.out.println("\tQual funcionario deseja pagar?\n");
		String str = new Scanner(System.in).nextLine();
		while (br.ready()) {
			String nomeAux = br.readLine();
			if (str.equalsIgnoreCase(nomeAux)) {
				String cpfAux = br.readLine();
				br.readLine();
				br.readLine();
				String cargo = br.readLine();
				String salario = br.readLine();
				String dataAd = br.readLine();
				String status = br.readLine();
				if (status.equalsIgnoreCase("Inativo")) {
					System.out.println("\tFuncionario nao pode ser pago, por conta do seu status atual\n");
					break;
				} else {
					System.out.println("Deseja abrir a calculadora? (Sim ou Não)");
					String aux = new Scanner(System.in).nextLine();
					if (aux.equalsIgnoreCase("sim")) {
						try {
							// Runtime.getRuntime().exec("calc");
							Runtime.getRuntime().exec("C:/Windows/System32/calc.exe");
						} catch (Exception e) {
							System.err.println("Não foi possivel abrir a calculadora");
						}

					}

					System.out.println("Digite o valor da hora extra e outro acrescimos adicionais");
					acrescimos = new Scanner(System.in).nextDouble();
					System.out.println("Digite o valor da pensão alimentícia");
					pensao = new Scanner(System.in).nextDouble();
					System.out.println("Digite o número de dependentes");
					depentes = new Scanner(System.in).nextDouble();
					System.out.println("Digite outros descontos");
					descontos = new Scanner(System.in).nextDouble();

					salarioBrutoDouble = Double.parseDouble(salario);
					salarioBrutoDouble = salarioBrutoDouble + acrescimos;

					if (salarioBrutoDouble > 5531.31) {
						inss = (salarioBrutoDouble - (608.44) - (pensao - (depentes * 189)));
						base = salarioBrutoDouble - (salarioBrutoDouble - (608.44) - (pensao - (depentes * 189)));

					} else {
						if (salarioBrutoDouble > 2765.67) {
							inss = ((salarioBrutoDouble - (salarioBrutoDouble * 0.11)) - (pensao - (depentes * 189)));
							base = salarioBrutoDouble - ((salarioBrutoDouble - (salarioBrutoDouble * 0.11))
									- (pensao - (depentes * 189)));

						} else {
							if (salarioBrutoDouble > 1659.39) {
								inss = ((salarioBrutoDouble - (salarioBrutoDouble * 0.9))
										- (pensao - (depentes * 189)));
								base = salarioBrutoDouble - ((salarioBrutoDouble - (salarioBrutoDouble * 0.9))
										- (pensao - (depentes * 189)));

							} else {
								inss = ((salarioBrutoDouble - (salarioBrutoDouble * 0.8))
										- (pensao - (depentes * 189)));
								base = salarioBrutoDouble - ((salarioBrutoDouble - (salarioBrutoDouble * 0.8))
										- (pensao - (depentes * 189)));

							}
						}
					}
					if (inss > 4664) {
						ir = (inss * 0.27) - 869.36;

					} else {
						if (inss > 3751) {
							ir = (inss * 0.22) - 636.13;

						} else {
							if (inss > 2826) {
								ir = (inss * 0.15) - 354.80;

							} else {
								if (inss > 1903) {
									ir = (inss * 0.8) - 142.80;

								} else {
									ir = (inss * 0) - 0;

								}
							}
						}
					}

					System.out.println("\t**********************************\n");
					System.out.println("\tPagamento realizado com sucesso :" + dataPagamento + "\n");
					System.out.println("\tContra-Cheque:\n");
					salarioLiquidoDouble = salarioBrutoDouble - (base + ir + descontos);
					System.out.println("Funcionario - " + empresa);
					System.out.println("Nome: " + nomeAux);
					System.out.println("CPF: " + cpfAux);
					System.out.println("Cargo: " + cargo);
					System.out.println("Data de admissão: " + dataAd);
					System.out.printf("Acrescimos R$%.2f\n", acrescimos);
					System.out.printf("Desconto INSS: R$%.2f\n", base);
					System.out.printf("Desconto IR: R$%.2f\n", ir);
					System.out.printf("Salario bruto: R$%.2f\n", salarioBrutoDouble);
					System.out.printf("Salario Liquido: R$%.2f\n", salarioLiquidoDouble);
					System.out.println("\t**********************************\n");

				}

			}
		}
		br.close();
		fr.close();
		br1.close();
		fr1.close();

	}
}
