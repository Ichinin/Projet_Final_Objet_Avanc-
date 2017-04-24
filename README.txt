*********************************
Projet final : Programmation Objet Avancée
SESSION : Hiver 2017

@authors 
SUNTHARASARMA Rama
ESSIMMOU Assil
KOUMADI Kodjovi Nyemo

********************************

But de l'application : Jounalisation avec AOP
Cas d'utilisation : opérations sur un compte bancaire

Outils utilisés : 
javafx : interface graphique pour desktop
android studio : interface mobile
AspectJ : pour AOP

********************

Fonctionnement 

- Gestion des authifications par aspect (AuthentificationAspect)
- gestion des log par aspects(LoggerAspect)

A chaque exécution d'une méthode de la classe CompteBancaire, grâce à l'aspect
les informations de l'opérations sont journalisées (date et heure, user, opération, montant, compte).
L'appel des méthodes est effectué par une interface : classe OperationController
