import java.util.ArrayList;

public class PetShop {
    private ArrayList<Tutor> tutors = new ArrayList<>();

    public ArrayList<Tutor> getTutors() {
        return this.tutors;
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
        PetShop petshop = new PetShop();
    }
}