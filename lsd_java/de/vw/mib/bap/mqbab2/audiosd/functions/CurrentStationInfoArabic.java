/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.mqbab2.audiosd.functions.CurrentStationInfo;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.CurrentStationInfo_Status;

public class CurrentStationInfoArabic
extends CurrentStationInfo {
    private void checkTertiaryAndQuaternaryInformation(CurrentStationInfo_Status currentStationInfo_Status) {
        if (currentStationInfo_Status.tertiaryInformation.isArabic()) {
            currentStationInfo_Status.tertiaryInformation.reset();
            currentStationInfo_Status.ti_Type = 0;
        }
        if (currentStationInfo_Status.quaternaryInformation.isArabic()) {
            currentStationInfo_Status.quaternaryInformation.reset();
            currentStationInfo_Status.qi_Type = 0;
        }
    }

    @Override
    protected void setStationInfoForRadioFM(CurrentStationInfo_Status currentStationInfo_Status) {
        super.setStationInfoForRadioFM(currentStationInfo_Status);
        if (currentStationInfo_Status.si_Type == 68) {
            if (currentStationInfo_Status.secondaryInformation.isArabic()) {
                currentStationInfo_Status.secondaryInformation.reset();
                currentStationInfo_Status.si_Type = 0;
            }
        } else if (currentStationInfo_Status.primaryInformation.isArabic()) {
            currentStationInfo_Status.primaryInformation.setContent(currentStationInfo_Status.secondaryInformation);
        }
        this.checkTertiaryAndQuaternaryInformation(currentStationInfo_Status);
    }

    @Override
    protected void setStationInfoForRadioDAB(CurrentStationInfo_Status currentStationInfo_Status) {
        super.setStationInfoForRadioDAB(currentStationInfo_Status);
        if (currentStationInfo_Status.primaryInformation.isArabic()) {
            currentStationInfo_Status.primaryInformation.setContent(this.getRadioService().getCurrentDABStationInfo().getCurrentDABStationFrequencyLabel());
            currentStationInfo_Status.pi_Type = 0;
        }
        if (currentStationInfo_Status.secondaryInformation.isArabic()) {
            currentStationInfo_Status.secondaryInformation.reset();
        }
        this.checkTertiaryAndQuaternaryInformation(currentStationInfo_Status);
    }

    private void checkArabicStationInfoForMedia(CurrentStationInfo_Status currentStationInfo_Status) {
        if (currentStationInfo_Status.primaryInformation.isArabic()) {
            int n = this.getMediaService().getCurrentTrackInfo().getCurrentTrackNumber();
            currentStationInfo_Status.primaryInformation.reset();
            currentStationInfo_Status.pi_Type = n != 0 ? 8 : 0;
            currentStationInfo_Status.pi_Id = n;
        }
        this.checkTertiaryAndQuaternaryInformation(currentStationInfo_Status);
    }

    @Override
    protected void setStationInfoForMediaDigitalAudioCD(CurrentStationInfo_Status currentStationInfo_Status) {
        super.setStationInfoForMediaDigitalAudioCD(currentStationInfo_Status);
        this.checkArabicStationInfoForMedia(currentStationInfo_Status);
    }

    @Override
    protected void setStationInfoForMediaExternalDevice(CurrentStationInfo_Status currentStationInfo_Status) {
        super.setStationInfoForMediaExternalDevice(currentStationInfo_Status);
        this.checkArabicStationInfoForMedia(currentStationInfo_Status);
    }
}

