package controle;

import Vision.IComproVante;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

public class Pagamento {

    public static double inss, ir, salarioLiquido, base, salarioBruto;
    DataHora dataHora;
    public static String tempNome, tempCpf, tempAd, tempCargo;

    public void pagar(DefaultTableModel funcionario) throws IOException {
        for (int i = 0; i < funcionario.getRowCount(); i++) {
            if (funcionario.getValueAt(i, 14) == Boolean.TRUE) {
                String cargoTemp = (String) funcionario.getValueAt(i, 12);
                double pensao = 0;
                File arquivo = new File("Dados\\cargos");
                FileReader fr = new FileReader(arquivo);
                BufferedReader br = new BufferedReader(fr);
                String linha = br.readLine();
                String[] dados;
                while (linha != null) {
                    dados = linha.split(";");
                    if (dados[2].equalsIgnoreCase(cargoTemp)) {
                        tempNome = (String) (funcionario.getValueAt(i, 0));
                        tempCpf = (String) (funcionario.getValueAt(i, 2));
                        tempAd = (String) (funcionario.getValueAt(i, 9));
                        tempCargo = (dados[0]);
                        salarioBruto = Double.parseDouble(dados[1]);
                        calSalario(Double.parseDouble(dados[1]), Integer.parseInt((String) funcionario.getValueAt(i, 10)), pensao);
                        linha = br.readLine();
                    }

                }

            }
        }

    }

    void calSalario(double salarioBrutoDouble, int depentes, double pensao) throws IOException {
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
                    inss = ((salarioBrutoDouble - (salarioBrutoDouble * 0.8)) - (pensao - (depentes * 189)));
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
        salarioLiquido = salarioBrutoDouble - (base + ir + 0); // 0 = outros descontos
        new IComproVante().setVisible(true);
//        System.out.printf("Desconto INSS: R$%.2f\n", base);
//        System.out.printf("Desconto IR: R$%.2f\n", ir);
//        System.out.printf("Salario bruto: R$%.2f\n", salarioBrutoDouble);
//        System.out.printf("Salario Liquido: R$%.2f\n", salarioLiquido);

    }

    public double getInss() {
        return inss;
    }

    public void setInss(double inss) {
        this.inss = inss;
    }

    public double getIr() {
        return ir;
    }

    public void setIr(double ir) {
        this.ir = ir;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

}
