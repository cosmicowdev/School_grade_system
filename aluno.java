import java.util.HashMap;
import java.util.ArrayList;

public class Aluno {

    private String nome;
    private String matricula;
    private String turma;
    private HashMap<Materia, ArrayList<Double>> notasPorMateria;

    public Aluno(String nome, String matricula, String turma) {
        this.nome = nome;
        this.matricula = matricula;
        this.turma = turma;
        this.notasPorMateria = new HashMap<>();
    }

    public void adicionarNota(Materia materia, double nota) {
        if (!notasPorMateria.containsKey(materia)) {
            notasPorMateria.put(materia, new ArrayList<>());
        }
        notasPorMateria.get(materia).add(nota);
    }

    public double calcularMedia(Materia materia) {
        if (!notasPorMateria.containsKey(materia)) return 0;

        ArrayList<Double> notas = notasPorMateria.get(materia);
        double soma = 0;
        for(double n : notas) soma += n;

        return soma / notas.size();
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }
}