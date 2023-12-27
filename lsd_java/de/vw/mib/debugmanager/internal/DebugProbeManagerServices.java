/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.internal;

import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.debugmanager.internal.CallbackManager;
import de.vw.mib.debugmanager.internal.DumpServices;
import de.vw.mib.debugmanager.unifiedlogging.BinaryLogger;
import de.vw.mib.debugmanager.unifiedlogging.UnifiedLoggingCallbackListener;
import de.vw.mib.log4mib.LogManager;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.timer.TimerManager;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;

public class DebugProbeManagerServices {
    private final BundleContext bundleContext;
    private final CallbackManager callbackManager;
    private final DumpServices dumpServices;
    private final LogManager logManager;
    private final ConfigurationManager configurationManager;
    private final LoggerFactory loggerFactory;
    private final BinaryLogger binaryLogger;
    private Hashtable directory;
    private TimerManager timerManager;
    static /* synthetic */ Class class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener;

    public DebugProbeManagerServices(BundleContext bundleContext, TimerManager timerManager, CallbackManager callbackManager, DumpServices dumpServices, LogManager logManager, ConfigurationManager configurationManager, LoggerFactory loggerFactory, BinaryLogger binaryLogger) {
        this.bundleContext = bundleContext;
        this.callbackManager = callbackManager;
        this.dumpServices = dumpServices;
        this.logManager = logManager;
        this.configurationManager = configurationManager;
        this.loggerFactory = loggerFactory;
        this.binaryLogger = binaryLogger;
        this.timerManager = timerManager;
    }

    public CallbackManager getCallbackManager() {
        return this.callbackManager;
    }

    public DumpServices getDumpServices() {
        return this.dumpServices;
    }

    public LogManager getLogManager() {
        return this.logManager;
    }

    public ConfigurationManager getConfigurationManager() {
        return this.configurationManager;
    }

    public Logger getLogger() {
        return this.loggerFactory.getLogger(2);
    }

    public BinaryLogger getBinaryLogger() {
        return this.binaryLogger;
    }

    public BundleContext getBundleContext() {
        return this.bundleContext;
    }

    public void registerUnifiedLoggingCallbackListener(UnifiedLoggingCallbackListener unifiedLoggingCallbackListener, short s) {
        if (this.directory == null) {
            this.directory = new Hashtable();
        } else {
            this.directory.clear();
        }
        this.directory.put("message.type", new Short(s));
        this.bundleContext.registerService((class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener == null ? (class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener = DebugProbeManagerServices.class$("de.vw.mib.debugmanager.unifiedlogging.UnifiedLoggingCallbackListener")) : class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener).getName(), (Object)unifiedLoggingCallbackListener, (Dictionary)this.directory);
    }

    public LoggerFactory getLoggerFactory() {
        return this.loggerFactory;
    }

    public TimerManager getTimerManager() {
        return this.timerManager;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

