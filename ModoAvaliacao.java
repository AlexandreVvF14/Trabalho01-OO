
import java.util.Scanner;

public class ModoAvaliacao {

    private Scanner scanner;
    private GerenciadorDeTurmas gerenciadorDeTurmas;


    public ModoAvaliacao(Scanner scanner, GerenciadorDeTurmas gerenciadorDeTurmas) {
        this.gerenciadorDeTurmas = gerenciadorDeTurmas;
        this.scanner = scanner;
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("+___________________________________________+");
            System.out.println("|        MODO AVALIAÇAO / FREQUÊNCIA        |");
            System.out.println("+___________________________________________+");
            System.out.println("| 1 - Lançar notas e presença por turma     |");
            System.out.println("| 2 - Exibir boletim de aluno               |");
            System.out.println("| 3 - Gerar relatórios                      |");
            System.out.println("| 0 - Voltar ao menu principal              |");
            System.out.println("+___________________________________________+");
            System.out.print("Escolha uma opção: ");
            
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    lancarNotasEFrequencia();
                    break;
                case 2:
                    exibirBoletimAluno();
                    break;
                case 3:
                    gerarRelatorios();
                    break;
                case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

        private void lancarNotasEFrequencia() {
        System.out.println("\n--- LANÇAR NOTAS E FREQUÊNCIA ---");
        System.out.print("Informe o código da disciplina: ");
        String codigoDisciplina = scanner.nextLine();

        System.out.print("Informe o número da turma: ");
        int numeroTurma = Integer.parseInt(scanner.nextLine());

        Turma turma = gerenciadorDeTurmas.buscarTurma(codigoDisciplina, numeroTurma);
        if (turma == null) {
            System.out.println("Turma não encontrada!");
            return;
        }

        for (Aluno aluno : turma.getAlunosMatriculados()) {
            System.out.println("\nAluno: " + aluno.getNome());

            System.out.print("Nota P1: ");
            double p1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Nota P2: ");
            double p2 = Double.parseDouble(scanner.nextLine());

            System.out.print("Nota P3: ");
            double p3 = Double.parseDouble(scanner.nextLine());

            System.out.print("Nota Listas (L): ");
            double l = Double.parseDouble(scanner.nextLine());

            System.out.print("Nota Seminário (S): ");
            double s = Double.parseDouble(scanner.nextLine());

            System.out.print("Frequência (%): ");
            double frequencia = Double.parseDouble(scanner.nextLine());

            Avaliacao avaliacao = new Avaliacao(p1, p2, p3, l, s, frequencia, turma.getFormaAvaliacao());
            turma.registrarAvaliacao(aluno, avaliacao);
        }

        System.out.println("Notas e frequência lançadas com sucesso!");
    }



    private void exibirBoletimAluno() {
        // Aqui exibiremos o boletim por semestre
    }

    private void gerarRelatorios() {
        // Submenu para relatórios por turma, disciplina, professor
    }
}
