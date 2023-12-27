/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.INavServiceStateListener;
import de.vw.mib.asl.api.navigation.INavigationPosPosition;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceService;
import de.vw.mib.asl.api.navigation.splitscreen.NavigationSplitscreenService;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navinfotile.Events;
import de.vw.mib.asl.internal.navinfotile.NavInfoTileDatapool;
import de.vw.mib.asl.internal.navinfotile.NavInfoTileNotifierModel;
import de.vw.mib.asl.internal.navinfotile.NavigationGuidanceListener;
import de.vw.mib.asl.internal.navinfotile.NavigationSplitscreenListener;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import java.util.ArrayList;
import java.util.Observer;

public class NavInfoTileTarget
extends AbstractASLTarget
implements INavServiceStateListener {
    private static final int EV_NAV_SERVICE_READY;
    final NavInfoTileNotifierModel notifierModel;
    private NavigationGuidanceService navigationGuidanceService;
    private final NavigationGuidanceListener navigationGuidanceListener;
    private final NavigationSplitscreenListener navigationSplitscreenListener;
    private NavigationSplitscreenService navigationSplitscreenService;
    private final ArrayList observer = new ArrayList();

    public NavInfoTileTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.notifierModel = new NavInfoTileNotifierModel();
        this.navigationGuidanceListener = new NavigationGuidanceListener(this);
        this.navigationSplitscreenListener = new NavigationSplitscreenListener(this);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.traceState("POWER_ON");
                Events.addObservers(this);
                this.notifierModel.notifyNavNotReady();
                ASLNavigationFactory.getNavigationApi().registerNavServiceStateListener(this);
                break;
            }
            case 8200001: {
                this.handleNavServiceReady();
                break;
            }
            case 1079641825: {
                this.traceState("SET_MANEUVER_VIEW_CONTENT");
                break;
            }
        }
    }

    private void handleNavServiceReady() {
        this.traceState("NavInfoTile: handleNavServiceReady()");
        this.notifierModel.setDefaults();
        try {
            NavInfoTileDatapool.getInstance().initPersistence();
            this.navigationGuidanceService = ASLNavigationFactory.getNavigationApi().getNavigationGuidanceService(this.navigationGuidanceListener);
            this.navigationSplitscreenService = ASLNavigationFactory.getNavigationApi().getNavigationSplitscreenService(this.navigationSplitscreenListener);
            this.notifierModel.notifyExecutionMode(this.navigationGuidanceService.getExecutionMode());
            INavigationPosPosition iNavigationPosPosition = this.navigationSplitscreenService.getCurrentPosition();
            this.notifierModel.updateCollectorGPSViewer(iNavigationPosPosition);
            this.notifierModel.updateCollectorCompassDataRotation(iNavigationPosPosition.getCompassDegree());
            NavInfoTileDatapool.getInstance().notifyPersistenceListeners();
        }
        catch (NavigationServiceException navigationServiceException) {
            this.traceState(navigationServiceException.getMessage());
        }
        for (int i2 = 0; i2 < this.observer.size(); ++i2) {
            ((Observer)this.observer.get(i2)).update(null, null);
        }
        this.notifierModel.notifyNavReady();
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

    public void updateGuidanceState(int n, int n2) {
        NavInfoTileDatapool.getInstance().setCurrentGuidanceMode(n);
        NavInfoTileDatapool.getInstance().setCurrentGuidanceState(n2);
    }

    @Override
    public void navServiceStateChanged() {
        if (ASLNavigationFactory.getNavigationApi().getNavigationServiceState() == 100) {
            try {
                this.triggerMe(1092582656);
            }
            catch (GenericEventException genericEventException) {
                // empty catch block
            }
        }
    }

    public void registerAsObserver(Observer observer) {
        this.observer.add(observer);
    }
}

