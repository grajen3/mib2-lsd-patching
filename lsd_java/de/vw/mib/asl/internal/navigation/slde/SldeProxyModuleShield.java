/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.slde;

import de.vw.mib.asl.api.navigation.ASLNavigationTruffelFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.slde.SldeProxyModule;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.properties.values.SpellerData;

public class SldeProxyModuleShield
extends SldeProxyModule {
    public SldeProxyModuleShield() {
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "SldeProxyModuleShield");
    }

    @Override
    public void handleSwitchToMapResultView() {
        this.printTrace("handleSwitchToMapResultView");
        ASLNavigationTruffelFactory.getNavigationTruffelApi().switchToResultMapView(true);
    }

    @Override
    public void handleRequestNextPage() {
        this.printTrace("handleRequestNextPage");
        ASLNavigationTruffelFactory.getNavigationTruffelApi().switchToResultMapView(false);
    }

    @Override
    public void handleListSelectById(EventGeneric eventGeneric) {
    }

    @Override
    public void handleCancelSearch() {
        try {
            this.printTrace("cancelSearch (don't send event. TargetShield is receiving this event too.");
            if (!ASLNavigationTruffelFactory.getNavigationTruffelApi().isWaitingForTryMatchLocationResults()) {
                this.printTrace("isWaitingForTryMatchLocationResults==false");
                this.quitModelWaitstate();
            }
        }
        catch (Exception exception) {
            this.printTrace("Exception on handleCancelSearch");
        }
    }

    @Override
    public void startSearch() {
    }

    @Override
    public void stopSearch() {
        this.printTrace("stopSearch");
        ASLNavigationTruffelFactory.getNavigationTruffelApi().stopSearch();
    }

    @Override
    public void spellerTextChanged(SpellerData spellerData) {
        this.printTrace("spellerTextChanged: Forwarding event to Shield.");
        ASLNavigationTruffelFactory.getNavigationTruffelApi().spellerTextChanged();
    }

    @Override
    void sendEvent(EventGeneric eventGeneric) {
        EventGeneric eventGeneric2 = ServiceManager.eventMain.getEventFactory().newEvent(eventGeneric);
        eventGeneric2.setReceiverTargetId(-951380992);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric2);
    }

    @Override
    void allowReceivingEvents(boolean bl) {
        this.printTrace(new StringBuffer().append("allowReceivingEvents=").append(bl).toString());
        ASLNavigationTruffelFactory.getNavigationTruffelApi().allowReceivingEvents(bl);
    }

    @Override
    void handleReturnToDualList() {
        this.quitModelWaitstate();
    }

    @Override
    void setupSlde(EventGeneric eventGeneric) {
    }

    @Override
    void initXt9Finished() {
        ASLNavigationTruffelFactory.getNavigationTruffelApi().initXt9Finished();
    }
}

