
import java.util.ArrayList;

public class Tutor {
    private String name;
    private String address;
    private int yearBirth;
    private int monthBirth;
    private int dayBirth;
    private int age;
    private int id;
    private ArrayList<Pet> pets = new ArrayList<>();

    public Tutor(int id, String name, int year, int month, int day, int age, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.yearBirth = year;
        this.monthBirth = month;
        this.dayBirth = day;
        this.age = age;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
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
