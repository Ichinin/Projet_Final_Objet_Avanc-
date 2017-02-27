
public class ClassMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client Nyemo = new Client("a1", "Nyemo KOUMADI");
		CompteBancaire Compte_Nyemo = new CompteBancaire("a1", 1000);
		
		Nyemo.setCompte(Compte_Nyemo);
		
		Compte_Nyemo.Deposer_argent(500);
		
		Nyemo.getCompte().Consulter_compte();
		
		
	}

}
