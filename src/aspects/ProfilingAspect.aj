package aspects;

public aspect ProfilingAspect {
/*
	pointcut publicOperation() : execution(public * *.*(..));

	Object around() : publicOperation() {
  
    long debut = System.nanoTime();
    
    Object ret = proceed();
    
    long fin = System.nanoTime();
    
    System.out.println(thisJoinPointStaticPart.getSignature() + " a pris " + (fin-debut) + " nanoseconds");

    return ret;
	} */
}