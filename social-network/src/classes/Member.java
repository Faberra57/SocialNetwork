package classes;
public class Member {
	
	private String login;
	private String password;
	private String description;
	
	public Member(String login,String password,String description) {
		this.login=login;
		this.password=password;
		this.description=description;
	}
	
	public String toString() {
		return "Utilisateur :"+login;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean equals(Object o) {
		return o instanceof Member && this.login.equals(((Member) o).login) && this.password.equals(((Member) o).password);
	}
}
