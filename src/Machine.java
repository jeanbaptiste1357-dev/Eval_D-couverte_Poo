public class Machine {
    private static final int MAX_EAU = 100, MAX_GRAINS = 50, MAX_GOBELETS = 10, USURE = 5;

    private int eau = MAX_EAU, grains = MAX_GRAINS, gobelets = MAX_GOBELETS, compteur = 0;
    private double credit = 0.0, caisse = 0.0;

    public String insert(double montant) {
        if (montant <= 0) return "Montant invalide";
        credit += montant; return String.format("Crédit: %.2f €", credit);
    }

    public String serve(Recette r) {
        if (compteur >= USURE) return "ERREUR : Machine entartrée - Appelez le technicien";
        if (credit < r.prix) return "Crédit insuffisant, ajoutez de la monnaie";
        if (eau < r.eau) return "Plus d'eau !";
        if (grains < r.grains) return "Plus de grains !";
        if (gobelets < r.gobelets) return "Plus de gobelets !";
        eau -= r.eau; grains -= r.grains; gobelets -= r.gobelets;
        credit -= r.prix; caisse += r.prix; compteur++;
        return "Votre café est prêt !";
    }

    public void recharge() { eau = MAX_EAU; grains = MAX_GRAINS; gobelets = MAX_GOBELETS; }
    public void detartrer() { compteur = 0; }
    public double recupererCaisse() { double t = caisse; caisse = 0; return t; }

    public String etat() {
        return String.format("E:%d/%d G:%d/%d Gb:%d/%d U:%d C:%.2f Cr:%.2f",
            eau, MAX_EAU, grains, MAX_GRAINS, gobelets, MAX_GOBELETS, compteur, caisse, credit);
    }
}
