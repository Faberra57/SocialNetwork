package opinion;
import java.util.LinkedList;
import exceptions.BadEntryException;
import exceptions.ItemBookAlreadyExistsException;
import exceptions.ItemFilmAlreadyExistsException;
import exceptions.MemberAlreadyExistsException;
import exceptions.NotItemException;
import exceptions.NotMemberException;
import classes.Book;
import classes.Film;
import classes.Member;
import classes.Review;
public class SocialNetwork implements ISocialNetwork {
	
	private LinkedList<Member> members ;
private LinkedList<Film> films;
private LinkedList<Book> books;
private LinkedList<Review> reviews;
public SocialNetwork() {
	this.members=new LinkedList<Member>();
	this.films=new LinkedList<Film>();
	this.books=new LinkedList<Book>();
	this.reviews=new LinkedList<Review>();
}
public int countNbMembers() {
	 return members.size();
}
public int countNbFilms(){
	return films.size();
}
public int countNbBooks() {
	return books.size();
}
public int countNbReviews() {
	return reviews.size();
}
public Member checkMember(String login, String password) throws NotMemberException,BadEntryException{
	if (login==null || login.isBlank()) {
		throw new BadEntryException("Nom d'utilisateur incorrect");
	}
	if (password==null || password.strip().length()<4) {
		throw new BadEntryException("Mot de passe incorrect");
	}
	for (Member member : members) {
		if (member.getLogin().equals(login.strip().toLowerCase()) && member.getPassword().equals(password.strip().toLowerCase())) {
			return member;
		}
	}
	throw new NotMemberException("");
}
public void addMember(String login, String password, String description) throws BadEntryException, MemberAlreadyExistsException{
	if (login==null || login.isBlank()) {
		throw new BadEntryException("Nom d'utilisateur incorrect");
	}
	if (password==null || password.strip().length()<4) {
		throw new BadEntryException("Mot de passe incorrect");
	}
	if (description==null) {
		throw new BadEntryException("Description incorrecte");
	}
	String login_format=login.strip().toLowerCase();
	for (int k=0;k<this.countNbMembers();k++) {
		if (this.members.get(k).getLogin().toLowerCase().equals(login_format)) {
			throw new MemberAlreadyExistsException();
		}
	}
	this.members.add(new Member(login_format,password,description));
}
public void addItemFilm(String login, String password, String title,String kind, String director, String scenarist, int duration)
		throws BadEntryException, NotMemberException,ItemFilmAlreadyExistsException{
	if (title==null || title.isBlank()) {
		throw new BadEntryException("Titre incorrect");
	}
	if (kind==null) {
		throw new BadEntryException("Genre incorrect");
	}
	if (director==null || scenarist==null) {
		throw new BadEntryException("Nom incorrect");
	}
	if (duration<=0) {
		throw new BadEntryException("Durée incorrecte");
	}
	Member creator=this.checkMember(login,password);
	String title_format=title.strip().toLowerCase();
	for (Film f : films) {
		if (f.getTitle().equals(title_format)) {
			throw new ItemFilmAlreadyExistsException();
		}
	}
	this.films.add(new Film(title_format,creator,kind,director,scenarist,duration));
}
	public void addItemBook(String login, String password, String title, String kind, String author, int nbPages)
			throws BadEntryException, NotMemberException, ItemBookAlreadyExistsException {
		if (title==null || title.isBlank()) {
		throw new BadEntryException("Titre incorrect");
	}
	if (kind==null) {
		throw new BadEntryException("Genre incorrect");
	}
	if (author==null) {
		throw new BadEntryException("Nom incorrect");
	}
	if (nbPages<=0) {
		throw new BadEntryException("Nombre de page incorrect");
	}
	Member creator=this.checkMember(login,password);
	String title_format=title.strip().toLowerCase();
	for (Book b : books) {
		if (b.getTitle().equals(title_format)) {
			throw new ItemBookAlreadyExistsException();
		}
	}
	this.books.add(new Book(title_format,creator,kind,author,nbPages));
		
	}
	
	public float reviewItemFilm(String login, String password, String title, float mark, String comment)
			throws BadEntryException, NotMemberException, NotItemException {
		if (title==null) {
		throw new BadEntryException("Titre incorrect");
	}
		if (mark<0.0 || mark>5.0) {
			throw new BadEntryException("Note incorrecte");
		}
		if (comment==null) {
		throw new BadEntryException("Commentaire incorrect");
	}
		Member creator=this.checkMember(login,password);
		int i=0;
		int n=this.countNbFilms();
		while (i<n && !title.strip().toLowerCase().equals(this.films.get(i).getTitle())) {
			i++;
		}
		if (i==n) {
			throw new NotItemException("Titre incorrect");
		}
		else {
			int j=0;
			int m=this.countNbReviews();
			Film film=this.films.get(i);
			while (j<m && !(film.equals(this.reviews.get(j).getItem()) && creator.equals(this.reviews.get(j).getCreator()))) {
				j++;
			}
			if (j==m) {
				this.reviews.add(new Review(film,creator,comment,mark));
				return mark;
			}
			else {
				this.reviews.remove(j);
				this.reviews.add(new Review(film,creator,comment,mark));
				return mark;
			}
		}
	}
	public float reviewItemBook(String login, String password, String title, float mark, String comment)
			throws BadEntryException, NotMemberException, NotItemException {
		if (title==null) {
		throw new BadEntryException("Titre incorrect");
	}
		if (mark<0.0 || mark>5.0) {
			throw new BadEntryException("Note incorrecte");
		}
		if (comment==null) {
		throw new BadEntryException("Commentaire incorrect");
	}
		Member creator=this.checkMember(login,password);
		int i=0;
		int n=this.countNbBooks();
		while (i<n && !title.strip().toLowerCase().equals(this.books.get(i).getTitle())) {
			i++;
		}
		if (i==n) {
			throw new NotItemException("Titre incorrect");
		}
		else {
			int j=0;
			int m=this.countNbReviews();
			Book book=this.books.get(i);
			while (j<m && !(book.equals(this.reviews.get(j).getItem()) && creator.equals(this.reviews.get(j).getCreator()))) {
				j++;
			}
			if (j==m) {
				this.reviews.add(new Review(book,creator,comment,mark));
				return mark;
			}
			else {
				this.reviews.remove(j);
				this.reviews.add(new Review(book,creator,comment,mark));
				return mark;
			}
		}
	}
	public LinkedList<String> consultItems(String title) throws BadEntryException {
		if (title==null || title.isBlank()) {
		throw new BadEntryException("Titre incorrect");
	}
		String title_format=title.strip().toLowerCase();
		int n=title_format.length();
		LinkedList<String> result=new LinkedList<String>();
		for (int k=0;k<this.countNbBooks();k++) {
			String chaine=this.books.get(k).getTitle();
			if (chaine.substring(0,n).equals(title_format)) {
				result.add(title_format);
			}
		}
		for (int k=0;k<this.countNbFilms();k++) {
			String chaine=this.films.get(k).getTitle();
			if (chaine.substring(0,n).equals(title_format)) {
				result.add(title_format);
			}
		}
		return result;
	}
public String toString() {
	String chaine="Membres :";
	for (int k=0;k<this.countNbMembers();k++) {
		chaine+=this.members.get(k).toString()+", ";
	}
	chaine+="Livres :";
	for (int k=0;k<this.countNbBooks();k++) {
		chaine+=this.books.get(k).toString()+", ";
	}
	chaine+="Films :";
	for (int k=0;k<this.countNbFilms();k++) {
		chaine+=this.films.get(k).toString()+", ";
	}
	return chaine;
}
}
