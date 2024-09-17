import java.util.Scanner;
import java.util.ArrayList;

public class PetShop {
    private ArrayList<Tutor> tutors = new ArrayList<>();

    public ArrayList<Tutor> getTutors() {
        return this.tutors;
    }
    public void setTutors(ArrayList<Tutor> tutors) {
        this.tutors = tutors;
    }

    public void createTutor(int id, String name, int year, int month, int day, String address){
        Tutor tutor = new Tutor(id,name,year,month, day, address);
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
            String name = tutor.getName();
            int yearBirth = tutor.getYearBirth();
            int monthBirth = tutor.getMonthBirth();
            int dayBirth = tutor.getDayBirth();
            int age = tutor.getAge();

            String address = tutor.getAddress();
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PetShop petshop = new PetShop();
        String option;

        switch (String opcao) {
            case "c":
                boolean stop = false;
                while (!stop) {
                    System.out.println("Digite o nome do tutor (vazio encerra cadastro tutor): ");
                    String name = scanner.nextLine(); 
                    scanner.nextLine();

                    System.out.println("Digite o ano de nascimento do tutor: ");
                    scanner.nextInt();
                    int year = scanner.nextInt(); 
                    scanner.nextLine();

                    System.out.println("Digite o mes de nascimento do tutor: ");
                    int month = scanner.nextInt();
                    scanner.nextInt();

                    System.out.println("Digite o dia de nascimento do tutor: ");
                    int day = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.println("Digite o endereco do tutor/ Pet: ");
                    String address = scanner.nextLine();
                    scanner.nextLine();

                    int id = petshop.getTutors().get(petshop.getTutors().size() - 1).getId() + 1;

                    petshop.createTutor(id, name, year, month, day, address);
                    boolean stopPet = false;

                    while(!stopPet){
                        System.out.println("Digite o nome do pet (vazio encerra cadastro pet): ");
                        String petName = scanner.nextLine();
                        scanner.nextLine();
                        petName = petName.trim();
                        if(petName.length() < 1){
                            System.out.println("Tutor cadastrado");
                        }

                        System.out.println("Digite o tipo do pet: ");
                        String petType = scanner.nextLine();
                        scanner.nextLine();

                        System.out.println("Digite o ano de nascimento do pet: ");
                        scanner.nextInt();
                        int yearPet = scanner.nextInt(); 
                        scanner.nextLine();
    
                        System.out.println("Digite o mes de nascimento do pet: ");
                        int monthPet = scanner.nextInt();
                        scanner.nextInt();
    
                        System.out.println("Digite o dia de nascimento do pet: ");
                        int dayPet = scanner.nextInt();
                        scanner.nextLine(); 
    

                    }
                }
                break;

            default:
                throw new AssertionError();
        }
    }
}