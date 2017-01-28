package forum;

import java.time.LocalDateTime;
import java.util.List;
import user.AdminUser;
import user.User;

public class Tema {

    private String name;
    private LocalDateTime date;
    private List<Post> posts;
    private User autor;
    private User closedBy;

    public Tema(String name, LocalDateTime date, User autor) {
        this.name = name;
        this.date = date;
        this.autor = autor;
    }

    public void setPosts(Post post) {
        this.posts.add(post);
    }

    public User getClosedBy() {
        return closedBy;
    }

    public void closeTema(User closedBy) {
        if (closedBy instanceof AdminUser || this.autor == closedBy) {
            this.closedBy = closedBy;
        } else {
            System.out.println("You dont have permission to close this");
        }
    }

    public void changeName(String name, User user) throws Exception {
        if (user instanceof AdminUser || this.autor == user) {
            this.name = name;
        } else {
           throw new Exception("You dont have permission");
        }
    }

    public String getName() {
        return name;
    }
    

}
