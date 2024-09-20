import java.time.DateTimeException; // Importa exceção para tratar erros de data
import java.time.LocalDate; // Importa a classe para trabalhar com datas
import java.time.Period; // Importa a classe para calcular períodos entre datas
import java.util.ArrayList; // Importa a classe ArrayList para listas dinâmicas
import java.util.Scanner; // Importa a classe Scanner para entrada de dados

public class PetShop { // Define a classe PetShop
    private ArrayList<Tutor> tutors = new ArrayList<>(); // Lista de tutores

    // Método para obter a lista de tutores
    public ArrayList<Tutor> getTutors() {
        return this.tutors; // Retorna a lista de tutores
    }

    // Método para definir a lista de tutores
    public void setTutors(ArrayList<Tutor> tutors) {
        this.tutors = tutors; // Atualiza a lista de tutores
    }

    // Método para criar um novo tutor
    public void createTutor(int id, String name, int year, int month, int day, int age, String address) {
        Tutor tutor = new Tutor(id, name, year, month, day, age, address); // Cria um novo objeto Tutor
        this.tutors.add(tutor); // Adiciona o tutor à lista
    }

    // Método para adicionar um pet a um tutor
    public void addPet(int tutorId, String name, String type, int year, int month, int day) {        
        for (Tutor tutor : tutors) { // Percorre a lista de tutores
            if (tutor.getId() == tutorId) { // Verifica se o ID do tutor corresponde
                tutor.setPet(name, type, year, month, day); // Adiciona o pet ao tutor
                break; // Sai do loop após adicionar o pet
            }
        }
    }

    // Método para imprimir o registro de tutores e pets
    public void printRegister() {
        for (Tutor tutor : tutors) { // Percorre a lista de tutores
            int id = tutor.getId();
            String name = tutor.getName();
            int yearBirth = tutor.getYearBirth();
            int monthBirth = tutor.getMonthBirth();
            int dayBirth = tutor.getDayBirth();
            int age = tutor.getAge();
            String address = tutor.getAddress();

            // Imprime informações do tutor
            System.out.println("Codigo do tutor: " + id);
            System.out.println("    Nome: " + name);
            System.out.println("    Data nascimento: " + dayBirth + "/" + monthBirth + "/" + yearBirth + " (" + age + " anos)");
            System.out.println("    Endereco: " + address + "\n");
            System.out.println("    Relacao de pets:");

            // Imprime informações dos pets
            for (Pet pet : tutor.getPets()) {
                System.out.println(" - Nome do pet: " + pet.getName() +
                "; Tipo: " + pet.getType() +
                "; Data de nascimento: " + pet.getDayBirth() + "/" + pet.getMonthBirth() + "/" + pet.getYearBirth() + " (" + pet.getAge() + " anos)");
            }
            System.out.println();    
            System.out.println();    
        }
    }

    // Método para buscar pets por ID do tutor
    public void searchPet(int tutor_id) {
        boolean localized = false; // Flag para verificar se o tutor foi encontrado
        for (Tutor tutor : tutors) { // Percorre a lista de tutores
            if (tutor.getId() == tutor_id) { // Verifica se o ID do tutor corresponde
                localized = true; // Marca que o tutor foi encontrado
                String name = tutor.getName();
                int yearBirth = tutor.getYearBirth();
                int monthBirth = tutor.getMonthBirth();
                int dayBirth = tutor.getDayBirth();
                int age = tutor.getAge();
                String address = tutor.getAddress();

                // Imprime informações do tutor encontrado
                System.out.println("---- Tutor Localizado ------");
                System.out.println("Nome: " + name);
                System.out.println("Data nascimento: " + dayBirth + "/" + monthBirth + "/" + yearBirth + " (" + age + " anos)");
                System.out.println("Endereco: " + address);
                
                // Imprime informações dos pets do tutor
                System.out.println("Relação de pets:");
                for (Pet pet : tutor.getPets()) {
                    System.out.println("Nome do pet: " + pet.getName() +
                    "; Tipo: " + pet.getType() +
                    "; Data de nascimento: " + pet.getDayBirth() + "/" + pet.getMonthBirth() + "/" + pet.getYearBirth() + " (" + pet.getAge() + " anos)");
                }
            }
        }
        // Se o tutor não for encontrado
        if (!localized) {
            System.out.println("\n-----------------------------------------------");
            System.out.println("Tutor com codigo " + tutor_id + " nao localizado!");
            System.out.println("-----------------------------------------------\n");
            return; // Sai do método
        }
        System.out.println("----------------------------");
        System.out.println();
    }

