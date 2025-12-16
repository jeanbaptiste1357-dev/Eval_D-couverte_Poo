import java.util.Scanner;

/** Interface en ligne de commande pour la machine. */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Machine machine = new Machine();
        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "0":
                    running = false;
                    break;
                case "1":
                    handleInsertMoney(machine);
                    break;
                case "2":
                    System.out.println(machine.servir(Recette.CAFE_COURT));
                    break;
                case "3":
                    System.out.println(machine.servir(Recette.CAFE_LONG));
                    break;
                case "4":
                    handleTechnicianMenu(machine);
                    break;
                case "5":
                    System.out.println(machine.etat());
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }

        System.out.println("Au revoir");
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("--- MACHINE A CAFE ---");
        System.out.println("1. Insérer de la monnaie");
        System.out.println("2. Café Court (1.50 €)");
        System.out.println("3. Café Long  (2.00 €)");
        System.out.println("4. Menu Technicien");
        System.out.println("5. Afficher état");
        System.out.println("0. Quitter");
        System.out.print("Choix > ");
    }

    private static void handleInsertMoney(Machine machine) {
        System.out.print("Montant (ex: 1.50) > ");
        String line = scanner.nextLine().trim();
        try {
            double montant = Double.parseDouble(line);
            System.out.println(machine.insererMonnaie(montant));
        } catch (NumberFormatException e) {
            System.out.println("Montant invalide");
        }
    }

    private static void handleTechnicianMenu(Machine machine) {
        System.out.println();
        System.out.println("--- MENU TECHNICIEN ---");
        System.out.println("1. Recharger (Eau, Grains, Gobelets)");
        System.out.println("2. Détartrer (remet compteur à 0)");
        System.out.println("3. Récupérer l'argent (affiche et remet à 0)");
        System.out.println("0. Retour");
        System.out.print("Choix tech > ");

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
                double montant = machine.recupererCaisse();
                System.out.printf("Montant récupéré : %.2f €\n", montant);
                break;
            case "0":
                break;
            default:
                System.out.println("Choix invalide");
        }
    }
}
