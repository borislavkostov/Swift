import java.util.Scanner;

public class Credentials {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Credentials enroll(String user,String pass){
		this.setUsername(user);
		this.setPassword(pass);
		System.out.println("ENROLL SUCCESS");
		return this;	
	}
	public void toString(Scanner input){
		String line = "";
		for (;;) {
			line=input.nextLine();
			String st[] = line.trim().split(" ");
			if(st[0].equals("ENROLL")){
				this.enroll(st[1],st[2]);
			}else if(st[0].equals("CHPASS")){
				if(st[2]!=st[3]){
					this.setPassword(st[3]);
					System.out.println("CHPASS success");
				}else{
					System.out.println("CHPASS fail");
				}
			}else if(st[0].equals("AUTH")){
				if(this.getPassword().equals(st[2])){
					System.out.println("AUTH success");
				}else{
					System.out.println("AUTH fail");
				}
			}else if(st[0].equals("END")){
				break;
			}
		}
	}
}
