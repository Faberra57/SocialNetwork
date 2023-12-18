package opinion;

public class Document {
	
	private String title;
	
	private Member creator;
	
	public Document(String title,Member creator) {
		this.title=title;
		this.creator=creator;
	}
	public String getTitle() {
		return title;
	}
	public String toString() {
		return "Titre :"+this.title+", Créateur :"+this.creator.toString();
	}
}
