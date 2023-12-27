/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm;

import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.data.StationNameFreqList;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationList;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationListAM;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationListFM;
import de.vw.mib.asl.internal.radio.amfm.persistence.AmFmFixedStationListPersistable;
import de.vw.mib.asl.internal.radio.amfm.persistence.AmFmSettingsPersistable;
import org.dsi.ifc.radio.DSIAMFMTuner;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radio.WavebandInfo;
import org.dsi.ifc.radiodata.DSIRadioData;

public interface AmfmController {
    default public void resetOptions() {
    }

    default public AmFmStation getLastStationForBand(int n) {
    }

    default public AmFmStation getCurrentStation() {
    }

    default public AmFmStation getCurrentFMStation() {
    }

    default public void setOldStation(AmFmStation amFmStation) {
    }

    default public AmFmStation getOldStation() {
    }

    default public AmFmStation getCurrentAMStation() {
    }

    default public void setCurrentStation(AmFmStation amFmStation) {
    }

    default public void skipStation(int n) {
    }

    default public int getCurrentListSize() {
    }

    default public void setStationListIndex(int n) {
    }

    default public void setSubStationListIndex(int n) {
    }

    default public AmFmStationList getCurrentStationList() {
    }

    default public AmFmStationList getCurrentSubStationList() {
    }

    default public int getCurrentSubStationListSize(AmFmStation amFmStation) {
    }

    default public boolean hasSubServiceList(AmFmStation amFmStation) {
    }

    default public AmFmStationList getSubStationListWithMPS(AmFmStation amFmStation) {
    }

    default public void updateStationListToBap() {
    }

    default public int getFrequencyForTicks(int n, int n2, int n3) {
    }

    default public HdStationInfo getCurrentHDStation() {
    }

    default public void setCurrentHDStation(HdStationInfo hdStationInfo) {
    }

    default public HdStationInfo getPreviousHDStation() {
    }

    default public AmFmStationListAM getAslStationListAM() {
    }

    default public AmFmStationListFM getAslStationListFM() {
    }

    default public WavebandInfo getFmBandInfo() {
    }

    default public WavebandInfo getAmBandInfo() {
    }

    default public DSIAMFMTuner getDsiAMFMTuner() {
    }

    default public DSIRadioData getDsiRadioData() {
    }

    default public void setDsiRadioData(DSIRadioData dSIRadioData) {
    }

    default public AmFmFixedStationListPersistable getFixedStationList() {
    }

    default public void setFixedStationList(AmFmFixedStationListPersistable amFmFixedStationListPersistable) {
    }

    default public AmFmSettingsPersistable getSettingsPersistable() {
    }

    default public void setPresetWidth(int n) {
    }

    default public int getPresetWidth() {
    }

    default public int getPresetHeigth() {
    }

    default public void setPresetHeigth(int n) {
    }

    default public AmFmStationListFM getFMSationListNARMulticast() {
    }

    default public void setTimeOutAmMinTuneTime(int n) {
    }

    default public int getTimeOutAmMinTuneTime() {
    }

    default public void setTimeOutAmRemove(int n) {
    }

    default public int getTimeOutAmRemove() {
    }

    default public int getTaggingInstance() {
    }

    default public void setTaggingInstance(int n) {
    }

    default public StationNameFreqList getStationNameFreqList() {
    }

    default public void notifyStationChanged(AmFmStation amFmStation) {
    }

    default public AmFmStation handleStationInfoChange(Station station, Station station2) {
    }

    default public boolean checkForHdStationInfoChanged(HdStationInfo hdStationInfo) {
    }

    default public boolean checkIfStationChanged(Station station, Station station2) {
    }

    default public void clearHdInformation() {
    }

    default public void setStationListViewIsOpen(boolean bl) {
    }

    default public boolean getStationListViewIsOpen() {
    }

    default public void setStationHdInformationIncomplete(boolean bl) {
    }

    default public boolean isStationHdInformationIncomplete() {
    }

    default public void setStationBeforeSeekStarted() {
    }

    default public AmFmStation getStationBeforeSeekStarted() {
    }

    default public void setMpsCoverArtRemovalTimerRunning(boolean bl) {
    }

    default public boolean isMpsCoverArtRemovalTimerRunning() {
    }

    default public void setCoverArtReceived(boolean bl) {
    }

    default public boolean isCoverArtReceived() {
    }

    default public void setTileCoverArtReceived(boolean bl) {
    }

    default public boolean isTileCoverArtReceived() {
    }
}

