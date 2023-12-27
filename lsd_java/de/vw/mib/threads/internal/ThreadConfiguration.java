/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.threads.internal;

import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.MIBThreadConfiguration;
import de.vw.mib.threads.MIBThreadDescription;
import de.vw.mib.threads.internal.ServiceManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

final class ThreadConfiguration
implements MIBThreadConfiguration {
    static final String SYSTEM_PROPERTY_DISABLE_WATCHDOG;
    static final String SYSTEM_PROPERTY;
    static final String DEFAULT_THREADS_PROPERTIES;
    static final String KEY_THREAD_NAME;
    static final String KEY_THREAD_PRIO;
    static final String KEY_WATCHDOG_ENABLED;
    static final String KEY_WATCHDOG_POLL_TIME;
    static final String KEY_WATCHDOG_PRIORITY;
    static final String KEY_WATCHDOG_RETRIES;
    static final String KEY_WATCHDOG_START;
    static final String KEY_WATCHDOG_TERMINATE;
    static final String KEY_WATCHDOG_TIMEOUT;
    private static Logger logger;
    private final MIBThreadDescription[] descriptions;
    private final boolean disableWatchdog;
    private final long watchdogPollTime;
    private final int watchdogPriority;
    static /* synthetic */ Class class$de$vw$mib$threads$internal$ThreadConfiguration;

    ThreadConfiguration() {
        Properties properties = ThreadConfiguration.loadProperties();
        this.disableWatchdog = Boolean.getBoolean("de.vw.mib.threads.disableWatchdog");
        this.watchdogPollTime = Long.parseLong(properties.getProperty("watchdog.poll.time", "60000"));
        this.watchdogPriority = Integer.parseInt(properties.getProperty("watchdog.thread.prio", "5"));
        this.descriptions = new MIBThreadDescription[8];
        for (int i2 = this.descriptions.length - 1; i2 >= 0; --i2) {
            this.descriptions[i2] = this.createMIBThreadDescription(properties, i2);
        }
    }

    private MIBThreadDescription createMIBThreadDescription(Properties properties, int n) {
        String string;
        boolean bl = false;
        String string2 = properties.getProperty(new StringBuffer().append("thread.name.").append(n).toString());
        if (string2 == null) {
            logger.error(32).append("missing configuration for thread ").append(n).log();
            bl = true;
            string2 = new StringBuffer().append("MIBThread-").append(n).append(" (configuration missing)").toString();
        }
        if ((string = properties.getProperty(new StringBuffer().append("thread.prio.").append(n).toString())) == null) {
            if (!bl) {
                logger.error(32).append("missing priority configuration for thread ").append(n).log();
                bl = true;
            }
            string = Integer.toString(5);
        }
        int n2 = Integer.parseInt(string);
        boolean bl2 = Boolean.valueOf(properties.getProperty(new StringBuffer().append("thread.watchdog.enabled.").append(n).toString(), "false"));
        if (this.disableWatchdog || !bl2) {
            return MIBThreadDescription.defineMIBThread(n, string2, n2);
        }
        String string3 = properties.getProperty(new StringBuffer().append("thread.watchdog.timeout.").append(n).toString());
        String string4 = properties.getProperty(new StringBuffer().append("thread.watchdog.retries.").append(n).toString());
        String string5 = properties.getProperty(new StringBuffer().append("thread.watchdog.start.").append(n).toString());
        if (string4 == null || string5 == null || string3 == null) {
            if (!bl) {
                logger.error(32).append("missing watchdog configuration for thread ").append(string2).log();
            }
            return MIBThreadDescription.defineMIBThread(n, string2, n2);
        }
        boolean bl3 = Boolean.valueOf(properties.getProperty(new StringBuffer().append("thread.watchdog.terminate.").append(n).toString(), "false"));
        int n3 = Integer.parseInt(string3);
        int n4 = Integer.parseInt(string4);
        int n5 = Integer.parseInt(string5);
        return MIBThreadDescription.defineMIBThreadWithWatchdog(n, string2, n2, bl3, n3, n4, n5);
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        String string = System.getProperty("threads.properties");
        if (string == null) {
            string = "threads.properties";
        }
        logger.normal(32).append("Loading threads properties from '").append(string).append("' ...").log();
        InputStream inputStream = null;
        if (string != null) {
            try {
                inputStream = new FileInputStream(string);
            }
            catch (FileNotFoundException fileNotFoundException) {
                // empty catch block
            }
        }
        if (inputStream == null) {
            inputStream = (class$de$vw$mib$threads$internal$ThreadConfiguration == null ? (class$de$vw$mib$threads$internal$ThreadConfiguration = ThreadConfiguration.class$("de.vw.mib.threads.internal.ThreadConfiguration")) : class$de$vw$mib$threads$internal$ThreadConfiguration).getResourceAsStream("/threads.properties");
        }
        if (inputStream == null) {
            logger.error(32, "Threads properties file not found!");
            throw new FileNotFoundException("Threads properties file not found!");
        }
        try {
            properties.load(inputStream);
        }
        catch (IOException iOException) {
            logger.error(32).append("Error while loading threads properties!").attachThrowable(iOException).log();
            throw iOException;
        }
        finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            catch (IOException iOException) {}
        }
        return properties;
    }

    @Override
    public MIBThreadDescription[] getMIBThreadDescriptions() {
        return this.descriptions;
    }

    @Override
    public long getWatchdogPollTime() {
        return this.watchdogPollTime;
    }

    @Override
    public int getWatchdogPriority() {
        return this.watchdogPriority;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        logger = ServiceManager.loggerFactory.getLogger(256);
    }
}

