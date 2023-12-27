/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.radio;

import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventListener;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioServiceListener;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.RadioCurrentAMStationInfo;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.RadioCurrentChannelInfo;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.RadioCurrentDABStationInfo;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.RadioCurrentFMStationInfo;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.RadioCurrentSatRadioText;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.RadioCurrentStationIndices;
import java.util.Iterator;

public interface RadioService {
    default public void addRadioServiceListener(RadioServiceListener radioServiceListener, int[] nArray) {
    }

    default public void removeRadioServiceListener(RadioServiceListener radioServiceListener, int[] nArray) {
    }

    default public void addHMIEventListener(HMIEventListener hMIEventListener, int[] nArray) {
    }

    default public void removeHMIEventListener(HMIEventListener hMIEventListener, int[] nArray) {
    }

    default public int getDABRadioListState() {
    }

    default public int getAMRadioListState() {
    }

    default public RadioCurrentAMStationInfo getCurrentAMStationInfo() {
    }

    default public String getCurrentAMRadioTextArtistName() {
    }

    default public String getCurrentAMRadioTextTitleName() {
    }

    default public int getAmHdRadioState() {
    }

    default public int getFMFrequencyScale() {
    }

    default public RadioCurrentFMStationInfo getCurrentFMStationInfo() {
    }

    default public String getCurrentFMRadioTextArtistName() {
    }

    default public String getCurrentFMRadioTextTitleName() {
    }

    default public int getFmHdRadioState() {
    }

    default public int getCurrentStationBand() {
    }

    default public RadioCurrentStationIndices getCurrentStationIndices() {
    }

    default public boolean isTrafficAnnouncementActive() {
    }

    default public int getTrafficAnnouncementSource() {
    }

    default public boolean isDABAnnouncementActive() {
    }

    default public int getCurrentDABAnnouncementType() {
    }

    default public String getCurrentDABAnnouncementStationName() {
    }

    default public int getDABEnsembleState() {
    }

    default public int getDABServiceState() {
    }

    default public int getDABAdditionalServiceState() {
    }

    default public RadioCurrentDABStationInfo getCurrentDABStationInfo() {
    }

    default public String getCurrentDABRadioTextPlusArtistName() {
    }

    default public String getCurrentDABRadioTextPlusTitleName() {
    }

    default public boolean isTrafficInformationActive() {
    }

    default public int getTrafficInformationFrequencyType() {
    }

    default public boolean isPTYAnnouncementActive() {
    }

    default public String getCurrentPTYAnnouncementStationName() {
    }

    default public int getCurrentPTYAnnouncementFrequency() {
    }

    default public int getCurrentTAFrequency() {
    }

    default public String getCurrentTAStationName() {
    }

    default public boolean isPiCodingActivated() {
    }

    default public Iterator getReceptionList() {
    }

    default public boolean isRDSSetupOptionEnabled() {
    }

    default public boolean isRDSSetupOptionAvailable() {
    }

    default public String getCurrentHDRadioPsTitleName() {
    }

    default public String getCurrentHDRadioPsArtistName() {
    }

    default public boolean isRatioTextPlusActive() {
    }

    default public boolean getDABRadioTextPlusActive() {
    }

    default public boolean isRadioTextPlusSetupActive() {
    }

    default public boolean isRadioTextSetupActive() {
    }

    default public int getTPState() {
    }

    default public RadioCurrentChannelInfo getCurrentChannelInfo() {
    }

    default public RadioCurrentSatRadioText getCurrentSatRadioText() {
    }

    default public boolean isRadioSeekActive() {
    }

    default public boolean isRadioScanningActive() {
    }

    default public boolean isManualModeActive() {
    }

    default public Iterator getSiriusPresetList() {
    }

    default public int getSiriusPresetSelectedIndex() {
    }

    default public Iterator getDABPresetList() {
    }

    default public Iterator getAMPresetList() {
    }

    default public Iterator getFMPresetList() {
    }

    default public boolean isTrafficMessageRecording() {
    }

    default public int getTpMemoListSelectedIndex() {
    }

    default public boolean isTpSetupOptionEnabled() {
    }

    default public Iterator getTrafficMessages() {
    }

    default public int getScopeOfArrowKeyMode() {
    }

    default public int getSatTunerState() {
    }

    default public void stopTrafficAnnouncement() {
    }

    default public void stopTrafficInformation() {
    }

    default public void startSeek(int n) {
    }

    default public void stopSeek() {
    }

    default public void startTargetSeek(int n) {
    }

    default public void stopTargetSeek() {
    }

    default public void stopChangingFrequency() {
    }

    default public void startScan() {
    }

    default public void stopScan() {
    }

    default public void setTpState(boolean bl) {
    }

    default public void setRDSSetupOptionState(boolean bl) {
    }

    default public void activateNextStation() {
    }

    default public void activatePreviousStation() {
    }

    default public void activateNextSatChannel() {
    }

    default public void activatePreviousSatChannel() {
    }

    default public void activateStationByID(long l, int n) {
    }

    default public void activateDABServiceByID(long l) {
    }

    default public void activateDABSecondaryServiceByID(long l) {
    }

    default public void activateStationPreset(int n) {
    }

    default public void activateSatChannelPreset(int n) {
    }

    default public void activateNextListStation() {
    }

    default public void activatePreviousListStation() {
    }

    default public void activateNextListSatChannel() {
    }

    default public void activatePreviousListSatChannel() {
    }

    default public void activateSatChannelByID(long l) {
    }

    default public void activateBand(int n) {
    }

    default public void startUpdateStationList() {
    }

    default public void cancelUpdateStationList() {
    }

    default public void setManualMode(boolean bl) {
    }

    default public void setTpMemoScreenEntered() {
    }

    default public void startFastForwardTrafficMessage(int n) {
    }

    default public void startRewindTrafficMessage(int n) {
    }

    default public void activateTrafficMessage(int n) {
    }
}

