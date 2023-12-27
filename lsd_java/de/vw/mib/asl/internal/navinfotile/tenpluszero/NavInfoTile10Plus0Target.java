/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.tenpluszero;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.splitscreen.NavigationSplitscreenService;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navinfotile.tenpluszero.NavInfoTile10Plus0NotifierModel;
import de.vw.mib.asl.internal.navinfotile.tenpluszero.NavInfoTileServiceListener;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import java.util.Observable;
import java.util.Observer;

public class NavInfoTile10Plus0Target
extends AbstractASLTarget
implements Observer {
    final NavInfoTile10Plus0NotifierModel notifierModel;
    NavInfoTileServiceListener serviceListener = new NavInfoTileServiceListener(this);
    private NavigationSplitscreenService navigationSplitscreenService;

    public NavInfoTile10Plus0Target(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.notifierModel = new NavInfoTile10Plus0NotifierModel();
        int[] nArray = new int[]{106};
        this.addObservers(nArray);
    }

    protected HsmState getDefaultState() {
        return null;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.traceState("POWER_ON");
                break;
            }
        }
    }

    private void handleNavServiceReady() {
        this.traceState("handleNavServiceReady()");
        this.navigationSplitscreenService = ASLNavigationFactory.getNavigationApi().getNavigationSplitscreenService(this.serviceListener);
        this.notifierModel.setManeuverExitViewDataDefaults();
        this.notifierModel.setManeuverViewTenItemsDefaults();
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

