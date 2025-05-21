//Só a estrutura por enquanto

import java.util.Scanner;

public class ModoDisciplinaTurma {
    private Scanner scanner;

    public ModoDisciplinaTurma(Scanner scanner) {
        this.scanner = scanner;
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n MODO DISCIPLINA / TURMA =====");
            System.out.println("1. Cadastrar Disciplina");
            System.out.println("2. Criar Turma");
            System.out.println("3. Listar Turmas e Alunos Matriculados");
            System.out.println("4. Salvar Dados");
            System.out.println("5. Carregar Dados");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarDisciplina();
                    break;
                case 2:
                    criarTurma();
                    break;
                case 3:
                    listarTurmasEAlunos();
                    break;
                case 4:
                    salvarDados();
                    break;
                case 5:
                    carregarDados();
                    break;
                case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void cadastrarDisciplina() {
    }

    private void criarTurma() {
    }

    private void listarTurmasEAlunos() {
    }

    private void salvarDados() {
    }

    private void carregarDados() {
    }
}
