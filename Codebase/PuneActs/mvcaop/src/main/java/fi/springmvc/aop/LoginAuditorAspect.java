package fi.springmvc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoginAuditorAspect 
{
	@Before("execution(public * fi.springmvc.controllers.UsersController.authenticateUser(..))")
	public void begunAuthentication(JoinPoint point)
	{
		// Advice Logic
		System.out.println("the authenticateUser method has just been called");
		System.out.println(this);
	}
	
	@After("execution(public * fi.springmvc.controllers.UsersController.authenticateUser(..))")
	public void authenticationCompleted(JoinPoint point)
	{
		System.out.println("Authentication completed");
	}
	
	
	
}
