import java.time.*; // Importa as classes de data e hora

public class Pet { 
    private String name; 
    private String type; 
    private int yearBirth; 
    private int monthBirth;
    private int dayBirth; 
    private int age; 

    // Construtor da classe Pet, com seus atributos
    public Pet(String name, String type, int yearBirth, int monthBirth, int dayBirth) {
        setName(name); 
        setType(type); 
        setYearBirth(yearBirth); 
        setMonthBirth(monthBirth); 
        setDayBirth(dayBirth);
        setAge(); 
    }

    // getters e setters para definir e obter o nome do pet
    public String getName() {
        return this.name; 
    }

    public void setName(String name) {
        this.name = name; 
    }

    // getters e setters para definir e obter o tipo do pet
    public String getType() {
        return type; 
    }

    public void setType(String type) {
        this.type = type; 
    }

    // getters e setters para definir e obter o ano de nascimento do pet
    public int getYearBirth() {
        return this.yearBirth; 
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth; 
    }

    // getters e setters para definir e obter o mes de nascimento do pet
    public int getMonthBirth() {
        return this.monthBirth; 
    }


    public void setMonthBirth(int monthBirth) {
        this.monthBirth = monthBirth; 
    }

    // getters e setters para definir e obter o dia de nascimento do pet
    public int getDayBirth() {
        return this.dayBirth;
    }

    public void setDayBirth(int dayBirth) {
        this.dayBirth = dayBirth; 
    }

    // getters e setters para definir e obter a idade do pet
    public int getAge(){
        return this.age; 
    }

    public void setAge(){
        LocalDate birthdate = LocalDate.of(getYearBirth(), getMonthBirth(), getDayBirth()); 
        LocalDate currentDate = LocalDate.now(); // obtem a data atual

        Period period = Period.between(birthdate, currentDate); 
        int age = period.getYears(); // obtem a idade em anos

        this.age = age; // define a idade do pet
    }
}
