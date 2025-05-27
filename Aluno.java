 //Classe base: Aluno
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String matricula;
    private String curso;
    private boolean trancado;
    private List<HistoricoEscolar> historico = new ArrayList<>();
    private ArrayList<Turma> turmasMatriculadas = new ArrayList<>();


    public Aluno(String nome, String matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.trancado = false; // Vou começar como ativo por padrão
        this.historico = new ArrayList<>();
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

    public void trancarSemestre() {
        for (Turma turma : new ArrayList<>(turmasMatriculadas)) {
            turma.removerAluno(this);
     }
    turmasMatriculadas.clear();
    trancado = true;
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
        for (Turma turma : turmasMatriculadas) {
        System.out.printf("- %s (%s) | Professor: %s | Sala: %s | Horário: %s\n",
        turma.getDisciplina().getNome(),
        turma.getDisciplina().getCodigo(),
        turma.getProfessor(),
        turma.getSala(),
        turma.getHorario());
}

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

    public void adicionarAoHistorico(HistoricoEscolar registro) {
    this.historico.add(registro);
    }

    public List<HistoricoEscolar> getHistorico() {
        return historico;
    }

    public void exibirHistorico() {
        if (historico.isEmpty()) {
            System.out.println("Nenhuma disciplina registrada no histórico.");
        } else {
            System.out.println("Histórico do Curso:");
            for (HistoricoEscolar h : historico) {
                System.out.println(h);
                System.out.println("-----------------------------");
            }
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




