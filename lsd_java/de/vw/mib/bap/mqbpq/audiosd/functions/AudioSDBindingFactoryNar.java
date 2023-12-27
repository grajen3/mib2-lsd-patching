/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.mqbpq.audiosd.functions.AudioSDBindingFactoryAll;
import de.vw.mib.bap.mqbpq.audiosd.functions.CurrentStationInfoNar;
import de.vw.mib.bap.mqbpq.audiosd.functions.InfoListNar;
import de.vw.mib.bap.mqbpq.audiosd.functions.InfoListTypeNar;
import de.vw.mib.bap.mqbpq.audiosd.functions.SourceListNar;
import de.vw.mib.bap.mqbpq.audiosd.functions.TaInfoNar;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStage;

public final class AudioSDBindingFactoryNar
extends AudioSDBindingFactoryAll {
    @Override
    public BAPStage createNewCurrentStationInfoStage() {
        return new CurrentStationInfoNar();
    }

    @Override
    public BAPStage createNewInfoListStage() {
        return new InfoListNar();
    }

    @Override
    public BAPStage createNewTaInfoStage() {
        return new TaInfoNar();
    }

    @Override
    public BAPStage createNewSourceListStage() {
        return new SourceListNar();
    }

    @Override
    public BAPStage createNewInfoListTypeStage() {
        return new InfoListTypeNar();
    }
}

