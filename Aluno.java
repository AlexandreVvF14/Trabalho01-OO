 //Classe base: Aluno
import java.io.Serializable;
import java.util.ArrayList;

public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String matricula;
    private String curso;
    private boolean trancado;
    private ArrayList<Turma> turmasMatriculadas = new ArrayList<>();


    public Aluno(String nome, String matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.trancado = false; // Vou começar como ativo por padrão
        this.turmasMatriculadas = new ArrayList<>();
    }

    //Ver e mudar os dados
    public String getNome() {
        return nome;
    }

    public boolean jaEstaNaTurma(Turma turma) {
        return turmasMatriculadas.contains(turma);
            }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
      
    public boolean isTrancado() {
        return trancado;
    }

    public void trancar() {
        trancado = true;
    }

    public void destrancar() {
        trancado = false;
    }

    public void matricularNaTurma(Turma turma) {
        if (!turmasMatriculadas.contains(turma)) {
            turmasMatriculadas.add(turma);
        }
    }

    public ArrayList<Disciplina> getDisciplinasMatriculadas() {
    ArrayList<Disciplina> disciplinas = new ArrayList<>();
    for (Turma t : turmasMatriculadas) {
        if (!disciplinas.contains(t.getDisciplina())) {
            disciplinas.add(t.getDisciplina());
        }
    }
        return disciplinas;
    }

    public ArrayList<Turma> getTurmasMatriculadas() {
        return turmasMatriculadas;
    }

    public String getCurso() {
        return curso;
    }

    public String getStatusCurso() {
        return trancado ? "Trancado" : "Ativo";
    }

    //Temporário
    private ArrayList<String> disciplinasAprovadas = new ArrayList<>();

    public ArrayList<String> getDisciplinasAprovadas() {
        return disciplinasAprovadas;
    }

    public void adicionarDisciplinaAprovada(String codigoDisciplina) {
        if (!disciplinasAprovadas.contains(codigoDisciplina)) {
            disciplinasAprovadas.add(codigoDisciplina);
        }
    }






    @Override
    public String toString() {
        return nome + "\n" +
           "Matrícula: " + matricula + "\n" +
           "Curso: " + curso + "\n" +
           "Status: " + (trancado ? "Trancado" : "Ativo") + "\n";
          
    }
}




