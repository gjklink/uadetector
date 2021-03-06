package net.sf.uadetector.internal.util;

import java.util.concurrent.ThreadFactory;

import javax.annotation.Nonnull;

import net.sf.qualitycheck.Check;

/**
 * Factory to create daemon threads that runs as a background process and do not blocks an application shutdown
 */
public final class DaemonThreadFactory implements ThreadFactory {

	/**
	 * Name of a new thread
	 */
	@Nonnull
	private final String threadName;

	public DaemonThreadFactory(@Nonnull final String threadName) {
		Check.notNull(threadName, "threadName");
		Check.notEmpty(threadName.trim(), "threadName");
		if (threadName.trim().isEmpty()) {
			throw new IllegalArgumentException("Argument 'threadName' must not be empty.");
		}
		this.threadName = threadName;
	}

	@Override
	public Thread newThread(@Nonnull final Runnable runnable) {
		final Thread thread = new Thread(runnable);
		thread.setName(threadName);
		thread.setDaemon(true);
		return thread;
	}

}
