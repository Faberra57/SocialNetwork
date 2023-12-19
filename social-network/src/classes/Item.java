package classes;
public class Item {
	
	private String title;
	private Member creator;
	
	public Item(String title, Member creator) {
		this.title=title;
		this.creator=creator;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String toString() {
		return "Titre :"+title+", Membre :"+creator.toString();
	}
}
