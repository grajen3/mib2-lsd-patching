/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.navsd.functions;

import de.vw.mib.bap.mqbpq.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbpq.navsd.functions.CurrentPositionInfoArabic;
import de.vw.mib.bap.mqbpq.navsd.functions.NavSDBindingFactoryAll;
import de.vw.mib.bap.mqbpq.navsd.functions.TurnToInfoArabic;

public final class NavSDBindingFactoryArabic
extends NavSDBindingFactoryAll {
    @Override
    public BAPStage createNewCurrentPositionInfoStage() {
        return new CurrentPositionInfoArabic();
    }

    @Override
    public BAPStage createNewTurnToInfoStage() {
        return new TurnToInfoArabic();
    }
}

