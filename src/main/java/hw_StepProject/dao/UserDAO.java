package hw_StepProject.dao;

import hw_StepProject.additional.Helper;
import hw_StepProject.info.Users;
import java.io.*;
public class UserDAO {
    Helper hp = new Helper();
    public void userLoad(Users user, File file) {
        try (FileOutputStream fs = new FileOutputStream(file,true);
             BufferedOutputStream bs = new BufferedOutputStream(fs);
             ObjectOutputStream os = new ObjectOutputStream(bs);
        ) {
            if (hp.checkExisting(user,file)==false) {
                os.writeObject(user.toString());//+ " " + user.toString())
                hp.userList.add(user);
                System.out.println("User succesfully registated");
            } else {
                System.out.println("Please enter not existing user or change login panel : ");
                os.writeObject("Users{}"+"\n");
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
