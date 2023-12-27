/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.mqbpq.audiosd.functions.AudioSDBindingFactoryAll;
import de.vw.mib.bap.mqbpq.audiosd.functions.CurrentStationInfoArabic;
import de.vw.mib.bap.mqbpq.audiosd.functions.InfoListArabic;
import de.vw.mib.bap.mqbpq.audiosd.functions.TaInfoArabic;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStage;

public final class AudioSDBindingFactoryArabic
extends AudioSDBindingFactoryAll {
    @Override
    public BAPStage createNewCurrentStationInfoStage() {
        return new CurrentStationInfoArabic();
    }

    @Override
    public BAPStage createNewInfoListStage() {
        return new InfoListArabic();
    }

    @Override
    public BAPStage createNewTaInfoStage() {
        return new TaInfoArabic();
    }
}

