package classes;
public class Book extends Item{
	
	private String author;
	private int nbPages;
	private String kind;
	
	public Book(String title,Member creator,String kind,String author,int nbPages) {
		super(title,creator);
		this.author=author;
		this.nbPages=nbPages;
		this.kind=kind;
	}
	
	public String toString() {
		return super.toString()+", Auteur :"+this.author+", Nombre de pages :"+this.nbPages+", Genre :"+this.kind;
	}
	
	public boolean equals(Object o) {
		return o instanceof Book
			&& super.getTitle().equals(((Book) o).getTitle())
			&& this.author.equals(((Book) o).author)
			&& this.kind.equals(((Book) o).kind)
			&& this.nbPages==((Book) o).nbPages;
	}
}
