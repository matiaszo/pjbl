import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;
// import java.time.*;

public class PetShop {
    private ArrayList<Tutor> tutors = new ArrayList<>();

    public ArrayList<Tutor> getTutors() {
        return this.tutors;
    }
    public void setTutors(ArrayList<Tutor> tutors) {
        this.tutors = tutors;
    }

    public void createTutor(int id, String name, int year, int month, int day,int age, String address){
        Tutor tutor = new Tutor(id,name,year,month, day, age, address);
        this.tutors.add(tutor);
    }

    public void addPet(int tutorId, String name, String type, int year, int month, int day){        
        for(Tutor tutor: tutors){
            if(tutor.getId() == tutorId){
                tutor.setPet(name, type, year, month, day);
                break;
            }
        }
    }

    public void printRegister() {
        for (Tutor tutor : tutors) {
            int id = tutor.getId();
            String name = tutor.getName();
            int yearBirth = tutor.getYearBirth();
            int monthBirth = tutor.getMonthBirth();
            int dayBirth = tutor.getDayBirth();
            int age = tutor.getAge();

            String address = tutor.getAddress();
            System.out.println("Codigo do tutor: " + id);
            System.out.println("    Nome: " + name);
            System.out.println("    Data nascimento: " + dayBirth + "/" + monthBirth + "/" + yearBirth + " (" + age + " anos)");
            System.out.println("    Endereco: " + address);
            System.out.println("    Relacao de pets:");

            for (Pet pet : tutor.getPets()) {
                System.out.println(" - Nome do pet: " + pet.getName() +
                "; Tipo: " + pet.getType() +
                "; Data de nascimento: " + pet.getDayBirth() + "/" + pet.getMonthBirth() + "/" + pet.getYearBirth() + " (" + pet.getAge() + " anos)");
            }
        }
        System.out.println();
    }

    public void searchPet(int tutor_id){
        for (Tutor tutor : tutors){
            if (tutor.getId() == tutor_id) {
            String name = tutor.getName();
            int yearBirth = tutor.getYearBirth();
            int monthBirth = tutor.getMonthBirth();
            int dayBirth = tutor.getDayBirth();
            int age = tutor.getAge();

            String address = tutor.getAddress();
            System.out.println("---- Tutor Localizado ------");
            System.out.println("Nome: " + name);
            System.out.println("Data nascimento: " + dayBirth + "/" + monthBirth + "/" + yearBirth + " (" + age + " anos)");
            System.out.println("Endereco: " + address);

            System.out.println("Relação de pets:");

            for (Pet pet : tutor.getPets()) {
                System.out.println("Nome do pet: " + pet.getName() +
                "; Tipo: " + pet.getType() +
                "; Data de nascimento: " + pet.getDayBirth() + "/" + pet.getMonthBirth() + "/" + pet.getYearBirth() + " (" + pet.getAge() + " anos)");
            }
            }
        }
    }

    public boolean deleteTutor(int tutor_id){
        for(Tutor tutor : tutors){
            if (tutor.getId() == tutor_id) {
                tutors.remove(tutor);
                return true;
            }
        }
        return false;
}

