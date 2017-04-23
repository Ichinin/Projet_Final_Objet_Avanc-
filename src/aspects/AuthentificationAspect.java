package aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import Application.MainApp;
import securite.ServiceAuthentification;
@Aspect
public class AuthentificationAspect {
	public static String logerUser;
	MainApp mainApp = new MainApp();
	private ServiceAuthentification authenticator = new ServiceAuthentification();
	
//@Pointcut("execution(* *.CompteBancaire.*(..))")
 //@Pointcut("execution(public static void main(..))")
	@Pointcut("execution(* *.MainApp.showOperation(..))")
	public void pcAuthentification(){}
	@Before("pcAuthentification()")
	public void secureAccess()
	{
		//authenticator.authenticate();
		
		authenticator.authenticated();
		logerUser = authenticator.getUserName();
		
	}
}
