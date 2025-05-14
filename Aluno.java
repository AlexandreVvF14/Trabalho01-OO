//Classe base: Aluno
public class Aluno {
    private String nome;
    private String matricula;
    private String curso;
    private boolean trancado;

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

    @Override
    public String toString() {
        return nome + "- Matrícula:" + matricula + "- Curso:" + curso + "- Trancado:" + (trancado ? "(Trancado)" : "Ativo");
    }
    
}



