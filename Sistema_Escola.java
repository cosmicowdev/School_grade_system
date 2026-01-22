import java.util.ArrayList;

public class SistemaEscola {

    private ArrayList<Aluno> alunos = new ArrayList<>();
    private ArrayList<Professor> professores = new ArrayList<>();
    private ArrayList<Materia> materias = new ArrayList<>();

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
    }

    public void adicionarMateria(Materia materia) {
        materias.add(materia);
    }

    public Aluno buscarAluno(String matricula) {
        for(Aluno a : alunos)
            if(a.getMatricula().equals(matricula))
                return a;
        return null;
    }

    public Professor buscarProfessor(String id) {
        for(Professor p : professores)
            if(p.getId().equals(id))
                return p;
        return null;
    }

    public Materia buscarMateria(int codigo) {
        for(Materia m : materias)
            if(m.getCodigo() == codigo)
                return m;
        return null;
    }

    public void lancarNota(String idProf, String matAluno, int codMat, double nota) {
        Professor p = buscarProfessor(idProf);
        Aluno a = buscarAluno(matAluno);
        Materia m = buscarMateria(codMat);

        if(p == null || a == null || m == null) {
            System.out.println("Dados nao encontrados.");
            return;
        }

        if(p.getMateria().getCodigo() != m.getCodigo()) {
            System.out.println("Professor nao leciona essa materia.");
            return;
        }

        p.lancarNota(a, m, nota);
        System.out.println("Nota lancada com sucesso!");
    }
}