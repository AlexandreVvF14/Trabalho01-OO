import java.util.ArrayList;

public class FabricaDeDisciplina {
    public static ArrayList<Disciplina> criarDisciplinas() {
        ArrayList<Disciplina> disciplinas = new ArrayList<>();

        Disciplina APC = new Disciplina("Algoritmo e Programação de Computadores", "CIC0004", 60, 2);
        Disciplina C1 = new Disciplina("Cálculo 1", "MAT0025", 90, 4);
        Disciplina DIAC = new Disciplina("Desenho Industrial Assistido por Computador", "FGA0168", 60, 2);
        Disciplina EA = new Disciplina("Engenharia e Ambiente", "FGA0302", 60, 2);
        Disciplina IE = new Disciplina("Introdução à Engenharia", "FGA0163", 60, 2);

        disciplinas.add(IE);
        disciplinas.add(APC);
        disciplinas.add(DIAC);
        disciplinas.add(C1);
        disciplinas.add(EA);
        
        return disciplinas;
       } 
}