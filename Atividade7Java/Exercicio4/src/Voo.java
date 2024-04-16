public class Voo {
    private int numeroVoo;
    private Data dataVoo;
    private boolean[] cadeiras;

    public Voo(int numeroVoo, Data dataVoo) {
        this.numeroVoo = numeroVoo;
        this.dataVoo = dataVoo;
        this.cadeiras = new boolean[100];
    }

    //encontra o número da próxima cadeira livre
    public int proximoLivre() {
        for (int i = 0; i < cadeiras.length; i++) {
            if (!cadeiras[i]) {
                return i + 1;
            }
        }
        return -1;
    }

    //verifica se uma cadeira está ocupada
    public boolean verifica(int numeroCadeira) {
        return cadeiras[numeroCadeira - 1];
    }

    //faz com que ocupe uma cadeira
    public boolean ocupa(int numeroCadeira) {
        if (!cadeiras[numeroCadeira - 1]) {
            cadeiras[numeroCadeira - 1] = true;
            return true;
        }
        return false;
    }

    //conta o número de cadeiras vagas
    public int vagas() {
        int count = 0;
        for (boolean cadeira : cadeiras) {
            if (!cadeira) {
                count++;
            }
        }
        return count;
    }

    //faz com que obtenha o numero do voo
    public int getVoo() {
        return numeroVoo;
    }

    //faz com que obtenha a data do voo
    public Data getData() {
        return dataVoo;
    }
}
