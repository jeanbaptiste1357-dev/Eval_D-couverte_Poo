public class Machine {
    public static final int MAX_EAU = 100; // cl
    public static final int MAX_GRAINS = 50; // g
    public static final int MAX_GOBELETS = 10; // unités
    public static final int USURE_MAX = 5; // cafés avant entartrage

    private int eau;
    private int grains;
    private int gobelets;
    private int compteurCafes;
    private double monnayeur; // crédit en cours
    private double caisse; // total encaissé

    public Machine() {
        this.eau = MAX_EAU;
        this.grains = MAX_GRAINS;
        this.gobelets = MAX_GOBELETS;
        this.compteurCafes = 0;
        this.monnayeur = 0.0;
        this.caisse = 0.0;
    }

    public synchronized String insererMonnaie(double montant) {
        if (montant <= 0) return "Montant invalide";
        this.monnayeur += montant;
        return String.format("Crédit actuel : %.2f €", this.monnayeur);
    }

    public synchronized String servir(Recette r) {
        if (this.compteurCafes >= USURE_MAX) {
            return "ERREUR : Machine entartrée - Appelez le technicien";
        }

        if (this.monnayeur < r.prix) {
            return "Crédit insuffisant, ajoutez de la monnaie";
        }

        if (this.eau < r.eauCl) return "Plus d'eau !";
        if (this.grains < r.grainsG) return "Plus de grains !";
        if (this.gobelets < r.gobelets) return "Plus de gobelets !";

        // Exécution de la commande
        this.eau -= r.eauCl;
        this.grains -= r.grainsG;
        this.gobelets -= r.gobelets;
        this.monnayeur -= r.prix;
        this.caisse += r.prix;
        this.compteurCafes += 1;

        return "Votre café est prêt !";
    }

    // Menu technicien
    public synchronized void recharger() {
        this.eau = MAX_EAU;
        this.grains = MAX_GRAINS;
        this.gobelets = MAX_GOBELETS;
    }

    public synchronized void detartrer() {
        this.compteurCafes = 0;
    }

    public synchronized double recupererCaisse() {
        double montant = this.caisse;
        this.caisse = 0.0;
        return montant;
    }

    public synchronized String etat() {
        return String.format(
            "Etat de la machine:\n- Eau : %d/%d cl\n- Grains : %d/%d g\n- Gobelets : %d/%d\n- Compteur cafés (usure) : %d/%d\n- Crédit (monnayeur) : %.2f €\n- Caisse : %.2f €",
            this.eau, MAX_EAU,
            this.grains, MAX_GRAINS,
            this.gobelets, MAX_GOBELETS,
            this.compteurCafes, USURE_MAX,
            this.monnayeur,
            this.caisse
        );
    }
}
