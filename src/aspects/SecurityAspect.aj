package aspects;

import banque.CompteBancaire;
import securite.ServiceAuthentification;


public aspect SecurityAspect {
	//private ServiceAuthentification authenticator = new ServiceAuthentification();

	//pointcut secureAccess()
      //  : execution(* CompteBancaire.*(..));

	//before() : secureAccess() {
		//System.out.println("Authentification de l'utilisateur :");
		//authenticator.authenticate();
		//System.out.println(authenticator.authenticatedUser.get()); 
		
	//}

}