import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        //faz a entrada da primeira data no formato DD/MM/AAAA
        String input1 = JOptionPane.showInputDialog("Informe a primeira data no formato DD/MM/AAAA:");
        if (!validarFormatoData(input1)) {
            JOptionPane.showMessageDialog(null, "Formato de data inválido ou data inexistente. O formato correto é DD/MM/AAAA.");
            return;
        }

        String[] partes1 = input1.split("/");
        int dia1 = Integer.parseInt(partes1[0]);
        int mes1 = Integer.parseInt(partes1[1]);
        int ano1 = Integer.parseInt(partes1[2]);

        Data data1 = new Data(dia1, mes1, ano1);

        //faz a entrada da segunda data no formato DD/MM/AAAA
        String input2 = JOptionPane.showInputDialog("Informe a segunda data no formato DD/MM/AAAA:");
        if (!validarFormatoData(input2)) {
            JOptionPane.showMessageDialog(null, "Formato de data inválido ou data inexistente. O formato correto é DD/MM/AAAA.");
            return;
        }

        String[] partes2 = input2.split("/");
        int dia2 = Integer.parseInt(partes2[0]);
        int mes2 = Integer.parseInt(partes2[1]);
        int ano2 = Integer.parseInt(partes2[2]);

        Data data2 = new Data(dia2, mes2, ano2);

        //compara as datas
        int resultado = data1.compararDatas(data2);

        String mensagem = "";
        if (resultado == 0) {
            mensagem = "0: as datas são iguais.";
        } else if (resultado == 1) {
            mensagem = "1: primeira data é maior que a segunda data.";
        } else {
            mensagem = "-1: segunda data é maior que a primeira data.";
        }

        JOptionPane.showMessageDialog(null, mensagem);
    }

    //valida o formato e a existencia da data inserida
    private static boolean validarFormatoData(String data) {
        String[] partes = data.split("/");
        if (partes.length != 3) {
            return false;
        }
        try {
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int ano = Integer.parseInt(partes[2]);
            if (dia < 1 || mes < 1 || mes > 12 || ano < 1) {
                return false;
            }
            int diasNoMes = numeroDiasMes(mes, ano);
            return dia <= diasNoMes;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //método para fazer as verificações dos meses
    private static int numeroDiasMes(int mes, int ano) {
        if (mes == 2) {
            if (ano % 400 == 0 || (ano % 4 == 0 && ano % 100 != 0)) {
                return 29;
            } else {
                return 28;
            }
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            return 30;
        } else {
            return 31;
        }
    }
}
