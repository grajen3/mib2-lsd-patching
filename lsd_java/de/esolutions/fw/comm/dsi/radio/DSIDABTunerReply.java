/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.AudioStatus;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.DABRadioText;
import org.dsi.ifc.radio.DABRadioTextPlusInfo;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.DataServiceInfo;
import org.dsi.ifc.radio.EPGFullInfo;
import org.dsi.ifc.radio.EPGLogo;
import org.dsi.ifc.radio.EPGShortInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.IntellitextMenu;
import org.dsi.ifc.radio.ServiceInfo;

public interface DSIDABTunerReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateSelectedEnsemble(EnsembleInfo ensembleInfo, int n) {
    }

    default public void updateSelectedService(ServiceInfo serviceInfo, int n) {
    }

    default public void updateSelectedComponent(ComponentInfo componentInfo, int n) {
    }

    default public void updateSelectedFrequency(FrequencyInfo frequencyInfo, int n) {
    }

    default public void updateEnsembleList(EnsembleInfo[] ensembleInfoArray, int n) {
    }

    default public void updateServiceList(ServiceInfo[] serviceInfoArray, int n) {
    }

    default public void updateComponentList(ComponentInfo[] componentInfoArray, int n) {
    }

    default public void updateDataServiceList(DataServiceInfo[] dataServiceInfoArray, int n) {
    }

    default public void updateFrequencyList(FrequencyInfo[] frequencyInfoArray, int n) {
    }

    default public void updateRadioText(DABRadioText dABRadioText, int n) {
    }

    default public void updateSyncStatus(int n, int n2) {
    }

    default public void updateQuality(short s, int n) {
    }

    default public void updateDRCSwitchStatus(boolean bl, int n) {
    }

    default public void updateLinkingSwitchStatus(int n, int n2) {
    }

    default public void updateFrequencyTableSwitchStatus(int n, int n2) {
    }

    default public void updateLinkingStatus(int n, int n2) {
    }

    default public void updateLinkingUsageStatus(int n, int n2) {
    }

    default public void updateAudioStatus(AudioStatus audioStatus, int n) {
    }

    default public void updateDetectedDevice(int n, int n2) {
    }

    default public void updateQualityInfo(String string, int n) {
    }

    default public void selectServiceStatus(int n) {
    }

    default public void seekServiceStatus(int n) {
    }

    default public void tuneEnsembleStatus(int n) {
    }

    default public void selectDataServiceStatus(int n) {
    }

    default public void updateRadioTextPlusInfo(DABRadioTextPlusInfo dABRadioTextPlusInfo, int n) {
    }

    default public void updateDecodedDataService(DataServiceInfo dataServiceInfo, boolean bl, String string, int n) {
    }

    default public void forceLMUpdateStatus(int n) {
    }

    default public void prepareTuningStatus(int n) {
    }

    default public void updateEpgLogo(int[] nArray, ResourceLocator[] resourceLocatorArray, int n) {
    }

    default public void updateEpgLogoList(EPGLogo[] ePGLogoArray, int n) {
    }

    default public void updateSlideShowInfo(DABSlideShowInfo dABSlideShowInfo, int n) {
    }

    default public void updateAvailability(int n, int n2) {
    }

    default public void updateIntellitext(IntellitextMenu[] intellitextMenuArray, int n) {
    }

    default public void updateEPGMode(int n, int n2) {
    }

    default public void updateEPGListData(EPGShortInfo[] ePGShortInfoArray, int n) {
    }

    default public void updateEPGDetailData(EPGFullInfo ePGFullInfo, int n) {
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

