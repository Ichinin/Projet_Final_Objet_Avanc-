
public class CompteBancaire {

	protected String identifiant;
	protected int somme;
	
	CompteBancaire(String id){
		this.identifiant = id;
	}
<<<<<<< HEAD
=======
	CompteBancaire(String id, int Somme){
		this.identifiant = id;
		this.somme = Somme;
	}
>>>>>>> 96420affcba03c4aa0beb26d80918e191c769206
	
	void Consulter_compte(){
		
		String reponse_compte = "Vous etes sur le comte " + this.identifiant + "\nLa somme disponible sur le compte est " + this.somme;
		System.out.println(reponse_compte);
		//return reponse_compte;
		
	}
	
	void Deposer_argent(int somme){
		this.somme += somme;
		
<<<<<<< HEAD
		System.out.println("Vous disposez maintenant de la sommme de " + this.somme);
=======
		System.out.println("Vous avez déposé " + somme+ ". \nVous disposez maintenant de la sommme de " + this.somme);
>>>>>>> 96420affcba03c4aa0beb26d80918e191c769206
		
	}
	
	void Retirer_somme(int somme){
		if (somme<this.somme) {
			this.somme -= somme;
			System.out.println("Vous etes a découvert de " + this.somme + " sur votre compte !");
		}else{
			this.somme -= somme;
<<<<<<< HEAD
			System.out.println("Vous disposez maintenant de la sommme de " + this.somme);	
=======
			System.out.println("Vous avez retiré " + this.somme+ ". \n Vous disposez maintenant de la sommme de " + this.somme);	
>>>>>>> 96420affcba03c4aa0beb26d80918e191c769206
		}

	}
	
	
	
}
