public class Data {
    private int dia;
    private int mes;
    private int ano;

    //construtor
    public Data(int dia, int mes, int ano){
        //verifica se a data é correta
        if (dataCorreta(dia, mes, ano)){
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            //se a data não for correta, configura a data como 01/01/0001
            this.dia = 1;
            this.mes = 1;
            this.ano = 1;
        }
    }

    //metodo privado para verificar se a data é correta
    private boolean dataCorreta(int dia, int mes, int ano){
        if (mes >= 1 && mes <= 12 && ano >= 1){
            int dias = numeroDiasMes(mes, ano);
            return dia >= 1 && dia <= dias;
        } else {
            return false;
        }
    }

    //metodo privado para obter o numero de dias em um mês específico de um ano específico
    private int numeroDiasMes(int mes, int ano){
        if (mes == 2){
            if (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0)){
                return 29;
            } else {
                return 28;
            }
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11){
            return 30;
        } else {
            return 31;
        }
    }

    //metodo para comparar duas datas
    public int compararDatas(Data Data2){
        if (this.ano == Data2.ano) {
            if (this.mes == Data2.mes) {
                if (this.dia == Data2.dia) {
                    return 0;
                } else if (this.dia > Data2.dia) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (this.mes > Data2.mes) {
                return 1;
            } else {
                return -1;
            }
        } else if (this.ano > Data2.ano){
            return 1;
        }  else {
            return -1;
        }
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }
}
