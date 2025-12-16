public enum Recette {
    COURT(1.50, 10, 10, 1),
    LONG(2.00, 20, 10, 1);

    public final double prix;
    public final int eau, grains, gobelets;

    Recette(double prix, int eau, int grains, int gobelets) {
        this.prix = prix; this.eau = eau; this.grains = grains; this.gobelets = gobelets;
    }
}
