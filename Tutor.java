import java.util.ArrayList; // Importa a classe ArrayList para criar a lista de pets

public class Tutor { 
    private String name; 
    private String address;
    private int yearBirth; 
    private int monthBirth;
    private int dayBirth; 
    private int age; 
    private int id; 
    private ArrayList<Pet> pets = new ArrayList<>(); // Lista de pets do tutor

    // Construtor da classe Tutor, com seus atributos
    public Tutor(int id, String name, int year, int month, int day, int age, String address) {
        this.id = id; 
        this.name = name; 
        this.address = address; 
        this.yearBirth = year; 
        this.monthBirth = month; 
        this.dayBirth = day; 
        this.age = age; 
    }

    // getters e setters para obter e definir o ID do tutor
    public int getId() {
        return this.id; 
    }

    public void setId(int id) {
        this.id = id; 
    }

    // getters e setters para obter e definir o nome do tutor
    public String getName() {
        return name; 
    }

    public void setName(String name) {
        this.name = name; 
    }

    // getters e setters para obter e definir o endereço do tutor
    public String getAddress() {
        return address; 
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // metodos para obter e definir a data de nascimento do tutor
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

    // getters e setters para obter e definir a idade do tutor
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age; 
    }

    // Método para adicionar um pet ao tutor
    public void setPet(String name, String type, int yearBirth, int monthBirth, int dayBirth) {
        Pet pet = new Pet(name, type, yearBirth, monthBirth, dayBirth); // chama o construtor da classe Pet
        pets.add(pet); // Adiciona o pet à lista de pets do tutor
    }

    // getter para obter a lista de pets do tutor
    public ArrayList<Pet> getPets() {
        return this.pets; 
    }
}
