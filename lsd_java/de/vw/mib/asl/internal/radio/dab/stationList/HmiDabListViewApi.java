/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.stationList;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.dab.stationList.HmiDabListView;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class HmiDabListViewApi {
    public static HmiDabListView mListView = null;

    public static void create(GenericEvents genericEvents, int n, String string) {
        if (mListView == null) {
            mListView = new HmiDabListView(genericEvents, n, string);
            mListView.registerObservers();
        }
    }

    public static void triggerMe(int n) {
        mListView.triggerMe(n);
    }

    public static void notifySyncState() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1551499008);
        HmiDabListViewApi.send(eventGeneric);
    }

    public static void notifyLinkingState() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1484390144);
        HmiDabListViewApi.send(eventGeneric);
    }

    public static void notifyServiceList() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1534721792);
        HmiDabListViewApi.send(eventGeneric);
    }

    public static void notifyComponentList() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1517944576);
        HmiDabListViewApi.send(eventGeneric);
    }

    public static void notifyDataServiceList() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1501167360);
        HmiDabListViewApi.send(eventGeneric);
    }

    public static void reloadList() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1450835712);
        HmiDabListViewApi.send(eventGeneric);
    }

    public static void notifyCurrentStationInfo() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1568276224);
        HmiDabListViewApi.send(eventGeneric);
    }

    public static void notifyJumpLmAborted() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1434058496);
        HmiDabListViewApi.send(eventGeneric);
    }

    public static void notifyJumpLmStarted() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1417281280);
        HmiDabListViewApi.send(eventGeneric);
    }

    public static void notifyPresetBank() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1467612928);
        HmiDabListViewApi.send(eventGeneric);
    }

    public static void notifyTunerNotAvailable() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1383726848);
        HmiDabListViewApi.send(eventGeneric);
    }

    private static void send(EventGeneric eventGeneric) {
        eventGeneric.setSenderTargetId(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB);
        eventGeneric.setReceiverTargetId(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_LIST);
        ServiceManager.eventMain.getEventDispatcher().send(eventGeneric);
    }
}

