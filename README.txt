*********************************
Projet final : Programmation Objet Avanc�e
SESSION : Hiver 2017

@authors 
SUNTHARASARMA Rama
ESSIMMOU Assil
KOUMADI Kodjovi Nyemo

********************************

But de l'application : Jounalisation avec AOP
Cas d'utilisation : op�rations sur un compte bancaire

Outils utilis�s : 
javafx : interface graphique pour desktop
android studio : interface mobile
AspectJ : pour AOP

********************

Fonctionnement 

- Gestion des authifications par aspect (AuthentificationAspect)
- gestion des log par aspects(LoggerAspect)

A chaque ex�cution d'une m�thode de la classe CompteBancaire, gr�ce � l'aspect
les informations de l'op�rations sont journalis�es (date et heure, user, op�ration, montant, compte).
L'appel des m�thodes est effectu� par une interface : classe OperationController
