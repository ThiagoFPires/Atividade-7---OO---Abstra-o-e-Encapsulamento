public class Hora {
    private int horas;
    private int minutos;
    private int segundos;

    public Hora(String horaMinutoSegundo) {
        String[] formato = horaMinutoSegundo.split(":");

        try {
            int horas = Integer.parseInt(formato[0]);
            int minutos = Integer.parseInt(formato[1]);
            int segundos = Integer.parseInt(formato[2]);

            //verifica se os valores sao validos
            if (horas >= 0 && horas < 24 && minutos >= 0 && minutos < 60 && segundos >= 0 && segundos < 60) {
                this.horas = horas;
                this.minutos = minutos;
                this.segundos = segundos;
            } else {
                this.horas = 0;
                this.minutos = 0;
                this.segundos = 0;
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            // Configurando como 00:00:00 se ocorrer uma exceção ao converter os valores
            this.horas = 0;
            this.minutos = 0;
            this.segundos = 0;
        }
    }

    //compara os horarios
    public int compara(Hora outraHora) {
        int segundosAtuais = this.horas * 3600 + this.minutos * 60 + this.segundos;
        int segundosOutraHora = outraHora.getHoras() * 3600 + outraHora.getMinutos() * 60 + outraHora.getSegundos();

        return segundosAtuais - segundosOutraHora;
    }

    //metodo para obter horas, minutos e segundos
    public int getHoras() {
        return this.horas;
    }

    public int getMinutos() {
        return this.minutos;
    }

    public int getSegundos() {
        return this.segundos;
    }

    //metodo para exibir hora completa no formato HH:MM:SS
    public String displayHora() {
        return String.format("%02d:%02d:%02d", this.horas, this.minutos, this.segundos);
    }
}
