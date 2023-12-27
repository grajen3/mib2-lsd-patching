/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.dsi;

import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.AMFMRadioText;
import org.dsi.ifc.radio.DSIAMFMTuner;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radio.WavebandInfo;

public final class AmFmProxyHelper
implements DSIAMFMTuner {
    private final DSIAMFMTuner mProxy;

    public AmFmProxyHelper(DSIAMFMTuner dSIAMFMTuner) {
        this.mProxy = dSIAMFMTuner;
    }

    @Override
    public void enableRadiotextPlus(int[] nArray) {
        this.mProxy.enableRadiotextPlus(nArray);
    }

    @Override
    public void forceAMUpdate(int n) {
        this.mProxy.forceAMUpdate(n);
    }

    @Override
    public void forceFMUpdate(int n) {
        this.mProxy.forceFMUpdate(n);
    }

    @Override
    public void freePreset(int n) {
        this.mProxy.freePreset(n);
    }

    @Override
    public void prepareTuning(int n, int n2, int n3) {
        this.mProxy.prepareTuning(n, n2, n3);
    }

    @Override
    public void reset(int n) {
        this.mProxy.reset(n);
    }

    @Override
    public void seekStation(int n) {
        this.mProxy.seekStation(n);
    }

    @Override
    public void selectFrequency(int n) {
        this.mProxy.selectFrequency(n);
    }

    @Override
    public void selectStation(int n, int n2, int n3) {
        this.mProxy.selectStation(n, n2, n3);
    }

    @Override
    public void setAMBandRange(int n) {
        this.mProxy.setAMBandRange(n);
    }

    @Override
    public void setERTDisplayable(boolean bl) {
        this.mProxy.setERTDisplayable(bl);
    }

    @Override
    public void setERTPrefered(boolean bl) {
        this.mProxy.setERTPrefered(bl);
    }

    @Override
    public void setModeHD(int n) {
        this.mProxy.setModeHD(n);
    }

    @Override
    public void switchAF(boolean bl) {
        this.mProxy.switchAF(bl);
    }

    @Override
    public void switchLinkingDeviceUsage(int n) {
        AmFmDsiApi.doSwitchLinkingDeviceUsageMode = n;
        this.mProxy.switchLinkingDeviceUsage(n);
    }

    @Override
    public void switchME(boolean bl) {
        this.mProxy.switchME(bl);
    }

    @Override
    public void switchPiIgnore(boolean bl) {
        this.mProxy.switchPiIgnore(bl);
    }

    @Override
    public void switchRDSIgnore(boolean bl) {
        this.mProxy.switchRDSIgnore(bl);
    }

    @Override
    public void switchREG(int n) {
        this.mProxy.switchREG(n);
    }

    @Override
    public void tuneFrequencySteps(int n) {
        this.mProxy.tuneFrequencySteps(n);
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.mProxy.clearNotification(nArray, dSIListener);
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.mProxy.clearNotification(n, dSIListener);
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.mProxy.clearNotification(dSIListener);
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.mProxy.setNotification(nArray, dSIListener);
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.mProxy.setNotification(n, dSIListener);
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.mProxy.setNotification(dSIListener);
    }

    public static void forceAMUpdateStatus(int n, int n2) {
    }

    public static void forceFMUpdateStatus(int n, int n2) {
    }

    public static void prepareTuningStatus(int n, int n2) {
    }

    public static void seekStationStatus(int n, int n2) {
    }

    public static void selectFrequencyStatus(int n, int n2) {
    }

    public static void selectStationStatus(int n, int n2) {
    }

    public static void setAMBandRangeStatus(int n, int n2) {
    }

    public static void tuneFrequencyStepsStatus(int n, int n2) {
    }

    public static void updateAFSwitchStatus(int n, boolean bl, int n2) {
    }

    public static void updateAvailability(int n, int n2, int n3) {
    }

    public static void updateDetectedDevice(int n, int n2, int n3) {
    }

    public static void updateHdMode(int n, int n2, int n3) {
    }

    public static void updateHdStationInfo(int n, HdStationInfo hdStationInfo, int n2) {
    }

    public static void updateHdStatus(int n, int n2, int n3) {
    }

    public static void updateLinkingUsageStatus(int n, int n2, int n3) {
    }

    public static void updateMESwitchStatus(int n, boolean bl, int n2) {
    }

    public static void updatePiIgnoreSwitchStatus(int n, boolean bl, int n2) {
    }

    public static void updateRDSIgnoreSwitchStatus(int n, boolean bl, int n2) {
    }

    public static void updateREGSwitchStatus(int n, int n2, int n3) {
    }

    public static void updateRadioText(int n, AMFMRadioText aMFMRadioText, int n2) {
    }

    public static void updateRadioTextPlus(int n, int[] nArray, String[] stringArray, int n2) {
    }

    public static void updateSelectedStation(int n, Station station, int n2) {
    }

    public static void updateStationList(int n, Station[] stationArray, int n2) {
    }

    public static void updateStationListLW(int n, Station[] stationArray, int n2) {
    }

    public static void updateStationListMW(int n, Station[] stationArray, int n2) {
    }

    public static void updateWavebandInfoList(int n, WavebandInfo[] wavebandInfoArray, int n2) {
    }

    public static void asyncException(int n, int n2, String string, int n3) {
    }

    @Override
    public void isOnPreset(int n, int n2, int n3, String string) {
    }

    @Override
    public void profileChange(int n) {
    }

    @Override
    public void profileCopy(int n, int n2) {
    }

    @Override
    public void profileReset(int n) {
    }

    @Override
    public void profileResetAll() {
    }
}

