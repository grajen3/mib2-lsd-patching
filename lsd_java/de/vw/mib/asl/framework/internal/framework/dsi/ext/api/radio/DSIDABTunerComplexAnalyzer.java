/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.ext.api.radio;

import de.vw.mib.asl.framework.internal.framework.dsi.ext.api.ComplexAnalyzer;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.AudioStatus;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.DABRadioText;
import org.dsi.ifc.radio.DABRadioTextPlusInfo;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.DSIDABTunerListener;
import org.dsi.ifc.radio.DataServiceInfo;
import org.dsi.ifc.radio.EPGFullInfo;
import org.dsi.ifc.radio.EPGLogo;
import org.dsi.ifc.radio.EPGShortInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.IntellitextMenu;
import org.dsi.ifc.radio.ServiceInfo;

public final class DSIDABTunerComplexAnalyzer
extends ComplexAnalyzer
implements DSIDABTunerListener {
    @Override
    public void forceLMUpdateStatus(int n) {
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
    public void seekServiceStatus(int n) {
        if (n == 2 || n == 4 || n == 3) {
            this.finished = true;
        }
    }

    @Override
    public void selectDataServiceStatus(int n) {
        if (n == 2 || n == 3 || n == 5 || n == 4) {
            this.finished = true;
        }
    }

    @Override
    public void selectServiceStatus(int n) {
        if (n == 2 || n == 3 || n == 7 || n == 6 || n == 5 || n == 4) {
            this.finished = true;
        }
    }

    @Override
    public void tuneEnsembleStatus(int n) {
        if (n == 2 || n == 6 || n == 3 || n == 4 || n == 5) {
            this.finished = true;
        }
    }

    @Override
    public void updateAudioStatus(AudioStatus audioStatus, int n) {
    }

    @Override
    public void updateAvailability(int n, int n2) {
    }

    @Override
    public void updateComponentList(ComponentInfo[] componentInfoArray, int n) {
    }

    @Override
    public void updateDRCSwitchStatus(boolean bl, int n) {
    }

    @Override
    public void updateDataServiceList(DataServiceInfo[] dataServiceInfoArray, int n) {
    }

    @Override
    public void updateDecodedDataService(DataServiceInfo dataServiceInfo, boolean bl, String string, int n) {
    }

    @Override
    public void updateDetectedDevice(int n, int n2) {
    }

    @Override
    public void updateEPGDetailData(EPGFullInfo ePGFullInfo, int n) {
    }

    @Override
    public void updateEPGListData(EPGShortInfo[] ePGShortInfoArray, int n) {
    }

    @Override
    public void updateEPGMode(int n, int n2) {
    }

    @Override
    public void updateEnsembleList(EnsembleInfo[] ensembleInfoArray, int n) {
    }

    @Override
    public void updateEpgLogo(int[] nArray, ResourceLocator[] resourceLocatorArray, int n) {
    }

    @Override
    public void updateFrequencyList(FrequencyInfo[] frequencyInfoArray, int n) {
    }

    @Override
    public void updateFrequencyTableSwitchStatus(int n, int n2) {
    }

    @Override
    public void updateIntellitext(IntellitextMenu[] intellitextMenuArray, int n) {
    }

    @Override
    public void updateLinkingStatus(int n, int n2) {
    }

    @Override
    public void updateLinkingSwitchStatus(int n, int n2) {
    }

    @Override
    public void updateLinkingUsageStatus(int n, int n2) {
    }

    @Override
    public void updateQuality(short s, int n) {
    }

    @Override
    public void updateQualityInfo(String string, int n) {
    }

    @Override
    public void updateRadioText(DABRadioText dABRadioText, int n) {
    }

    public void updateRadioTextPlus(int[] nArray, String[] stringArray, int n) {
    }

    @Override
    public void updateSelectedComponent(ComponentInfo componentInfo, int n) {
    }

    @Override
    public void updateSelectedEnsemble(EnsembleInfo ensembleInfo, int n) {
    }

    @Override
    public void updateSelectedFrequency(FrequencyInfo frequencyInfo, int n) {
    }

    @Override
    public void updateSelectedService(ServiceInfo serviceInfo, int n) {
    }

    @Override
    public void updateServiceList(ServiceInfo[] serviceInfoArray, int n) {
    }

    public void updateSlideShowImage(ResourceLocator resourceLocator, DateTime dateTime, int n) {
    }

    @Override
    public void updateSyncStatus(int n, int n2) {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void updateRadioTextPlusInfo(DABRadioTextPlusInfo dABRadioTextPlusInfo, int n) {
    }

    @Override
    public void updateSlideShowInfo(DABSlideShowInfo dABSlideShowInfo, int n) {
    }

    @Override
    public void updateEpgLogoList(EPGLogo[] ePGLogoArray, int n) {
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

