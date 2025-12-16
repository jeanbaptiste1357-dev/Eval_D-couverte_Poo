import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Machine m = new Machine();
        while (true) {
            System.out.println("\n0: Quit 1: Insérer 2: Court 3: Long 4: Tech 5: Etat");
            System.out.print("> ");
            String c = in.nextLine().trim();
            if (c.equals("0")) break;
            switch (c) {
                case "1": insertMoney(m); break;
                case "2": System.out.println(m.serve(Recette.COURT)); break;
                case "3": System.out.println(m.serve(Recette.LONG)); break;
                case "4": techMenu(m); break;
                case "5": System.out.println(m.etat()); break;
                default: System.out.println("Choix invalide");
            }
        }
        System.out.println("Au revoir");
    }

    private static void insertMoney(Machine m) {
        System.out.print("Montant: ");
        try { double v = Double.parseDouble(in.nextLine().trim()); System.out.println(m.insert(v)); }
        catch (Exception e) { System.out.println("Montant invalide"); }
    }

    private static void techMenu(Machine m) {
        System.out.println("t: recharge  d: detartrer  r: recup  0: retour");
        System.out.print("> "); String a = in.nextLine().trim();
        if (a.equals("t")) { m.recharge(); System.out.println("Rechargé"); }
        else if (a.equals("d")) { m.detartrer(); System.out.println("Détartré"); }
        else if (a.equals("r")) System.out.printf("Récup: %.2f €\n", m.recupererCaisse());
    }
}
