import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro:"));

        NumeroInteiro numeroInteiro = new NumeroInteiro(numero);

        String menu = "Escolha uma opção:\n" +
                "1. Soma\n" +
                "2. Subtração\n" +
                "3. Próximo número primo\n" +
                "4. Verificar se é primo\n" +
                "5. Sair";

        //cria o loop para as opçoes do usuario
        while (true) {
            // Exibe o menu e solicita a escolha do usuário
            int escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));

            //faz com que realize as ações dependendo da escolha
            switch (escolha) {
                case 1:
                    int valorSoma = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor para soma:"));
                    numeroInteiro.soma(valorSoma);
                    JOptionPane.showMessageDialog(null, "Resultado da soma: " + numeroInteiro.getNumero());
                    break;
                case 2:
                    int valorSubtracao = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor para subtração:"));
                    numeroInteiro.subtrai(valorSubtracao);
                    JOptionPane.showMessageDialog(null, "Resultado da subtração: " + numeroInteiro.getNumero());
                    break;
                case 3:
                    int proximoPrimo = numeroInteiro.getNextPrimo();
                    JOptionPane.showMessageDialog(null, "O próximo número primo é: " + proximoPrimo);
                    break;
                case 4:
                    String mensagemPrimo = numeroInteiro.isPrimo() ? "O número é primo." : "O número não é primo.";
                    JOptionPane.showMessageDialog(null, mensagemPrimo);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saindo do programa...");
                    return; // Termina o programa
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        }
    }
}
