package aop.domain;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {
	// aop.infraestructure.data.RegistroPersonas.insertar
	// @Around("execution(* aop.web.UserController.darDeAlta10(..))")
	@Around("@annotation(Time)")
	public void antesDeinsertar(ProceedingJoinPoint point) {
		long start = System.currentTimeMillis();
		try {
			point.proceed();
		} catch (Throwable e) {

			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start) / 1000f);
		System.out.println("hola");

	}

}
