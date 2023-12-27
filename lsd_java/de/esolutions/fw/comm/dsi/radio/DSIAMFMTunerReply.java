/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio;

import org.dsi.ifc.radio.AMFMRadioText;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radio.WavebandInfo;

public interface DSIAMFMTunerReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateStationList(Station[] stationArray, int n) {
    }

    default public void updateStationListMW(Station[] stationArray, int n) {
    }

    default public void updateStationListLW(Station[] stationArray, int n) {
    }

    default public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray, int n) {
    }

    default public void updateRadioText(AMFMRadioText aMFMRadioText, int n) {
    }

    default public void updateAFSwitchStatus(boolean bl, int n) {
    }

    default public void updateREGSwitchStatus(int n, int n2) {
    }

    default public void updateLinkingUsageStatus(int n, int n2) {
    }

    default public void updateDetectedDevice(int n, int n2) {
    }

    default public void tuneFrequencyStepsStatus(int n) {
    }

    default public void selectStationStatus(int n) {
    }

    default public void seekStationStatus(int n) {
    }

    default public void updateRadioTextPlus(int[] nArray, String[] stringArray, int n) {
    }

    default public void updateSelectedStation(Station station, int n) {
    }

    default public void updateSelectedStationHD(Station station, int n, int n2) {
    }

    default public void prepareTuningStatus(int n) {
    }

    default public void selectFrequencyStatus(int n) {
    }

    default public void setAMBandRangeStatus(int n) {
    }

    default public void forceFMUpdateStatus(int n) {
    }

    default public void updatePiIgnoreSwitchStatus(boolean bl, int n) {
    }

    default public void forceAMUpdateStatus(int n) {
    }

    default public void updateRDSIgnoreSwitchStatus(boolean bl, int n) {
    }

    default public void updateMESwitchStatus(boolean bl, int n) {
    }

    default public void updateHdStatus(int n, int n2) {
    }

    default public void updateHdMode(int n, int n2) {
    }

    default public void updateHdStationInfo(HdStationInfo hdStationInfo, int n) {
    }

    default public void updateAvailability(int n, int n2) {
    }

    default public void updateElectronicSerialCode(String string, int n) {
    }

    default public void updateProfileState(int n, int n2, int n3) {
    }

    default public void profileChanged(int n, int n2) {
    }

    default public void profileCopied(int n, int n2, int n3) {
    }

    default public void profileReset(int n, int n2) {
    }

    default public void profileResetAll(int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

