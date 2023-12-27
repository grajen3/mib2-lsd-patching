/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.navsd.functions.AddressListArabic;
import de.vw.mib.bap.mqbab2.navsd.functions.CurrentPositionInfoArabic;
import de.vw.mib.bap.mqbab2.navsd.functions.LastDestListArabic;
import de.vw.mib.bap.mqbab2.navsd.functions.NavSDBindingFactoryAll;
import de.vw.mib.bap.mqbab2.navsd.functions.PreferredDestListArabic;
import de.vw.mib.bap.mqbab2.navsd.functions.TurnToInfoArabic;

public class NavSDBindingFactoryArabic
extends NavSDBindingFactoryAll {
    @Override
    public BAPStage createNewCurrentPositionInfoStage() {
        return new CurrentPositionInfoArabic();
    }

    @Override
    public BAPStage createNewAddressListStage() {
        return new AddressListArabic();
    }

    @Override
    public BAPStage createNewTurnToInfoStage() {
        return new TurnToInfoArabic();
    }

    @Override
    public BAPStage createNewLastDestListStage() {
        return new LastDestListArabic();
    }

    @Override
    public BAPStage createNewPreferredDestListStage() {
        return new PreferredDestListArabic();
    }
}

