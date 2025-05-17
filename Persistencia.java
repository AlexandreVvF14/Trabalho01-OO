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
 }     