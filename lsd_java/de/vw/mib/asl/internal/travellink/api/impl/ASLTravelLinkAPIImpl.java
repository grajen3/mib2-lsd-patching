/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.api.impl;

import de.vw.mib.asl.api.travellink.ASLTravelLinkAPI;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.main.TargetMain;
import java.util.ArrayList;

public class ASLTravelLinkAPIImpl
implements ASLTravelLinkAPI {
    @Override
    public void updateRadioText(ArrayList arrayList) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("ASLTravelLinkAPIImpl - updateRadioText()").log();
            }
            if (TLinkServiceManager.isTravelLinkReady()) {
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateRadioText(arrayList);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void updateSdarsTunerState(int n) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("ASLTravelLinkAPIImpl - updateSdarsTunerState( ").append(n).append(" )").log();
            }
            TLinkServiceManager.updateSdarsTunerState(n);
            if (TLinkServiceManager.isTravelLinkReady()) {
                TargetMain targetMain = TLinkServiceManager.getServiceManager().getTargetMain();
                if (null != targetMain) {
                    targetMain.updateTunerStatus(n);
                }
                TLinkServiceManager.getServiceManager().getGuiControllerMain().updateTunerStatus(n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void updateAudioSubscription(int n) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("ASLTravelLinkAPIImpl - updateAudioSubscription( ").append(n).append(")").log();
            }
            TLinkServiceManager.updateAudioSubscriptionState(n);
            if (TLinkServiceManager.isTravelLinkReady()) {
                int n2 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getAudioSubscribtion();
                if (n != n2) {
                    TLinkServiceManager.getServiceManager().getGuiControllerMain().showSubscriptionChangedPopup();
                }
                TLinkServiceManager.getServiceManager().getGuiControllerMain().updateAudioSubscriptionState(n);
                TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setAudioSubscribtion(n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    static {
        PreRegisteredIds.addServiceOrObserverToArray(0, 1642272256, -506376960, true);
    }
}

