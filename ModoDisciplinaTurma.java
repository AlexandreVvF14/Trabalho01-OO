import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ModoDisciplinaTurma {
    private ArrayList<Disciplina> listaDisciplinas;
    private GerenciadorDeDisciplinas gerenciadorDeDisciplinas;
    private Scanner scanner;

    public ModoDisciplinaTurma(ArrayList<Disciplina> listaDisciplinas, Scanner scanner) {
        this.listaDisciplinas = listaDisciplinas;
        this.gerenciadorDeDisciplinas = new GerenciadorDeDisciplinas(listaDisciplinas);
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

    private void criarTurma() {
        // Em breve!
        System.out.println("[TODO] Criação de turma será implementada.");
    }

    private void listarTurmasEAlunos() {
        // Em breve!
        System.out.println("[TODO] Listagem de turmas e alunos será implementada.");
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
