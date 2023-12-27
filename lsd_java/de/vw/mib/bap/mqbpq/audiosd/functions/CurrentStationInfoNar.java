/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.mqbpq.audiosd.functions.AudioSDCommon;
import de.vw.mib.bap.mqbpq.audiosd.functions.CurrentStationInfo;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.CurrentStationInfo_Status;

public class CurrentStationInfoNar
extends CurrentStationInfo {
    private static final int AM_HD_STATION;

    @Override
    protected void setBapCurrentStationInfoInfoTextsForRadioAM(CurrentStationInfo_Status currentStationInfo_Status) {
        boolean bl;
        int n = this.getCurrentAmHdChannelNumber() == 0 ? 0 : -1;
        String string = this.getLanguageUtil().formatFrequencyNAR(this.getCurrentAMFrequency(), 1, n);
        currentStationInfo_Status.infotext_1.setContent(string);
        String string2 = this.getCurrentAMRadioTextTitleName();
        String string3 = this.getCurrentAMRadioTextArtistName();
        boolean bl2 = (this.getHdRadioState() == 0 || this.getHdRadioState() == 2 || this.getHdRadioState() != 1) && this.getCurrentAmHdChannelNumber() >= 0;
        boolean bl3 = this.getCurrentHdRadioPsTitleName().length() != 0 || this.getCurrentHdRadioPsArtistName().length() != 0;
        boolean bl4 = bl = this.getCurrentAmHdChannelNumber() > 1;
        if (bl2 && (bl3 || bl) || !this.getRadioTextSetupState()) {
            string2 = this.getCurrentHdRadioPsTitleName();
            string3 = this.getCurrentHdRadioPsArtistName();
        }
        currentStationInfo_Status.infotext_2.setContent(string2);
        currentStationInfo_Status.infotext_3.setContent(string3);
    }

    @Override
    protected void setBapCurrentStationInfoInfoTextsForRadioFM(CurrentStationInfo_Status currentStationInfo_Status) {
        boolean bl;
        currentStationInfo_Status.infotext_1.setContent(this.getLanguageUtil().formatFrequencyNAR(this.getCurrentFmFrequency(), 0, this.getCurrentFmHdChannelNumber()));
        String string = this.getCurrentHdRadioPsTitleName();
        String string2 = this.getCurrentHdRadioPsArtistName();
        boolean bl2 = (this.getHdRadioState() == 0 || this.getHdRadioState() == 2 || this.getHdRadioState() != 1) && this.getCurrentFmHdChannelNumber() >= 0;
        boolean bl3 = this.getCurrentHdRadioPsTitleName().length() != 0 || this.getCurrentHdRadioPsArtistName().length() != 0;
        boolean bl4 = bl = this.getCurrentFmHdChannelNumber() > 1;
        if (bl2 && (bl3 || bl) || !this.getRadioTextSetupState()) {
            string = this.getCurrentHdRadioPsTitleName();
            string2 = this.getCurrentHdRadioPsArtistName();
        } else {
            string = this.getCurrentFmRadioTextPlusTitleName();
            string2 = this.getCurrentFmRadioTextPlusArtistName();
        }
        currentStationInfo_Status.infotext_2.setContent(string);
        currentStationInfo_Status.infotext_3.setContent(string2);
    }

    @Override
    protected int findBapPosIdInReceptionList() {
        int n;
        switch (this.getArrowKeyScopeMode()) {
            case 0: {
                n = this.getReceptionList() != null ? this.getReceptionList().getBapPosID(AudioSDCommon.computeUniquePresetID(this.getCurrentStationInfoBand(), this.getPresetBankActiveIndex())) : 0;
                break;
            }
            default: {
                n = super.findBapPosIdInReceptionList();
            }
        }
        return n;
    }
}

