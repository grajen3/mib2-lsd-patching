/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.log4mib.BinaryMessage;
import de.vw.mib.log4mib.InvocationContext;
import de.vw.mib.log4mib.LogHeartbeatInformationProvider;
import de.vw.mib.log4mib.LogManagerDiag;
import de.vw.mib.log4mib.LogManagerDiagListener;
import de.vw.mib.log4mib.LogWriter;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.log4mib.Settings;
import de.vw.mib.log4mib.backend.BinaryMessageFactory;
import de.vw.mib.log4mib.backend.MessageWriter;
import de.vw.mib.log4mib.backend.TimestampProvider;
import de.vw.mib.log4mib.internal.AbstractMessage;
import de.vw.mib.log4mib.internal.ContextLogger;
import de.vw.mib.log4mib.internal.Heartbeat;
import de.vw.mib.log4mib.internal.LogClassifierNames;
import de.vw.mib.log4mib.internal.LogWriterManager;
import de.vw.mib.log4mib.internal.LoggingProperties;
import de.vw.mib.log4mib.internal.LoggingThread;
import de.vw.mib.log4mib.internal.MainLogger$1;
import de.vw.mib.log4mib.internal.MainLogger$2;
import de.vw.mib.log4mib.internal.MainLogger$3;
import de.vw.mib.log4mib.internal.MessageFactory;
import de.vw.mib.log4mib.internal.PooledLogMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public final class MainLogger
implements BinaryMessageFactory,
LoggerFactory,
LogManagerDiag {
    private static final String LOGGING_THREAD_RESTARTS;
    public static final String MLP_ENABLED;
    public static final String CONSOLE_TRACES_ENABLED;
    public static final String CONSOLE_TEXTUAL_CLASSIFIERS_ENABLED;
    public static final String LOGGING_HEARTBEAT_STARTUPTIME;
    public static final String LOGGING_HEARTBEAT_THREAD_PRIORITY;
    public static final String LOGGING_PROPERTIES;
    public static final String LOGGING_THREAD_PRIORITY;
    public static final String LOGGING_WATCHDOG_ENABLED;
    public static final byte LOGMESSAGE_CODEC_VERSION;
    private final Set diagListeners = new HashSet();
    static final int ALL;
    static MainLogger INSTANCE;
    static final int NONE;
    private int restartCount;
    public static final boolean DEBUG_SPI_MLP_ENABLED;
    private static final int MAX_LOGGING_THREAD_RESTARTS;
    private final LogClassifierNames classifierNamesService;
    private final IntObjectMap contextLoggers;
    private final MessageFactory factory;
    private final Heartbeat heartbeat;
    private final LoggingThread loggingThread;
    private final LogWriterManager logWriterManager;
    private final Settings settings;
    static /* synthetic */ Class class$de$vw$mib$log4mib$internal$MainLogger;

    public static LoggerFactory getLoggerFactory() {
        return INSTANCE;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static MainLogger initLogger() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        Properties properties = new Properties();
        String string = System.getProperty("logging.properties");
        InputStream inputStream = null;
        try {
            inputStream = string != null ? new FileInputStream(string) : (class$de$vw$mib$log4mib$internal$MainLogger == null ? (class$de$vw$mib$log4mib$internal$MainLogger = MainLogger.class$("de.vw.mib.log4mib.internal.MainLogger")) : class$de$vw$mib$log4mib$internal$MainLogger).getResourceAsStream("/logging.properties");
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                System.err.println("[Log4MIB] no logging settings specified or found!");
            }
        }
        catch (IOException iOException) {
            System.err.println("[Log4MIB] error while loading logging settings!");
            iOException.printStackTrace();
        }
        finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                }
                catch (IOException iOException) {}
            }
        }
        new MainLogger(new LoggingProperties(properties));
        return INSTANCE;
    }

    static MainLogger getInstance() {
        return INSTANCE;
    }

    public MainLogger(Settings settings) {
        this.settings = settings;
        this.classifierNamesService = new LogClassifierNames();
        IntIntMap intIntMap = settings.getInitialSubClassifierMasks();
        if (intIntMap == null) {
            intIntMap = new IntIntOptHashMap(41);
        }
        this.factory = new MessageFactory(settings.getLogMessagePoolSize());
        this.logWriterManager = new LogWriterManager(settings, this.factory);
        this.loggingThread = new LoggingThread(settings, this);
        this.heartbeat = new Heartbeat(this.loggingThread, this.factory, settings.getLogHeartbeatFrequency());
        AbstractMessage.loggingThread = this.loggingThread;
        AbstractMessage.logWriter = this.logWriterManager;
        this.contextLoggers = this.createContextLoggers(intIntMap);
        this.checkInvocationContextActive();
        INSTANCE = this;
        this.loggingThread.startLoggingThread();
    }

    @Override
    public void addHeartbeatInformation(String string, String string2) {
        this.heartbeat.addHeartbeatInformation(string, string2);
    }

    @Override
    public void addHeartbeatInformationProvider(String string, LogHeartbeatInformationProvider logHeartbeatInformationProvider) {
        this.heartbeat.addHeartbeatInformationProvider(string, logHeartbeatInformationProvider);
    }

    @Override
    public void clearMessageCache() {
        this.logWriterManager.clearMessageCache();
    }

    @Override
    public BinaryMessage createBinaryMessage(short s) {
        return this.factory.createBinaryMessage(s);
    }

    @Override
    public int[] getClassifierIds() {
        return this.classifierNamesService.getClassifierIds();
    }

    @Override
    public String[] getClassifierNames() {
        return this.classifierNamesService.getClassifierNames();
    }

    @Override
    public Logger getLogger(int n) {
        return (ContextLogger)this.contextLoggers.get(n);
    }

    public Settings getSettings() {
        return this.settings;
    }

    @Override
    public String[] getSubClassifierNames(int n) {
        return this.classifierNamesService.getSubClassifierNames(n);
    }

    @Override
    public int getTraceSubClassifierMask(int n) {
        ContextLogger contextLogger = (ContextLogger)this.contextLoggers.get(n);
        if (contextLogger == null) {
            PooledLogMessage pooledLogMessage = this.factory.createLogMessage(4, 512, 1);
            pooledLogMessage.append("no logger available for classifier '").append(n).append("'").log();
            return 0;
        }
        return contextLogger.getTraceSubClassifierMask();
    }

    @Override
    public void registerLogManagerDiagListener(LogManagerDiagListener logManagerDiagListener) {
        this.diagListeners.add(logManagerDiagListener);
    }

    @Override
    public void registerLogWriter(LogWriter logWriter) {
        if (logWriter == null) {
            return;
        }
        this.logWriterManager.registerLogWriter(new MainLogger$1(this, logWriter));
    }

    public void setPriority(int n) {
        if (this.loggingThread != null) {
            this.loggingThread.setPriority(n);
        }
    }

    @Override
    public void setTraceSubClassifierMask(int n, int n2) {
        ContextLogger contextLogger = (ContextLogger)this.contextLoggers.get(n);
        if (contextLogger == null) {
            PooledLogMessage pooledLogMessage = this.factory.createLogMessage(4, 512, 1);
            pooledLogMessage.append("no logger available for classifier '").append(n).append("'").log();
            return;
        }
        contextLogger.setTraceSubClassifierMask(n2);
        if (n == 512) {
            this.checkInvocationContextActive();
        }
    }

    @Override
    public void updateLogManagerDiagListener(LogManagerDiagListener logManagerDiagListener) {
        Iterator iterator = this.diagListeners.iterator();
        while (iterator.hasNext()) {
            LogManagerDiagListener logManagerDiagListener2 = (LogManagerDiagListener)iterator.next();
            if (logManagerDiagListener2 == logManagerDiagListener) continue;
            logManagerDiagListener2.logMangerSettingsUpdated();
        }
    }

    public String toString() {
        return "MainLogger";
    }

    @Override
    public void unregisterLogManagerDiagListener(LogManagerDiagListener logManagerDiagListener) {
        this.diagListeners.remove(logManagerDiagListener);
    }

    @Override
    public void unregisterLogWriter() {
        this.logWriterManager.unregisterLogWriter();
    }

    private void checkInvocationContextActive() {
        ContextLogger contextLogger = (ContextLogger)this.contextLoggers.get(512);
        if (contextLogger != null) {
            InvocationContext.setActive(contextLogger.isTraceEnabled(8));
        }
    }

    private IntObjectMap createContextLoggers(IntIntMap intIntMap) {
        int[] nArray = this.classifierNamesService.getClassifierIds();
        IntObjectOptHashMap intObjectOptHashMap = new IntObjectOptHashMap(nArray.length);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n = nArray[i2];
            ContextLogger contextLogger = new ContextLogger(n, this, this.logWriterManager, this.factory);
            contextLogger.setTraceSubClassifierMask(intIntMap.get(n));
            intObjectOptHashMap.put(n, contextLogger);
        }
        return intObjectOptHashMap;
    }

    LoggingThread getLoggingThread() {
        return this.loggingThread;
    }

    void log(int n, int n2, int n3, String string) {
        this.factory.createLogMessage(n, n2, n3, string).log();
    }

    void log(int n, int n2, int n3, String string, Throwable throwable) {
        this.factory.createLogMessage(n, n2, n3, string).attachThrowable(throwable).log();
    }

    void registerBackendMessageWriter(MessageWriter messageWriter) {
        if (messageWriter == null) {
            return;
        }
        this.logWriterManager.registerLogWriter(new MainLogger$2(this, messageWriter));
    }

    void registerBackendTimestampProvider(TimestampProvider timestampProvider) {
        this.factory.setTimestampProvider(timestampProvider);
        this.log(8, 512, 4, "Using new TimestampProvider by now to create logging timestamps!");
        this.heartbeat.startHeartbeat();
    }

    void stopLoggingThread() {
        this.heartbeat.stopHeartbeat();
        this.loggingThread.stopLoggingThread();
    }

    boolean onRestartLoggingThread() {
        ++this.restartCount;
        if (this.restartCount == MAX_LOGGING_THREAD_RESTARTS) {
            this.logWriterManager.registerLogWriter(new MainLogger$3(this));
            this.factory.createLogMessage(4, 512, 1).append("Ethernet logging deactivated after watchdog trys to restart for ").append(MAX_LOGGING_THREAD_RESTARTS).append(" times.").log();
            return true;
        }
        return this.restartCount < MAX_LOGGING_THREAD_RESTARTS;
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
        DEBUG_SPI_MLP_ENABLED = System.getProperty("de.vw.mib.log4mib.mlp.enabled", "true").equals("true");
        MAX_LOGGING_THREAD_RESTARTS = Integer.getInteger("de.vw.mib.log4mib.thread.restarts", 5) - 1;
    }
}

