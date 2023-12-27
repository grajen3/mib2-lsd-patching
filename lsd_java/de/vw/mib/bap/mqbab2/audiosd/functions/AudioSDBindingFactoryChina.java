/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.mqbab2.audiosd.functions.AudioSDBindingFactoryAll;
import de.vw.mib.bap.mqbab2.audiosd.functions.CurrentStationInfoChinaJp;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;

public class AudioSDBindingFactoryChina
extends AudioSDBindingFactoryAll {
    @Override
    public BAPStage createNewCurrentStationInfoStage() {
        return new CurrentStationInfoChinaJp();
    }
}

