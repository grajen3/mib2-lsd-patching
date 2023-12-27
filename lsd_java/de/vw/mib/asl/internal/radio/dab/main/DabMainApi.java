/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.main;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.DabDatabase;
import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import de.vw.mib.asl.internal.radio.dab.main.HsmTarget;
import de.vw.mib.asl.internal.radio.dab.stationList.HmiDabListViewApi;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public final class DabMainApi {
    private static HsmTarget dabMainTarget = (HsmTarget)DabDatabase.mDabMainTarget;

    private DabMainApi() {
    }

    public static void notifyUpdateComponentList(ComponentInfo[] componentInfoArray) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1920335616);
        eventGeneric.setObject(0, componentInfoArray);
        DabMainApi.send(eventGeneric, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_DSI);
    }

    public static void notifyUpdateServiceList(ServiceInfo[] serviceInfoArray) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1886781184);
        eventGeneric.setObject(0, serviceInfoArray);
        DabMainApi.send(eventGeneric, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_DSI);
    }

    public static void notifyUpdateDataServiceList() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1769340672);
        DabMainApi.send(eventGeneric, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_DSI);
    }

    public static void notifyUpdateFrequencyList() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-2121858816);
        DabMainApi.send(eventGeneric, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_DSI);
    }

    public static void notifyCurrentStationInfo(FrequencyInfo frequencyInfo, EnsembleInfo ensembleInfo, ServiceInfo serviceInfo, ComponentInfo componentInfo) {
        if (null != dabMainTarget) {
            dabMainTarget.updateCurrentStationInfo(frequencyInfo, ensembleInfo, serviceInfo, componentInfo);
            HmiDabListViewApi.notifyCurrentStationInfo();
        }
    }

    public static void notifyNewStationSelected(FrequencyInfo frequencyInfo, EnsembleInfo ensembleInfo, ServiceInfo serviceInfo, ComponentInfo componentInfo) {
        if (null != dabMainTarget) {
            dabMainTarget.newStationSelected(ensembleInfo, serviceInfo, componentInfo);
        }
    }

    public static void notifyCurrentPreset(int n) {
        if (null != dabMainTarget) {
            dabMainTarget.updateCurrentStationInfo(n);
        }
    }

    public static void notifyFrequencyTuneDone(FrequencyInfo frequencyInfo, EnsembleInfo ensembleInfo) {
        if (frequencyInfo != null && frequencyInfo.getFrequency() > 0L) {
            RadioData.getDabDatabase().mTunerState.setCurrentFrequency(frequencyInfo);
            if (ensembleInfo != null) {
                DabTunerState.correctEmptyLabels(ensembleInfo);
                RadioData.getDabDatabase().mTunerState.setCurrentEnsemble(ensembleInfo);
            } else {
                RadioData.getDabDatabase().mTunerState.setCurrentService(null, null);
            }
        }
        if (null != dabMainTarget) {
            dabMainTarget.updateCurrentStationInfo(frequencyInfo, ensembleInfo);
            HmiDabListViewApi.notifyCurrentStationInfo();
        }
    }

    public static void notifySelectServiceDone(EnsembleInfo ensembleInfo, ServiceInfo serviceInfo, ComponentInfo componentInfo) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1651900160);
        eventGeneric.setObject(0, ensembleInfo);
        eventGeneric.setObject(1, serviceInfo);
        eventGeneric.setObject(2, componentInfo);
        DabMainApi.send(eventGeneric, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_DSI);
    }

    public static void notifySelectServiceRunning() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(1028);
        DabMainApi.send(eventGeneric, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_DSI);
    }

    public static void notifyScanNextService(EnsembleInfo ensembleInfo, ServiceInfo serviceInfo, ComponentInfo componentInfo) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1517682432);
        eventGeneric.setObject(0, ensembleInfo);
        eventGeneric.setObject(1, serviceInfo);
        eventGeneric.setObject(2, componentInfo);
        DabMainApi.send(eventGeneric, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_DSI);
    }

    public static void notifyServiceSelectedUnsuccessful() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1786117888);
        DabMainApi.send(eventGeneric, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_DSI);
    }

    public static void notifyPrepareTuningStatus(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1870003968);
        eventGeneric.setInt(0, n);
        DabMainApi.send(eventGeneric, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_DSI);
    }

    public static void notifyDabPresetsUpdate() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(2038890752);
        DabMainApi.send(eventGeneric, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_DSI);
    }

    public static void notifyServiceTunedFromList() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(2105999616);
        DabMainApi.send(eventGeneric, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_LIST);
    }

    public static void notifySyncStatus(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1685454592);
        eventGeneric.setInt(0, n);
        DabMainApi.send(eventGeneric, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_DSI);
    }

    public static void notifyTunerActivated() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1601568512);
        DabMainApi.send(eventGeneric, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_DSI);
    }

    public static void notifyTunerDeactivated() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1584791296);
        DabMainApi.send(eventGeneric, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_DSI);
    }

    public static void triggerLastService() {
        if (null != dabMainTarget) {
            dabMainTarget.tuneLastService();
        }
    }

    public static void startAutoStore(int n, int n2) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1953890048);
        eventGeneric.setSenderEventId(n2);
        DabMainApi.send(eventGeneric, n);
    }

    public static void cancelAutoStore(int n, int n2) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1970667264);
        eventGeneric.setSenderEventId(n2);
        DabMainApi.send(eventGeneric, n);
    }

    public static void notifySearchingState(boolean bl) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(226);
        eventGeneric.setBoolean(0, bl);
        DabMainApi.send(eventGeneric, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_DSI);
    }

    private static void send(EventGeneric eventGeneric, int n) {
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setReceiverTargetId(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB);
        ServiceManager.eventMain.getEventDispatcher().send(eventGeneric);
    }

    public static void restartTuner(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(1026);
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setReceiverTargetId(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    public static void pauseTuner(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(1027);
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setReceiverTargetId(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    public static void notifyTimeoutForServiceName(ServiceInfo serviceInfo) {
        if (null != serviceInfo) {
            RadioData.getDabDatabase().dabPresetList.changePresetName(serviceInfo);
            GuiApiDab.updatePresetList();
        }
    }
}

