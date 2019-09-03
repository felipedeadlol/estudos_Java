package controle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class EscreverArquivo {

   ArrayList<String> dados = new ArrayList<>();

    public void salvar(DefaultTableModel tabela, String local) throws IOException {
        String linha = "";
        for (int i = 0; i < tabela.getRowCount(); i++) {
            for (int e = 0; e < tabela.getColumnCount(); e++) {
                linha = linha + (tabela.getValueAt(i, e).toString()) + ";";
            }
            dados.add(linha);
            linha = "";
        }
        File arquivo = new File("Dados\\" + local);
        FileWriter fw = new FileWriter(arquivo, false);
        BufferedWriter bw = new BufferedWriter(fw);
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
        for (int i = 0; i < dados.size(); i++) {
            bw.write(dados.get(i));
            bw.newLine();
        }
        bw.close();
        fw.close();
        dados.clear();

    }
    
    
    

}
