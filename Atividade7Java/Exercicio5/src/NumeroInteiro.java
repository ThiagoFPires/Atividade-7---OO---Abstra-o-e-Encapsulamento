public class NumeroInteiro {
    private int numero;

    public NumeroInteiro() {
        this.numero = 0;
    }

    public NumeroInteiro(int numero) {
        this.numero = numero;
    }

    //soma
    public void soma(int valor) {
        this.numero += valor;
    }

    //subtração
    public void subtrai(int valor) {
        this.numero -= valor;
    }

    //veirifa se é primo
    public boolean isPrimo() {
        if (this.numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(this.numero); i++) {
            if (this.numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    //obtem o numero primo mais proximo
    public int getNextPrimo() {
        int next = this.numero + 1;
        while (true) {
            if (isPrimo(next)) {
                return next;
            }
            next++;
        }
    }

    //verifica se o numero é primo
    private static boolean isPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    //obtem o numero atual
    public int getNumero() {
        return this.numero;
    }
}
