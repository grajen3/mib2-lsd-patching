/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.mqbab2.audiosd.functions.CurrentStationInfo;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioService;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.RadioCurrentAMStationInfo;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.RadioCurrentFMStationInfo;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.CurrentStationInfo_Status;

public class CurrentStationInfoChinaJp
extends CurrentStationInfo {
    @Override
    protected void setStationInfoForRadioAM(CurrentStationInfo_Status currentStationInfo_Status) {
        String string;
        String string2;
        RadioCurrentAMStationInfo radioCurrentAMStationInfo = this.getRadioService().getCurrentAMStationInfo();
        String string3 = radioCurrentAMStationInfo.getCurrentAMStationInfoStationName();
        String string4 = this.formatFrequency(radioCurrentAMStationInfo.getCurrentAMStationInfoFrequency(), 1);
        currentStationInfo_Status.primaryInformation.setContent(string4);
        currentStationInfo_Status.pi_Type = 67;
        currentStationInfo_Status.pi_Id = 0;
        currentStationInfo_Status.secondaryInformation.setContent(string3);
        int n = currentStationInfo_Status.si_Type = string3.length() != 0 ? 68 : 0;
        if (this.isRadioTextPlusEnabledAMFM()) {
            RadioService radioService = this.getRadioService();
            string2 = radioService.getCurrentAMRadioTextTitleName();
            string = radioService.getCurrentAMRadioTextArtistName();
        } else {
            string2 = "";
            string = "";
        }
        currentStationInfo_Status.tertiaryInformation.setContent(string2);
        currentStationInfo_Status.ti_Type = string2.length() != 0 ? 72 : 0;
        currentStationInfo_Status.quaternaryInformation.setContent(string);
        currentStationInfo_Status.qi_Type = string.length() != 0 ? 73 : 0;
    }

    @Override
    protected void setStationInfoForRadioFM(CurrentStationInfo_Status currentStationInfo_Status) {
        String string;
        String string2;
        RadioCurrentFMStationInfo radioCurrentFMStationInfo = this.getRadioService().getCurrentFMStationInfo();
        String string3 = radioCurrentFMStationInfo.getCurrentFMStationInfoStationName();
        String string4 = this.formatFrequency(radioCurrentFMStationInfo.getCurrentFMStationInfoFrequency(), 0);
        currentStationInfo_Status.primaryInformation.setContent(string4);
        currentStationInfo_Status.pi_Type = 67;
        currentStationInfo_Status.pi_Id = 0;
        currentStationInfo_Status.secondaryInformation.setContent(string3);
        int n = currentStationInfo_Status.si_Type = string3.length() != 0 ? 68 : 0;
        if (!this.manualTuning && this.isRadioTextPlusEnabledAMFM()) {
            RadioService radioService = this.getRadioService();
            string2 = radioService.getCurrentFMRadioTextTitleName();
            string = radioService.getCurrentFMRadioTextArtistName();
        } else {
            string2 = "";
            string = "";
        }
        currentStationInfo_Status.tertiaryInformation.setContent(string2);
        currentStationInfo_Status.ti_Type = string2.length() != 0 ? 72 : 0;
        currentStationInfo_Status.quaternaryInformation.setContent(string);
        currentStationInfo_Status.qi_Type = string.length() != 0 ? 73 : 0;
    }
}

