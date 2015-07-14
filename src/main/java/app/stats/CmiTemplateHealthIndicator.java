package app.stats;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CmiTemplateHealthIndicator implements HealthIndicator {

	@Value("${info.app.version}")
	private String version;

	@Override
	public Health health() {
		return Health.up()
				.withDetail("name", "CMI Template APIs")
				.withDetail("version", version)
				.build();
	}

}
