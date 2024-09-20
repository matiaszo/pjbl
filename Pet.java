import java.time.*; // Importa as classes de data e hora

public class Pet { // Define a classe Pet
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

    // Método para obter o nome
    public String getName() {
        return this.name; 
    }

    // Método para definir o nome
    public void setName(String name) {
        this.name = name; 
    }

    // Método para obter o tipo
    public String getType() {
        return type; 
    }

    // Método para definir o tipo
    public void setType(String type) {
        this.type = type; 
    }

    // Método para obter o ano de nascimento
    public int getYearBirth() {
        return this.yearBirth; 
    }

    // Método para definir o ano de nascimento
    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth; 
    }

    // Método para obter o mês de nascimento
    public int getMonthBirth() {
        return this.monthBirth; 
    }

    // Método para definir o mês de nascimento
    public void setMonthBirth(int monthBirth) {
        this.monthBirth = monthBirth; 
    }

    // Método para obter o dia de nascimento
    public int getDayBirth() {
        return this.dayBirth;
    }

    // Método para definir o dia de nascimento
    public void setDayBirth(int dayBirth) {
        this.dayBirth = dayBirth; 
    }

    // Método para obter a idade
    public int getAge(){
        return this.age; 
    }

    // Método para calcular e definir a idade
    public void setAge(){
        LocalDate birthdate = LocalDate.of(getYearBirth(), getMonthBirth(), getDayBirth()); // Cria a data de nascimento
        LocalDate currentDate = LocalDate.now(); // Obtém a data atual

        Period period = Period.between(birthdate, currentDate); // Calcula o período entre as datas
        int age = period.getYears(); // Obtém a idade em anos

        this.age = age; // Define a idade
    }
}
