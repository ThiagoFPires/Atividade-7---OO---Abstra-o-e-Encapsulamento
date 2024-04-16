class Aluno {
    private int matricula;
    private String nome;
    private double notaProva1;
    private double notaProva2;
    private double notaTrabalho;
    private static final double MAX_NOTA_PROVA = 3.0;
    private static final double MAX_NOTA_TRABALHO = 4.0;

    public Aluno(int matricula, String nome, double notaProva1, double notaProva2, double notaTrabalho) {
        this.matricula = matricula;
        this.nome = nome;
        this.notaProva1 = Math.min(notaProva1, MAX_NOTA_PROVA);
        this.notaProva2 = Math.min(notaProva2, MAX_NOTA_PROVA);
        this.notaTrabalho = Math.min(notaTrabalho, MAX_NOTA_TRABALHO);
    }

    public double notaTotal() {
        return notaProva1  + notaProva2 + notaTrabalho;
    }

    public boolean isAprovado() {
        double percentual = (notaTotal() / 10) * 100;
        return percentual >= 60;
    }
}
