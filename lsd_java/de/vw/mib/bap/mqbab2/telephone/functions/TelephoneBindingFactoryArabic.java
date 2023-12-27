/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.telephone.functions.CallInfoArabic;
import de.vw.mib.bap.mqbab2.telephone.functions.CombinedNumbersArabic;
import de.vw.mib.bap.mqbab2.telephone.functions.TelephoneBindingFactoryAll;

public class TelephoneBindingFactoryArabic
extends TelephoneBindingFactoryAll {
    @Override
    public BAPStage createNewCallInfoStage() {
        return new CallInfoArabic();
    }

    @Override
    public BAPStage createNewCombinedNumbersStage() {
        return new CombinedNumbersArabic();
    }
}

