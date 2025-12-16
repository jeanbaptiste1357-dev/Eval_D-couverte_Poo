/**
 * Machine à café : gère les stocks, le crédit et l'usure.
 */
public class Machine {
    // Capacités et limites
    private static final int MAX_EAU = 100;       // cl
    private static final int MAX_GRAINS = 50;     // g
    private static final int MAX_GOBELETS = 10;   // unités
    private static final int USURE_MAX = 5;       // cafés avant entartrage

    // État interne
    private int eau;           // cl
    private int grains;        // g
    private int gobelets;      // unités
    private int compteurCafes; // nb de cafés servis

    private double credit;     // montant inséré non dépensé
    private double caisse;     // total encaissé

    public Machine() {
        this.eau = MAX_EAU;
        this.grains = MAX_GRAINS;
        this.gobelets = MAX_GOBELETS;
        this.compteurCafes = 0;
        this.credit = 0.0;
        this.caisse = 0.0;
    }

    /** Insérer de la monnaie */
    public String insererMonnaie(double montant) {
        if (montant <= 0) {
            return "Montant invalide";
        }
        credit += montant;
        return String.format("Crédit : %.2f €", credit);
    }

    /** Tenter de servir une recette. Retourne un message résultat. */
    public String servir(Recette recette) {
        if (compteurCafes >= USURE_MAX) {
            return "ERREUR : Machine entartrée - Appelez le technicien";
        }

        if (credit < recette.prix) {
            return "Crédit insuffisant, ajoutez de la monnaie";
        }

        if (eau < recette.eauCl) return "Plus d'eau !";
        if (grains < recette.grainsG) return "Plus de grains !";
        if (gobelets < recette.gobelets) return "Plus de gobelets !";

        // Consommer les ressources et mettre à jour les compteurs
        eau -= recette.eauCl;
        grains -= recette.grainsG;
        gobelets -= recette.gobelets;
        credit -= recette.prix;
        caisse += recette.prix;
        compteurCafes++;

        return "Votre café est prêt !";
    }

    // Opérations technicien
    public void recharger() {
        this.eau = MAX_EAU;
        this.grains = MAX_GRAINS;
        this.gobelets = MAX_GOBELETS;
    }

    public void detartrer() { this.compteurCafes = 0; }

    public double recupererCaisse() {
        double montant = this.caisse;
        this.caisse = 0.0;
        return montant;
    }

    /** Retourne un résumé lisible de l'état de la machine. */
    public String etat() {
        StringBuilder sb = new StringBuilder();
        sb.append("Etat machine:\n");
        sb.append(String.format("- Eau : %d/%d cl\n", eau, MAX_EAU));
        sb.append(String.format("- Grains : %d/%d g\n", grains, MAX_GRAINS));
        sb.append(String.format("- Gobelets : %d/%d\n", gobelets, MAX_GOBELETS));
        sb.append(String.format("- Compteur cafés : %d/%d\n", compteurCafes, USURE_MAX));
        sb.append(String.format("- Crédit : %.2f €\n", credit));
        sb.append(String.format("- Caisse : %.2f €", caisse));
        return sb.toString();
    }
}
