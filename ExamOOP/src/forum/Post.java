package forum;

import java.time.LocalDateTime;
import user.User;

public class Post {

    private User user;
    private String content;
    private LocalDateTime dateOfPost;
    private Tema tema;

    public Post(User user, String content, LocalDateTime dateOfPost, Tema tema) {
        this.user = user;
        this.content = content;
        this.dateOfPost = dateOfPost;
        this.tema = tema;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDateOfPost() {
        return dateOfPost;
    }

    public Tema getTema() {
        return tema;
    }

    public User getUser() {
        return user;
    }

    public void changeContent(String content,User user) throws Exception {
        if(user==this.user){
        this.content = content;
        }else{
            System.out.println("You don't have permission to change post content");
        }
        throw new Exception("You dont have permission");
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public void setDateOfPost(LocalDateTime dateOfPost) {
        this.dateOfPost = dateOfPost;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
