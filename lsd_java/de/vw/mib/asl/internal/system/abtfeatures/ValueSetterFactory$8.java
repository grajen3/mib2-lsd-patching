/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.abtfeatures;

import de.vw.mib.asl.internal.system.abtfeatures.IntegerSetter;
import de.vw.mib.asl.internal.system.abtfeatures.ValueSetterFactory;
import de.vw.mib.asl.systemcommon.persistence.AbtFeatures;

class ValueSetterFactory$8
extends IntegerSetter {
    private final /* synthetic */ ValueSetterFactory this$0;

    ValueSetterFactory$8(ValueSetterFactory valueSetterFactory, AbtFeatures abtFeatures) {
        this.this$0 = valueSetterFactory;
        super(abtFeatures);
    }

    @Override
    protected void apply(AbtFeatures abtFeatures, int n) {
        abtFeatures.setNubmerOfHardKeys(n);
    }
}

