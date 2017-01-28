
package user;

import java.time.LocalDateTime;


public class AdminUser extends User {
    
    public AdminUser(String name, String pass, LocalDateTime registrationDate) {
        super(name, pass, registrationDate);
    }
    
}
