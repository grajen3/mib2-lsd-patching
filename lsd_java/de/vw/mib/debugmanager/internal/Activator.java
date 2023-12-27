/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.internal;

import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.debug.spi.DebugSPI;
import de.vw.mib.debugmanager.dump.HmiDumpInformationProvider;
import de.vw.mib.debugmanager.internal.CallbackManager;
import de.vw.mib.debugmanager.internal.DebugProbeManagerImpl;
import de.vw.mib.debugmanager.internal.DebugProbeManagerServices;
import de.vw.mib.debugmanager.internal.DumpServices;
import de.vw.mib.debugmanager.internal.LegacyBackend;
import de.vw.mib.debugmanager.internal.Log4MibBackend;
import de.vw.mib.debugmanager.internal.Log4MibBackendBase;
import de.vw.mib.debugmanager.internal.PerformanceServices;
import de.vw.mib.debugmanager.performance.PerformanceIndicatorListener;
import de.vw.mib.debugmanager.probes.DebugProbeFactory;
import de.vw.mib.debugmanager.tester.TesterTargetService;
import de.vw.mib.debugmanager.unifiedlogging.BinaryLogger;
import de.vw.mib.debugmanager.unifiedlogging.UnifiedLoggingCallbackListener;
import de.vw.mib.log4mib.LogManager;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.log4mib.backend.BinaryMessageFactory;
import de.vw.mib.log4mib.backend.ConfigurationChangeListener;
import de.vw.mib.timer.TimerManager;
import de.vw.mib.timer.spi.TimerSPI;
import de.vw.mib.util.StringBuilder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public final class Activator
implements BundleActivator,
ServiceListener {
    public static final boolean DEBUG_SPI_MLP_ENABLED = System.getProperty("de.vw.mib.log4mib.mlp.enabled", "true").equals("true");
    private BundleContext bundleContext;
    private CallbackManager callbackManager;
    private DumpServices dumpServices;
    private LogManager logManager;
    private ConfigurationManager configurationManager;
    private LoggerFactory loggerFactory;
    private TimerManager timerManager;
    private DebugProbeManagerImpl debugProbeManager;
    private TesterTargetService testerTargetService;
    private Set alreadyCollectedProbeFactories;
    private BinaryLogger binaryLogger;
    static /* synthetic */ Class class$de$vw$mib$debug$spi$DebugSPI;
    static /* synthetic */ Class class$de$vw$mib$timer$spi$TimerSPI;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$log4mib$backend$BinaryMessageFactory;
    static /* synthetic */ Class class$de$vw$mib$debugmanager$unifiedlogging$BinaryLogger;
    static /* synthetic */ Class class$de$vw$mib$log4mib$backend$MessageWriter;
    static /* synthetic */ Class class$de$vw$mib$log4mib$backend$TimestampProvider;
    static /* synthetic */ Class class$de$vw$mib$debugmanager$dump$DumpService;
    static /* synthetic */ Class class$de$vw$mib$debugmanager$performance$PerformanceIndicatorService;
    static /* synthetic */ Class class$de$vw$mib$debugmanager$performance$PerformanceTracingService;
    static /* synthetic */ Class class$de$vw$mib$log4mib$backend$ConfigurationChangeListener;
    static /* synthetic */ Class class$de$vw$mib$debugmanager$dump$HmiDumpInformationProvider;
    static /* synthetic */ Class class$de$vw$mib$debugmanager$performance$PerformanceIndicatorListener;
    static /* synthetic */ Class class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener;
    static /* synthetic */ Class class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingScopeListener;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LogManager;
    static /* synthetic */ Class class$de$vw$mib$timer$TimerManager;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManager;
    static /* synthetic */ Class class$de$vw$mib$debugmanager$tester$TesterTargetService;
    static /* synthetic */ Class class$de$vw$mib$debugmanager$probes$DebugProbeFactory;
    static /* synthetic */ Class class$de$vw$mib$debugmanager$probes$DebugProbeManager;

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        block3: {
            String[] stringArray;
            Object object;
            block2: {
                object = this.bundleContext.getService(serviceEvent.getServiceReference());
                stringArray = (String[])serviceEvent.getServiceReference().getProperty("objectClass");
                if (serviceEvent.getType() != 1) break block2;
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    this.handleServiceRegistered(stringArray[i2], object, serviceEvent.getServiceReference());
                }
                break block3;
            }
            if (serviceEvent.getType() != 4) break block3;
            for (int i3 = 0; i3 < stringArray.length; ++i3) {
                this.handleServiceUnregistering(stringArray[i3], object, serviceEvent.getServiceReference());
            }
        }
    }

    @Override
    public void start(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
        DebugSPI debugSPI = (DebugSPI)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$debug$spi$DebugSPI == null ? (class$de$vw$mib$debug$spi$DebugSPI = Activator.class$("de.vw.mib.debug.spi.DebugSPI")) : class$de$vw$mib$debug$spi$DebugSPI).getName()));
        TimerSPI timerSPI = (TimerSPI)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$timer$spi$TimerSPI == null ? (class$de$vw$mib$timer$spi$TimerSPI = Activator.class$("de.vw.mib.timer.spi.TimerSPI")) : class$de$vw$mib$timer$spi$TimerSPI).getName()));
        this.loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        Logger logger = this.loggerFactory.getLogger(1);
        BinaryMessageFactory binaryMessageFactory = (BinaryMessageFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$backend$BinaryMessageFactory == null ? (class$de$vw$mib$log4mib$backend$BinaryMessageFactory = Activator.class$("de.vw.mib.log4mib.backend.BinaryMessageFactory")) : class$de$vw$mib$log4mib$backend$BinaryMessageFactory).getName()));
        Log4MibBackendBase log4MibBackendBase = DEBUG_SPI_MLP_ENABLED ? new Log4MibBackend(logger, debugSPI, timerSPI, binaryMessageFactory) : new LegacyBackend(logger, debugSPI, timerSPI, binaryMessageFactory);
        this.binaryLogger = log4MibBackendBase;
        bundleContext.registerService(new String[]{(class$de$vw$mib$debugmanager$unifiedlogging$BinaryLogger == null ? (class$de$vw$mib$debugmanager$unifiedlogging$BinaryLogger = Activator.class$("de.vw.mib.debugmanager.unifiedlogging.BinaryLogger")) : class$de$vw$mib$debugmanager$unifiedlogging$BinaryLogger).getName(), (class$de$vw$mib$log4mib$backend$MessageWriter == null ? (class$de$vw$mib$log4mib$backend$MessageWriter = Activator.class$("de.vw.mib.log4mib.backend.MessageWriter")) : class$de$vw$mib$log4mib$backend$MessageWriter).getName(), (class$de$vw$mib$log4mib$backend$TimestampProvider == null ? (class$de$vw$mib$log4mib$backend$TimestampProvider = Activator.class$("de.vw.mib.log4mib.backend.TimestampProvider")) : class$de$vw$mib$log4mib$backend$TimestampProvider).getName()}, (Object)this.binaryLogger, null);
        this.callbackManager = new CallbackManager(this.loggerFactory.getLogger(64), log4MibBackendBase, DEBUG_SPI_MLP_ENABLED);
        debugSPI.addDebugListener(this.callbackManager);
        this.dumpServices = new DumpServices(logger, debugSPI);
        bundleContext.registerService((class$de$vw$mib$debugmanager$dump$DumpService == null ? (class$de$vw$mib$debugmanager$dump$DumpService = Activator.class$("de.vw.mib.debugmanager.dump.DumpService")) : class$de$vw$mib$debugmanager$dump$DumpService).getName(), (Object)this.dumpServices, null);
        bundleContext.registerService(new String[]{(class$de$vw$mib$debugmanager$performance$PerformanceIndicatorService == null ? (class$de$vw$mib$debugmanager$performance$PerformanceIndicatorService = Activator.class$("de.vw.mib.debugmanager.performance.PerformanceIndicatorService")) : class$de$vw$mib$debugmanager$performance$PerformanceIndicatorService).getName(), (class$de$vw$mib$debugmanager$performance$PerformanceTracingService == null ? (class$de$vw$mib$debugmanager$performance$PerformanceTracingService = Activator.class$("de.vw.mib.debugmanager.performance.PerformanceTracingService")) : class$de$vw$mib$debugmanager$performance$PerformanceTracingService).getName()}, (Object)new PerformanceServices(debugSPI), null);
        this.registerServiceListener();
    }

    @Override
    public void stop(BundleContext bundleContext) {
    }

    private void handleServiceRegistered(String string, Object object, ServiceReference serviceReference) {
        if ((class$de$vw$mib$log4mib$backend$ConfigurationChangeListener == null ? (class$de$vw$mib$log4mib$backend$ConfigurationChangeListener = Activator.class$("de.vw.mib.log4mib.backend.ConfigurationChangeListener")) : class$de$vw$mib$log4mib$backend$ConfigurationChangeListener).getName().equals(string)) {
            this.callbackManager.registerUnifiedLoggingScopeListener((ConfigurationChangeListener)object);
        } else if ((class$de$vw$mib$debugmanager$dump$HmiDumpInformationProvider == null ? (class$de$vw$mib$debugmanager$dump$HmiDumpInformationProvider = Activator.class$("de.vw.mib.debugmanager.dump.HmiDumpInformationProvider")) : class$de$vw$mib$debugmanager$dump$HmiDumpInformationProvider).getName().equals(string)) {
            this.dumpServices.register((HmiDumpInformationProvider)object);
        } else if ((class$de$vw$mib$debugmanager$performance$PerformanceIndicatorListener == null ? (class$de$vw$mib$debugmanager$performance$PerformanceIndicatorListener = Activator.class$("de.vw.mib.debugmanager.performance.PerformanceIndicatorListener")) : class$de$vw$mib$debugmanager$performance$PerformanceIndicatorListener).getName().equals(string)) {
            this.callbackManager.registerPerformanceIndicatorListener((PerformanceIndicatorListener)object);
        } else if ((class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener == null ? (class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener = Activator.class$("de.vw.mib.debugmanager.unifiedlogging.UnifiedLoggingCallbackListener")) : class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener).getName().equals(string)) {
            Object object2 = serviceReference.getProperty("message.type");
            if (object2.getClass().isArray()) {
                short[] sArray = (short[])object2;
                for (int i2 = 0; i2 < sArray.length; ++i2) {
                    this.callbackManager.registerUnifiedLoggingCallbackListener(sArray[i2], (UnifiedLoggingCallbackListener)object);
                }
            } else {
                this.callbackManager.registerUnifiedLoggingCallbackListener((Short)object2, (UnifiedLoggingCallbackListener)object);
            }
        } else if ((class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingScopeListener == null ? (class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingScopeListener = Activator.class$("de.vw.mib.debugmanager.unifiedlogging.UnifiedLoggingScopeListener")) : class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingScopeListener).getName().equals(string)) {
            this.callbackManager.registerUnifiedLoggingScopeListener((ConfigurationChangeListener)object);
        } else if ((class$de$vw$mib$log4mib$LogManager == null ? (class$de$vw$mib$log4mib$LogManager = Activator.class$("de.vw.mib.log4mib.LogManager")) : class$de$vw$mib$log4mib$LogManager).getName().equals(string)) {
            this.logManager = (LogManager)object;
            this.registerProbeManagerIfPossible();
        } else if ((class$de$vw$mib$timer$TimerManager == null ? (class$de$vw$mib$timer$TimerManager = Activator.class$("de.vw.mib.timer.TimerManager")) : class$de$vw$mib$timer$TimerManager).getName().equals(string)) {
            this.timerManager = (TimerManager)object;
            this.registerProbeManagerIfPossible();
        } else if ((class$de$vw$mib$configuration$ConfigurationManager == null ? (class$de$vw$mib$configuration$ConfigurationManager = Activator.class$("de.vw.mib.configuration.ConfigurationManager")) : class$de$vw$mib$configuration$ConfigurationManager).getName().equals(string)) {
            this.configurationManager = (ConfigurationManager)object;
            this.registerProbeManagerIfPossible();
        } else if ((class$de$vw$mib$debugmanager$tester$TesterTargetService == null ? (class$de$vw$mib$debugmanager$tester$TesterTargetService = Activator.class$("de.vw.mib.debugmanager.tester.TesterTargetService")) : class$de$vw$mib$debugmanager$tester$TesterTargetService).getName().equals(string)) {
            this.testerTargetService = (TesterTargetService)object;
            if (this.debugProbeManager != null) {
                this.debugProbeManager.sendReady();
            }
        } else if ((class$de$vw$mib$debugmanager$probes$DebugProbeFactory == null ? (class$de$vw$mib$debugmanager$probes$DebugProbeFactory = Activator.class$("de.vw.mib.debugmanager.probes.DebugProbeFactory")) : class$de$vw$mib$debugmanager$probes$DebugProbeFactory).getName().equals(string)) {
            if (this.debugProbeManager == null) {
                if (this.alreadyCollectedProbeFactories == null) {
                    this.alreadyCollectedProbeFactories = new HashSet();
                }
                this.alreadyCollectedProbeFactories.add(object);
            } else {
                this.debugProbeManager.registerDebugProbe((DebugProbeFactory)object);
            }
        }
    }

    private void registerProbeManagerIfPossible() {
        if (this.debugProbeManager == null && this.logManager != null && this.timerManager != null && this.configurationManager != null) {
            DebugProbeManagerServices debugProbeManagerServices = new DebugProbeManagerServices(this.bundleContext, this.timerManager, this.callbackManager, this.dumpServices, this.logManager, this.configurationManager, this.loggerFactory, this.binaryLogger);
            this.debugProbeManager = new DebugProbeManagerImpl(debugProbeManagerServices);
            this.bundleContext.registerService((class$de$vw$mib$debugmanager$probes$DebugProbeManager == null ? (class$de$vw$mib$debugmanager$probes$DebugProbeManager = Activator.class$("de.vw.mib.debugmanager.probes.DebugProbeManager")) : class$de$vw$mib$debugmanager$probes$DebugProbeManager).getName(), (Object)this.debugProbeManager, null);
            if (this.alreadyCollectedProbeFactories != null) {
                Iterator iterator = this.alreadyCollectedProbeFactories.iterator();
                while (iterator.hasNext()) {
                    DebugProbeFactory debugProbeFactory = (DebugProbeFactory)iterator.next();
                    this.debugProbeManager.registerDebugProbe(debugProbeFactory);
                    iterator.remove();
                }
            }
            if (this.testerTargetService != null) {
                this.debugProbeManager.sendReady();
            }
        }
    }

    private void handleServiceUnregistering(String string, Object object, ServiceReference serviceReference) {
        if ((class$de$vw$mib$log4mib$backend$ConfigurationChangeListener == null ? (class$de$vw$mib$log4mib$backend$ConfigurationChangeListener = Activator.class$("de.vw.mib.log4mib.backend.ConfigurationChangeListener")) : class$de$vw$mib$log4mib$backend$ConfigurationChangeListener).getName().equals(string)) {
            this.callbackManager.unregisterUnifiedLoggingScopeListener((ConfigurationChangeListener)object);
        } else if ((class$de$vw$mib$debugmanager$dump$HmiDumpInformationProvider == null ? (class$de$vw$mib$debugmanager$dump$HmiDumpInformationProvider = Activator.class$("de.vw.mib.debugmanager.dump.HmiDumpInformationProvider")) : class$de$vw$mib$debugmanager$dump$HmiDumpInformationProvider).getName().equals(string)) {
            this.dumpServices.unregister((HmiDumpInformationProvider)object);
        } else if ((class$de$vw$mib$debugmanager$performance$PerformanceIndicatorListener == null ? (class$de$vw$mib$debugmanager$performance$PerformanceIndicatorListener = Activator.class$("de.vw.mib.debugmanager.performance.PerformanceIndicatorListener")) : class$de$vw$mib$debugmanager$performance$PerformanceIndicatorListener).getName().equals(string)) {
            this.callbackManager.unregisterPerformanceIndicatorListener((PerformanceIndicatorListener)object);
        } else if ((class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener == null ? (class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener = Activator.class$("de.vw.mib.debugmanager.unifiedlogging.UnifiedLoggingCallbackListener")) : class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener).getName().equals(string)) {
            Object object2 = serviceReference.getProperty("message.type");
            if (object2.getClass().isArray()) {
                short[] sArray = (short[])object2;
                for (int i2 = 0; i2 < sArray.length; ++i2) {
                    this.callbackManager.unregisterUnifiedLoggingCallbackListener(sArray[i2], (UnifiedLoggingCallbackListener)object);
                }
            } else {
                this.callbackManager.unregisterUnifiedLoggingCallbackListener((Short)object2, (UnifiedLoggingCallbackListener)object);
            }
        } else if ((class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingScopeListener == null ? (class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingScopeListener = Activator.class$("de.vw.mib.debugmanager.unifiedlogging.UnifiedLoggingScopeListener")) : class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingScopeListener).getName().equals(string)) {
            this.callbackManager.unregisterUnifiedLoggingScopeListener((ConfigurationChangeListener)object);
        } else if ((class$de$vw$mib$debugmanager$probes$DebugProbeFactory == null ? (class$de$vw$mib$debugmanager$probes$DebugProbeFactory = Activator.class$("de.vw.mib.debugmanager.probes.DebugProbeFactory")) : class$de$vw$mib$debugmanager$probes$DebugProbeFactory).getName().equals(string)) {
            if (this.alreadyCollectedProbeFactories != null) {
                this.alreadyCollectedProbeFactories.remove(object);
            }
            if (this.debugProbeManager != null) {
                this.debugProbeManager.unregisterDebugProbe((DebugProbeFactory)object);
            }
        }
    }

    private void registerServiceListener() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(|");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$log4mib$backend$ConfigurationChangeListener == null ? (class$de$vw$mib$log4mib$backend$ConfigurationChangeListener = Activator.class$("de.vw.mib.log4mib.backend.ConfigurationChangeListener")) : class$de$vw$mib$log4mib$backend$ConfigurationChangeListener).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$debugmanager$dump$HmiDumpInformationProvider == null ? (class$de$vw$mib$debugmanager$dump$HmiDumpInformationProvider = Activator.class$("de.vw.mib.debugmanager.dump.HmiDumpInformationProvider")) : class$de$vw$mib$debugmanager$dump$HmiDumpInformationProvider).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$debugmanager$performance$PerformanceIndicatorListener == null ? (class$de$vw$mib$debugmanager$performance$PerformanceIndicatorListener = Activator.class$("de.vw.mib.debugmanager.performance.PerformanceIndicatorListener")) : class$de$vw$mib$debugmanager$performance$PerformanceIndicatorListener).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener == null ? (class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener = Activator.class$("de.vw.mib.debugmanager.unifiedlogging.UnifiedLoggingCallbackListener")) : class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingScopeListener == null ? (class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingScopeListener = Activator.class$("de.vw.mib.debugmanager.unifiedlogging.UnifiedLoggingScopeListener")) : class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingScopeListener).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$debugmanager$tester$TesterTargetService == null ? (class$de$vw$mib$debugmanager$tester$TesterTargetService = Activator.class$("de.vw.mib.debugmanager.tester.TesterTargetService")) : class$de$vw$mib$debugmanager$tester$TesterTargetService).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$log4mib$LogManager == null ? (class$de$vw$mib$log4mib$LogManager = Activator.class$("de.vw.mib.log4mib.LogManager")) : class$de$vw$mib$log4mib$LogManager).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$timer$TimerManager == null ? (class$de$vw$mib$timer$TimerManager = Activator.class$("de.vw.mib.timer.TimerManager")) : class$de$vw$mib$timer$TimerManager).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$configuration$ConfigurationManager == null ? (class$de$vw$mib$configuration$ConfigurationManager = Activator.class$("de.vw.mib.configuration.ConfigurationManager")) : class$de$vw$mib$configuration$ConfigurationManager).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$timer$TimerManager == null ? (class$de$vw$mib$timer$TimerManager = Activator.class$("de.vw.mib.timer.TimerManager")) : class$de$vw$mib$timer$TimerManager).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$debugmanager$probes$DebugProbeFactory == null ? (class$de$vw$mib$debugmanager$probes$DebugProbeFactory = Activator.class$("de.vw.mib.debugmanager.probes.DebugProbeFactory")) : class$de$vw$mib$debugmanager$probes$DebugProbeFactory).getName()).append(")");
        stringBuilder.append(")");
        String string = stringBuilder.toString();
        this.bundleContext.addServiceListener(this, string);
        ServiceReference[] serviceReferenceArray = this.bundleContext.getServiceReferences(null, string);
        for (int i2 = 0; serviceReferenceArray != null && i2 < serviceReferenceArray.length; ++i2) {
            this.serviceChanged(new ServiceEvent(1, serviceReferenceArray[i2]));
        }
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

