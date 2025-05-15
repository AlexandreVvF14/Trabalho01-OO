import java.util.ArrayList;

public class Disciplina {
    private String nome;
    private String codigo;
    private int cargaHoraria;
    private ArrayList<Aluno> alunosMatriculados;

    public Disciplina(String nome, String codigo, int cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.alunosMatriculados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public ArrayList<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public void matricularAluno(Aluno aluno) {
        if (!alunosMatriculados.contains(aluno)) {
            alunosMatriculados.add(aluno);
            System.out.println("Aluno matriculado com sucesso!");
        } else {
            System.out.println("Aluno já matriculado nesta disciplina.");
        }
    }

    @Override
    public String toString() {
        return nome + "\n" +
        "Código: " + codigo + "\n" +
        "Carga Horária: " + cargaHoraria + "\n" +
        "Alunos Matriculados: " + alunosMatriculados.size() + "\n";
    }
}