// Classe que representa um aluno especial, herda de Aluno
public class AlunoEspecial extends Aluno {

    public AlunoEspecial(String nome, String matricula, String curso) {
        super(nome, matricula, curso);
    }

    @Override
    public String toString() {
        return super.toString() + " [Aluno Especial]";
    }
}