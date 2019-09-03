/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CalculosGerais {

    ArrayList<String> cargos = new ArrayList<String>();

    public int quant(String local) throws IOException {
        File file = new File("Dados\\" + local);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        int cont = 0;
        while (br.readLine() != null) {
            cont++;
        }
        fr.close();
        br.close();
        return cont;
    }

    public String estimativaSaida() throws FileNotFoundException, IOException {
        double soma = 0;
        File file = new File("Dados\\funcionarios");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String linha = br.readLine();
        while (linha != null) {
            String dados[] = linha.split(";");
            cargos.add(dados[9]);
            linha = br.readLine();
        }
        File file2 = new File("Dados\\cargos");
        FileReader fr2 = new FileReader(file2);
        BufferedReader br2 = new BufferedReader(fr2);
        String linha2 = br2.readLine();

        while (linha2 != null) {
            String dados[] = linha2.split(";");
            for (int i = 0; cargos.size() > i; i++) {

                if (cargos.get(i).equals(dados[2])) {

                    soma = soma + Double.parseDouble(dados[1]);

                }
            }
            linha2 = br2.readLine();
        }
        fr.close();
        br.close();
        fr2.close();
        br2.close();

        return "R$ " + soma;

    }

}
