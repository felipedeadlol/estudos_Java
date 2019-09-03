package br.edu.ifba.sistema;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {

		Scanner num = new Scanner(System.in);
		boolean menu = true, menu2 = true, menu3 = true;
		int op;
		Funcionario funcionario = new Funcionario();
		Cargo cargos = new Cargo();
		Empresa empresa = new Empresa();
		Administrativa administrativa = new Administrativa();
		Pagamento pagamento = new Pagamento();
		administrativa.setCargos(cargos);
		administrativa.setEmpresa(empresa);
		administrativa.setFuncionario(funcionario);
		administrativa.setPagamento(pagamento);

		while (menu) {

			System.out.println(
					"Digite 1- Funcionario || 2- Cargo || 3-Empresa || 4-Menu de Primeiro Uso || 5-Limpar Todos os Dados || 6-Sair");
			op = num.nextInt();
			switch (op) {
			case 1:
				while (menu2) {
					System.out.println("Menu do Funcionario-----");
					System.out.println(
							"Digite 1- Registrar || 2- Listar || 3- Deletar || 4- Editar || 5- Pagar Funcionario || 6- Dar Ferias || 7- Terminar Ferias || 7- Voltar");
					op = num.nextInt();
					switch (op) {
					case 1:
						administrativa.funcionario.registrarFuncionario();
						break;
					case 2:
						administrativa.funcionario.verFuncionario();
						break;
					case 3:
						administrativa.funcionario.deletarFuncionario();
						break;
					case 4:
						administrativa.funcionario.editarFuncionario();
						break;
					case 5:
						administrativa.funcionario.verFuncionario();
						administrativa.pagamento.pagarFuncionario();
						break;
					case 6:
						administrativa.funcionario.verFuncionario();
						administrativa.darFerias();
						;
						break;
					case 7:
						administrativa.funcionario.verFuncionario();
						administrativa.tirarFerias();
						break;
					default:
						menu2 = false;
					}
				}
				break;
			case 2:
				while (menu3) {
					System.out.println("Menu do Cargo-----");
					System.out.println("Digite 1- Registrar || 2- Listar || 3-Deletar || 4-Editar || 5-Voltar");
					op = num.nextInt();
					switch (op) {
					case 1:
						administrativa.cargos.registrarCargo();
						break;
					case 2:
						administrativa.cargos.verCargo();
						break;
					case 3:
						administrativa.cargos.verCargo();
						administrativa.cargos.deletarCargo();
						break;
					case 4:
						administrativa.cargos.verCargo();
						administrativa.cargos.editarCargo();
						break;
					default:
						menu3 = false;

					}
				}

				break;
			case 3:

				System.out.println("Menu da empresa-----");
				System.out.println("Digite 1- Registrar || 2- Visualizar || 3- Editar || 4- Voltar");
				op = new Scanner(System.in).nextInt();
				switch (op) {
				case 1:
					administrativa.empresa.registrarEmpresa();
					break;
				case 2:
					administrativa.empresa.verEmpresa();
					break;
				case 3:
					administrativa.empresa.editarEmpresa();
					break;
				default:
				}

				break;

			case 4:
				java.awt.Desktop.getDesktop().open(new File("Nota.txt"));
				System.out.println("Registrando empresa");
				administrativa.empresa.registrarEmpresa();
				System.out.println("Registrando cargos");
				administrativa.cargos.registrarCargo();
				System.out.println("Registrando funcionarios");
				administrativa.funcionario.registrarFuncionario();
				break;
			case 5:
				administrativa.clean();
				System.out.println("Sistema reiniciado");
				break;
			default:
				menu = false;
				break;
			}

		}
		num.close();

	}

}
