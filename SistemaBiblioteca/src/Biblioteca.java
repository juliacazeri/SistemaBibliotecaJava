import java.util.HashMap;
import java.util.Map;

public class Biblioteca{
    private Map<String, Livro> livros = new HashMap<>();

    public void adicionarLivro(Livro livro) throws LivroDuplicadoException{
        if(livros.get(livro.getIsbn()) != null){
            throw new LivroDuplicadoException("O ISBN informado já foi cadastrado: " + livro.getIsbn());
        }
        livros.put(livro.getIsbn(), livro);
    }

    public void emprestarLivro(String isbn) throws LivroIndisponivelException{
        Livro livro = livros.get(isbn);
        if(livro == null){
            throw new IllegalArgumentException("O livro com ISBN " + isbn + " não foi encontrado.");
        }
        livro.emprestar();
    }

    public void devolverLivro(String isbn){
        Livro livro = livros.get(isbn);
        if(livro == null){
            throw new IllegalArgumentException("O livro com ISBN " + isbn + " não foi encontrado.");
        }
        livro.devolver();
    }

    public void listarLivros(){
        if(livros.isEmpty()){
            System.out.println("Nenhum livro foi cadastrado.");
        } else{
            for(Livro livro : livros.values()){
                System.out.println(livro);
            }
        }
    }
}