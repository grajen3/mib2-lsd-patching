/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import de.vw.mib.genericevents.TaskInterface;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.has.HAS;
import de.vw.mib.has.HASClient;
import de.vw.mib.has.internal.HASClockImpl;
import de.vw.mib.has.internal.HASConfig;
import de.vw.mib.has.internal.HASDSITarget;
import de.vw.mib.has.internal.HASLog;
import de.vw.mib.has.internal.HASManager;
import de.vw.mib.has.internal.HASStartupTarget$1;
import de.vw.mib.has.internal.HASStartupTarget$GeneralTimerCallback;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class HASStartupTarget
implements Target {
    private static final String LOG_PREFIX;
    private final HashMap targets = new HashMap();
    private final GenericEvents eventContext;
    private final TaskInterface task;
    private int targetId;
    private boolean running;
    private Timer timer;
    private HASClockImpl clock;
    private ThreadSwitchingTarget threadSwitch;
    private ServiceReference threadSwitchRef;
    private ServiceReference loggerFactoryRef;
    private static final String[] CLIENT_NAMES;
    private static final int[] FEATURE_FLAGS;
    private static final boolean[] CLIENT_DEFAULTS;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$genericevents$ThreadSwitchingTarget;

    public HASStartupTarget(GenericEvents genericEvents, String string) {
        this(genericEvents, 558306816, string);
    }

    public HASStartupTarget(GenericEvents genericEvents, int n, String string) {
        this.eventContext = genericEvents;
        this.task = genericEvents.getEventDispatcher().getTask(string);
        this.eventContext.getEventDispatcher().registerTarget(n, this, string);
    }

    @Override
    public GenericEvents getMainObject() {
        return this.eventContext;
    }

    @Override
    public int getTargetId() {
        return this.targetId;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.onPowerOn();
                break;
            }
            case 107: {
                this.onPowerOff();
                break;
            }
        }
    }

    private void onPowerOn() {
        this.running = true;
        this.initLogger();
        LogMessage logMessage = HASLog.info();
        HASLog.appendPrefixAndMethod(logMessage, "HASStartupTarget", "onPowerOn", true);
        logMessage.append("Initializing HAS engine").log();
        this.initThreadSwitch();
        this.initDSITargets();
        this.initGeneralTimer();
    }

    private void onPowerOff() {
        this.running = false;
        this.initLogger();
        LogMessage logMessage = HASLog.info();
        HASLog.appendPrefixAndMethod(logMessage, "HASStartupTarget", "onPowerOff", true);
        logMessage.append("Stopping HAS engine").log();
        this.stopGeneralTimer();
        this.stopDSITargets();
        this.releaseThreadSwitch();
        this.releaseLogger();
    }

    private void initLogger() {
        if (null == this.loggerFactoryRef) {
            BundleContext bundleContext = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext();
            this.loggerFactoryRef = bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = HASStartupTarget.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName());
            if (null == this.loggerFactoryRef) {
                throw new NullPointerException("LoggerFactory");
            }
            Logger logger = ((LoggerFactory)bundleContext.getService(this.loggerFactoryRef)).getLogger(0x1008000);
            HASStartupTarget$1 hASStartupTarget$1 = new HASStartupTarget$1(this, 16, "[HAS] ", logger);
            HASLog.init(hASStartupTarget$1);
        }
    }

    private void releaseLogger() {
        if (null != this.loggerFactoryRef) {
            BundleContext bundleContext = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext();
            bundleContext.ungetService(this.loggerFactoryRef);
            this.loggerFactoryRef = null;
        }
    }

    private void initThreadSwitch() {
        if (null == this.threadSwitchRef) {
            BundleContext bundleContext = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext();
            ServiceReference[] serviceReferenceArray = bundleContext.getServiceReferences((class$de$vw$mib$genericevents$ThreadSwitchingTarget == null ? (class$de$vw$mib$genericevents$ThreadSwitchingTarget = HASStartupTarget.class$("de.vw.mib.genericevents.ThreadSwitchingTarget")) : class$de$vw$mib$genericevents$ThreadSwitchingTarget).getName(), "(genericEvents.task=hsmtask)");
            if (0 == serviceReferenceArray.length) {
                throw new NullPointerException("ThreadSwitchTarget");
            }
            this.threadSwitchRef = serviceReferenceArray[0];
            this.threadSwitch = (ThreadSwitchingTarget)bundleContext.getService(this.threadSwitchRef);
        }
    }

    private void releaseThreadSwitch() {
        if (null != this.threadSwitchRef) {
            BundleContext bundleContext = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext();
            bundleContext.ungetService(this.threadSwitchRef);
            this.threadSwitch = null;
            this.threadSwitchRef = null;
        }
    }

    private void initDSITargets() {
        Object object;
        HASClient[] hASClientArray;
        Object[] objectArray = HASStartupTarget.getConfiguredClientNames();
        HashSet hashSet = new HashSet(Arrays.asList(objectArray));
        if (hashSet.isEmpty()) {
            hASClientArray = HASLog.info();
            HASLog.appendPrefixAndMethod((LogMessage)hASClientArray, "HASStartupTarget", "initDSITargets", true);
            hASClientArray.append("No clients configured, no communication is setup.").log();
        }
        hASClientArray = HAS.getInstance().getFactory().getClients();
        for (int i2 = 0; i2 < hASClientArray.length; ++i2) {
            object = hASClientArray[i2];
            String string = ((HASClient)object).getClientName();
            if (!hashSet.contains(string)) continue;
            this.initDSITarget((HASClient)object);
            hashSet.remove(string);
        }
        if (!hashSet.isEmpty()) {
            Iterator iterator = hashSet.iterator();
            object = HASLog.appendPrefixAndMethod(HASLog.warn(), "HASStartupTarget", "initDSITargets", true);
            object.append("Unknown HAS client(s) configured: \"").append(String.valueOf(iterator.next())).append("\"");
            while (iterator.hasNext()) {
                object.append(", \"").append(String.valueOf(iterator.next())).append("\"");
            }
            object.log();
        }
    }

    private void stopDSITargets() {
        Iterator iterator = this.targets.values().iterator();
        while (iterator.hasNext()) {
            HASDSITarget hASDSITarget = (HASDSITarget)iterator.next();
            EventGeneric eventGeneric = this.eventContext.getEventFactory().newEvent(this.getTargetId(), hASDSITarget.getTargetId(), 107);
            this.eventContext.getEventDispatcher().sendSafe(eventGeneric);
        }
    }

    private void initDSITarget(HASClient hASClient) {
        String string = hASClient.getClientName();
        LogMessage logMessage = HASLog.info();
        HASLog.appendPrefixAndMethod(logMessage, "HASStartupTarget", "initDSITarget", true);
        logMessage.append("Initializing HAS DSI Target");
        HASLog.appendStringProperty(logMessage, "client", string, true).log();
        HASDSITarget hASDSITarget = (HASDSITarget)this.targets.get(hASClient);
        if (null == hASDSITarget) {
            hASDSITarget = new HASDSITarget(this.eventContext, -865266176 + hASClient.getDSIInstance(), this.task, hASClient);
            this.targets.put(hASClient, hASDSITarget);
        }
        EventGeneric eventGeneric = this.eventContext.getEventFactory().newEvent(this.getTargetId(), hASDSITarget.getTargetId(), 106);
        this.eventContext.getEventDispatcher().sendSafe(eventGeneric);
    }

    private void initGeneralTimer() {
        if (null == this.timer) {
            int n = HASConfig.getTimerInterval();
            TimerManager timerManager = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getTimerManager();
            this.timer = timerManager.createTimer("HAS-Timer", n, false, new HASStartupTarget$GeneralTimerCallback(this), this.threadSwitch);
            this.clock = HASManager.getInstance().getClock();
            this.clock.setInterval(n);
        }
        this.timer.start();
    }

    void onGeneralTimer() {
        if (this.running) {
            try {
                this.clock.onTimer();
            }
            catch (RuntimeException runtimeException) {
                HASLog.error().append("onGeneralTimer execution failed").attachThrowable(runtimeException).log();
            }
            this.initGeneralTimer();
        }
    }

    private void stopGeneralTimer() {
        if (null != this.timer) {
            this.timer.stop();
        }
    }

    @Override
    public void setTargetId(int n) {
        this.targetId = n;
    }

    private static String[] getConfiguredClientNames() {
        ConfigurationManagerDiag configurationManagerDiag = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getConfigurationManagerDiag();
        boolean[] blArray = new boolean[CLIENT_NAMES.length];
        int n = 0;
        for (int i2 = 0; i2 < blArray.length; ++i2) {
            blArray[i2] = CLIENT_DEFAULTS[i2] || configurationManagerDiag.isFeatureFlagSet(FEATURE_FLAGS[i2]);
            if (!blArray[i2]) continue;
            ++n;
        }
        LogMessage logMessage = HASLog.info();
        if (null != logMessage) {
            HASLog.appendPrefixAndMethod(logMessage, "HASStartupTarget", "getConfiguredClientNames", true);
            logMessage.append("clients by feature flags");
            for (int i3 = 0; i3 < blArray.length; ++i3) {
                HASLog.appendBooleanProperty(logMessage, CLIENT_NAMES[i3], blArray[i3], true);
            }
            logMessage.log();
        }
        String[] stringArray = new String[n];
        for (int i4 = blArray.length - 1; 0 < n && i4 >= 0; --i4) {
            if (!blArray[i4]) continue;
            stringArray[--n] = CLIENT_NAMES[i4];
        }
        return stringArray;
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
        CLIENT_NAMES = new String[]{"EXLAP", "OnlineServices"};
        FEATURE_FLAGS = new int[]{64, 184};
        CLIENT_DEFAULTS = new boolean[]{true, false};
    }
}

