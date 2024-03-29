package kr.co.seoulit.logistics.sys.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Configuration
@EnableAspectJAutoProxy
@Slf4j
//LoggerAspect
	 public class CommonAspect {
		  //Logger log = LoggerFactory.getLogger(getClass());
		
		@Around("execution(* kr..controller.*.*(..)) or execution(* kr..service.*.*(..)) or execution(* kr..mapper.*.*(..))")
		public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
			String type = "";
			String name = joinPoint.getSignature().getDeclaringTypeName();
			if (name.indexOf("Controller") > -1) {
				type = "Controller  \t:  ";
			}
			else if (name.indexOf("Service") > -1) {
				type = "ServiceImpl  \t:  ";
			}
			else if (name.indexOf("Mapper") > -1) {
				type = "Mapper  \t\t:  ";
			}
			log.info(type + name + "." + joinPoint.getSignature().getName() + "()");
			Object obj = joinPoint.proceed();
			
			return obj;
		}
	 }
	
//	TransactionAspect
