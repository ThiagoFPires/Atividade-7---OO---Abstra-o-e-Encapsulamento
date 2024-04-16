import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int matricula;
        String nome;
        double notaProva1;
        double notaProva2;
        double notaTrabalho;
        //valida e solicita a matricula do aluno
        while (true) {
            while (true) {
                try {
                    matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe a matrícula do aluno:"));
                    if (matricula <= 0) {
                        throw new IllegalArgumentException("Matrícula inválida. Digite um número inteiro positivo.");
                    }
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número inteiro válido para a matrícula.");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }

            //valida e solicita que o campo seja preenchido.
            while (true) {
                nome = JOptionPane.showInputDialog("Informe o nome do aluno:");
                if (!nome.isEmpty()) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Nome do aluno não pode ser vazio.");
                }
            }

            //valida e solicita a nota da prova 1
            while (true) {
                try {
                    notaProva1 = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota da prova 1:"));
                    if (notaProva1 >= 0 && notaProva1 <= 3) {
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Nota da prova 1 deve estar entre 0 e 3.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido para a nota da prova 1.");
                }
            }

            //valida e solicita a nota da prova 1
            while (true) {
                try {
                    notaProva2 = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota da prova 2:"));
                    if (notaProva2 >= 0 && notaProva2 <= 3) {
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Nota da prova 2 deve estar entre 0 e 3.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido para a nota da prova 2.");
                }
            }

            //valida a nota do trabalho
            while (true) {
                try {
                    notaTrabalho = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota do trabalho:"));
                    if (notaTrabalho >= 0 && notaTrabalho <= 4) {
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Nota do trabalho deve estar entre 0 e 4.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido para a nota do trabalho.");
                }
            }

            break;
        }

        //cria o objeto aluno com as informações fornecidas pelo usuario
        Aluno aluno = new Aluno(matricula, nome, notaProva1, notaProva2, notaTrabalho);

        //constroi a mensagem no final do programa com as informações preenchidas
        String mensagem = "Matrícula: " + matricula + "\n" +
                "Nome: " + nome + "\n" +
                "Nota da Prova 1: " + notaProva1 + "\n" +
                "Nota da Prova 2: " + notaProva2 + "\n" +
                "Nota do Trabalho: " + notaTrabalho + "\n" +
                "Nota Total: " + aluno.notaTotal() + "\n" +
                "Aprovado? " + (aluno.isAprovado() ? "Sim" : "Não");

        JOptionPane.showMessageDialog(null, mensagem);
    }
}
