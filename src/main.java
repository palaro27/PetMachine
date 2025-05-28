import java.util.Scanner;

public class main {

    private final static Scanner scanner = new Scanner(System.in);
    private final static PetMachine petMachine = new PetMachine();
    public static void main(String[] args) {
        var option = -1;
        do {
            System.out.println("===Escolha uma das opições===");
            System.out.println("1 - Dar banho no pet");
            System.out.println("2 - Abastecer maquina com agua");
            System.out.println("3 - Abastecer maquina com shampoo");
            System.out.println("4 - Verificar agua da maquina");
            System.out.println("5 - Verificar shampoo da maquina");
            System.out.println("6 - Verificar se tem pet no banho");
            System.out.println("7 - Colocar pet na maquina");
            System.out.println("8 - Retirar pet na maquina");
            System.out.println("9 - Limpar maquina");
            System.out.println("0 - Sair");

            option = scanner.nextInt();

            switch (option) {
                case 1 -> petMachine.takeAShower();
                case 2 -> setWater();
                case 3 -> setShampoo();
                case 4 -> verifyWater();
                case 5 -> verifyShampoo();
                case 6 -> checkIfHasPetInMachine();
                case 7 -> setPetInPetMachine();
                case 8 -> petMachine.removePet();
                case 9 -> petMachine.wash();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida");
            }
        }
        while (true);
    }

    private static void setWater(){
        System.out.println("Tentando colocar agua na maquina");
        petMachine.addWater();
    }

    private static void setShampoo(){
        System.out.println("Tentando colocar shampoo na maquina");
        petMachine.addShampoo();
    }

    private static void verifyWater() {
        var amout = petMachine.getWater();
        System.out.println("A maquina está no momento com " + amout + " litros de água");
    }

    private static void verifyShampoo() {
        var amout = petMachine.getShampoo();
        System.out.println("A maquina está no momento com " + amout + " litros de shampoo");
    }

    public static void setPetInPetMachine(){
        var name = "";
        while (name == null || name.isEmpty()) {
            System.out.println("Informe o nome do pet");
            name = scanner.next();
        }
        var pet = new Pet(name);
        petMachine.setPet(pet);
    }

    private static void checkIfHasPetInMachine(){
        var hasPet = petMachine.hasPet();
        System.out.println(hasPet ? "Tem pet na máquina" : "Não tem pet na máquina");
    }
}