    public static void clearBuffer(Scanner scanner){
        if (scanner.hasNextLine()) {
            scanner.nextLine();
            System.out.println("no buffer!!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tutor_id = 0;
        int year = 0;
        int month = 0;
        int day = 0;
        int age = 0;
        PetShop petshop = new PetShop();
        while (true) {
            
        System.out.println("***** ESCOLHER UMA OPCAO *****: ");
        System.out.println("c: cadastrar tutor + pet(s) ");
        System.out.println("i: imprimir cadastro");
        System.out.println("b: buscar pets por codigo tutor");
        System.out.println("e: excluir pets por codigo tutor");
        System.out.println("x: encerrar.");
        
        String option = scanner.next();
        System.out.println("Opcao escolhida: " + option);
        

        switch (option) {

            case "c":
                while (true) {
                    System.out.println("Digite o nome do tutor (vazio encerra cadastro tutor): ");
                    String name = scanner.nextLine(); 
                    
                    name = name.trim();
                    if(name.length() < 1){
                        break;
                    }
                    while (true) {
                        
                        try {
                            System.out.println("Digite o ano de nascimento do tutor: ");
                            year = scanner.nextInt(); 
                            clearBuffer(scanner);
        
                            System.out.println("Digite o mes de nascimento do tutor: ");
                            month = scanner.nextInt();
                            clearBuffer(scanner);
        
                            System.out.println("Digite o dia de nascimento do tutor: ");
                            day = scanner.nextInt();
                            clearBuffer(scanner);
    
                            LocalDate birthdate = LocalDate.of(year, month, year);
                            LocalDate currentDate = LocalDate.now();
        
                            Period period = Period.between(birthdate, currentDate);
                            age = period.getYears(); 
                            break;
                            
                        } catch (Exception e) {
                            System.out.println("Voce precisa digitar uma data valida!");
                            System.out.println("O erro ocorrido foi: "+ e);
                        }
                    }
                    
                    System.out.println("Digite o endereco do tutor/ Pet: ");
                    String address = scanner.nextLine();

                    int id = 0;
                    if (petshop.getTutors().size() == 0) {
                        id = 1;
                    }else{
                     id = petshop.getTutors().get(petshop.getTutors().size() - 1).getId() + 1;
                }
                    petshop.createTutor(id, name, year, month, day, age, address);

                    while(true){
                        System.out.println("Digite o nome do pet (vazio encerra cadastro pet): ");
                        String petName = scanner.nextLine();

                        petName = petName.trim();
                        if(petName.length() < 1){
                            System.out.println("Tutor cadastrado");
                            break;
                        }

                        System.out.println("Digite o tipo do pet: ");
                        String petType = scanner.nextLine();

                        System.out.println("Digite o ano de nascimento do pet: ");
                        int yearPet = scanner.nextInt(); 
                        clearBuffer(scanner);
    
                        System.out.println("Digite o mes de nascimento do pet: ");
                        int monthPet = scanner.nextInt();
                        clearBuffer(scanner);
    
                        System.out.println("Digite o dia de nascimento do pet: ");
                        int dayPet = scanner.nextInt();
                        clearBuffer(scanner);

                        petshop.addPet(id, petName, petType, yearPet, monthPet, dayPet);

                        System.out.println("Pet cadastrado! ");
                        System.out.println();
                }
            }
            break;

            case "i":
                System.out.println("--------CADASTRO DE TUTORES E PETS------------");
                petshop.printRegister();
                System.out.println("----------------------------------------------");
                System.out.println();
                break;

            case "b":
                System.out.println("Digite o codigo do tutor a ser localizado: ");
                tutor_id = scanner.nextInt();
                clearBuffer(scanner);
                petshop.searchPet(tutor_id);
                break;

            case "e":
                System.out.print("Digite o codigo do tutor a ser excluido: ");
                tutor_id = scanner.nextInt();
                clearBuffer(scanner);

                if (petshop.getTutors().size() < tutor_id) {
                    System.out.println("Nao existe um tutor com o id " + tutor_id);
                    System.out.println();
                    break;
                }

                if(petshop.deleteTutor(tutor_id)){
                    System.out.println("--- Tutor (+pets) com codigo "+ tutor_id + " excluido com sucesso! ---");

                }else{
                    System.out.println("Nao existe um tutor com o id " + tutor_id);
                }
                System.out.println();
                break;
            case "x":
                System.out.println("--- Programa de cadastro encerrado ---");
                                        
                System.exit(0);
                System.out.println();
                break;

            default:
            System.out.println("Voce precisa digitar uma das opcoes mostradas!!");
            System.out.println();
            break;
        }
    }
    }
}