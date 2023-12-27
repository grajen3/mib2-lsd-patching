/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.pnav;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceService;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navinfotile.pnav.Events;
import de.vw.mib.asl.internal.navinfotile.pnav.PnavNotifierModel;
import de.vw.mib.asl.internal.navinfotile.pnav.PnavServiceListener;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import java.util.Observable;
import java.util.Observer;

public class NavInfoTilePnavTarget
extends AbstractASLTarget
implements Observer {
    final PnavNotifierModel notifierModel = new PnavNotifierModel();
    private final PnavServiceListener pnavServiceListener = new PnavServiceListener(this);
    private NavigationGuidanceService navigationGuidanceService;

    public NavInfoTilePnavTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.traceState("POWER_ON");
                break;
            }
            case 1079641827: {
                this.traceState("START_PNAV_GUIDANCE");
                int n = eventGeneric.getInt(0);
                this.navigationGuidanceService.startGuidancePNAVRoute(n);
                break;
            }
            case 1079641828: {
                this.traceState("SET_PNAV_STATUS");
                int n = eventGeneric.getInt(0);
                this.setPNAVStatus(n);
                break;
            }
        }
    }

    private void setPNAVStatus(int n) {
        switch (n) {
            case 0: {
                this.traceState("SET_PNAV_STATUS__VALUE__C0_OFF");
                n = 0;
                break;
            }
            case 1: {
                this.traceState("SET_PNAV_STATUS__VALUE__C1_PASSIVE");
                n = 2;
                break;
            }
            case 2: {
                this.traceState("SET_PNAV_STATUS__VALUE__C2_ACTIVE");
                n = 1;
                break;
            }
            default: {
                this.traceState("default");
                n = 0;
            }
        }
        this.navigationGuidanceService.setPNAVStatus(n);
    }

    private void handleNavServiceReady() {
        this.traceState("handleNavServiceReady()");
        Events.addObservers(this);
        this.navigationGuidanceService = ASLNavigationFactory.getNavigationApi().getNavigationGuidanceService(this.pnavServiceListener);
        this.notifierModel.setDefaults();
        this.notifierModel.notifyPNavStatusChanged(this.navigationGuidanceService.getPnavStatus());
    }

    public void traceState(String string) {
        if (ServiceManager.logger2.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger2.trace(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    @Override
    public int getSubClassifier() {
        return 32;
    }

    @Override
    public void update(Observable observable, Object object) {
        this.trace("Navigation state fully operable received");
        try {
            this.handleNavServiceReady();
        }
        catch (NavigationServiceException navigationServiceException) {
            this.traceState(navigationServiceException.getMessage());
        }
    }
}

