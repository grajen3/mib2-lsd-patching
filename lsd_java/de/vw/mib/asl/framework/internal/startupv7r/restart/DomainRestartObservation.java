/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.restart;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServiceManager;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;
import de.vw.mib.asl.framework.internal.startupv7r.model.DomainStates;
import de.vw.mib.asl.framework.internal.startupv7r.restart.DomainRestartObservation$1;
import de.vw.mib.asl.framework.internal.startupv7r.restart.RestartHandler;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.Util;
import org.dsi.ifc.startup.DSIStartup;
import org.dsi.ifc.startup.DSIStartupListener;

public class DomainRestartObservation
implements DSIServiceStateListener {
    final DomainStates domainStatesModel;
    private final Logger logger;
    private final RestartHandler restartHandler;
    private final EventDispatcherHSM eventDispatcher;
    private final DSIProxy dsiProxy;
    private DSIStartup dsiStartup;
    private DSIStartupListener dsiStartupListener;
    final IntSet domainsWereFullyOperationalOnce;
    static /* synthetic */ Class class$org$dsi$ifc$startup$DSIStartup;
    static /* synthetic */ Class class$org$dsi$ifc$startup$DSIStartupListener;

    public DomainRestartObservation(StartupServices startupServices) {
        this.logger = startupServices.getLogger();
        this.restartHandler = startupServices.getRestartHandler();
        this.eventDispatcher = startupServices.getEventDispatcher();
        this.domainStatesModel = startupServices.getDomainStates();
        this.dsiProxy = startupServices.getDSIProxy();
        this.domainsWereFullyOperationalOnce = new IntOptHashSet();
    }

    public void run() {
        this.dsiProxy.addServiceStateListener(class$org$dsi$ifc$startup$DSIStartup == null ? (class$org$dsi$ifc$startup$DSIStartup = DomainRestartObservation.class$("org.dsi.ifc.startup.DSIStartup")) : class$org$dsi$ifc$startup$DSIStartup, this);
    }

    @Override
    public void unregistered(String string, int n) {
    }

    @Override
    public void registered(String string, int n) {
        this.connectToDsi();
    }

    boolean handleRestartSds(int n, int n2) {
        boolean bl;
        boolean bl2 = true;
        boolean bl3 = bl = (n2 & 1) != 0 && (n & 4) != 0 || Util.isBitSet(16, n2) && Util.isBitSet(n, 1);
        if ((n2 & 0x30C) != 0 && (n & 0x10) != 0) {
            this.info("SDS/TTS is in state ERROR now");
            this.domainStatesModel.setRequestedState(10, n);
            EventFactory eventFactory = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getEventFactory();
            this.eventDispatcher.sendSafe(eventFactory.newEvent(5900, 328275968, 107));
            this.eventDispatcher.sendSafe(eventFactory.newEvent(5900, 345053184, 107));
        } else if ((n2 & 8) != 0 && (n & 1) != 0) {
            this.info("SDS/TTS is in state not started now");
            this.domainStatesModel.setRequestedState(10, n);
        } else if (bl) {
            this.info("[ASLStartup v8]SDS/TTS seems to be ready for restart now .. trying to load");
            this.domainStatesModel.setRequestedState(10, n);
            if (StartupServiceManager.startupDone) {
                this.restartHandler.restart(RestartHandler.RESTART_SPEECH);
            } else {
                this.restartHandler.queueForRestart(RestartHandler.RESTART_SPEECH);
            }
        } else if ((n2 & 4) != 0 && (n & 8) != 0) {
            this.info("[ASLStartup v8]SDS/TTS domain seems to be restarted correctly");
            this.domainStatesModel.setRequestedState(10, n);
        } else {
            bl2 = false;
        }
        return bl2;
    }

    boolean handleRestartNav(int n, int n2) {
        boolean bl = true;
        if ((n2 & 8) != 0 && (n & 1) != 0) {
            this.info("Nav is in state not started now");
            this.domainStatesModel.setRequestedState(6, n);
        } else if ((n2 & 1) != 0 && (n & 4) != 0) {
            this.info("[ASLStartup v8]Nav seems to be ready for restart now .. trying to load");
            this.domainStatesModel.setRequestedState(6, n);
            if (StartupServiceManager.startupDone) {
                if (StartupServiceManager.komoNavIsAllowedByCoding) {
                    this.restartHandler.restart(RestartHandler.RESTART_NAV_WITH_KOMONAV);
                } else {
                    this.restartHandler.restart(RestartHandler.RESTART_NAV_WITH_SPLITSCREEN);
                }
            } else if (StartupServiceManager.komoNavIsAllowedByCoding) {
                this.restartHandler.queueForRestart(RestartHandler.RESTART_NAV_WITH_KOMONAV);
            } else {
                this.restartHandler.queueForRestart(RestartHandler.RESTART_NAV_WITH_SPLITSCREEN);
            }
        } else if ((n2 & 4) != 0 && (n & 8) != 0) {
            this.info("[ASLStartup v8]Nav domain seems to be restarted correctly");
            this.domainStatesModel.setRequestedState(6, n);
        } else {
            bl = false;
        }
        return bl;
    }

    boolean handleRestartGemmi(int n, int n2) {
        boolean bl = true;
        if ((n2 & 0xC) != 0 && (n & 1) != 0) {
            this.info("[ASLStartup v8]Google Earth seems to be down");
            this.domainStatesModel.setRequestedState(17, n);
        } else if ((n2 & 1) != 0 && (n & 8) != 0) {
            this.info("[ASLStartup v8]Google Earth seems to be ready for restart now .. trying to load");
            this.domainStatesModel.setRequestedState(17, n);
            if (StartupServiceManager.startupDone) {
                this.restartHandler.restart(RestartHandler.RESTART_GEMMI);
            } else {
                this.restartHandler.queueForRestart(RestartHandler.RESTART_GEMMI);
            }
        } else {
            bl = false;
        }
        return bl;
    }

    boolean handleRestartExlap(int n, int n2) {
        boolean bl = true;
        if ((Util.isAnyBitSet(12, n2) || n2 > 64) && Util.isBitSet(n, 16)) {
            this.info("[ASLStartup v8]ExLAP is down, waiting...");
            this.domainStatesModel.setRequestedState(32, n);
        } else if (Util.isAnyBitSet(16, n2) && Util.isBitSet(n, 0)) {
            this.info("[ASLStartup v8]ExLAP is down, waiting for south side to restart...");
            this.domainStatesModel.setRequestedState(32, n);
        } else if (Util.isBitSet(16, n2) && Util.isBitSet(n, 1)) {
            this.info("[ASLStartup v8]ExLAP is down, restarting...");
            this.domainStatesModel.setRequestedState(32, n);
            if (StartupServiceManager.startupDone) {
                this.info("Restarting Exlap from Placeholder");
                this.restartHandler.restart(RestartHandler.RESTART_EXLAP);
            } else {
                this.restartHandler.queueForRestart(RestartHandler.RESTART_EXLAP);
            }
        } else if (Util.isBitSet(32, n)) {
            this.info("[ASLStartup v8]ExLAP is unrecoverably down!");
            this.domainStatesModel.setRequestedState(32, n);
        } else {
            bl = false;
        }
        return bl;
    }

    private void connectToDsi() {
        this.dsiStartup = (DSIStartup)this.dsiProxy.getService(null, class$org$dsi$ifc$startup$DSIStartup == null ? (class$org$dsi$ifc$startup$DSIStartup = DomainRestartObservation.class$("org.dsi.ifc.startup.DSIStartup")) : class$org$dsi$ifc$startup$DSIStartup);
        this.dsiStartupListener = this.createDsiStartupListener();
        this.dsiProxy.addResponseListener(null, class$org$dsi$ifc$startup$DSIStartupListener == null ? (class$org$dsi$ifc$startup$DSIStartupListener = DomainRestartObservation.class$("org.dsi.ifc.startup.DSIStartupListener")) : class$org$dsi$ifc$startup$DSIStartupListener, this.dsiStartupListener);
        this.dsiStartup.setNotification(this.dsiStartupListener);
    }

    private DSIStartupListener createDsiStartupListener() {
        return new DomainRestartObservation$1(this);
    }

    void info(String string) {
        this.logger.info(1, new StringBuffer().append("[").append(super.getClass().getName()).append("] ").append(string).toString());
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

