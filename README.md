#Demineur Avec Design Pattern
Réalisé par Alexia Bossiere, Soukaina Fauberteau et Lucas Lelong

##Builder l'application
Utilisez gradle pour build l'application :
```shell
gradle build
```

##Tester l'application
Pour réaliser les tests l'application, utilisez également gradle:
```shell
gradle test
```

##Lancer l'application
Pour lancer l'application, utilisez encore une fois gradle:
```shell
gradle runApp
```

##Designs Patterns
Pour cette application, nous avions pour consigne d'utiliser au moins 3 design pattern.
Nous avons donc décidé d'utiliser un builder, un decorator et deux state.

###Builder
Tout d'abord, nous avons eu besoin d'un builder pour créer un plateau de différentes tailles.  Grace a son Directeur qui nous a permit de créer rapidement trois tailles de plateau prédéfinis. Nous avons pu intégrer ce design pattern facilement.

###State
Le deuxième pattern qui nous a été nécessaire est le state. Nous l'avons utilisé deux fois. La première a été pour gérer les cases du jeu pour determiner leur nature (Affichée, Cachée, ou avec un Drapeau). 
La deuxième a été utilisée pour gérer la difficulté du jeu. Pour pouvoir modifier le nombre de bombes générées en fonction que ce que l'utilisateur a choisi. (mode Facile, Normal ou Difficile).

###Decorator
Le dernier est le Decorator. Grâce à lui, nous voulions ajouter de la couleur choisie par l'utilisateur pour les cases du démineur. La couleur des cases du démineur est donc affichée en créant un objet qui modifie juste la methode afficherStatus() en ajoutant de la couleur.

##Diagramme de Classe

Notre diagramme de classe se trouve dans le dépot à la racine du projet avec ce nom-ci : demineur_Diagramme_UML_AlexiaSoukainaLucas