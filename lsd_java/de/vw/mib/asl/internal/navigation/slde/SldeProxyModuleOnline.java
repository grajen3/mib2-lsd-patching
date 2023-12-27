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
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.properties.values.SpellerData;

public class SldeProxyModuleOnline
extends SldeProxyModule {
    public SldeProxyModuleOnline() {
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "SldeProxyModuleOnline");
    }

    @Override
    public void handleSwitchToMapResultView() {
        this.clearResultList();
        this.startSearch();
        this.quitModelWaitstate();
    }

    @Override
    public void handleRequestNextPage() {
        EventGeneric eventGeneric = SldeEventHelper.generateEvent(-1807019008, -1559625664);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void handleListSelectById(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            ShieldCollector shieldCollector = (ShieldCollector)ASLNavigationTruffelFactory.getNavigationTruffelApi().getSearchResult(n);
            EventGeneric eventGeneric2 = SldeEventHelper.generateEvent(-1807019008, 37303552);
            eventGeneric2.setObject(54080768, new Integer(n));
            eventGeneric2.setObject(70857984, shieldCollector.navLocation);
            ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric2);
        }
        catch (GenericEventException genericEventException) {
            // empty catch block
        }
    }

    @Override
    public void handleCancelSearch() {
        this.stopSearch();
        this.quitModelWaitstate();
    }

    @Override
    public void startSearch() {
        this.printTrace("startOnlinePoiSearch");
        EventGeneric eventGeneric = SldeEventHelper.generateEvent(-1807019008, -2029387712);
        EventGeneric eventGeneric2 = SldeEventHelper.generateEvent(-1807019008, -2096496576);
        eventGeneric2.setString(0, this.spellerHandler.getSpellerData().getEnteredText());
        EventGeneric eventGeneric3 = SldeEventHelper.generateEvent(-1807019008, -2130051008);
        EventGeneric eventGeneric4 = SldeEventHelper.generateEvent(-1807019008, -2012610496);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric2);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric3);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric4);
    }

    @Override
    public void stopSearch() {
        this.printTrace("stopOnlinePoiSearch");
        EventGeneric eventGeneric = SldeEventHelper.generateEvent(-1807019008, -1962278848);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void spellerTextChanged(SpellerData spellerData) {
        this.printTrace("spellerTextChanged discarded. Don't need to do anything on textchange");
    }

    @Override
    void sendEvent(EventGeneric eventGeneric) {
        eventGeneric.setReceiverTargetId(-1807019008);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    void allowReceivingEvents(boolean bl) {
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
        ASLNavigationPoiFactory.getNavigationPoiApi().initXt9Finished();
    }
}

