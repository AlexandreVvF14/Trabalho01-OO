import java.util.ArrayList;

public class FabricaDeDisciplina {
    public static ArrayList<Disciplina> criarDisciplinas() {
        ArrayList<Disciplina> disciplinas = new ArrayList<>();

        Disciplina MD1 = new Disciplina("Matemática Discreta", "MAT001", 60, 2);
        Disciplina OO = new Disciplina("Orientação a Objetos", "CIC002", 60, 2);
        Disciplina EDA = new Disciplina("Estrutura de Dados e Algoritmos 1", "CIC003", 60, 2);
        Disciplina DS = new Disciplina("Desenvolvimento de Software", "CIC004", 60, 2); 
        Disciplina C2 = new Disciplina("Cálculo 2", "MAT005", 90, 4);
        Disciplina APC = new Disciplina("Algoritmo e Programação de Computadores", "CIC006", 60, 2);
        Disciplina C1 = new Disciplina("Cálculo 1", "MAT007", 90, 4);
        Disciplina DIAC = new Disciplina("Desenho Industrial Assistido por Computador", "FGA008", 60, 2);
        Disciplina MDS = new Disciplina("Métodos de Desenvolvimento de Software", "CIC009", 60, 2);
        Disciplina DCV = new Disciplina("Design e Concepção de Veículos", "FGA010", 60, 2);
        Disciplina EDA2 = new Disciplina("Estruturas de Dados 2", "CIC011", 60, 2);

        OO.adicionarPreRequisito(APC);
        EDA.adicionarPreRequisito(APC);
        DS.adicionarPreRequisito(APC);
        C2.adicionarPreRequisito(C1);
        DCV.adicionarPreRequisito(DIAC);
        MDS.adicionarPreRequisito(OO);
        EDA2.adicionarPreRequisito(EDA);

        disciplinas.add(MD1);
        disciplinas.add(OO);
        disciplinas.add(EDA);
        disciplinas.add(DS);
        disciplinas.add(C2);
        disciplinas.add(APC);
        disciplinas.add(C1);
        disciplinas.add(DIAC);
        disciplinas.add(MDS);
        disciplinas.add(DCV);
        
        return disciplinas;
       } 
}