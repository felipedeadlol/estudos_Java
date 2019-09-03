package controle;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DataHora {

    public int hora, minuto, dia, mes, ano;
    public Calendar cal = new GregorianCalendar();
    public String dataFormatada;

    public String setHora() {

        hora = cal.get(Calendar.HOUR_OF_DAY);
        minuto = cal.get(Calendar.MINUTE);
        /// int segundo = cal.get(Calendar.SECOND);
        String ajudaHora = null;
        String ajudaMinuto = null;
        if (hora < 10) {
            ajudaHora = "0" + hora;
        } else {
            ajudaHora = "" + hora;
        }
        if (minuto < 10) {
            ajudaMinuto = "0" + minuto;
        } else {
            ajudaMinuto = "" + minuto;
        }
        return (ajudaHora + ":" + ajudaMinuto);
    }

    public String setData() {
        dia = cal.get(Calendar.DAY_OF_MONTH);
        mes = cal.get(Calendar.MONTH);
        ano = cal.get(Calendar.YEAR);

        return (dia + "/" + (mes + 1) + "/" + ano);

    }

    void dataFormatar() {
        dia = cal.get(Calendar.DAY_OF_MONTH);
        mes = cal.get(Calendar.MONTH);
        ano = cal.get(Calendar.YEAR);

        switch (mes) {
            case 1:
                dataFormatada = "Janeiro/" + ano;
                break;
            case 2:
                dataFormatada = "Fevereiro/" + ano;
                break;
            case 3:
                dataFormatada = "Março/" + ano;
                break;
            case 4:
                dataFormatada = "Abril/" + ano;
                break;
            case 5:
                dataFormatada = "Maio/" + ano;
                break;
            case 6:
                dataFormatada = "Junho/" + ano;
                break;
            case 7:
                dataFormatada = "Julho/" + ano;
                break;
            case 8:
                dataFormatada = "Agosto/" + ano;
                break;
            case 9:
                dataFormatada = "Setembro/" + ano;
                break;
            case 10:
                dataFormatada = "Outubro/" + ano;
                break;
            case 11:
                dataFormatada = "Novembro/" + ano;
                break;
            case 12:
                dataFormatada = "Dezembro/" + ano;
                break;
        }
    }

    /**
     * @return the dataFormatada
     */
    public String getDataFormatada() {
        return dataFormatada;
    }

}
