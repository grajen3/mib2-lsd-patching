/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm;

import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.AmfmControllerBase;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmConstants;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.amfm.main.StateAmFmActive;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextFactory;
import de.vw.mib.asl.internal.radio.tagging.TaggingApi;
import de.vw.mib.asl.internal.radio.tile.list.TileStationList;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.radio.Station;

public class AmfmControllerNar
extends AmfmControllerBase {
    private boolean hdInformationIncomplete = false;
    private boolean mpsCoverArtRemovalTimerRunning = false;
    private boolean coverArtReceived = false;

    @Override
    public int getTaggingInstance() {
        return this.mSettingsPersistable.getTaggingInstance();
    }

    @Override
    public void setTaggingInstance(int n) {
        this.mSettingsPersistable.setTaggingInstance(n);
    }

    public void stopCoverArtRemovalTimers() {
        TileStationList tileStationList;
        HsmTarget hsmTarget = RadioServiceManager.getServiceManager().getRadioAmFMTarget();
        if (RadioData.getAmfmDatabase().isMpsCoverArtRemovalTimerRunning()) {
            hsmTarget.stopTimer(-2004418304);
            RadioData.getAmfmDatabase().setMpsCoverArtRemovalTimerRunning(false);
        }
        if (StateAmFmActive.isSpsCovertArtRemovalTimerRunning) {
            hsmTarget.stopTimer(1871118592);
            StateAmFmActive.isSpsCovertArtRemovalTimerRunning = false;
        }
        if (hsmTarget.getTimerServer().isTimerActive(hsmTarget.getTargetId(), 1988559104)) {
            hsmTarget.stopTimer(1988559104);
            RadioData.getAmfmDatabase().setCoverArtReceived(false);
        }
        if (null != (tileStationList = RadioServiceManager.getServiceManager().getTileStationList())) {
            tileStationList.stopTileCoverArtTimer();
            RadioData.getAmfmDatabase().setTileCoverArtReceived(false);
        }
    }

    @Override
    public void notifyStationChanged(AmFmStation amFmStation) {
        if (null == amFmStation) {
            return;
        }
        if (null != logger && logger.isTraceEnabled(128)) {
            logger.trace(128).append(" Notify station change : : updating model to clear information of the previous station").log();
        }
        this.stopCoverArtRemovalTimers();
        AmFmFactory.getAslAmfmModelController().updateHDStationInfo("", "", "");
        if (RadiotextFactory.getRadioTextInstance() != null) {
            RadiotextFactory.getRadioTextInstance().notifyStationChange();
        }
        if (RadioCurrentWaveband.isFm()) {
            if (amFmStation.getServiceId() > 0 || amFmStation.isHD()) {
                AmFmFactory.getAslAmfmModelController().updateFmRadiotextAndState("", 1);
            } else {
                AmFmFactory.getAslAmfmModelController().updateFmRadiotextAndState("", 0);
            }
        }
        RadioData.getAmfmDatabase().setCurrentHDStation(AmFmConstants.EMPTY_HDSTATIONINFO);
        TaggingApi.notifyAMFMStationChanged();
    }

    @Override
    public AmFmStation handleStationInfoChange(Station station, Station station2) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(" handleStationInfoChange : : ").log();
        }
        AmFmStation amFmStation = this.getCurrentStation();
        if (null == station) {
            return null;
        }
        if (this.checkIfStationChanged(station, station2) || amFmStation == null) {
            amFmStation = new AmFmStation(station);
            this.notifyStationChanged(amFmStation);
            if (logger.isTraceEnabled(128)) {
                logger.trace(128).append(" Station changed : ").append(amFmStation.toString()).log();
            }
        } else {
            if (!station.isHd() && station2.isHd()) {
                if (logger.isTraceEnabled(128)) {
                    logger.trace(128).append(" Current station changed from HD to Complete Analog ").log();
                }
                this.notifyStationChanged(amFmStation);
            }
            amFmStation.fillStationInfo(station);
            if (logger.isTraceEnabled(128)) {
                logger.trace(128).append(" Station info is refilled : ").append(amFmStation.toString()).log();
            }
        }
        return amFmStation;
    }

    @Override
    public boolean checkIfStationChanged(Station station, Station station2) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(" checkIfStationChanged : current station ->").append(station != null ? station.toString() : "NULL").append(" PreviousStation -> ").append(station2 != null ? station2.toString() : "NULL").log();
        }
        return station != null && (station2 == null || station2.getFrequency() != station.getFrequency() || station2.getServiceId() != station.getServiceId());
    }

    @Override
    public boolean checkForHdStationInfoChanged(HdStationInfo hdStationInfo) {
        HdStationInfo hdStationInfo2;
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(" checkForHdStationInfoChanged : ").log();
        }
        return hdStationInfo != null && ((hdStationInfo2 = this.getPreviousHDStation()) == null || hdStationInfo.frequency != hdStationInfo2.frequency || hdStationInfo.serviceId != hdStationInfo2.serviceId || !hdStationInfo.songTitle.equals(hdStationInfo2.songTitle) || !hdStationInfo.artistName.equals(hdStationInfo2.artistName));
    }

    @Override
    public void clearHdInformation() {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(" clearHdInformation : ").log();
        }
        if (RadioCurrentWaveband.isFm()) {
            AmFmFactory.getAslAmfmModelController().updateHDStationInfo("", "", "");
            RadioData.getAmfmDatabase().setCurrentHDStation(AmFmConstants.EMPTY_HDSTATIONINFO);
            if (RadioData.getAmfmDatabase().getSettingsPersistable().getFmViewState() == 1) {
                AmFmFactory.getAslAmfmModelController().updateLogoInStationView(null);
                RadioServiceManager.getServiceManager().getGuiBapApi().changeInFmHdStationLogosForKombi(null);
            }
        } else if (RadioCurrentWaveband.isAm()) {
            RadioData.getAmfmDatabase().setCurrentHDStation(AmFmConstants.EMPTY_HDSTATIONINFO);
        }
        AmFmPresetApi.updateHdPresetList();
    }

    @Override
    public void setStationHdInformationIncomplete(boolean bl) {
        this.hdInformationIncomplete = bl;
    }

    @Override
    public boolean isStationHdInformationIncomplete() {
        return this.hdInformationIncomplete;
    }

    @Override
    public void setMpsCoverArtRemovalTimerRunning(boolean bl) {
        this.mpsCoverArtRemovalTimerRunning = bl;
    }

    @Override
    public void setCoverArtReceived(boolean bl) {
        this.coverArtReceived = bl;
    }

    @Override
    public void setTileCoverArtReceived(boolean bl) {
        this.coverArtReceived = bl;
    }

    @Override
    public boolean isCoverArtReceived() {
        return this.coverArtReceived;
    }

    @Override
    public boolean isTileCoverArtReceived() {
        return this.coverArtReceived;
    }

    @Override
    public boolean isMpsCoverArtRemovalTimerRunning() {
        return this.mpsCoverArtRemovalTimerRunning;
    }
}

