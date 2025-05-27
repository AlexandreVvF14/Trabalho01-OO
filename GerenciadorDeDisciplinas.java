import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorDeDisciplinas {
    private ArrayList<Disciplina> listaDisciplinas;
    private Scanner scanner;

    public GerenciadorDeDisciplinas(ArrayList<Disciplina> listaDisciplinas) {
        this.listaDisciplinas = listaDisciplinas;
        this.scanner = new Scanner(System.in);
    }

    public void cadastrarNovaDisciplina() {
        System.out.println("--- Cadastro de Nova Disciplina ---");

        System.out.print("Nome da disciplina: ");
        String nome = scanner.nextLine();

        System.out.print("Código da disciplina: ");
        String codigo = scanner.nextLine();

            if (buscarDisciplinaPorCodigo(codigo) !=null) {
                System.out.println("Já existe uma disciplina cadastrada com o código \"" + codigo + "\".");
                return;
            }

        System.out.print("Carga horária (em horas): ");
        int cargaHoraria = Integer.parseInt(scanner.nextLine());

        System.out.print("Capacidade máxima de alunos: "); 
        int capacidadeMaxima = Integer.parseInt(scanner.nextLine()); 

        System.out.print("A disciplina possui pré-requisitos? (s/n): ");
        String resposta = scanner.nextLine().trim().toLowerCase();

        ArrayList<Disciplina> preRequisitos = new ArrayList<>();

        if (resposta.equals("s")) {
            while (true) {
                System.out.print("Digite o código de um pré-requisito (ou pressione ENTER para finalizar): ");
                String codPre = scanner.nextLine().trim();

                if (codPre.isEmpty()) {
                    break;
                }

                Disciplina disciplinaPreReq = buscarDisciplinaPorCodigo(codPre);
                if (disciplinaPreReq != null) {
                    preRequisitos.add(disciplinaPreReq);
                    System.out.println("Pré-requisito adicionado: " + disciplinaPreReq.getNome());
                } else {
                    System.out.println("Disciplina com código " + codPre + " não encontrada.");
                }
            }
        }

        Disciplina novaDisciplina = new Disciplina(nome, codigo, cargaHoraria, capacidadeMaxima, preRequisitos);
        listaDisciplinas.add(novaDisciplina);
        System.out.println("Disciplina " + nome + " cadastrada com sucesso!");
    }

    private Disciplina buscarDisciplinaPorCodigo(String codigo) {
        for (Disciplina d : listaDisciplinas) {
            if (d.getCodigo().equalsIgnoreCase(codigo)) {
                return d;
            }
        }
        return null;
    }
}
