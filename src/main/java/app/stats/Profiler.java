package app.stats;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

@Configurable
@Aspect
@Component
public class Profiler {

    private static final Logger LOGGER = LoggerFactory.getLogger(Profiler.class);
    
	@Pointcut("execution(public * app.controller..*.*(..))")
	public void inWebLayer() {
		// Web Layer
	}

	@Pointcut("execution(public * app.service..*.*(..))")
	public void inServiceLayer() {
		// Service Layer
	}

	@Pointcut("execution(public * app.dao..*.*(..))")
	public void inDaoLayer() {
		// dao Layer
	}

	@Around("inWebLayer() || inServiceLayer() || inDaoLayer()")
	public Object doBasicProfiling(final ProceedingJoinPoint pjp) throws Throwable {
		// Start Watch
		final long startTime = System.currentTimeMillis();
		final String handlerName = pjp.getSignature().toShortString();
		Object retval;

		try {
			// Proceed with the method call
			retval = pjp.proceed();
		} finally {
			// Stop Watch
			final long endTime = System.currentTimeMillis();
			captureStats(handlerName, endTime-startTime);
		}

		return retval;
	}

	public void reset() {
		// Reset stats
	}

	public String getDelimitedHogStats() {
		return "delimited stats";
	}

	public String getHtmlHogStats() {
		return "html stats";
	}


	private void captureStats(final String name, final long executionTime) {
		// Capture stats
	    LOGGER.trace("Method {} took {} ms", name, executionTime);
	}

	@Override
	public String toString() {
		return getDelimitedHogStats();
	}

	public void clearStats() {
		// Clear stats
	}
}
