import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int opcao;

        do {
            System.out.println("+___________________________+");
            System.out.println("|      SISTEMA FCTE         |");
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
                    modoAluno();
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
       
    public static void modoAluno() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("+____________________________________________+");
            System.out.println("|                  MODO ALUNO                |");
            System.out.println("+____________________________________________+");
            System.out.println("| 1 - Cadastrar Aluno                        |");
            System.out.println("| 2 - Listar Alunos                          |");
            System.out.println("| 3 - Matricular Aluno em Disciplina         |");
            System.out.println("| 4 - Trancar disciplina ou semestre         |");
            System.out.println("| 5 - Salvar dados dos alunos                |");
            System.out.println("| 6 - Carregar dados dos alunos              |");
            System.out.println("| 0 - Voltar                                 |");
            System.out.println("+____________________________________________+");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.println("Cadastro de aluno iniciado...");
                    break;
        
                case 2:
                    System.out.println("Lista de alunos:");
                    break;

                case 3:
                    System.out.println("Matrícula em disciplina...");
                    break;

                case 4:
                    System.out.println("Trancamento solicitado...");
                    break;

                case 5:
                    System.out.println("Salvando dados...");
                    break;

                case 6:
                    System.out.println("Carregando dados...");
                    break;

                case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}