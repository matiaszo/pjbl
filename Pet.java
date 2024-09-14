import java.time.*;

public class Pet {
    private String name;
    private String type;
    private int yearBirth;
    private int monthBirth;
    private int dayBirth;
    private int age;

    public Pet(String name, String type, int yearBirth, int monthBirth, int dayBirth) {
        setName(name);
        setType(type);
        setYearBirth(yearBirth);
        setMonthBirth(monthBirth);
        setDayBirth(dayBirth);
        setAge();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}