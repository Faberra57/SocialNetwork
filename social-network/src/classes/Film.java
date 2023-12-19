package classes;
public class Film extends Item{
	
	private String director;
	private String scenarist;
	private int duration;
	private String kind;
	
	public Film(String title,Member creator,String kind,String director,String scenarist,int duration) {
		super(title,creator);
		this.director=director;
		this.scenarist=scenarist;
		this.duration=duration;
		this.kind=kind;
	}
	
	public String toString() {
		return super.toString()+", Directeur :"+this.director+", Scénariste :"+this.scenarist+", Durée :"+this.duration+", Genre :"+this.kind;
	}
	
	public boolean equals(Object o) {
		return o instanceof Film
			&& super.getTitle().equals(((Film) o).getTitle())
			&& this.director.equals(((Film) o).director)
			&& this.scenarist.equals(((Film) o).scenarist)
			&& this.kind.equals(((Film) o).kind)
			&& this.duration==((Film) o).duration;
	}
}
