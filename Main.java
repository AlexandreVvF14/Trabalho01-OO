import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;

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
            System.out.println("|                 MODO ALUNO                 |");
            System.out.println("+____________________________________________+");
            System.out.println("| 1 - Cadastrar Aluno                        |");
            System.out.println("| 2 - Listar Alunos                          |");
            System.out.println("| 3 - Matricular Aluno em Disciplina         |");
            System.out.println("| 4 - Trancar disciplina ou semestre         |");
            System.out.println("| 5 - Salvar dados dos alunos                |");
            System.out.println("| 0 - Voltar                                 |");
            System.out.println("+____________________________________________+");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.println("Cadastro de aluno iniciado...");
                    System.out.print("Digite o nome completo do aluno: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite a matrícula do aluno: ");
                    String matricula = scanner.nextLine();

                    boolean alunoExiste = false;
                    for (Aluno a : listaAlunos) {
                        if (a.getMatricula().equals(matricula)) { 
                            alunoExiste = true;
                            break;
                        }
                    }

                    if (alunoExiste) {
                        System.out.println("Aluno já cadastrado!");
                    } else {
                        System.out.println("Digite o curso do aluno: ");
                        String curso = scanner.nextLine();
                        Aluno novoAluno = new Aluno(nome, matricula, curso);
                        listaAlunos.add(novoAluno);
                        System.out.println("Aluno cadastrado com sucesso!");
                    }
                    break;
        
                case 2:
                    System.out.println("Lista de alunos:");

                    if (listaAlunos.isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado.");
                    } else {
                        HashSet<String> matriculasJaListadas = new HashSet<>();

                        for (Aluno a : listaAlunos) {
                            if (matriculasJaListadas.contains(a.getMatricula())) {
                                continue;
                            }
                            matriculasJaListadas.add(a.getMatricula());

                            System.out.println(a);
                            if (!a.getDisciplinasMatriculadas().isEmpty()) {
                                System.out.println("Disciplinas matriculadas: ");
                                for (Disciplina d : a.getDisciplinasMatriculadas()) {
                                    System.out.println("- " + d.getNome() + " (" + d.getCodigo() + ")");
                                }
                            } else {
                                System.out.println("Disciplinas matriculadas: Nenhuma");
                            }
                            System.out.println();
                        }
                    }
                    break;
                    
                case 3:
                    if (listaAlunos.isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado ainda.");
                        break;
                    }

                    System.out.print("Digite a matrícula do aluno que deseja matricular: ");
                    String matriculaAluno = scanner.nextLine();

                    Aluno alunoEncontrado = null;
                    for (Aluno a : listaAlunos) {
                        if (a.getMatricula().equalsIgnoreCase(matriculaAluno)) {
                            alunoEncontrado = a;
                            break;
                        }
                    }

                    if (alunoEncontrado == null) {
                        System.out.println("Aluno não encontrado.");
                        break;
                    }

                    if (listaDisciplinas.isEmpty()) {
                        System.out.println("Nenhuma disciplina disponível para matrícula.");
                        break;
                    }

                    System.out.println("Disciplinas disponíveis:");
                    for (Disciplina d : listaDisciplinas) {
                        int vagasRestantes = d.getCapacidadeMaxima() - d.getAlunosMatriculados().size();
                        System.out.println("- " + d.getNome() + " (" + d.getCodigo() + ") - Vagas restantes: " + vagasRestantes);
                    }

                    System.out.print("Digite o código da disciplina para matrícula (ex: MAT001): ");
                    String codigoDisciplina = scanner.nextLine();

                    Disciplina disciplinaEscolhida = null;
                    for (Disciplina d : listaDisciplinas) {
                        if (d.getCodigo().equalsIgnoreCase(codigoDisciplina)) {
                            disciplinaEscolhida = d;
                            break;
                        }
                    }

                    if (disciplinaEscolhida == null) {
                        System.out.println("Disciplina não encontrada.");
                    } else {
                        if (!alunoEncontrado.getDisciplinasMatriculadas().contains(disciplinaEscolhida)) {
                            if (disciplinaEscolhida.temVaga()) {
                                alunoEncontrado.matricularEmDisciplina(disciplinaEscolhida);
                                disciplinaEscolhida.matricularAluno(alunoEncontrado);
                                System.out.println("Matrícula realizada com sucesso!");
                            } else {
                                System.out.println("Não há mais vagas nesta disciplina.");
                            }
                        } else {
                            System.out.println("Aluno já está matriculado nesta disciplina.");
                        }
                    }
                    break; 

                case 4:
                    System.out.println("Trancamento solicitado...");
                    break;

                case 5:
                    System.out.println("Salvando dados...");
                    Persistencia.salvarAlunos(listaAlunos, "alunos.dat");
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
