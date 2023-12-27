/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.api.asl.audio;

import de.vw.mib.bap.mqbpq.ServiceManager;
import de.vw.mib.bap.mqbpq.common.api.asl.audio.ASLSpeech;
import de.vw.mib.genericevents.EventGeneric;

public final class ASLRadio {
    private ASLRadio() {
    }

    public static void stopTrafficAnnouncement() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-586940352);
        ASLSpeech.performingBAPAction(1);
    }

    public static void stopTrafficInformation() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-2079915968);
        ASLSpeech.performingBAPAction(1);
    }

    public static void startSeek(int n) {
        EventGeneric eventGeneric = ServiceManager.serviceManager.genericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-805044160, eventGeneric);
        ASLSpeech.performingBAPAction(1);
    }

    public static void stopSeek() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-654049216);
        ASLSpeech.performingBAPAction(1);
    }

    public static void startTargetSeek(int n) {
        EventGeneric eventGeneric = ServiceManager.serviceManager.genericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-788266944, eventGeneric);
        ASLSpeech.performingBAPAction(1);
    }

    public static void stopTargetSeek() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-620494784);
    }

    public static void stopChangingFrequency() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-754712512);
    }

    public static void startScan() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-821821376);
        ASLSpeech.performingBAPAction(1);
    }

    public static void stopScan() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-670826432);
        ASLSpeech.performingBAPAction(1);
    }

    public static void setTpState(boolean bl) {
        EventGeneric eventGeneric = ServiceManager.serviceManager.genericEventFactory.newEvent();
        eventGeneric.setBoolean(0, bl);
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-888930240, eventGeneric);
    }

    public static void setRdsSetupOptionState(boolean bl) {
        EventGeneric eventGeneric = ServiceManager.serviceManager.genericEventFactory.newEvent();
        eventGeneric.setBoolean(0, bl);
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-956039104, eventGeneric);
    }

    public static void activateNextStation() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-1962672064);
        ASLSpeech.performingBAPAction(1);
    }

    public static void activateNextTvTunerStation() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(2013724736);
        ASLSpeech.performingBAPAction(1);
    }

    public static void activatePreviousTvTunerStation() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(2030501952);
        ASLSpeech.performingBAPAction(1);
    }

    public static void activateTvPreset(int n) {
        EventGeneric eventGeneric = ServiceManager.serviceManager.genericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-234422208, eventGeneric);
        ASLSpeech.performingBAPAction(1);
    }

    public static void satActivateNextChannel() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(0x4F040040);
        ASLSpeech.performingBAPAction(1);
    }

    public static void activatePreviousStation() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-1895563200);
        ASLSpeech.performingBAPAction(1);
    }

    public static void satActivatePreviousChannel() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(1375993920);
        ASLSpeech.performingBAPAction(1);
    }

    public static void activateStationByID(long l, int n) {
        EventGeneric eventGeneric = ServiceManager.serviceManager.genericEventFactory.newEvent();
        eventGeneric.setLong(0, l);
        eventGeneric.setInt(1, n);
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(0x4A040040, eventGeneric);
        ASLSpeech.performingBAPAction(1);
    }

    public static void activateDABServiceByID(long l) {
        EventGeneric eventGeneric = ServiceManager.serviceManager.genericEventFactory.newEvent();
        eventGeneric.setLong(0, l);
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-2046558144, eventGeneric);
        ASLSpeech.performingBAPAction(1);
    }

    public static void activateDABSecondaryServiceByID(long l) {
        EventGeneric eventGeneric = ServiceManager.serviceManager.genericEventFactory.newEvent();
        eventGeneric.setLong(0, l);
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-2080112576, eventGeneric);
        ASLSpeech.performingBAPAction(1);
    }

    public static void activateStationPreset(int n) {
        EventGeneric eventGeneric = ServiceManager.serviceManager.genericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-1811677120, eventGeneric);
        ASLSpeech.performingBAPAction(1);
    }

    public static void satActivateChannelPreset(int n) {
        EventGeneric eventGeneric = ServiceManager.serviceManager.genericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(0x4D040040, eventGeneric);
        ASLSpeech.performingBAPAction(1);
    }

    public static void activateNextListStation() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-1979449280);
        ASLSpeech.performingBAPAction(1);
    }

    public static void satActivateNextChannelList() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(0x50040040);
        ASLSpeech.performingBAPAction(1);
    }

    public static void activatePreviousListStation() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-1929117632);
        ASLSpeech.performingBAPAction(1);
    }

    public static void satActivatePreviousChannelList() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(1392771136);
        ASLSpeech.performingBAPAction(1);
    }

    public static void satActivateChannelByID(long l) {
        EventGeneric eventGeneric = ServiceManager.serviceManager.genericEventFactory.newEvent();
        eventGeneric.setLong(0, l);
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(0x4C040040, eventGeneric);
        ASLSpeech.performingBAPAction(1);
    }

    public static void activateBand(int n) {
        EventGeneric eventGeneric = ServiceManager.serviceManager.genericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-2096889792, eventGeneric);
        ASLSpeech.performingBAPAction(0);
    }

    public static void updateStationList() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-402390976);
    }

    public static void cancelUpdateStationList() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-1727791040);
    }

    public static void setManualMode(boolean bl) {
        EventGeneric eventGeneric = ServiceManager.serviceManager.genericEventFactory.newEvent();
        if (bl) {
            eventGeneric.setBoolean(0, true);
        } else {
            eventGeneric.setBoolean(0, false);
        }
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-1023147968, eventGeneric);
    }

    public static void tpMemoEntered() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-519831488);
    }

    public static void fastForwardTrafficMessage(int n) {
        EventGeneric eventGeneric = ServiceManager.serviceManager.genericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-1576796096, eventGeneric);
        ASLSpeech.performingBAPAction(1);
    }

    public static void rewindTrafficMessage(int n) {
        EventGeneric eventGeneric = ServiceManager.serviceManager.genericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-1358692288);
        ASLSpeech.performingBAPAction(1);
    }

    public static void activateTrafficMessage(int n) {
        EventGeneric eventGeneric = ServiceManager.serviceManager.genericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-1778122688, eventGeneric);
        ASLSpeech.performingBAPAction(1);
    }
}

