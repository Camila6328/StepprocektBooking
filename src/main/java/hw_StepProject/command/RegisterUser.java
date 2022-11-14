package hw_StepProject.command;
import hw_StepProject.additional.Helper;
import hw_StepProject.dao.Dao;
import hw_StepProject.dao.UserDAO;
import hw_StepProject.info.Users;
import java.util.Scanner;
public class RegisterUser {
    Helper hp = new Helper();
    UserDAO ud = new UserDAO();
    Scanner sc = new Scanner(System.in);
    public void register() {
        System.out.print("Enter user Username: ");
        String username = hp.checkText(sc.nextLine(),"Username");
        System.out.print("Enter user password: ");
        String password = sc.nextLine();
        System.out.print("Enter user Name: ");
        String name = hp.checkText(sc.nextLine(),"Name");
        System.out.print("Enter user Surname: ");
        String surname = hp.checkText(sc.nextLine(),"Surname");
        //Users user = new Users(name, surname,username, password);
        Users user = new Users(username, password);
        ud.userLoad(user, Dao.fileU);
        }
}