    // Método para excluir um tutor
    public boolean deleteTutor(int tutor_id) {
        for (Tutor tutor : tutors) { // Percorre a lista de tutores
            if (tutor.getId() == tutor_id) { // Verifica se o ID do tutor corresponde
                tutors.remove(tutor); // Remove o tutor da lista
                return true; // Retorna verdadeiro se o tutor foi excluído
            }
        }
        return false; // Retorna falso se o tutor não foi encontrado
    }

    // Método para limpar o buffer do Scanner
    public static void clearBuffer(Scanner scanner) {
        System.out.println("antes do input");
        if (scanner.hasNextLine()) {
            scanner.nextLine(); // Limpa o buffer de entrada
            System.out.println("no buffer!!");
        }
    }

    // Método principal do programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para entrada de dados
        String name = ""; // Variável para armazenar o nome do tutor
        int tutor_id = 0; // Variável para armazenar o ID do tutor
        int year = 0; // Variável para armazenar o ano de nascimento
        int month = 0; // Variável para armazenar o mês de nascimento
        int day = 0; // Variável para armazenar o dia de nascimento
        int age = 0; // Variável para armazenar a idade
        PetShop petshop = new PetShop(); // Cria um novo objeto PetShop

        // Loop principal do programa
        while (true) {
            // Exibe opções para o usuário
            System.out.println("***** ESCOLHER UMA OPCAO *****: ");
            System.out.println("c: cadastrar tutor + pet(s) ");
            System.out.println("i: imprimir cadastro");
            System.out.println("b: buscar pets por codigo tutor");
            System.out.println("e: excluir pets por codigo tutor");
            System.out.println("x: encerrar.");
            
            String option = scanner.nextLine(); // Lê a opção do usuário
            option = option.toLowerCase(); // Converte para minúsculas
            System.out.println("Opcao escolhida: " + option);

            switch (option) {
                case "c": // Cadastrar tutor e pets
                    while (true) {
                        System.out.println("Digite o nome do tutor (vazio encerra cadastro tutor): ");
                        name = scanner.nextLine().trim().toLowerCase(); // Lê o nome do tutor

                        if (name.isEmpty()) { // Se o nome estiver vazio, encerra o cadastro
                            break; 
                        }

                        boolean validDate = false; // Flag para verificar a validade da data

                        while (!validDate) { // Loop para validar a data de nascimento
                            try {
                                System.out.println("Digite o ano de nascimento do tutor: ");
                                year = Integer.parseInt(scanner.nextLine().trim());

                                System.out.println("Digite o mes de nascimento do tutor: ");
                                month = Integer.parseInt(scanner.nextLine().trim());

                                System.out.println("Digite o dia de nascimento do tutor: ");
                                day = Integer.parseInt(scanner.nextLine().trim());

                                // Cria um objeto LocalDate para verificar a validade da data
                                LocalDate birthdate = LocalDate.of(year, month, day);
                                LocalDate currentDate = LocalDate.now(); // Obtém a data atual

                                Period period = Period.between(birthdate, currentDate); // Calcula a idade
                                age = period.getYears(); // Obtém a idade
                                validDate = true; // Marca a data como válida

                            } catch (NumberFormatException e) {
                                System.out.println("Você precisa digitar um número válido para o ano, o mês e o dia. \n");
                            } catch (DateTimeException e) {
                                System.out.println("Data inválida, Tente novamente. \n");
                            }
                        }

                        System.out.println("Digite o endereco do tutor/Pet: "); // Lê o endereço
                        String address = scanner.nextLine();

                        // Gera um novo ID para o tutor
                        int id = petshop.getTutors().size() == 0 ? 1 : petshop.getTutors().get(petshop.getTutors().size() - 1).getId() + 1;

                        petshop.createTutor(id, name, year, month, day, age, address); // Cria o tutor

                        while (true) { // Loop para cadastrar pets
                            System.out.println("Digite o nome do pet (vazio encerra cadastro pet): ");
                            String petName = scanner.nextLine().trim(); // Lê o nome do pet

                            if (petName.isEmpty()) { // Se o nome estiver vazio, encerra o cadastro
                                System.out.println("Tutor cadastrado \n");
                                break;
                            }

                            System.out.println("Digite o tipo do pet: "); // Lê o tipo do pet
                            String petType = scanner.nextLine().trim();

                            int yearPet = 0, monthPet = 0, dayPet = 0; // Variáveis para a data de nascimento do pet
                            boolean validPetDate = false; // Flag para verificar a validade da data do pet

                            while (!validPetDate) { // Loop para validar a data do pet
                                try {
                                    System.out.println("Digite o ano de nascimento do pet: ");
                                    yearPet = Integer.parseInt(scanner.nextLine().trim());

                                    System.out.println("Digite o mes de nascimento do pet: ");
                                    monthPet = Integer.parseInt(scanner.nextLine().trim());

                                    System.out.println("Digite o dia de nascimento do pet: ");
                                    dayPet = Integer.parseInt(scanner.nextLine().trim());

                                    // Cria um objeto LocalDate para verificar a validade da data do pet
                                    LocalDate petBirthdate = LocalDate.of(yearPet, monthPet, dayPet);
                                    validPetDate = true; // Marca a data como válida

                                } catch (NumberFormatException e) {
                                    System.out.println("Você precisa digitar um número válido para o ano, mês e dia do pet!\n");
                                } catch (DateTimeException e) {
                                    System.out.println("Data inválida para o pet! Tente novamente.\n");
                                }
                            }

                            petshop.addPet(id, petName, petType, yearPet, monthPet, dayPet); // Adiciona o pet ao tutor
                            System.out.println("Pet cadastrado!\n");
                        }
                    }
                    break;

                case "i": // Imprimir cadastro
                    System.out.println("--------CADASTRO DE TUTORES E PETS------------");
                    petshop.printRegister(); // Chama o método para imprimir o registro
                    System.out.println("----------------------------------------------");
                    System.out.println();
                    break;

                case "b": // Buscar pets por código do tutor
                    boolean validCodeLocalize = false; // Flag para verificar a validade do código
                    while (!validCodeLocalize) {
                        try {
                            System.out.println("Digite o codigo do tutor a ser localizado: ");
                            tutor_id = Integer.parseInt(scanner.nextLine().trim()); // Lê o ID do tutor
                            petshop.searchPet(tutor_id); // Chama o método para buscar o tutor
                            validCodeLocalize = true; // Marca o código como válido
                            break;
                            
                        } catch (Exception e) {
                            System.out.println("\n-------------------------------");
                            System.out.println("Voce precisa digitar um numero!");
                            System.out.println("-------------------------------\n");
                        }
                    }
                    break;

                case "e": // Excluir tutor
                    boolean validCodeDelete = false; // Flag para verificar a validade do código de exclusão
                    while (!validCodeDelete) {
                        try {
                            System.out.print("Digite o codigo do tutor a ser excluido: ");
                            tutor_id = Integer.parseInt(scanner.nextLine().trim()); // Lê o ID do tutor

                            // Verifica se o código é válido
                            if (petshop.getTutors().size() < tutor_id || tutor_id == 0) {
                                if (petshop.deleteTutor(tutor_id)) { // Tenta excluir o tutor
                                    System.out.println("--- Tutor (+pets) com codigo "+ tutor_id + " excluido com sucesso! ---");
                                } else {
                                    System.out.println("\nNao existe um tutor com o id " + tutor_id + "!!\n");
                                }
                                System.out.println();
                                validCodeDelete = true; // Marca o código como válido
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("-------------------------------");
                            System.out.println("Voce precisa digitar um numero!");
                            System.out.println("-------------------------------\n");
                        }
                    }
                    break;

                case "x": // Encerrar o programa
                    System.out.println("--- Programa de cadastro encerrado ---");
                    System.exit(0); // Sai do programa
                    System.out.println();
                    scanner.close(); // Fecha o scanner
                    break;

                default: // Opção inválida
                    System.out.println("Voce precisa digitar uma das opcoes mostradas!!");
                    System.out.println();
                    break;
            }
        }
    }
}
