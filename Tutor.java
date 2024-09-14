import java.time.*;
import java.util.ArrayList;


public class Tutor {
    private String name;
    private String address;
    private int yearBirth;
    private int monthBirth;
    private int dayBirth;
    private int age;
    private ArrayList<Pet> pets = new ArrayList<Pet>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getYearBirth() {
        return this.yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }
    public int getMonthBirth() {
        return this.monthBirth;
    }

    public void setMonthBirth(int monthBirth) {
        this.monthBirth = monthBirth;
    }
    public int getDayBirth() {
        return this.dayBirth;
    }

    public void setDayBirth(int dayBirth) {
        this.dayBirth = dayBirth;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(){
        LocalDate birthdate = LocalDate.of(getYearBirth(), getMonthBirth(), getDayBirth());
        LocalDate currentDate = LocalDate.now();

        Period period = Period.between(birthdate, currentDate);
        int age = period.getYears();    

        this.age = age;
    }

    public void setPet(String name, String type, int yearBirth, int monthBirth, int dayBirth) {
        Pet pet = new Pet(name, type, yearBirth, monthBirth, dayBirth);
        pets.add(pet);
    }

    public ArrayList<Pet> getPets() {
        return this.pets;
    }
}
