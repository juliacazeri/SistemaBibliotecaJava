import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int opcao;
        do{
            System.out.println("\n===== Menu da Biblioteca =====");
            System.out.println("1. Cadastrar Livro.");
            System.out.println("2. Emprestar Livro.");
            System.out.println("3. Devolver Livro.");
            System.out.println("4. Listar todos os livros.");
            System.out.println("5. Sair.");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch(opcao){
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();

                    Livro livro = new Livro(titulo, autor, isbn);
                    try{
                        biblioteca.adicionarLivro(livro);
                        System.out.println("O livro foi cadastrado!");
                    } catch(LivroDuplicadoException e){
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Informe o ISBN do livro para emprestar: ");
                    isbn = scanner.nextLine();
                    try{
                        biblioteca.emprestarLivro(isbn);
                        System.out.println("O livro foi emprestado!");
                    } catch(LivroIndisponivelException | IllegalArgumentException e){
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Informe o ISBN do livro para devolver: ");
                    isbn = scanner.nextLine();
                    try{
                        biblioteca.devolverLivro(isbn);
                        System.out.println("O livro foi devolvido!");
                    } catch (IllegalArgumentException e){
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 4:
                    biblioteca.listarLivros();
                    break;

                case 5:
                    System.out.println("Encerrando o sistema de biblioteca...");
                    break;

                default:
                    System.out.println("A opção informada é inválida.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}