 //Classe base: Aluno

import java.util.ArrayList;

public class Aluno {
    private String nome;
    private String matricula;
    private String curso;
    private boolean trancado;
    private ArrayList<Disciplina> disciplinasMatriculadas = new ArrayList<>();


    public Aluno(String nome, String matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.trancado = false; // Vou começar como ativo por padrão
    }

    //Ver e mudar os dados
    public String getNome() {
        return nome;
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

    public void matricularEmDisciplina(Disciplina disciplina) {
    disciplinasMatriculadas.add(disciplina);
    }

    public ArrayList<Disciplina> getDisciplinasMatriculadas() {
        return disciplinasMatriculadas;
    }


    @Override
    public String toString() {
        return nome + "\n" +
           "Matrícula: " + matricula + "\n" +
           "Curso: " + curso + "\n" +
           "Status: " + (trancado ? "Trancado" : "Ativo") + "\n";
          
    }
}




