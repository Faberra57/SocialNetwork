package opinion


public class Film extends Document{
	
	private String director;
	private String scenarist;
	private int duration;
	private String kind;
	
	public Film(String title,Member creator,String director,String scenarist,int duration,String kind) {
		super(title,creator);
		this.director=director;
		this.scenarist=scenarist;
		this.duration=duration;
		this.kind=kind;
	}
	
	public String toString() {
		return super.toString()+", Directeur :"+this.director+", Scénariste :"+this.scenarist+", Durée :"+this.duration+", Genre :"+this.kind;
	}
}
