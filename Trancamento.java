import java.util.ArrayList;
import java.util.Scanner;

public class Trancamento {

    public static void menuTrancamento(ArrayList<Aluno> listaAlunos, ArrayList<Disciplina> listaDisciplinas, Scanner scanner) {

        System.out.println("Digite a matrícula do aluno: ");
            String matricula = scanner.nextLine().trim();  

        Aluno alunoSelecionado = null;
        for (Aluno aluno : listaAlunos) {
            if (aluno.getMatricula().equals(matricula)) {
                alunoSelecionado = aluno;
                break;
            }
        }

        if (alunoSelecionado == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        Aluno aluno = alunoSelecionado;


        System.out.println("+____________________________+");
        System.out.println("|       TRANCAMENTO          |");
        System.out.println("+____________________________+");
        System.out.println("| 1 - Trancar Semestre       |");
        System.out.println("| 2 - Trancar Disciplina     |");
        System.out.println("| 3 - Destrancar Semestre    |");
        System.out.println("| 0 - Voltar                 |");
        System.out.println("+____________________________+");
        System.out.print("Escolha uma opção: ");

        String escolha = scanner.nextLine();

        switch (escolha) {

            case "1":
                if (aluno.isTrancado()) {
                    System.out.println("Aluno já está com o semestre trancado.");
                } else {
                    aluno.trancar();

                    for (Disciplina d : aluno.getDisciplinasMatriculadas()) {
                        d.getAlunosMatriculados().remove(aluno);

                }
                aluno.getDisciplinasMatriculadas().clear();

                System.out.println("Semestre trancado com sucesso!");
                }
                break;


            case "2":
                trancarDisciplina(aluno, scanner);
                break;

            case "3":
                aluno.destrancar();
                System.out.println("Semestre destrancado com sucesso!");
                break;

            case "0":
                System.out.println("Voltando ao Modo Aluno...");
                break;

            default:
                System.out.println("Opção inválida!");
        }

    }

    private static void trancarDisciplina(Aluno aluno, Scanner scanner) {
        ArrayList<Disciplina> disciplinas = aluno.getDisciplinasMatriculadas();

        if (disciplinas.isEmpty()) {
            System.out.println("Aluno não está matriculado em nenhuma disciplina.");
            return;
        }

        System.out.println("Disciplinas matriculadas: ");
        for (Disciplina d : disciplinas) {
            System.out.println("- " + d.getNome() + " (" + d.getCodigo() + ")");
        }

        System.out.print("Digite o código da disciplina que deseja trancar: ");
        String codigo = scanner.nextLine();

        Disciplina disciplinaParaRemover = null;
        for (Disciplina d : disciplinas) {
            if (d.getCodigo().equalsIgnoreCase(codigo)) {
                disciplinaParaRemover = d;
                break;
            }
        }

        if (disciplinaParaRemover != null) {
            disciplinas.remove(disciplinaParaRemover);
            disciplinaParaRemover.getAlunosMatriculados().remove(aluno);
            System.out.println("Disciplina trancada com sucesso.");
        } else {
            System.out.println("Disciplina não encontrada na matrícula do aluno.");
        }
            
    }
}