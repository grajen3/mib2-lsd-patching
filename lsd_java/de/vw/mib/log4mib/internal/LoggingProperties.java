/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.log4mib.Settings;
import de.vw.mib.log4mib.internal.LogClassifierNames;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Properties;

final class LoggingProperties
implements Settings {
    static final String LOGGING_SETTINGS_PREFIX;
    static final String KEY_CONSOLE_LOGGING_ENABLED;
    static final String KEY_LOGMESSAGE_CACHE_SIZE;
    static final String KEY_LOGMESSAGE_POOL_SIZE;
    static final String KEY_LOGMESSAGE_QUEUE_SIZE;
    static final String KEY_LOGHEARTBEAT_FREQUENCY;
    static final String KEY_DEBUGSPI_TCP_ENABLED;
    static final String KEY_LOGGING_SETTING_VERSION;
    private static final int INVALID_ID;
    private static final String SEPERATOR;
    private static final String TRUE;
    private static final long MIN_HEARDBEAT_FREQ;
    private static final long MAX_HEARDBEAT_FREQ;
    private final boolean consoleLoggingEnabled;
    private final long logHeartbeatFrequency;
    private final int logMessageCacheSize;
    private final int logMessagePoolSize;
    private final int logMessageQueueSize;
    private final LogClassifierNames classifierNames = new LogClassifierNames();
    private final IntIntMap subClassifierMasks = new IntIntOptHashMap();
    private boolean tcpSinkEnabled;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$log4mib$internal$LoggingProperties;

    LoggingProperties(Properties properties) {
        if (!$assertionsDisabled && properties == null) {
            throw new AssertionError((Object)"logging properies are null");
        }
        this.logMessageCacheSize = Integer.parseInt(properties.getProperty("logging.logmessage.cache.size", "999"));
        this.logMessagePoolSize = Integer.parseInt(properties.getProperty("logging.logmessage.pool.size", "999"));
        this.logMessageQueueSize = Integer.parseInt(properties.getProperty("logging.logmessage.queue.size", "999"));
        this.consoleLoggingEnabled = Boolean.valueOf(properties.getProperty("logging.console.enabled", "false"));
        long l = Long.parseLong(properties.getProperty("logging.heartbeat.frequency", "60000"));
        this.logHeartbeatFrequency = l < 0 ? (long)0 : (l > 0 ? (long)0 : l);
        this.tcpSinkEnabled = Boolean.valueOf(properties.getProperty("logging.debugspi.tcp.enabled", "false"));
        Iterator iterator = properties.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            String string = (String)map$Entry.getKey();
            Object object = map$Entry.getValue();
            if (!"true".equals(object) || string.startsWith("logging.")) continue;
            this.activateTrace(string);
        }
    }

    @Override
    public IntIntMap getInitialSubClassifierMasks() {
        return this.subClassifierMasks;
    }

    @Override
    public boolean isConsoleLoggingEnabled() {
        return this.consoleLoggingEnabled;
    }

    @Override
    public boolean isTcpSinkEnabled() {
        return this.tcpSinkEnabled;
    }

    @Override
    public long getLogHeartbeatFrequency() {
        return this.logHeartbeatFrequency;
    }

    @Override
    public int getLogMessageCacheSize() {
        return this.logMessageCacheSize;
    }

    @Override
    public int getLogMessagePoolSize() {
        return this.logMessagePoolSize;
    }

    @Override
    public int getLogMessageQueueSize() {
        return this.logMessageQueueSize;
    }

    private void activateTrace(String string) {
        int n = string.indexOf(".");
        int n2 = this.getClassifier(string.substring(0, n));
        int n3 = this.getSubClassifier(n2, string.substring(n + 1));
        int n4 = this.subClassifierMasks.get(n2) + n3;
        this.subClassifierMasks.put(n2, n4);
    }

    private int getClassifier(String string) {
        int[] nArray = this.classifierNames.getClassifierIds();
        String[] stringArray = this.classifierNames.getClassifierNames();
        for (int i2 = stringArray.length - 1; i2 >= 0; --i2) {
            if (!string.equals(stringArray[i2])) continue;
            return nArray[i2];
        }
        return -1;
    }

    private int getSubClassifier(int n, String string) {
        String[] stringArray = this.classifierNames.getSubClassifierNames(n);
        for (int i2 = stringArray.length - 1; i2 >= 0; --i2) {
            if (!string.equals(stringArray[i2])) continue;
            return 1 << i2;
        }
        return -1;
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
        $assertionsDisabled = !(class$de$vw$mib$log4mib$internal$LoggingProperties == null ? (class$de$vw$mib$log4mib$internal$LoggingProperties = LoggingProperties.class$("de.vw.mib.log4mib.internal.LoggingProperties")) : class$de$vw$mib$log4mib$internal$LoggingProperties).desiredAssertionStatus();
    }
}

