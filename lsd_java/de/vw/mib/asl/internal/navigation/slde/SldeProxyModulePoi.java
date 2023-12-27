/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.slde;

import de.vw.mib.asl.api.navigation.ASLNavigationTruffelFactory;
import de.vw.mib.asl.api.navigation.poi.ASLNavigationPoiFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.shield.transformer.ShieldCollector;
import de.vw.mib.asl.internal.navigation.slde.SldeEventHelper;
import de.vw.mib.asl.internal.navigation.slde.SldeProxyModule;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.properties.values.SpellerData;

public class SldeProxyModulePoi
extends SldeProxyModule {
    public SldeProxyModulePoi() {
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "SldeProxyModulePoi");
    }

    @Override
    public void handleSwitchToMapResultView() {
        this.clearResultList();
        this.startSearch();
        this.quitModelWaitstate();
    }

    @Override
    public void handleRequestNextPage() {
    }

    @Override
    public void startSearch() {
        this.printTrace("startPoiSearch");
        EventGeneric eventGeneric = SldeEventHelper.generateEvent(1598755840, 1372131392);
        eventGeneric.setInt(0, 0);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void stopSearch() {
        this.printTrace("stopPoiSearch");
        EventGeneric eventGeneric = SldeEventHelper.generateEvent(1598755840, -1174273984);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void handleListSelectById(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            ShieldCollector shieldCollector = (ShieldCollector)ASLNavigationTruffelFactory.getNavigationTruffelApi().getSearchResult(n);
            EventGeneric eventGeneric2 = SldeEventHelper.generateEvent(1598755840, 37303552);
            eventGeneric2.setObject(54080768, new Integer(n));
            eventGeneric2.setObject(70857984, shieldCollector.navLocation);
            ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric2);
        }
        catch (Exception exception) {
            this.printTrace("Exception on handleListSelectById");
        }
    }

    @Override
    public void handleCancelSearch() {
        this.stopSearch();
        this.quitModelWaitstate();
    }

    @Override
    public void spellerTextChanged(SpellerData spellerData) {
        this.printTrace("spellerTextChanged discarded. Don't need to do anything on textchange");
    }

    @Override
    void sendEvent(EventGeneric eventGeneric) {
        eventGeneric.setReceiverTargetId(1598755840);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    void allowReceivingEvents(boolean bl) {
    }

    @Override
    void handleReturnToDualList() {
        EventGeneric eventGeneric = SldeEventHelper.generateEvent(1598755840, 87635200);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        this.quitModelWaitstate();
    }

    @Override
    void setupSlde(EventGeneric eventGeneric) {
        this.spellerHandler.removeSuggestion();
    }

    @Override
    void initXt9Finished() {
        ASLNavigationPoiFactory.getNavigationPoiApi().initXt9OnboardFinished();
    }
}

