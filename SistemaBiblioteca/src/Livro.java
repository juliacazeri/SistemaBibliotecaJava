public class Livro implements Emprestavel{
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponivel;

    public Livro(String titulo, String autor, String isbn){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponivel = true;
    }

    public String getIsbn(){
        return isbn;
    }

    public boolean isDisponivel(){
        return disponivel;
    }

    @Override
    public void emprestar() throws LivroIndisponivelException{
        if(!disponivel){
            throw new LivroIndisponivelException("O livro está emprestado.");
        }
        disponivel = false;
    }

    @Override
    public void devolver(){
        disponivel = true;
    }

    @Override
    public String toString(){
        return "Título: " + titulo +
               ", Autor: " + autor +
               ", ISBN: " + isbn +
               ", Disponível: " + (disponivel ? "Sim" : "Não");
    }
}