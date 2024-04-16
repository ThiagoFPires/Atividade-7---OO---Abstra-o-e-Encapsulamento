import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        //solita que o usuario insira o primeiro horario
        String inputHorario1 = solicitarHorario("Insira o primeiro horário no formato HH:MM:SS");
        Hora hora1 = new Hora(inputHorario1);
        // solicita que o usuario insira o segundo horario
        String inputHorario2 = solicitarHorario("Insira o segundo horário no formato HH:MM:SS");
        Hora hora2 = new Hora(inputHorario2);
        //faz o calculo da diferença entre os horarios
        int diferencaSegundos = hora1.compara(hora2);
        JOptionPane.showMessageDialog(null, "Diferença de segundos: " + diferencaSegundos);
    }

    //solicita o usuario que insira a hora utilizando as devidas validações
    private static String solicitarHorario(String mensagem) {
        String inputHorario;
        String[] formato;
        //loop para garantir que seja inserido um horario valido
        do {
            inputHorario = JOptionPane.showInputDialog(mensagem);
            if (inputHorario == null || inputHorario.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, insira um horário.");
                continue;
            }
            //faz a divisao para o formato HH:MM:SS
            formato = inputHorario.split(":");
            if (formato.length != 3) {
                //varifica se está no formato correto
                JOptionPane.showMessageDialog(null, "Por favor, insira o horário no formato correto (HH:MM:SS).");
                continue;
            }

            try {
                int horas = Integer.parseInt(formato[0]);
                int minutos = Integer.parseInt(formato[1]);
                int segundos = Integer.parseInt(formato[2]);

                //verifica se os valores inseridos estão dentro dos limites colocados
                if (horas < 0 || horas > 23 || minutos < 0 || minutos > 59 || segundos < 0 || segundos > 59) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos para horas, minutos e segundos.");
                    continue;
                }
            } catch (NumberFormatException e) {
                //mensagem de alerta disparada caso não seja inserido um número inteiro
                JOptionPane.showMessageDialog(null, "Por favor, insira valores numéricos para horas, minutos e segundos.");
                continue;
            }

            break;
        } while (true);

        return inputHorario;
    }
}
