/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.impl.system.SystemServicesProvider;
import de.vw.mib.asl.internal.system.AslTargetSystemHmiWatchdogResponder$1;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.util.SystemLogger;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.system.DSIHMIWatchDog;
import org.dsi.ifc.system.DSIHMIWatchDogListener;

public final class AslTargetSystemHmiWatchdogResponder
extends AbstractASLTarget {
    private static final int EV_WATCHDOG_WATCHDOG_WHO_WATCHES_THE_WATCHERS_TIMEOUT;
    private static final int WATCHDOG_WHO_WATCHES_THE_WATCHERS_TIMEOUT;
    private static boolean heartBeatResponseIsActive;
    private DSIHMIWatchDog dsiHmiWatchDog;
    private boolean atLeastOnWatchdogPingWasReceived;
    private SystemServices systemServices;
    private SystemLogger systemLogger;
    static /* synthetic */ Class class$org$dsi$ifc$system$DSIHMIWatchDog;
    static /* synthetic */ Class class$org$dsi$ifc$system$DSIHMIWatchDogListener;

    public AslTargetSystemHmiWatchdogResponder(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.initializeTarget();
    }

    public AslTargetSystemHmiWatchdogResponder(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.initializeTarget();
    }

    private void initializeTarget() {
        this.systemServices = SystemServicesProvider.getSystemServices();
        this.systemLogger = new SystemLogger(this.systemServices.getAsl1Logger(), super.getClass());
        this.atLeastOnWatchdogPingWasReceived = false;
    }

    @Override
    public int getSubClassifier() {
        return 2048;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (!heartBeatResponseIsActive) break;
                DSIProxy dSIProxy = SystemServicesProvider.getSystemServices().getDsiProxy();
                this.dsiHmiWatchDog = (DSIHMIWatchDog)dSIProxy.getService(this, class$org$dsi$ifc$system$DSIHMIWatchDog == null ? (class$org$dsi$ifc$system$DSIHMIWatchDog = AslTargetSystemHmiWatchdogResponder.class$("org.dsi.ifc.system.DSIHMIWatchDog")) : class$org$dsi$ifc$system$DSIHMIWatchDog);
                DSIHMIWatchDogListener dSIHMIWatchDogListener = this.createDsiWatchDogListener();
                dSIProxy.addResponseListener(this, class$org$dsi$ifc$system$DSIHMIWatchDogListener == null ? (class$org$dsi$ifc$system$DSIHMIWatchDogListener = AslTargetSystemHmiWatchdogResponder.class$("org.dsi.ifc.system.DSIHMIWatchDogListener")) : class$org$dsi$ifc$system$DSIHMIWatchDogListener, dSIHMIWatchDogListener);
                this.systemLogger.trace("Received POWER_ON event.");
                this.dsiHmiWatchDog.hmiReady();
                this.dsiHmiWatchDog.setNotification(1, (DSIListener)dSIHMIWatchDogListener);
                break;
            }
            case 100001: {
                this.systemLogger.warn("updateQueryHeartbeat wasn't received from southside for 113s since the last time. Southside dead?");
                break;
            }
        }
    }

    void dsiHmiWatchDogUpdateQueryHeartbeat(int n) {
        this.systemLogger.trace(new Object[]{"Send heartbeat to south side now. Sequence number: ", new Integer(n)});
        this.dsiHmiWatchDog.heartbeat(n);
        if (this.atLeastOnWatchdogPingWasReceived) {
            this.restartTimer(-1585053440);
        } else {
            this.atLeastOnWatchdogPingWasReceived = true;
            this.startTimer(-1585053440, (long)0, false);
        }
    }

    @Override
    public int getDefaultTargetId() {
        return 5605;
    }

    private DSIHMIWatchDogListener createDsiWatchDogListener() {
        return new AslTargetSystemHmiWatchdogResponder$1(this);
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
        heartBeatResponseIsActive = null == System.getProperty("de.vw.mib.asl.internal.system.deactivateHeartbeatResponse");
    }
}

