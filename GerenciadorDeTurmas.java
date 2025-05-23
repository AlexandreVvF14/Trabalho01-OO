import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorDeTurmas {

public void criarTurmaParaDisciplina(ArrayList<Disciplina> listaDisciplinas, Scanner scanner) {
    if (listaDisciplinas.isEmpty()) {
        System.out.println("Nenhuma disciplina cadastrada ainda.");
        return;
    }

    System.out.println("Disciplinas disponíveis:");
    for (Disciplina d : listaDisciplinas) {
        System.out.println("- " + d.getNome() + " (" + d.getCodigo() + ")");
    }

    System.out.print("Digite o código da disciplina para adicionar uma turma: ");
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
        return;
    }

    System.out.print("Nome do professor responsável: ");
    String professor = scanner.nextLine();

    String semestre;
    while (true) {
        System.out.print("Semestre (ex: 2025.1): ");
        semestre = scanner.nextLine();
        if (semestre.matches("\\d{4}\\.[12]")) break;
        System.out.println("Formato inválido. Use o formato YYYY.1 ou YYYY.2");
    }

    String formaAvaliacao;
    while (true) {
        System.out.print("Forma de avaliação: ");
        formaAvaliacao = scanner.nextLine();
        if (!formaAvaliacao.trim().isEmpty()) break;
        System.out.println("Forma de avaliação não pode ser vazia.");
    }

    boolean presencial;
    while (true) {
        System.out.print("A aula será presencial? (s/n): ");
        String presencialStr = scanner.nextLine().trim().toLowerCase();
        if (presencialStr.equals("s")) {
            presencial = true;
            break;
        } else if (presencialStr.equals("n")) {
            presencial = false;
            break;
        } else {
            System.out.println("Entrada inválida. Digite 's' ou 'n'.");
        }
    }

    String sala = "";
    if (presencial) {
        while (true) {
            System.out.print("Sala da aula: ");
            sala = scanner.nextLine();
            if (!sala.trim().isEmpty()) break;
            System.out.println("A sala não pode estar vazia para aulas presenciais.");
        }
    }

    String horario;
    while (true) {
        System.out.print("Horário (ex: Segunda 10h-12h): ");
        horario = scanner.nextLine();
        if (horario.matches("(?i)^(segunda|terça|quarta|quinta|sexta|sábado|domingo) .*")) break;
        System.out.println("Formato inválido. Comece com o dia da semana (ex: 'Segunda 10h-12h' ou 'Segunda e Quarta 10h-12h').");
    }

    for (Turma t : disciplinaEscolhida.getTurmas()) {
        if (t.getHorario().equalsIgnoreCase(horario)) {
            System.out.println("Já existe uma turma com este horário para esta disciplina.");
            return;
        }
    }

    int capacidade;
    while (true) {
        System.out.print("Capacidade máxima de alunos: ");
        try {
            capacidade = Integer.parseInt(scanner.nextLine());
            if (capacidade > 0) break;
            System.out.println("A capacidade deve ser maior que zero.");
        } catch (NumberFormatException e) {
            System.out.println("Digite um número válido.");
        }
    }

    int numero = disciplinaEscolhida.getTurmas().size() + 1;
    Turma novaTurma = new Turma(numero, disciplinaEscolhida, professor, semestre, formaAvaliacao, presencial, sala, horario, capacidade);
    disciplinaEscolhida.adicionarTurma(novaTurma);

    System.out.println("Turma criada com sucesso!");
    }
}
