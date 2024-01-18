# karmaka_LO02

## Organisation des fichiers

### Dossier modelio

Ce dossier contient les fichiers du projet modelio.

### Dossier karmaka

Ce dossier contient les fichiers du projet java karmaka.

#### Dossier src

Ce dossier contient les fichiers sources du projet java karmaka.

#### Dossier doc

Ce dossier contient la documentation du projet java karmaka.

#### Dossier bin

Ce dossier contient les fichiers binaires du projet java karmaka.

## État actuel de l’application

### Fonctionnalités implémentées

Les fonctionnalités implémentées sont ceux du cahier des charges, nous avons fait le choix de ne pas implémenter les fonctionnalités bonus, soit l'interface graphique.

### Fonctionnalités non implémentées

* L'interface graphique
* Le mode multijoueur
* Une véritable intelligence artificielle (pour l'instant l'IA joue aléatoirement avec des pondérations différentes pour les stratégies)
* Une gestion des erreurs plus poussée (création d'excpetions spécifiques, etc.)
* Une gestion de la partie plus poussée:
  * Possibilité de sauvegarder une partie plus simplement
  * Affichage amélioré de la partie:
    * Une CLI plus jolie
    * Affichage des cartes jouées par les autres joueurs (actions et cartes)
  * Possibilité de sauvegarder plus d'une partie à la fois
* Certains pouvoirs peuvent être bugués.
* Les pouvoirs pour les bots peuvent être améliorés dans leur implémentation (éviter les `instanceof`)