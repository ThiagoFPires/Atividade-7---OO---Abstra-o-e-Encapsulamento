public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    //formata a data
    public String formatarData() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }
}
