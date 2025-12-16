import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Machine machine = new Machine();
        boolean running = true;

        while (running) {
            System.out.println("\n--- MACHINE A CAFE - MENU ---");
            System.out.println("1. Insérer de la monnaie");
            System.out.println("2. Commander : Café Court (1.50 €)");
            System.out.println("3. Commander : Café Long (2.00 €)");
            System.out.println("4. Menu Technicien");
            System.out.println("5. Afficher état machine");
            System.out.println("0. Quitter");
            System.out.print("Choix > ");

            String choix = scanner.nextLine().trim();
            switch (choix) {
                case "1":
                    System.out.print("Montant à insérer (ex: 1.50) > ");
                    try {
                        double montant = Double.parseDouble(scanner.nextLine().trim());
                        System.out.println(machine.insererMonnaie(montant));
                    } catch (NumberFormatException e) {
                        System.out.println("Montant invalide");
                    }
                    break;
                case "2":
                    System.out.println(machine.servir(Recette.CAFE_COURT));
                    break;
                case "3":
                    System.out.println(machine.servir(Recette.CAFE_LONG));
                    break;
                case "4":
                    menuTechnicien(machine);
                    break;
                case "5":
                    System.out.println(machine.etat());
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }

        System.out.println("Au revoir !");
    }

    private static void menuTechnicien(Machine machine) {
        boolean enTech = true;
        while (enTech) {
            System.out.println("\n--- MENU TECHNICIEN ---");
            System.out.println("1. Recharger (Eau, Grains, Gobelets)");
            System.out.println("2. Détartrer (remet compteur à 0)");
            System.out.println("3. Récupérer l'argent (affiche et remet à 0)");
            System.out.println("0. Retour");
            System.out.print("Choix Tech > ");

            String c = scanner.nextLine().trim();
            switch (c) {
                case "1":
                    machine.recharger();
                    System.out.println("Rechargement effectué");
                    break;
                case "2":
                    machine.detartrer();
                    System.out.println("Machine détartrée");
                    break;
                case "3":
                    double recup = machine.recupererCaisse();
                    System.out.printf("Montant récupéré : %.2f €\n", recup);
                    break;
                case "0":
                    enTech = false;
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }
    }
}
