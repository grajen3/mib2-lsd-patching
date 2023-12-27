/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.mqbab2.audiosd.functions.AnnouncementInfoArabic;
import de.vw.mib.bap.mqbab2.audiosd.functions.AudioSDBindingFactoryAll;
import de.vw.mib.bap.mqbab2.audiosd.functions.CurrentStationInfoArabic;
import de.vw.mib.bap.mqbab2.audiosd.functions.ReceptionListArabic;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;

public class AudioSDBindingFactoryArabic
extends AudioSDBindingFactoryAll {
    @Override
    public BAPStage createNewReceptionListStage() {
        return new ReceptionListArabic();
    }

    @Override
    public BAPStage createNewCurrentStationInfoStage() {
        return new CurrentStationInfoArabic();
    }

    @Override
    public BAPStage createNewAnnouncementInfoStage() {
        return new AnnouncementInfoArabic();
    }
}

