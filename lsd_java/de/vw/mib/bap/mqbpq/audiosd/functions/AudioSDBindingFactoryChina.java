/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.mqbpq.audiosd.functions.AudioSDBindingFactoryAll;
import de.vw.mib.bap.mqbpq.audiosd.functions.CurrentStationInfoChinaJp;
import de.vw.mib.bap.mqbpq.audiosd.functions.InfoListChinaJp;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStage;

public final class AudioSDBindingFactoryChina
extends AudioSDBindingFactoryAll {
    @Override
    public BAPStage createNewCurrentStationInfoStage() {
        return new CurrentStationInfoChinaJp();
    }

    @Override
    public BAPStage createNewInfoListStage() {
        return new InfoListChinaJp();
    }
}

