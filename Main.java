import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Aluno> listaAlunos = new ArrayList<>();
    static ArrayList<Disciplina> listaDisciplinas;

    public static void main(String[] args) {
        // Carregar disciplinas
        listaDisciplinas = Persistencia.carregarDisciplinas("disciplinas.dat");
        if (listaDisciplinas == null) {
            listaDisciplinas = FabricaDeDisciplina.criarDisciplinas();
        }


        // Carregar alunos
        listaAlunos = Persistencia.carregarAlunos("alunos.dat");
        if (listaAlunos == null) {
            listaAlunos = new ArrayList<>();
        }
       
        Scanner scanner =new Scanner(System.in);
        int opcao = -1;


        do {
            System.out.println("+____________________________+");
            System.out.println("|        SISTEMA FCTE        |");
            System.out.println("+____________________________+");
            System.out.println("| 1 - Modo Aluno             |");
            System.out.println("| 2 - Modo Disciplina/Turma  |");
            System.out.println("| 3 - Modo Avaliação         |");
            System.out.println("| 0 - Sair                   |");
            System.out.println("+____________________________+");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine()); 
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Entrando no Modo Aluno...");
                    ModoAluno modoAluno = new ModoAluno(listaAlunos, listaDisciplinas);
                    modoAluno.exibirMenu();
                    break;

                case 2:
                    System.out.println("Entrando no Modo Disciplina/Turma...");
                    ModoDisciplinaTurma modoDisciplinaTurma = new ModoDisciplinaTurma(listaDisciplinas, scanner);
                    modoDisciplinaTurma.exibirMenu();
                    break;

                case 3:
                    GerenciadorDeTurmas gerenciadorDeTurmas = new GerenciadorDeTurmas();
                    ModoAvaliacao modoAvaliacao = new ModoAvaliacao(scanner, gerenciadorDeTurmas);
                    modoAvaliacao.exibirMenu();
                    break;

                case 0:
                    System.out.println("Saindo do sistema... Até a próxima jornada!");
                    Persistencia.salvarAlunos(listaAlunos, "alunos.dat");
                    Persistencia.salvarDisciplinas(listaDisciplinas, "disciplinas.dat");
                    break;

                default:
                    System.out.println("Opção inválida! Escolha uma opção válida.");
            }
        
        } while (opcao != 0); {
                opcao = scanner.nextInt();
        }

        scanner.close();
    }
    }

