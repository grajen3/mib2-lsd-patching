/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.dsi;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.dsi.HsmDabDsi;
import de.vw.mib.asl.internal.radio.dab.presets.DabPreset;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public final class DabDsiApi {
    private static HsmDabDsi dabDsiTarget = null;
    public static int P_FOUND_ENSEMBLE = 1;
    public static int P_FOUND_FREQUENCY = 0;
    public static int P0_LM_UPDATESTATUS = 0;

    private DabDsiApi() {
    }

    public static void start(GenericEvents genericEvents, int n, String string) {
        dabDsiTarget = new HsmDabDsi(genericEvents, n, string);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1601830656);
        DabDsiApi.send(eventGeneric);
    }

    public static void stop() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1585053440);
        DabDsiApi.send(eventGeneric);
    }

    public static void stepUp() {
        RadioData.getDabDatabase().mInitialStartup = false;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1568276224);
        DabDsiApi.send(eventGeneric);
    }

    public static void stepDown() {
        RadioData.getDabDatabase().mInitialStartup = false;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1551499008);
        DabDsiApi.send(eventGeneric);
    }

    public static void startIncreasingFrequency(boolean bl) {
        RadioData.getDabDatabase().mInitialStartup = false;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1534721792);
        eventGeneric.setInt(0, 1);
        eventGeneric.setBoolean(1, bl);
        DabDsiApi.send(eventGeneric);
    }

    public static void startDecreasingFrequency(boolean bl) {
        RadioData.getDabDatabase().mInitialStartup = false;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1534721792);
        eventGeneric.setInt(0, 0);
        eventGeneric.setBoolean(1, bl);
        DabDsiApi.send(eventGeneric);
    }

    public static void stopChangingFrequency() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1517944576);
        DabDsiApi.send(eventGeneric);
    }

    public static void startTargetSeekUp(boolean bl, boolean bl2, int n) {
        RadioData.getDabDatabase().mInitialStartup = false;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1501167360);
        eventGeneric.setSenderEventId(n);
        eventGeneric.setInt(0, 1);
        eventGeneric.setBoolean(1, bl);
        eventGeneric.setBoolean(2, bl2);
        DabDsiApi.send(eventGeneric);
    }

    public static void startTargetSeekDown(boolean bl, boolean bl2, int n) {
        RadioData.getDabDatabase().mInitialStartup = false;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1501167360);
        eventGeneric.setSenderEventId(n);
        eventGeneric.setInt(0, 0);
        eventGeneric.setBoolean(1, bl);
        eventGeneric.setBoolean(2, bl2);
        DabDsiApi.send(eventGeneric);
    }

    public static void stopTargetSeek() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1467612928);
        DabDsiApi.send(eventGeneric);
    }

    public static void stopTargetSeekAtNext() {
        RadioData.getDabDatabase().mInitialStartup = false;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1484390144);
        DabDsiApi.send(eventGeneric);
    }

    public static void tuneFrequency(int n) {
        RadioData.getDabDatabase().mInitialStartup = false;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1450835712);
        eventGeneric.setInt(0, n);
        DabDsiApi.send(eventGeneric);
    }

    public static void tuneEnsemble(FrequencyInfo frequencyInfo) {
        DabDsiApi.dabDsiTarget.mDsiDabTuner.tuneEnsemble(2, 0, 0, frequencyInfo.frequency);
    }

    public static void tuneEnsemble(int n, int n2) {
        DabDsiApi.dabDsiTarget.mDsiDabTuner.tuneEnsemble(1, n, n2, 0L);
    }

    public static void scan(int n, int n2) {
        RadioData.getDabDatabase().mInitialStartup = false;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1434058496);
        eventGeneric.setSenderEventId(n2);
        eventGeneric.setInt(1, n);
        DabDsiApi.send(eventGeneric);
    }

    public static void cancelScan() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1417281280);
        DabDsiApi.send(eventGeneric);
    }

    public static void notifyLeaveManualMode() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(143065344);
        DabDsiApi.send(eventGeneric);
    }

    public static void abortSelectService() {
        if (null != dabDsiTarget) {
            DabDsiApi.dabDsiTarget.mDsiDabTuner.selectService(5, 0L, 0, 0, 0, 0, 0L);
        }
    }

    public static void selectService(ServiceInfo serviceInfo) {
        RadioData.getDabDatabase().mInitialStartup = false;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1400504064);
        eventGeneric.setObject(0, serviceInfo);
        DabDsiApi.send(eventGeneric);
    }

    public static void selectStoredService(DabPreset dabPreset) {
        RadioData.getDabDatabase().mInitialStartup = false;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1249509120);
        eventGeneric.setObject(0, dabPreset);
        DabDsiApi.send(eventGeneric);
    }

    public static void selectComponent(ComponentInfo componentInfo) {
        RadioData.getDabDatabase().mInitialStartup = false;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1333395200);
        eventGeneric.setObject(0, componentInfo);
        DabDsiApi.send(eventGeneric);
    }

    public static void updateLearnMemory(int n, int n2, int n3) {
        RadioData.getDabDatabase().mInitialStartup = false;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1299840768);
        eventGeneric.setInt(0, n2);
        eventGeneric.setInt(1, n3);
        eventGeneric.setInt(2, n);
        DabDsiApi.send(eventGeneric);
    }

    public static void ddsRotated(int n) {
        RadioData.getDabDatabase().mInitialStartup = false;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        eventGeneric.setReceiverEventId(176619776);
        DabDsiApi.send(eventGeneric);
    }

    public static void cancelLearnMemoryUpdate() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1283063552);
        DabDsiApi.send(eventGeneric);
    }

    public static void jumpLMUp() {
        RadioData.getDabDatabase().mInitialStartup = false;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1232731904);
        eventGeneric.setBoolean(0, true);
        DabDsiApi.send(eventGeneric);
    }

    public static void jumpLMDown() {
        RadioData.getDabDatabase().mInitialStartup = false;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1232731904);
        eventGeneric.setBoolean(0, false);
        DabDsiApi.send(eventGeneric);
    }

    public static void canceljumpLM() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1182400256);
        DabDsiApi.send(eventGeneric);
    }

    public static void selectServiceByFrequency(ServiceInfo serviceInfo, FrequencyInfo frequencyInfo) {
        RadioData.getDabDatabase().mInitialStartup = false;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(260505856);
        eventGeneric.setObject(0, serviceInfo);
        eventGeneric.setObject(1, frequencyInfo);
        DabDsiApi.send(eventGeneric);
    }

    public static void stepService(boolean bl) {
        RadioData.getDabDatabase().mInitialStartup = false;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(243728640);
        eventGeneric.setBoolean(0, bl);
        DabDsiApi.send(eventGeneric);
    }

    public static void activateTuner() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(277283072);
        DabDsiApi.send(eventGeneric);
    }

    public static void deactivateTuner() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(294060288);
        DabDsiApi.send(eventGeneric);
    }

    private static void send(EventGeneric eventGeneric) {
        eventGeneric.setSenderTargetId(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB);
        try {
            dabDsiTarget.gotEvent(eventGeneric);
        }
        catch (Exception exception) {
            ServiceManager.logger.error(128, "Direct DSI event Dispatching", exception);
        }
    }
}

