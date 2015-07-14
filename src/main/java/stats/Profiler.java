package stats;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import com.aol.util.hog4j.MsStats;

@Configurable
@Aspect
@Component
public class Profiler {

	private MsStats msStats;
	private String statsDelimiter = ",";

	private static final Logger LOGGER = LoggerFactory.getLogger(Profiler.class);

	@Autowired
	public void setMsStats(MsStats msStats) {
		this.msStats = msStats;
	}

	@Pointcut("execution(public * com.aol.cmi.controller..*.*(..))")
	public void inWebLayer() {
		// Web Layer
	}

	@Pointcut("execution(public * com.aol.cmi.service..*.*(..))")
	public void inServiceLayer() {
		// Service Layer
	}

	@Pointcut("execution(public * com.aol.cmi.dao..*.*(..))")
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
		msStats.reset();
	}

	public String getDelimitedHogStats() {
		try {
			return msStats.printDelimOutput(statsDelimiter);
		} catch (final Exception e) {
			LOGGER.warn(e.getMessage(), e);
			return "Unable to produce delimited hog stats:" + e.getMessage();
		}
	}

	public String getHtmlHogStats() {
		return msStats.getHtmlTable();
	}


	private void captureStats(final String name, final long executionTime) {
		try {
			if(msStats==null) {
				LOGGER.warn("msStats object is null. Hog Stats will not be collected until the container/server is restarted");
				return;
			}
			msStats.update(name, executionTime);
		} catch (final Exception e) {
			LOGGER.warn(e.getMessage(), e);
		}
	}

	public void setStatsDelimiter(final String statsDelimiter) {
		this.statsDelimiter = statsDelimiter;
	}

	@Override
	public String toString() {
		return getDelimitedHogStats();
	}

	public void clearStats() {
		LOGGER.info("Resetting all the HOG stats");
		msStats.reset();
	}
}
