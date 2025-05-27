import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class HistoricoEscolar implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codigoDisciplina;
    private String nomeDisciplina;
    private int numeroTurma;
    private String semestre;
    private double notaFinal;
    private double frequencia;
    private String status; 


    public HistoricoEscolar(String codigoDisciplina, String nomeDisciplina, int numeroTurma,
                            String semestre, double notaFinal, double frequencia, String status) {
        this.codigoDisciplina = codigoDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.numeroTurma = numeroTurma;
        this.semestre = semestre;
        this.notaFinal = notaFinal;
        this.frequencia = frequencia;
        this.status = status;

    }

    public String toString() {
        return String.format("%s (%s) - Turma %d - Semestre: %s\nNota Final: %.2f | Frequência: %.1f%% | Status: %s",
                nomeDisciplina, codigoDisciplina, numeroTurma, semestre, notaFinal, frequencia * 100, status);
    }

    
}
