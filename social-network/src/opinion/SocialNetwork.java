package opinion;

import java.util.LinkedList;

import exceptions.BadEntryException;
import exceptions.ItemBookAlreadyExistsException;
import exceptions.ItemFilmAlreadyExistsException;
import exceptions.MemberAlreadyExistsException;
import exceptions.NotItemException;
import exceptions.NotMemberException;
public class SocialNetwork implements ISocialNetwork {
	private LinkedList<Member> members ;
	private LinkedList<Film> films;
	private LinkedList<Book> books;
	private LinkedList<Review> reviews;
	public boolean isMember(String login) {
		for (int k=0;k<this.countNbMembers();) {
			if (members.get(k).getLogin().equals(login)) {
				return true;
			}
		}
		return false;
	}
	public Member checkPassword(String login,String password) throws BadEntryException,NotMemberException{
		if (!this.isMember(login)) {
			throw new NotMemberException("");
		}
		else {
			int k=0;
			while (k<this.countNbMembers()&&!this.members.get(k).getLogin().equals(login)) {
				k++;
			}
			if (!this.members.get(k).getPassword().equals(password)) {
				throw new BadEntryException("Mot de passe incorrect");
			}
			else {
				return members.get(k);
			}
			
		}
	}

	public int countNbMembers() {
		
		return members.size();
	}

	@Override
	public int countNbFilms() {
		return films.size();
	}

	@Override
	public int countNbBooks() {
		return books.size();
	}

	@Override
	public void addMember(String login, String password, String description)
			throws BadEntryException, MemberAlreadyExistsException {
		if (!isMember(login)) {
			members.add(new Member(login,password,description));
		}
		else {
			throw new MemberAlreadyExistsException();
		}
	}

	@Override
	public void addItemFilm(String login, String password, String title, String kind, String director, String scenarist,
			int duration) throws BadEntryException, NotMemberException, ItemFilmAlreadyExistsException {
		Member member=checkPassword(login,password);
		Film nFilm = new Film(title,member,director,scenarist,duration,kind);
		for (int k=0;k<this.countNbFilms(); k++) {
			if (this.films.get(k).equals(nFilm)) {
				throw new ItemFilmAlreadyExistsException();
			}
		}
		films.add(nFilm);
	}

	@Override
	public void addItemBook(String login, String password, String title, String kind, String author, int nbPages)
			throws BadEntryException, NotMemberException, ItemBookAlreadyExistsException {
		Member member=checkPassword(login,password);
		Book nBook = new Book(title,member,author,nbPages,kind);
		for (int k=0;k<this.countNbBooks();k++) {
			if(films.get(k).equals(nBook)){
				throw new ItemFilmAlreadyExistsException();
			}
		}
		books.add(nBook);
	}


	@Override
	public float reviewItemFilm(String login, String password, String title, float mark, String comment)
			throws BadEntryException, NotMemberException, NotItemException {
		float total=0;
		int nb=0;
		Member member=checkPassword(login,password);
			for (int f=0; f<films.size(); f++) {
				if(films.get(f).getTitle().equals(title)) {
					if(reviews.isEmpty()) {
						reviews.add(new Review(films.get(f),member,comment,mark));
					}
					for(int j=0 ; j<reviews.size();j++) {
						if(reviews.get(j).getMember().equals(member)) {
							reviews.get(j).setReviewComment(comment);
							}
						if(reviews.get(j).getTitle().equals(title)) {
							nb++;
							total=total+reviews.get(j).getMark();
							}
						}
					reviews.add(new Review(films.get(f),member,comment,mark));
					}
				}
		return total/nb ;
	}

	@Override
	public float reviewItemBook(String login, String password, String title, float mark, String comment)
			throws BadEntryException, NotMemberException, NotItemException {
		float total=0;
		int nb=0;
		Member member=checkPassword(login,password);
			for (int b=0; b<books.size(); b++) {
				if(films.get(b).getTitle().equals(title)) {
					if(reviews.isEmpty()) {
						reviews.add(new Review(books.get(b),member,comment,mark));
					}
					for(int j=0 ; j<reviews.size();j++) {
						if(reviews.get(j).getMember().equals(members.get(i))) {
							reviews.get(j).setReviewComment(comment);
							}
						if(reviews.get(j).getTitle().equals(title)) {
							nb++;
							total=total+reviews.get(j).getMark();
							}
						}
					reviews.add(new Review(books.get(b),member,comment,mark));
					}
				}
		return total/nb ;
	}
	public LinkedList<String> consultItems(String title) throws BadEntryException {
		LinkedList<String> s = new LinkedList<String>();
		for (int b=0; b<books.size(); b++) {
			if(films.get(b).getTitle().equals(title)) {
				s.add("Il y a le film"+books.get(b).getTitle());
			}
		}
		for (int f=0; f<films.size(); f++) {
			if(films.get(f).getTitle().equals(title)) {
				s.add("il y a le livre"+films.get(f).getTitle());
			}
		}
		return s;
	}

}
