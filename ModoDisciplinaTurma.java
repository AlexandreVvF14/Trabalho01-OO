import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ModoDisciplinaTurma {
    private ArrayList<Disciplina> listaDisciplinas;
    private GerenciadorDeDisciplinas gerenciadorDeDisciplinas;
    private GerenciadorDeTurmas gerenciadorDeTurmas;
    private Scanner scanner;

    public ModoDisciplinaTurma(ArrayList<Disciplina> listaDisciplinas, Scanner scanner) {
        this.listaDisciplinas = listaDisciplinas;
        this.gerenciadorDeDisciplinas = new GerenciadorDeDisciplinas(listaDisciplinas);
        this.gerenciadorDeTurmas = new GerenciadorDeTurmas();
        this.scanner = scanner;
    }

    public void exibirMenu() {
        int opcao;

        do {
            System.out.println("+___________________________________________+");
            System.out.println("|          MODO DISCIPLINA / TURMA          |");
            System.out.println("+___________________________________________+");
            System.out.println("| 1. Cadastrar nova disciplina              |");
            System.out.println("| 2. Criar turma para uma disciplina        |");
            System.out.println("| 3. Listar turmas e alunos                 |");
            System.out.println("| 4. Salvar dados de disciplinas            |");
            System.out.println("| 5. Carregar dados de disciplinas          |");
            System.out.println("| 0. Voltar ao menu principal               |");
            System.out.println("+___________________________________________+");
            System.out.print("Escolha uma opção: ");

        try {
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    gerenciadorDeDisciplinas.cadastrarNovaDisciplina();
                    break;
                case 2:
                    criarTurma();
                    break;
                case 3:
                    listarTurmasEAlunos();
                    break;
                case 4:
                    salvarDisciplinas();
                    break;
                case 5:
                    carregarDisciplinas();
                    break;
                case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            opcao = -1;
        }
      } while (opcao != 0);
    }

    

    private void listarTurmasDaDisciplina(Disciplina disciplina) {
    ArrayList<Turma> turmas = disciplina.getTurmas();

            if (turmas.isEmpty()) {
                System.out.println("Essa disciplina não possui turmas cadastradas.");
                return;
            }

            System.out.println("\nTurmas disponíveis para " + disciplina.getNome() + ":");
            for (int i = 0; i < turmas.size(); i++) {
                Turma turma = turmas.get(i);
                System.out.println((i + 1) + ". Turma " + turma.getNumero() + " - " + turma.getHorario());
            }

            System.out.print("Escolha o número da turma: ");
            int escolhaTurma;
            try {
                escolhaTurma = Integer.parseInt(scanner.nextLine()) - 1;
                if (escolhaTurma < 0 || escolhaTurma >= turmas.size()) {
                    System.out.println("Turma inválida.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
                return;
            }

            Turma turmaEscolhida = turmas.get(escolhaTurma);
            listarAlunosDaTurma(turmaEscolhida);
        }

    private void listarAlunosDaTurma(Turma turma) {
    ArrayList<Aluno> alunos = turma.getAlunosMatriculados();

            if (alunos.isEmpty()) {
                System.out.println("Nenhum aluno matriculado nesta turma.");
                return;
            }

            System.out.println("\nAlunos matriculados na Turma " + turma.getNumero() + ":");
            for (int i = 0; i < alunos.size(); i++) {
                System.out.println((i + 1) + ". " + alunos.get(i).getNome());
            }

            System.out.print("Digite o número do aluno para ver detalhes ou 0 para voltar: ");
            int escolha;
            try {
                escolha = Integer.parseInt(scanner.nextLine());
                if (escolha == 0) return;
                if (escolha < 1 || escolha > alunos.size()) {
                    System.out.println("Número inválido.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
                return;
            }

            Aluno alunoSelecionado = alunos.get(escolha - 1);
            exibirInformacoesDoAluno(alunoSelecionado);
        }

    private void exibirInformacoesDoAluno(Aluno aluno) {
            System.out.println("\n=== Informações do Aluno ===");
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Matrícula: " + aluno.getMatricula());
            System.out.println("Curso: " + aluno.getCurso());
            System.out.println("Status: " + aluno.getStatusCurso());

            System.out.println("Disciplinas Aprovadas:");
            for (String cod : aluno.getDisciplinasAprovadas()) {
                System.out.println(" - " + cod);
            }
        }


    private void criarTurma() {
        gerenciadorDeTurmas.criarTurmaParaDisciplina(listaDisciplinas, scanner);    
    }

    private void listarTurmasEAlunos() {
        if (listaDisciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }

            System.out.println("\nDisciplinas disponíveis:");
            for (int i = 0; i < listaDisciplinas.size(); i++) {
                System.out.println((i + 1) + ". " + listaDisciplinas.get(i).getNome());
            }

            System.out.print("Escolha o número da disciplina: ");
            int escolhaDisciplina;
            try {
                escolhaDisciplina = Integer.parseInt(scanner.nextLine()) - 1;
                if (escolhaDisciplina < 0 || escolhaDisciplina >= listaDisciplinas.size()) {
                    System.out.println("Disciplina inválida.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
                return;
            }

            Disciplina disciplinaEscolhida = listaDisciplinas.get(escolhaDisciplina);
            listarTurmasDaDisciplina(disciplinaEscolhida);
        }

    private void salvarDisciplinas() {
        Persistencia.salvarDisciplinas(listaDisciplinas, "disciplinas.dat");
        System.out.println("Disciplinas salvas com sucesso!");
    }

    private void carregarDisciplinas() {
        ArrayList<Disciplina> carregadas = Persistencia.carregarDisciplinas("disciplinas.dat");
        if (carregadas != null) {
            listaDisciplinas.clear();
            listaDisciplinas.addAll(carregadas);
            System.out.println("Disciplinas carregadas com sucesso!");
        } else {
            System.out.println("Falha ao carregar disciplinas.");
        }
    }
}
