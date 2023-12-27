/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.mqbpq.audiosd.functions.CurrentStationInfo;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.CurrentStationInfo_Status;

public final class CurrentStationInfoChinaJp
extends CurrentStationInfo {
    @Override
    protected void setBapCurrentStationInfoInfoTextsForRadioAM(CurrentStationInfo_Status currentStationInfo_Status) {
        String string;
        String string2;
        String string3 = this.getLanguageUtil().formatFrequency(this.getCurrentAMFrequency(), 1);
        currentStationInfo_Status.infotext_1.setContent(string3);
        if (this.isRadioTextPlusEnabledAMFM()) {
            string2 = this.getCurrentAMRadioTextTitleName();
            string = this.getCurrentAMRadioTextArtistName();
        } else {
            string2 = "";
            string = "";
        }
        currentStationInfo_Status.infotext_2.setContent(string2);
        currentStationInfo_Status.infotext_3.setContent(string);
    }

    @Override
    protected void setBapCurrentStationInfoInfoTextsForRadioFM(CurrentStationInfo_Status currentStationInfo_Status) {
        String string;
        String string2;
        String string3 = this.getLanguageUtil().formatFrequency(this.getCurrentFmFrequency(), 0);
        currentStationInfo_Status.infotext_1.setContent(string3);
        if (!this.getManualModeActive() && this.isRadioTextPlusEnabledAMFM()) {
            string2 = this.getCurrentFmRadioTextPlusTitleName();
            string = this.getCurrentFmRadioTextPlusArtistName();
        } else {
            string2 = "";
            string = "";
        }
        currentStationInfo_Status.infotext_2.setContent(string2);
        currentStationInfo_Status.infotext_3.setContent(string);
    }
}

