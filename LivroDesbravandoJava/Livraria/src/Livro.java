
public class Livro {
	
	String nome;
	String descricao;
	double Valor;
	String isbn;
	String nomeDoAutor;
	String emailDoAutor;
	String cpfDoAutor;
	public Autor autor;
	
	
	void mostrarDetralhes() {
		
		System.out.println("***********Mostrando Detralhes do Livro*********** ");
		System.out.println("Nome: "+nome);
		System.out.println("Descrição: "+descricao);
		System.out.println("Valor: "+Valor);
		System.out.println("ISBN: "+isbn);
		autor.mostrarDetalhes();
		System.out.println("--");
	
		
	}
	

}
