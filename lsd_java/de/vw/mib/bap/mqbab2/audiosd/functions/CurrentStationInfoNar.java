/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.mqbab2.audiosd.functions.CurrentStationInfo;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioService;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.RadioCurrentAMStationInfo;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.RadioCurrentFMStationInfo;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.CurrentStationInfo_Status;

public class CurrentStationInfoNar
extends CurrentStationInfo {
    private static final int AM_HD_STATION;

    @Override
    protected boolean isHDRadioAvailable() {
        boolean bl;
        RadioService radioService = this.getRadioService();
        int n = radioService.getCurrentStationBand();
        if (n == 1) {
            boolean bl2 = radioService.getCurrentFMStationInfo().isHDAvailableForCurrentFMStation();
            int n2 = radioService.getFmHdRadioState();
            bl = bl2 && (n2 == 0 || n2 == 2);
        } else if (n == 0) {
            boolean bl3 = radioService.getCurrentAMStationInfo().isHDAvailableForCurrentAMStation();
            int n3 = radioService.getAmHdRadioState();
            bl = bl3 && (n3 == 0 || n3 == 2);
        } else {
            bl = false;
        }
        return bl;
    }

    @Override
    protected void setStationInfoForRadioAM(CurrentStationInfo_Status currentStationInfo_Status) {
        boolean bl;
        RadioService radioService = this.getRadioService();
        RadioCurrentAMStationInfo radioCurrentAMStationInfo = radioService.getCurrentAMStationInfo();
        int n = radioCurrentAMStationInfo.getCurrentAMStationInfoHDChannelNumber() == 0 ? 0 : -1;
        String string = this.getFixFormatter().fmtIcFrequencyNAR(radioCurrentAMStationInfo.getCurrentAMStationInfoFrequency(), 1, n);
        String string2 = this.transmitALongDABProgrammStation ? radioCurrentAMStationInfo.getCurrentAMStationInfoStationName() : radioCurrentAMStationInfo.getCurrentAMStationInfoStationShortName();
        currentStationInfo_Status.primaryInformation.setContent(string);
        currentStationInfo_Status.pi_Type = !this.isHDRadioAvailable() ? 67 : 68;
        currentStationInfo_Status.pi_Id = 0;
        currentStationInfo_Status.secondaryInformation.setContent(string2);
        currentStationInfo_Status.si_Type = string2.length() != 0 ? 68 : 0;
        String string3 = radioService.getCurrentAMRadioTextTitleName();
        String string4 = radioService.getCurrentAMRadioTextArtistName();
        boolean bl2 = (radioService.getAmHdRadioState() == 0 || radioService.getAmHdRadioState() == 2 || radioService.getAmHdRadioState() != 1) && radioCurrentAMStationInfo.getCurrentAMStationInfoHDChannelNumber() >= 0;
        boolean bl3 = radioService.getCurrentHDRadioPsTitleName().length() != 0 || radioService.getCurrentHDRadioPsArtistName().length() != 0;
        boolean bl4 = bl = radioCurrentAMStationInfo.getCurrentAMStationInfoHDChannelNumber() > 1;
        if (bl2 && (bl3 || bl) || !radioService.isRadioTextSetupActive()) {
            string3 = radioService.getCurrentHDRadioPsTitleName();
            string4 = radioService.getCurrentHDRadioPsArtistName();
        }
        currentStationInfo_Status.tertiaryInformation.setContent(string3);
        currentStationInfo_Status.ti_Type = string3.length() != 0 ? 72 : 0;
        currentStationInfo_Status.quaternaryInformation.setContent(string4);
        currentStationInfo_Status.qi_Type = string4.length() != 0 ? 73 : 0;
    }

    @Override
    protected void setStationInfoForRadioFM(CurrentStationInfo_Status currentStationInfo_Status) {
        boolean bl;
        RadioService radioService = this.getRadioService();
        RadioCurrentFMStationInfo radioCurrentFMStationInfo = radioService.getCurrentFMStationInfo();
        String string = this.getFixFormatter().fmtIcFrequencyNAR(radioCurrentFMStationInfo.getCurrentFMStationInfoFrequency(), 0, radioCurrentFMStationInfo.getCurrentFMStationInfoHDChannelNumber());
        String string2 = this.transmitALongDABProgrammStation || !radioCurrentFMStationInfo.isHDAvailableForCurrentFMStation() ? radioCurrentFMStationInfo.getCurrentFMStationInfoStationName() : radioCurrentFMStationInfo.getCurrentFMStationInfoStationShortName();
        currentStationInfo_Status.primaryInformation.setContent(string);
        currentStationInfo_Status.pi_Type = !this.isHDRadioAvailable() ? 67 : 68;
        currentStationInfo_Status.pi_Id = 0;
        currentStationInfo_Status.secondaryInformation.setContent(string2);
        currentStationInfo_Status.si_Type = string2.length() != 0 ? 68 : 0;
        String string3 = radioService.getCurrentFMRadioTextTitleName();
        String string4 = radioService.getCurrentFMRadioTextArtistName();
        boolean bl2 = (radioService.getFmHdRadioState() == 0 || radioService.getFmHdRadioState() == 2 || radioService.getFmHdRadioState() != 1) && radioCurrentFMStationInfo.getCurrentFMStationInfoHDChannelNumber() >= 0;
        boolean bl3 = radioService.getCurrentHDRadioPsTitleName().length() != 0 || radioService.getCurrentHDRadioPsArtistName().length() != 0;
        boolean bl4 = bl = radioCurrentFMStationInfo.getCurrentFMStationInfoHDChannelNumber() > 1;
        if (!this.manualTuning && (bl2 && (bl3 || bl) || !radioService.isRadioTextSetupActive())) {
            string3 = radioService.getCurrentHDRadioPsTitleName();
            string4 = radioService.getCurrentHDRadioPsArtistName();
        } else if (this.manualTuning) {
            string3 = "";
            string4 = "";
        }
        currentStationInfo_Status.tertiaryInformation.setContent(string3);
        currentStationInfo_Status.ti_Type = string3.length() != 0 ? 72 : 0;
        currentStationInfo_Status.quaternaryInformation.setContent(string4);
        currentStationInfo_Status.qi_Type = string4.length() != 0 ? 73 : 0;
    }

    @Override
    protected void setStationProperties(CurrentStationInfo_Status currentStationInfo_Status) {
        super.setStationProperties(currentStationInfo_Status);
        currentStationInfo_Status.stationProperties.ibocLiveTransmissionActiveHdLiveMode = this.getRadioService().getAmHdRadioState() == 2;
    }
}

