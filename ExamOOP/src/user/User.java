package user;

import java.time.LocalDateTime;

public class User {

    private String name;
    private String pass;
    private LocalDateTime registrationDate;

    public User(String name, String pass, LocalDateTime registrationDate) {
        this.name = name;
        this.pass = pass;
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return new String (this.getName());
    }
    
}
