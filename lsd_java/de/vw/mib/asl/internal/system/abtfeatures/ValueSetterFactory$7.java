/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.abtfeatures;

import de.vw.mib.asl.internal.system.abtfeatures.IntegerSetter;
import de.vw.mib.asl.internal.system.abtfeatures.ValueSetterFactory;
import de.vw.mib.asl.systemcommon.persistence.AbtFeatures;

class ValueSetterFactory$7
extends IntegerSetter {
    private final /* synthetic */ ValueSetterFactory this$0;

    ValueSetterFactory$7(ValueSetterFactory valueSetterFactory, AbtFeatures abtFeatures, short s) {
        this.this$0 = valueSetterFactory;
        super(abtFeatures, s);
    }

    @Override
    protected void apply(AbtFeatures abtFeatures, int n) {
        abtFeatures.setDisplayShape(n);
    }
}

