import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int numeroVoo = Integer.parseInt(JOptionPane.showInputDialog("Insira o número do voo:"));

        Data dataVoo = solicitarData();

        Voo voo = new Voo(numeroVoo, dataVoo);

        while (true) {
            String escolha = JOptionPane.showInputDialog(
                    "Escolha uma opção:\n" +
                            "1. Próxima cadeira livre\n" +
                            "2. Verificar ocupação de cadeira\n" +
                            "3. Ocupar cadeira\n" +
                            "4. Número de cadeiras vagas\n" +
                            "5. Número do voo\n" +
                            "6. Data do voo\n" +
                            "0. Sair");

            //se cancelar ou sair cancela o programa
            if (escolha == null || escolha.equals("0")) {
                JOptionPane.showMessageDialog(null, "Encerrando o programa.");
                break;
            }

            //faz com que execute a ação dependendo da escolha do usuario
            switch (escolha) {
                case "1":
                    JOptionPane.showMessageDialog(null, "Próxima cadeira livre: " + voo.proximoLivre());
                    break;
                case "2":
                    int numeroCadeira = Integer.parseInt(JOptionPane.showInputDialog("Insira o número da cadeira:"));
                    if (voo.verifica(numeroCadeira)) {
                        JOptionPane.showMessageDialog(null, "Cadeira ocupada.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cadeira livre.");
                    }
                    break;
                case "3":
                    int cadeiraOcupar = Integer.parseInt(JOptionPane.showInputDialog("Insira o número da cadeira a ocupar:"));
                    if (voo.ocupa(cadeiraOcupar)) {
                        JOptionPane.showMessageDialog(null, "Cadeira ocupada com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cadeira já está ocupada.");
                    }
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "Número de cadeiras vagas: " + voo.vagas());
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "Número do voo: " + voo.getVoo());
                    break;
                case "6":
                    // Mostra a data do voo ao usuário
                    JOptionPane.showMessageDialog(null, "Data do voo: " + voo.getData().formatarData());
                    break;
                default:
                    // Caso o usuário escolha uma opção inválida
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        }
    }

    // Método para solicitar a data do voo ao usuário
    private static Data solicitarData() {
        while (true) {
            // Solicita a data do voo ao usuário
            String input = JOptionPane.showInputDialog("Insira a data do voo (DD/MM/AAAA):");

            // Se o usuário cancelar, encerra o programa
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Encerrando o programa.");
                System.exit(0);
            }

            // Divide a entrada do usuário em partes (dia, mês, ano)
            String[] partes = input.split("/");

            // Verifica se a entrada possui três partes (dia, mês, ano)
            if (partes.length != 3) {
                JOptionPane.showMessageDialog(null, "Por favor, insira a data no formato correto (DD/MM/AAAA).");
                continue;
            }

            try {
                // Tenta converter as partes em números inteiros (dia, mês, ano)
                int dia = Integer.parseInt(partes[0]);
                int mes = Integer.parseInt(partes[1]);
                int ano = Integer.parseInt(partes[2]);

                // Retorna um novo objeto Data com os valores fornecidos
                return new Data(dia, mes, ano);
            } catch (NumberFormatException e) {
                // Caso ocorra erro na conversão, solicita ao usuário para inserir valores numéricos
                JOptionPane.showMessageDialog(null, "Por favor, insira valores numéricos para dia, mês e ano.");
            }
        }
    }
}
