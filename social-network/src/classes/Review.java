package classes;
public class Review {
	
	private Item item;
	private Member creator;
	private String comments;
	private float mark;
	
	public Review(Item item,Member author,String comments,float mark) {
		this.item=item;
		this.creator=author;
		this.comments=comments;
		this.mark=mark;
	}
	
	public String toString() {
		return item.toString()+", Auteur de la revue :"+creator.toString();
	}
	
	public Item getItem() {
		return item;
	}
	
	public Member getCreator() {
		return creator;
	}
}
