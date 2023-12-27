/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.mqbpq.audiosd.functions.CurrentStationInfo;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.CurrentStationInfo_Status;

public final class CurrentStationInfoArabic
extends CurrentStationInfo {
    private void checkArabicStationInfoForMedia(CurrentStationInfo_Status currentStationInfo_Status) {
        if (currentStationInfo_Status.infotext_1.isArabic()) {
            this.setSimpleTitleWithoutId3Information(currentStationInfo_Status);
        }
        if (currentStationInfo_Status.infotext_2.isArabic()) {
            currentStationInfo_Status.infotext_2.reset();
        }
        if (currentStationInfo_Status.infotext_3.isArabic()) {
            currentStationInfo_Status.infotext_3.reset();
        }
    }

    @Override
    protected void setBapCurrentStationInfoInfoTextsForRadioFM(CurrentStationInfo_Status currentStationInfo_Status) {
        super.setBapCurrentStationInfoInfoTextsForRadioFM(currentStationInfo_Status);
        if (currentStationInfo_Status.infotext_1.isArabic()) {
            currentStationInfo_Status.infotext_1.reset();
        }
        if (currentStationInfo_Status.infotext_2.isArabic()) {
            currentStationInfo_Status.infotext_2.reset();
        }
        if (currentStationInfo_Status.infotext_3.isArabic()) {
            currentStationInfo_Status.infotext_3.reset();
        }
    }

    @Override
    protected void setBapCurrentStationInfoInfoTextsForRadioDAB(CurrentStationInfo_Status currentStationInfo_Status) {
        super.setBapCurrentStationInfoInfoTextsForRadioDAB(currentStationInfo_Status);
        if (currentStationInfo_Status.infotext_1.isArabic()) {
            currentStationInfo_Status.infotext_1.setContent(this.getCurrentDABFrequencyLabel());
        }
        if (currentStationInfo_Status.infotext_2.isArabic()) {
            currentStationInfo_Status.infotext_2.reset();
        }
        if (currentStationInfo_Status.infotext_3.isArabic()) {
            currentStationInfo_Status.infotext_3.reset();
        }
    }

    @Override
    protected void setBapCurrentStationInfoInfoTextsForMediaDigitalAudioCD(CurrentStationInfo_Status currentStationInfo_Status) {
        super.setBapCurrentStationInfoInfoTextsForMediaDigitalAudioCD(currentStationInfo_Status);
        this.checkArabicStationInfoForMedia(currentStationInfo_Status);
    }

    @Override
    protected void setBapCurrentStationInfoInfoTextsForExternalDevice(CurrentStationInfo_Status currentStationInfo_Status) {
        super.setBapCurrentStationInfoInfoTextsForExternalDevice(currentStationInfo_Status);
        this.checkArabicStationInfoForMedia(currentStationInfo_Status);
    }
}

