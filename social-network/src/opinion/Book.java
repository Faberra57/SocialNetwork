package opinion;

public class Book extends Document{
	
	private String author;
	private int nbPages;
	private String kind;
	
	public Book(String title,Member creator,String author,int nbPages,String kind) {
		super(title,creator);
		this.author=author;
		this.nbPages=nbPages;
		this.kind=kind;
	}
	
	public String toString() {
		return super.toString()+", Auteur :"+this.author+", Nombre de pages :"+this.nbPages+", Genre :"+this.kind;
	}
	public boolean equals(Book book) {
		return super.getTitle().equals(book.getTitle())&&this.author.equals(book.author)&&this.nbPages==book.nbPages&&this.kind.equals(book.kind);
	}
}