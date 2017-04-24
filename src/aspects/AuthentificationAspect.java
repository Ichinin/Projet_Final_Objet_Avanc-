package aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import securite.ServiceAuthentification;
/*
 * Aspect pour la gestion des authenfications
 * il est appelé lors de l'affichage des opétaions
 */
@Aspect
public class AuthentificationAspect {
	public static String logerUser;	
	private ServiceAuthentification authenticator = new ServiceAuthentification();
	

	@Pointcut("execution(* *.MainApp.showOperation(..))")
	public void pcAuthentification(){}
	@Before("pcAuthentification()")
	public void secureAccess()
	{
		authenticator.authenticated();
		logerUser = authenticator.getUserName();
		
	}
}
