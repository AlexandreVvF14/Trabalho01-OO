import java.util.ArrayList;
import java.io.Serializable;

public class Disciplina implements Serializable{
    private static final long serialVersionUID = 1L;
    private String nome;
    private String codigo;
    private int vagas;
    private int cargaHoraria;
    private int capacidadeMaxima;
    private ArrayList<Aluno> alunosMatriculados;
    private ArrayList<Disciplina> preRequisitos = new ArrayList<>();

    public Disciplina(String nome, String codigo, int cargaHoraria, int capacidadeMaxima) {
        this.nome = nome;
        this.codigo = codigo;
        this.vagas = capacidadeMaxima;
        this.cargaHoraria = cargaHoraria;
        this.capacidadeMaxima = capacidadeMaxima;
        this.alunosMatriculados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void adicionarPreRequisito(Disciplina disciplina) {
        preRequisitos.add(disciplina);
    }

    public ArrayList<Disciplina> getPreRequisitos() {
        return preRequisitos;
    }

    public ArrayList<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public void matricularAluno(Aluno aluno) {
        if (!alunosMatriculados.contains(aluno)) {
            if (vagas > 0) {
                alunosMatriculados.add(aluno);
                vagas--;
                System.out.println("Aluno matriculado com sucesso!");
            } else {
                System.out.println("Não há vagas disponíveis nesta disciplina.");
            }
        } else {
            System.out.println("Aluno já matriculado nesta disciplina.");
        }
    }

    public boolean temVaga(){
        return alunosMatriculados.size() < capacidadeMaxima;
    }

    public int getVagasDisponiveis() {
        return vagas;
    }

    public void incrementarVaga() {
        if (vagas < capacidadeMaxima) {
            vagas++;
        }
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    @Override
    public String toString() {
        return nome + "\n" +
        "Código: " + codigo + "\n" +
        "Carga Horária: " + cargaHoraria + "\n" +
        "Alunos Matriculados: " + alunosMatriculados.size() + "\n" +
        "Vagas Disponíveis: " + vagas + "\n" ;
    }

    @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return codigo.equals(that.codigo);
}

    @Override
    public int hashCode() {
        return codigo.hashCode();
}

}