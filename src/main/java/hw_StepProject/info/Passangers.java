package hw_StepProject.info;

public class Passangers {
    String name;
    String surname;
    String passportNo;

    public Passangers() {}
    public Passangers(String name, String surname, String passportNo) {
        this.name = name;
        this.surname = surname;
        this.passportNo = passportNo;
    }
    public Passangers(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public String toStringAll() {
        return "Passangers{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passportNo='" + passportNo + '\'' +
                '}';
    }
    @Override
    public String toString() {
        return "Passanger: " + name.toUpperCase() + " " + surname.toUpperCase();
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
    public String getPassportNo() {
        return passportNo;
    }
    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }
}
