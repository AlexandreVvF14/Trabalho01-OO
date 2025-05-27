import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModoAluno {
    private ArrayList<Aluno> listaAlunos;
    private ArrayList<Disciplina> listaDisciplinas;
    private Scanner scanner;

    public ModoAluno(ArrayList<Aluno> listaAlunos, ArrayList<Disciplina> listaDisciplinas) {
        this.listaAlunos = listaAlunos;
        this.listaDisciplinas = listaDisciplinas;
        this.scanner = new Scanner(System.in);

    }

    public void exibirMenu() {
        int opcao;
 
        do {
            System.out.println("+____________________________________________+");
            System.out.println("|                 MODO ALUNO                 |");
            System.out.println("+____________________________________________+");
            System.out.println("| 1 - Cadastrar Aluno                        |");
            System.out.println("| 2 - Listar Alunos                          |");
            System.out.println("| 3 - Matricular Aluno em Disciplina         |");
            System.out.println("| 4 - Trancar disciplina ou semestre         |");
            System.out.println("| 5 - Adicionar Histórico                    |");
            System.out.println("| 6 - Salvar dados dos alunos                |");
            System.out.println("| 0 - Voltar                                 |");
            System.out.println("+____________________________________________+");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarAluno();

                case 2 -> listarAlunos(listaAlunos);

                case 3 -> matricularAluno();

                case 4 -> Trancamento.menuTrancamento(listaAlunos, listaDisciplinas, scanner);
                
                case 5 -> 
                    adicionarHistorico();

                case 6 -> {System.out.println("Salvando dados...");
                    Persistencia.salvarAlunos(listaAlunos, "alunos.dat");
                    Persistencia.salvarDisciplinas(listaDisciplinas, "disciplinas.dat");}

                case 0 -> System.out.println("Retornando ao menu principal...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void cadastrarAluno() {
        System.out.println("Cadastro de aluno iniciado...");

        String resposta;
        do {
            System.out.print("O aluno é especial? (s/n): ");
            resposta = scanner.nextLine().trim();

            if (!resposta.equals("s") && !resposta.equals("n")) {
                System.out.println("Entrada inválida. Digite apenas 's' para sim ou 'n' para não.");
            }
        } while (!resposta.equals("s") && !resposta.equals("n"));


        System.out.print("Digite o nome completo do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a matrícula do aluno: ");
        String matricula = scanner.nextLine();

        for (Aluno a : listaAlunos) {
            if (a.getMatricula().equals(matricula)) {
                System.out.println("Aluno já cadastrado!");
                return;
            }
        }

        System.out.print("Digite o curso do aluno: ");
        String curso = scanner.nextLine();

        Aluno novoAluno;
        if (resposta.equals("s")) {
            novoAluno = new AlunoEspecial(nome, matricula, curso);
        } else {
            novoAluno = new Aluno(nome, matricula, curso);
        }

        listaAlunos.add(novoAluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public static void listarAlunos(List<Aluno> alunos) {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        System.out.println("Lista de Alunos:");
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
            System.out.println("----------------------------");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Deseja ver mais informações sobre algum aluno? (s/n): ");
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("s")) {
            System.out.print("Digite a matrícula do aluno: ");
            String matricula = scanner.nextLine();

            Aluno encontrado = null;
            for (Aluno aluno : alunos) {
                if (aluno.getMatricula().equalsIgnoreCase(matricula)) {
                    encontrado = aluno;
                    break;
                }
            }

            System.out.println("Informações detalhadas:");
            System.out.println(encontrado);

            // Mostrar disciplinas em andamento
            System.out.println("\nDisciplinas em andamento:");
            if (encontrado.getDisciplinasMatriculadas().isEmpty()) {
                System.out.println("Nenhuma disciplina em andamento no momento.");
            } else {
                for (Turma turma : encontrado.getTurmasMatriculadas()) {
                    System.out.printf("- %s (%s) | Turma %d | Professor: %s | Horário: %s\n",
                        turma.getDisciplina().getNome(),
                        turma.getDisciplina().getCodigo(),
                        turma.getNumero(),
                        turma.getProfessor(),
                        turma.getHorario()
                    );
                }
            }

            // Mostrar histórico finalizado
            
            encontrado.exibirHistorico();

            } else {
                System.out.println("Aluno não encontrado com essa matrícula.");
            }
        }
    


    private void adicionarHistorico() {
        System.out.print("Digite a matrícula do aluno: ");
        String matricula = scanner.nextLine();
        Aluno aluno = null;
        
        for (Aluno a : listaAlunos) {
            if (a.getMatricula().equalsIgnoreCase(matricula)) {
                aluno = a;
                break;
            }
        }

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        if (listaDisciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }

        // Exibir disciplinas disponíveis
        System.out.println("Disciplinas disponíveis:");
        for (Disciplina d : listaDisciplinas) {
            System.out.println("- " + d.getNome() + " (" + d.getCodigo() + ")");
        }

        System.out.print("Digite o código da disciplina: ");
        String codigo = scanner.nextLine();

        Disciplina disciplina = null;
        for (Disciplina d : listaDisciplinas) {
            if (d.getCodigo().equalsIgnoreCase(codigo)) {
                disciplina = d;
                break;
            }
        }

        if (disciplina == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }

        System.out.print("Número da turma: ");
        int turma;
        try {
            turma = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Número de turma inválido.");
            return;
        }

        System.out.print("Semestre (ex: 2024.1): ");
        String semestre = scanner.nextLine();

        System.out.print("Nota final (0 a 10): ");
        double nota;
        try {
            nota = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Nota inválida.");
            return;
        }

        System.out.print("Frequência (em percentual, ex: 87.5): ");
        double frequencia;
        try {
            frequencia = Double.parseDouble(scanner.nextLine()) / 100.0;
        } catch (NumberFormatException e) {
            System.out.println("Frequência inválida.");
            return;
        }

        // Avaliação por conceito
        String conceito;
        if (nota == 0) {
            conceito = "SR";
        } else if (nota >= 9.0) {
            conceito = "SS";
        } else if (nota >= 7.0) {
            conceito = "MS";
        } else if (nota >= 5.0) {
            conceito = "MM";
        } else if (nota >= 3.0) {
            conceito = "MI";
        } else if (nota >= 1.0) {
            conceito = "II";
        } else {
            conceito = "SR";
        }

        String statusFinal;
        if (frequencia < 0.75) {
            statusFinal = "Reprovado por falta";
        } else if (conceito.equals("MI") || conceito.equals("II") || conceito.equals("SR")) {
            statusFinal = "Reprovado por conceito: " + conceito;
        } else {
            statusFinal = "Aprovado com conceito: " + conceito;
        }

        HistoricoEscolar registro = new HistoricoEscolar(
            disciplina.getCodigo(),
            disciplina.getNome(),
            turma,
            semestre,
            nota,
            frequencia,
            statusFinal
        );

        aluno.adicionarAoHistorico(registro);

        System.out.println("Registro adicionado ao histórico com sucesso!");
}


    private void matricularAluno() {
        if (listaAlunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado ainda.");
            return;
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

        if (alunoEncontrado instanceof AlunoEspecial) {
            if (alunoEncontrado.getDisciplinasMatriculadas().size() >= 2) {
                System.out.println("Aluno especial só pode se matricular em no máximo 2 disciplinas.");
                return;
            }
        }

        if (alunoEncontrado == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        if (alunoEncontrado.isTrancado()) {
            System.out.println("Não é possível realizar matrícula. O aluno está com o semestre trancado.");
            return;
        }

        if (listaDisciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina disponível para matrícula.");
            return;
        }

        System.out.println("Disciplinas disponíveis:");
        for (Disciplina d : listaDisciplinas) {
            int totalTurmas = d.getTurmas().size();
            System.out.println("- " + d.getNome() + " (" + d.getCodigo() + ") - Turmas disponíveis: " + totalTurmas);
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
            if (alunoEncontrado.getDisciplinasMatriculadas().contains(disciplinaEscolhida)) {
                System.out.println("Aluno já está matriculado nesta disciplina.");
                return;
            }

            ArrayList<Turma> turmas = disciplinaEscolhida.getTurmas();
            if (turmas.isEmpty()) {
                System.out.println("Não há turmas disponíveis para essa disciplina.");
                return;
            }

            System.out.println("Turmas disponíveis para " + disciplinaEscolhida.getNome() + ":");
            for (int i = 0; i < turmas.size(); i++) {
                Turma t = turmas.get(i);
                int vagasRestantes = t.getCapacidadeMaxima() - t.getAlunosMatriculados().size();
                String modalidadeInfo = t.isRemota() ? "Online" : "Presencial: " + t.getSala();
                System.out.printf("%d - Turma %d | Professor: %s | %s | Horário: %s | Vagas restantes: %d\n",
                    i + 1, t.getNumero(), t.getProfessor(), modalidadeInfo, t.getHorario(), vagasRestantes);

            }

            System.out.print("Escolha o número da turma para matrícula: ");
            int escolha = -1;
            try {
                escolha = Integer.parseInt(scanner.nextLine()) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
                return;
            }

            if (escolha < 0 || escolha >= turmas.size()) {
                System.out.println("Turma inválida.");
                return;
            }

            Turma turmaEscolhida = turmas.get(escolha);

            if (!turmaEscolhida.temVaga()) {
                System.out.println("Turma sem vagas disponíveis.");
                return;
            }

            turmaEscolhida.matricularAluno(alunoEncontrado);
            alunoEncontrado.matricularNaTurma(turmaEscolhida);
            System.out.println("Matrícula realizada com sucesso!");

        }
    }
}

