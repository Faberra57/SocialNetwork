package opinion;

public class Member {
	
	private String login;
	private String password;
	private String description;
	
	public Member(String login,String password,String description) {
		this.login=login;
		this.password=password;
		this.description=description;
	}
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	public String toString() {
		return "Le nom de l'utilisateur est"+login+"et sa description est"+description;
	}
}
