/**
 * Recettes proposées par la machine avec leur consommation de ressources.
 */
public enum Recette {
    CAFE_COURT(1.50, 10, 10, 1),
    CAFE_LONG(2.00, 20, 10, 1);

    // Prix en euros
    public final double prix;

    // Consommation
    public final int eauCl;     // en centilitres
    public final int grainsG;   // en grammes
    public final int gobelets;  // nombre de gobelets

    Recette(double prix, int eauCl, int grainsG, int gobelets) {
        this.prix = prix;
        this.eauCl = eauCl;
        this.grainsG = grainsG;
        this.gobelets = gobelets;
    }
}
