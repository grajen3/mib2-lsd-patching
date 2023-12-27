/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.overlay;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.splitscreen.NavigationSplitscreenService;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navinfotile.overlay.OverlayNotifierModel;
import de.vw.mib.asl.internal.navinfotile.overlay.OverlayServiceListener;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import java.util.Observable;
import java.util.Observer;

public class NavInfoTileOverlayTarget
extends AbstractASLTarget
implements Observer {
    final OverlayNotifierModel notifierModel = new OverlayNotifierModel();
    OverlayServiceListener overlayHandler = new OverlayServiceListener(this);
    private NavigationSplitscreenService navigationSplitscreenService;

    public NavInfoTileOverlayTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
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
        this.navigationSplitscreenService = ASLNavigationFactory.getNavigationApi().getNavigationSplitscreenService(this.overlayHandler);
        this.notifierModel.setOverlayDataDefaults();
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

