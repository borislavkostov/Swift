import forum.Post;
import forum.Tema;
import java.time.LocalDate;
import java.time.LocalDateTime;
import user.*;
public class Forum {

    public static void main(String args[]) throws Exception {
        User Alice = new AdminUser("Alice","1231",LocalDateTime.now());
        User Bob = new NormalUser("Bob","231241",LocalDateTime.now());
        User Charlie = new NormalUser("Charlie","41241",LocalDateTime.now());
        Tema bobTema = new Tema("How to draw",LocalDateTime.now(),Bob);
        Post charliePost = new Post(Charlie,"You can't!!!!", LocalDateTime.now(), bobTema);
        bobTema.changeName("How to cook", Bob);
        //bobTema.changeName("You are Stupid !@$#!@%!",Charlie);
        bobTema.changeName("How to cook fish?",Alice);
        System.out.println(bobTema.getName());
        bobTema.closeTema(Bob);
        System.out.println(bobTema.getClosedBy());
    }
}
