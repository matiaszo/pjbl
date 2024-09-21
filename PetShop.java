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
        for (Tutor tutor : tutors) {
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
            System.out.println(
                    "    Data nascimento: " + dayBirth + "/" + monthBirth + "/" + yearBirth + " (" + age + " anos)");
            System.out.println("    Endereco: " + address + "\n");
            System.out.println("    Relacao de pets:");

            // Imprime informações dos pets
            for (Pet pet : tutor.getPets()) {
                System.out.println(" - Nome do pet: " + pet.getName() +
                        "; Tipo: " + pet.getType() +
                        "; Data de nascimento: " + pet.getDayBirth() + "/" + pet.getMonthBirth() + "/"
                        + pet.getYearBirth() + " (" + pet.getAge() + " anos)");
            }
            System.out.println();
        }
    }

    // Método para buscar pets por ID do tutor
    public void searchPet(int tutor_id) {
        boolean localized = false; // variavel criada para verificar se o tutor foi encontrado
        for (Tutor tutor : tutors) {
            if (tutor.getId() == tutor_id) { // verifica se existe um tutor com i id de entrada
                localized = true; 
                String name = tutor.getName();
                int yearBirth = tutor.getYearBirth();
                int monthBirth = tutor.getMonthBirth();
                int dayBirth = tutor.getDayBirth();
                int age = tutor.getAge();
                String address = tutor.getAddress();

                // mostra as informaoees do tutor encontrado
                System.out.println("---- Tutor Localizado ------");
                System.out.println("Nome: " + name);
                System.out.println(
                        "Data nascimento: " + dayBirth + "/" + monthBirth + "/" + yearBirth + " (" + age + " anos)");
                System.out.println("Endereco: " + address);

                // mostra as informações dos pets do tutor encontrado
                System.out.println("Relação de pets:");
                for (Pet pet : tutor.getPets()) {
                    System.out.println("Nome do pet: " + pet.getName() +
                            "; Tipo: " + pet.getType() +
                            "; Data de nascimento: " + pet.getDayBirth() + "/" + pet.getMonthBirth() + "/"
                            + pet.getYearBirth() + " (" + pet.getAge() + " anos)");
                }
            }
        }
        // codigo caso o tutor não for encontrado
        if (!localized) {
            System.out.println("\n-----------------------------------------------");
            System.out.println("Tutor com codigo " + tutor_id + " nao localizado!");
            System.out.println("-----------------------------------------------\n");
            return; // Sai do método
        }
        System.out.println("----------------------------");
        System.out.println();
    }

    // metodo publico criado para excluir um tutor dado um id
    public boolean deleteTutor(int tutor_id) {
        for (Tutor tutor : tutors) { // Percorre a lista de tutores
            if (tutor.getId() == tutor_id) { // Verifica se o ID do tutor corresponde
                tutors.remove(tutor); // remove o tutor da lista(metodo do arraylist)
                return true; 
            }
        }
        return false; 
    }


    // Método principal do programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        int tutor_id = 0;
        int year = 0;
        int month = 0;
        int day = 0;
        int age = 0;
        PetShop petshop = new PetShop();

        // principal(main) parte do programa
        while (true) {
            // mostra as opções para o usuário
            System.out.println("***** ESCOLHER UMA OPCAO *****: ");
            System.out.println("c: cadastrar tutor + pet(s) ");
            System.out.println("i: imprimir cadastro");
            System.out.println("b: buscar pets por codigo tutor");
            System.out.println("e: excluir pets por codigo tutor");
            System.out.println("x: encerrar.");

            String option = scanner.nextLine();
            option = option.toLowerCase(); // Converte o input do usuario para lowerCase
            System.out.println("Opcao escolhida: " + option);

            switch (option) {
                case "c": // Cadastrar tutor e pets
                    while (true) {
                        System.out.println("Digite o nome do tutor (vazio encerra cadastro tutor): ");
                        name = scanner.nextLine().trim().toLowerCase(); // Lê o nome do tutor

                        if (name.isEmpty()) { // Se o nome estiver vazio, encerra o cadastro
                            break;
                        }

                        boolean validDate = false; // variavel criada para verificar a validade da data

                        while (!validDate) { // loop para validar a data de nascimento
                            try {
                                System.out.println("Digite o ano de nascimento do tutor: ");
                                year = Integer.parseInt(scanner.nextLine().trim());

                                System.out.println("Digite o mes de nascimento do tutor: ");
                                month = Integer.parseInt(scanner.nextLine().trim());

                                System.out.println("Digite o dia de nascimento do tutor: ");
                                day = Integer.parseInt(scanner.nextLine().trim());

                                // variaveis criadas para calcular a idade do tutor
                                LocalDate birthdate = LocalDate.of(year, month, day);
                                LocalDate currentDate = LocalDate.now(); // Obtém a data atual

                                Period period = Period.between(birthdate, currentDate); // Calcula a idade
                                age = period.getYears(); 
                                validDate = true; // deixa a variavel 'data' como válida

                            } catch (NumberFormatException e) {
                                System.out.println("Você precisa digitar um número válido para o ano, o mês e o dia. \n");
                            } catch (DateTimeException e) {
                                System.out.println("Data inválida, Tente novamente. \n");
                            }
                        }

                        System.out.println("Digite o endereco do tutor/Pet: "); // Lê o endereço
                        String address = scanner.nextLine();

                        // gera um codigo(id) novo e unico para o tutor
                        int id = petshop.getTutors().size() == 0 ? 1: petshop.getTutors().get(petshop.getTutors().size() - 1).getId() + 1;

                        petshop.createTutor(id, name, year, month, day, age, address); 

                        while (true) { // loop para cadastrar os pets do tutor
                            System.out.println("Digite o nome do pet (vazio encerra cadastro pet): ");
                            String petName = scanner.nextLine().trim(); 

                            if (petName.isEmpty()) { // se o nome estiver vazio, encerra o cadastro do tutor
                                System.out.println("Tutor cadastrado \n");
                                break;
                            }

                            System.out.println("Digite o tipo do pet: "); // Lê o tipo do pet
                            String petType = scanner.nextLine().trim();

                            int yearPet = 0, monthPet = 0, dayPet = 0; // Variáveis para a data de nascimento do pet
                            boolean validPetDate = false; // variavel(flag) criada para verificar a validade da data do pet

                            while (!validPetDate) { // Loop para validar a data do pet
                                try {
                                    System.out.println("Digite o ano de nascimento do pet: ");
                                    yearPet = Integer.parseInt(scanner.nextLine().trim());

                                    System.out.println("Digite o mes de nascimento do pet: ");
                                    monthPet = Integer.parseInt(scanner.nextLine().trim());

                                    System.out.println("Digite o dia de nascimento do pet: ");
                                    dayPet = Integer.parseInt(scanner.nextLine().trim());

                                    // variavel criada para verificar a validade da data, nao eh utilizada, mas eh necessaria para o funcionamento do programa
                                    LocalDate petBirthdate = LocalDate.of(yearPet, monthPet, dayPet); 
                                    validPetDate = true; // Marca a data como válida

                                } catch (NumberFormatException e) {
                                    System.out.println(
                                            "Você precisa digitar um número válido para o ano, mês e dia do pet!\n");
                                } catch (DateTimeException e) {
                                    System.out.println("Data inválida para o pet! Tente novamente.\n");
                                }
                            }

                            petshop.addPet(id, petName, petType, yearPet, monthPet, dayPet); // Adiciona o pet ao tutor
                            System.out.println("Pet cadastrado!\n");
                        }
                    }
                    break;

                case "i": // mostra o cadastro de todos os tutores
                    System.out.println("--------CADASTRO DE TUTORES E PETS------------");
                    petshop.printRegister(); // chama o método para imprimir o registro
                    System.out.println("----------------------------------------------");
                    System.out.println();
                    break;

                case "b": // procura um tutor pelo seu id
                    boolean validCodeLocalize = false; // variavel(flag) para verificar a validade do código
                    while (!validCodeLocalize) {
                        try {
                            System.out.println("Digite o codigo do tutor a ser localizado: ");
                            tutor_id = Integer.parseInt(scanner.nextLine().trim()); // Lê o ID do tutor
                            petshop.searchPet(tutor_id); 
                            validCodeLocalize = true; // Marca o código(id) como válido
                            break;

                        } catch (Exception e) {
                            System.out.println("\n-------------------------------");
                            System.out.println("Voce precisa digitar um numero!");
                            System.out.println("-------------------------------\n");
                            break;
                        }
                    }
                    break;

                    case "e": // Excluir tutor
                    boolean validCodeDelete = false; 
                    while (!validCodeDelete) {
                        try {
                            System.out.print("Digite o código do tutor a ser excluído: ");
                            tutor_id = Integer.parseInt(scanner.nextLine().trim()); // Lê o ID do tutor
                
                            boolean tutorExists = false;
                            
                            // Verifica se o tutor existe pelo ID percorrendo a lista
                            for (Tutor t : petshop.getTutors()) {
                                if (t.getId() == tutor_id) {
                                    tutorExists = true;
                                    break;
                                }
                            }
                
                            // Se o tutor existe, o programa tenta excluir ele
                            if (tutorExists) {
                                if (petshop.deleteTutor(tutor_id)) { // Tenta excluir o tutor
                                    System.out.println("\n--- Tutor (+pets) com código " + tutor_id + " excluído com sucesso! ---\n");
                                    validCodeDelete = true; 
                                } else {
                                    System.out.println("\nErro ao excluir tutor com o id " + tutor_id + "!!\n");
                                    break;
                                }
                            } else {
                                System.out.println("\nNão existe um tutor com o id " + tutor_id + "!!\n");
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("--------------------------------------");
                            System.out.println("Você precisa digitar um número válido!");
                            System.out.println("--------------------------------------\n");
                            break;
                        }
                    }
                    break;
                

                case "x": // Encerrar o programa
                    System.out.println("--- Programa de cadastro encerrado ---");
                    System.exit(0); // Sai do programa
                    System.out.println();
                    scanner.close(); // fecha o scanner
                    break;

                default: // o programa vai cair aqui caso a entrada nao seja valida
                    System.out.println("Voce precisa digitar uma das opcoes mostradas!!");
                    System.out.println();
                    break;
            }
        }
    }
}
