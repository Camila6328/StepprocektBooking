package hw_StepProject.info;

public class Users {
    String username;
    String name;
    String surname;
    String password;



    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Users(String name, String surname,String username, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "username= " + getUsername() +
                ", password= " + getPassword() +
                '}'+"\n";
    }


    public String toString1() {
        return "UsersInfo{" +
                "name= " + getName() +
                ", surname= " + getSurname() +
                '}'+"\n";
    }
}
