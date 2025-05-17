import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    static ArrayList<Aluno> listaAlunos = new ArrayList<>();
    static ArrayList<Disciplina> listaDisciplinas = FabricaDeDisciplina.criarDisciplinas();

    public static void main(String[] args) {
        listaAlunos = Persistencia.carregarAlunos("alunos.dat");

        if (listaAlunos == null) {
            listaAlunos = new ArrayList<>();
        }

        Scanner scanner =new Scanner(System.in);
        int opcao;


        do {
            System.out.println("+___________________________+");
            System.out.println("|        SISTEMA FCTE       |");
            System.out.println("+___________________________+");
            System.out.println("| 1 - Modo Aluno            |");
            System.out.println("| 2 - Modo Disciplina/Turma |");
            System.out.println("| 3 - Modo Avaliação        |");
            System.out.println("| 0 - Sair                  |");
            System.out.println("+___________________________+");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("Entrando no Modo Aluno...");
                    ModoAluno modoAluno = new ModoAluno(listaAlunos, listaDisciplinas);
                    modoAluno.exibirMenu();
                    break;

                case 2:
                    System.out.println("Entrando no Modo Disciplina/Turma...");
                    break;

                case 3:
                    System.out.println("Entrando no Modo Avaliação/Frequência...");
                    break;

                case 0:
                    System.out.println("Saindo do sistema... Até a próxima jornada!");
                    break;

                default:
                    System.out.println("Opção inválida! Escolha uma opção válida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
    
}
