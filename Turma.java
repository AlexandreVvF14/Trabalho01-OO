import java.util.ArrayList;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Turma implements Serializable {
    private static final long serialVersionUID = 1L;
    private Disciplina disciplina;
    private String professor;
    private String semestre;
    private int formaAvaliacao;
    private boolean presencial;
    private String sala;
    private String horario;
    private int capacidadeMaxima;
    private ArrayList<Aluno> alunosMatriculados;
    private int numero;
    private Map<Aluno, Avaliacao> avaliacoes = new HashMap<>();
    
     public Turma(int numero, Disciplina disciplina, String professor, String semestre, int formaAvaliacao, boolean presencial, String sala, String horario, int capacidadeMaxima) {
        this.disciplina = disciplina;
        this.professor = professor;
        this.semestre = semestre;
        this.formaAvaliacao = formaAvaliacao;
        this.presencial = presencial;
        this.sala = presencial ? sala : null;
        this.horario = horario;
        this.capacidadeMaxima = capacidadeMaxima;
        this.numero = numero;
        this.alunosMatriculados = new ArrayList<>();

    }

    // Getters e setters (pelo menos para todos os campos principais)
    public String getHorario() {
        return horario;
    }

    public int getNumero() {
        return numero;
    }

    public String getProfessor() {
        return professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public boolean isRemota() {
        return !presencial;
    }

    public String getSala() {
        return sala;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public ArrayList<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public boolean temVaga() {
        return alunosMatriculados.size() < capacidadeMaxima;
    }

    public int getFormaAvaliacao() {
    return formaAvaliacao;
    }

    public void matricularAluno(Aluno aluno) {
        if (temVaga() && !alunosMatriculados.contains(aluno)) {
            alunosMatriculados.add(aluno);
            
        }
    }

    public void removerAluno(Aluno aluno) {
        alunosMatriculados.remove(aluno);
    }

    public void registrarAvaliacao(Aluno aluno, Avaliacao avaliacao) {
    if (alunosMatriculados.contains(aluno)) {
        avaliacoes.put(aluno, avaliacao);
    } else {
        System.out.println("Aluno não está matriculado nesta turma.");
    }
}

    public void exibirBoletimAluno(Aluno aluno) {
    Avaliacao a = avaliacoes.get(aluno);
    if (a == null) {
        System.out.println("Avaliação não registrada.");
        return;
    }
    
    System.out.println("Boletim do Aluno:");
    System.out.println("P1: " + a.getP1());
    System.out.println("P2: " + a.getP2());
    System.out.println("P3: " + a.getP3());
    System.out.println("L:  " + a.getL());
    System.out.println("S:  " + a.getS());
    System.out.println("Frequência: " + (a.getFrequencia() * 100) + "%");
    System.out.printf("Média Final: %.2f\n", a.calcularMedia());
    
    if (a.isAprovado()) {
        System.out.println("Situação: Aprovado ✅");
    } else if (a.reprovadoPorFalta()) {
        System.out.println("Situação: Reprovado por Falta ❌");
    } else {
        System.out.println("Situação: Reprovado por Nota ❌");
    }



}


    @Override
    public String toString() {
        return "Professor: " + professor +
               "\nSemestre: " + semestre +
               "\nAvaliação: " + formaAvaliacao +
               "\nModalidade: " + (presencial ? "Presencial" : "Remota") +
               (presencial ? "\nSala: " + sala : "") +
               "\nHorário: " + horario +
               "\nCapacidade: " + alunosMatriculados.size() + "/" + capacidadeMaxima;
    }
}

