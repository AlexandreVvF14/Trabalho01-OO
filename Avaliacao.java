public class Avaliacao {
    private double p1, p2, p3, l, s;
    private double frequencia; // valor entre 0.0 e 1.0
    private int formaAvaliacao; // 1 ou 2

    public Avaliacao(double p1, double p2, double p3, double l, double s, double frequencia, int forma) {
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
    this.l = l;
    this.s = s;
    this.frequencia = frequencia;
    this.formaAvaliacao = forma;
}



    public void setP1(double p1) { this.p1 = p1; }
    public void setP2(double p2) { this.p2 = p2; }
    public void setP3(double p3) { this.p3 = p3; }
    public void setL(double l) { this.l = l; }
    public void setS(double s) { this.s = s; }
    public void setFrequencia(double frequencia) { this.frequencia = frequencia; }

    public double getP1() { return p1; }
    public double getP2() { return p2; }
    public double getP3() { return p3; }
    public double getL()  { return l; }
    public double getS()  { return s; } 
    public double getFrequencia() { return frequencia; }



    public double calcularMedia() {
        if (formaAvaliacao == 1) {
            return (p1 + p2 + p3 + l + s) / 5.0;
        } else { // forma 2
            return (p1 + p2 * 2 + p3 * 3 + l + s) / 8.0;
        }
    }


    public boolean isAprovado() {
        return calcularMedia() >= 5.0 && frequencia >= 0.75;
    }

    public boolean reprovadoPorNota() {
        return calcularMedia() < 5.0;
    }

    public boolean reprovadoPorFalta() {
        return frequencia < 0.75;
    }
}
