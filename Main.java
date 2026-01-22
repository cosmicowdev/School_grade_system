
import java.util.Scanner;

public class Main {

    static SistemaEscola sistema = new SistemaEscola();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Dados iniciais para teste
        Materia mat1 = new Materia("Matematica", 101);
        Materia mat2 = new Materia("Portugues", 102);
        sistema.adicionarMateria(mat1);
        sistema.adicionarMateria(mat2);

        sistema.adicionarProfessor(new Professor("Carlos", "P1", mat1));
        sistema.adicionarProfessor(new Professor("Ana", "P2", mat2));

        sistema.adicionarAluno(new Aluno("Victor", "A1", "1A"));

        while(true) {
            System.out.println("\n=== LOGIN ===");
            System.out.println("1 - Professor");
            System.out.println("2 - Aluno");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");
            int op = sc.nextInt();
            sc.nextLine();

            if(op == 0) break;

            if(op == 1) loginProfessor();
            if(op == 2) loginAluno();
        }

        System.out.println("Sistema encerrado.");
    }

    // ===== LOGIN PROFESSOR =====
    static void loginProfessor() {
        System.out.print("ID do professor: ");
        String id = sc.nextLine();

        Professor p = sistema.buscarProfessor(id);

        if(p == null) {
            System.out.println("Professor nao encontrado!");
            return;
        }

        while(true) {
            System.out.println("\nProfessor: " + p.getNome());
            System.out.println("1 - Lancar nota");
            System.out.println("2 - Calcular media de aluno");
            System.out.println("0 - Logout");

            int op = sc.nextInt();
            sc.nextLine();

            if(op == 0) break;

            if(op == 1) {
                System.out.print("Matricula do aluno: ");
                String mat = sc.nextLine();

                System.out.print("Codigo da materia: ");
                int cod = sc.nextInt();

                System.out.print("Nota: ");
                double nota = sc.nextDouble();
                sc.nextLine();

                sistema.lancarNota(p.getId(), mat, cod, nota);
            }

            if(op == 2) {
                System.out.print("Matricula do aluno: ");
                String mat = sc.nextLine();

                Aluno a = sistema.buscarAluno(mat);
                if(a == null) {
                    System.out.println("Aluno nao encontrado!");
                    continue;
                }

                System.out.print("Codigo da materia: ");
                int cod = sc.nextInt();
                sc.nextLine();

                Materia m = sistema.buscarMateria(cod);
                if(m == null) {
                    System.out.println("Materia nao encontrada!");
                    continue;
                }

                double media = a.calcularMedia(m);
                System.out.println("Media do aluno: " + media);
            }
        }
    }

    // ===== LOGIN ALUNO =====
    static void loginAluno() {
        System.out.print("Matricula do aluno: ");
        String mat = sc.nextLine();

        Aluno a = sistema.buscarAluno(mat);

        if(a == null) {
            System.out.println("Aluno nao encontrado!");
            return;
        }

        while(true) {
            System.out.println("\nAluno: " + a.getNome());
            System.out.println("1 - Ver media");
            System.out.println("0 - Logout");

            int op = sc.nextInt();
            sc.nextLine();

            if(op == 0) break;

            if(op == 1) {
                System.out.print("Codigo da materia: ");
                int cod = sc.nextInt();
                sc.nextLine();

                Materia m = sistema.buscarMateria(cod);
                if(m == null) {
                    System.out.println("Materia nao encontrada!");
                    continue;
                }

                double media = a.calcularMedia(m);
                System.out.println("Sua media: " + media);
            }
        }
    }
}