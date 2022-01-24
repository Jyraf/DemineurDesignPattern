#Demineur Avec Design Pattern
Réalisé par Alexia Bossiere, Soukaina Fauberteau et Lucas Lelong

##Build the application
Utilisez gradle pour build l'application :
```shell
gradle build
```

##Test the Application
Pour réaliser les tests l'application, utilisez également gradle:
```shell
gradle test
```
##Design Pattern
Pour cette application, nous avons pour consigne d'utiliser au moins 3 design pattern.

###Builder
La première est le builder, nous avons eu besoin de ce builder pour créer un plateau de jeu de taille personnalisée. Grace a son Directeur qui nous as permis de créer rapidement trois tailles de plateau prédéfini, nous avons pu intégrer ce design pattern facilement.

###State
Le deuxième est le state. Nous l'avons utilisé deux fois en tout. La première a été pour gérer les cases du jeu pour determiner leur nature (Ouverte, Fermé, ou avec un Drapeau) La deuxième a été pour gérer la difficulté du jeu, Pour pouvoir modifier le nombre de bombes générer en fonction que ce que l'utilisateur a choisi. (Facile, Normal, Difficile).

###Decorator
Le dernier est le Décorator, Grace à lui, nous voulions ajouter de la couleur choisit par l'utilisateur pour les cases du démineur. Il nous a donc permis de gérer la couleur des cases du démineur en créant un objet modifiant juste la methode afficherStatus() en ajoutant de la couleur.