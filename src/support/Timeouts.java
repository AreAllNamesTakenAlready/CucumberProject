package support;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Timeouts {
	static final Duration SCRIPT_TIMEOUT = Duration.of(5, ChronoUnit.SECONDS);
	static final Duration PAGELOAD_TIMEOUT = Duration.of(60, ChronoUnit.SECONDS);
	static final Duration IMPLICIT_WAIT_TIMEOUT = Duration.of(60, ChronoUnit.SECONDS);
}
