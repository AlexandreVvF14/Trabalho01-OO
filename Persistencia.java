import java.io.*;
import java.util.ArrayList;

public class Persistencia {

    public static void salvarAlunos(ArrayList<Aluno> alunos, String nomeArquivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            out.writeObject(alunos);
            System.out.println("Dados dos alunos salvos com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados dos alunos: " + e.getMessage());
        }
    }

    public static ArrayList<Aluno> carregarAlunos(String nomeArquivo) {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            return (ArrayList<Aluno>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar dados dos alunos: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Para salvar disciplinas
    public static void salvarDisciplinas(ArrayList<Disciplina> disciplinas, String nomeArquivo) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
        oos.writeObject(disciplinas);
    } catch (IOException e) {
        System.out.println("Erro ao salvar disciplinas: " + e.getMessage());
    }
}


    @SuppressWarnings("unchecked")

    public static ArrayList<Disciplina> carregarDisciplinas(String nomeArquivo) {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
        return (ArrayList<Disciplina>) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Erro ao carregar disciplinas: " + e.getMessage());
        return null;
    }
}
}