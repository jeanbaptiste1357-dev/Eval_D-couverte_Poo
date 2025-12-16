# Eval_D-couverte_Poo

Implémentation Java du TP "Machine à café connectée".

Fichiers ajoutés :

- `src/Recette.java` : enum décrivant les recettes et leurs coûts/ressources.
- `src/Machine.java` : logique métier (stocks, monnayeur, caisse, usure, opérations technicien).
- `src/Main.java` : interface CLI (menu utilisateur + menu technicien).
- `run.sh` : script pour compiler et exécuter l'application.

Exécution (Linux) :

```bash
chmod +x run.sh
./run.sh
```

Usage rapide :
- Insérer de la monnaie (option 1). Exemple : `1.50` ou `2.00`.
- Commander un `Café Court` (1.50 €) ou `Café Long` (2.00 €).
- Menu technicien (option 4) : recharger, détartrer, récupérer la caisse.

Messages spécifiques implémentés :
- "ERREUR : Machine entartrée - Appelez le technicien" (après 5 cafés servis).
- "Crédit insuffisant, ajoutez de la monnaie".
- "Plus d'eau !", "Plus de grains !", "Plus de gobelets !".
- "Votre café est prêt !" lorsque la commande est validée.

# Eval_D-couverte_Poo