public enum Recette {
    CAFE_COURT(1.50, 10, 10, 1, "Café Court (Espresso)"),
    CAFE_LONG(2.00, 20, 10, 1, "Café Long (Allongé)");

    public final double prix;
    public final int eauCl;
    public final int grainsG;
    public final int gobelets;
    public final String label;

    Recette(double prix, int eauCl, int grainsG, int gobelets, String label) {
        this.prix = prix;
        this.eauCl = eauCl;
        this.grainsG = grainsG;
        this.gobelets = gobelets;
        this.label = label;
    }
}
