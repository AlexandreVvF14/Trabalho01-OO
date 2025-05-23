import java.util.ArrayList;

public class Turma {
    private Disciplina disciplina;
    private String professor;
    private String semestre;
    private String formaAvaliacao;
    private boolean presencial;
    private String sala;
    private String horario;
    private int capacidadeMaxima;
    private ArrayList<Aluno> alunosMatriculados;
    
     public Turma(Disciplina disciplina, String professor, String semestre, String formaAvaliacao, boolean presencial, String sala, String horario, int capacidadeMaxima) {
        this.disciplina = disciplina;
        this.professor = professor;
        this.semestre = semestre;
        this.formaAvaliacao = formaAvaliacao;
        this.presencial = presencial;
        this.sala = presencial ? sala : null;
        this.horario = horario;
        this.capacidadeMaxima = capacidadeMaxima;
        this.alunosMatriculados = new ArrayList<>();
    }

    // Getters e setters (pelo menos para todos os campos principais)
    public String getHorario() {
        return horario;
    }

    public Disciplina getDisciplina() {
        return disciplina;
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

    public void matricularAluno(Aluno aluno) {
        if (temVaga() && !alunosMatriculados.contains(aluno)) {
            alunosMatriculados.add(aluno);
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

