
public class CompteBancaire {

	protected String identifiant;
	protected int somme;
	
	CompteBancaire(String id){
		this.identifiant = id;
	}
	
	void Consulter_compte(){
		
		String reponse_compte = "Vous etes sur le comte " + this.identifiant + "\nLa somme disponible sur le compte est " + this.somme;
		System.out.println(reponse_compte);
		//return reponse_compte;
		
	}
	
	void Deposer_argent(int somme){
		this.somme += somme;
		
		System.out.println("Vous disposez maintenant de la sommme de " + this.somme);
		
	}
	
	void Retirer_somme(int somme){
		if (somme<this.somme) {
			this.somme -= somme;
			System.out.println("Vous etes a découvert de " + this.somme + " sur votre compte !");
		}else{
			this.somme -= somme;
			System.out.println("Vous disposez maintenant de la sommme de " + this.somme);	
		}

	}
	
	
	
}
