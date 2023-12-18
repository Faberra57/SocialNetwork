package opinion;
public class Review {
	
	private Document doc;
	private Member author;
	private String comments;
	private float mark;
	
	public Review(Document doc,Member author,String comments,float mark) {
		this.doc=doc;
		this.author=author;
		this.comments=comments;
		this.mark=mark;
	}
	public void setReviewComment(String comment) {
		this.comments=comment;
	}
	public float getMark() {
		return mark;
	}
	public String getTitle(){
		return doc.getTitle();
	}
	public Member getMember() {
		return author;
	}
	public String toString() {
		return doc.getTitle()+this.author.toString();
	}
}
