public class Professor {

    private String nome;
    private String id;
    private Materia materia;

    public Professor(String nome, String id, Materia materia) {
        this.nome = nome;
        this.id = id;
        this.materia = materia;
    }

    public String getId() {
        return id;
    }

    public Materia getMateria() {
        return materia;
    }

    public String getNome() {
        return nome;
    }

    public void lancarNota(Aluno aluno, Materia materia, double nota) {
        aluno.adicionarNota(materia, nota);
    }
}