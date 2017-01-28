package user;

import java.time.LocalDateTime;

public class NormalUser extends User {

    public NormalUser(String name, String pass, LocalDateTime registrationDate) {
        super(name, pass, registrationDate);
    }

}
