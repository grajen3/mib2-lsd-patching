/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.ext.api.radio;

import de.vw.mib.asl.framework.internal.framework.dsi.ext.api.ComplexAnalyzer;
import org.dsi.ifc.radio.AMFMRadioText;
import org.dsi.ifc.radio.DSIAMFMTunerListener;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radio.WavebandInfo;

public final class DSIAMFMTunerComplexAnalyzer
extends ComplexAnalyzer
implements DSIAMFMTunerListener {
    @Override
    public void forceAMUpdateStatus(int n) {
        if (n == 3 || n == 2 || n == 4) {
            this.finished = true;
        }
    }

    @Override
    public void forceFMUpdateStatus(int n) {
        if (n == 3 || n == 2 || n == 4) {
            this.finished = true;
        }
    }

    @Override
    public void prepareTuningStatus(int n) {
        if (n == 3 || n == 2 || n == 4) {
            this.finished = true;
        }
    }

    @Override
    public void seekStationStatus(int n) {
        if (n == 3 || n == 2 || n == 5 || n == 4) {
            this.finished = true;
        }
    }

    @Override
    public void selectFrequencyStatus(int n) {
        if (n == 3 || n == 2 || n == 4) {
            this.finished = true;
        }
    }

    @Override
    public void selectStationStatus(int n) {
        if (n == 3 || n == 2 || n == 4) {
            this.finished = true;
        }
    }

    @Override
    public void setAMBandRangeStatus(int n) {
        if (n == 3 || n == 2 || n == 4) {
            this.finished = true;
        }
    }

    @Override
    public void tuneFrequencyStepsStatus(int n) {
        if (n == 3 || n == 4 || n == 2) {
            this.finished = true;
        }
    }

    @Override
    public void updateAFSwitchStatus(boolean bl, int n) {
    }

    @Override
    public void updateAvailability(int n, int n2) {
    }

    @Override
    public void updateDetectedDevice(int n, int n2) {
    }

    @Override
    public void updateHdMode(int n, int n2) {
    }

    @Override
    public void updateHdStationInfo(HdStationInfo hdStationInfo, int n) {
    }

    @Override
    public void updateHdStatus(int n, int n2) {
    }

    @Override
    public void updateLinkingUsageStatus(int n, int n2) {
    }

    @Override
    public void updateMESwitchStatus(boolean bl, int n) {
    }

    @Override
    public void updatePiIgnoreSwitchStatus(boolean bl, int n) {
    }

    @Override
    public void updateRDSIgnoreSwitchStatus(boolean bl, int n) {
    }

    @Override
    public void updateREGSwitchStatus(int n, int n2) {
    }

    @Override
    public void updateRadioText(AMFMRadioText aMFMRadioText, int n) {
    }

    @Override
    public void updateRadioTextPlus(int[] nArray, String[] stringArray, int n) {
    }

    @Override
    public void updateSelectedStation(Station station, int n) {
    }

    @Override
    public void updateStationList(Station[] stationArray, int n) {
    }

    @Override
    public void updateStationListLW(Station[] stationArray, int n) {
    }

    @Override
    public void updateStationListMW(Station[] stationArray, int n) {
    }

    @Override
    public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray, int n) {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void updateElectronicSerialCode(String string, int n) {
    }

    @Override
    public void updateSelectedStationHD(Station station, int n, int n2) {
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
    }

    @Override
    public void profileChanged(int n, int n2) {
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
    }

    @Override
    public void profileReset(int n, int n2) {
    }

    @Override
    public void profileResetAll(int n) {
    }
}

