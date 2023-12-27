/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.abtfeatures;

import de.vw.mib.asl.internal.system.abtfeatures.BooleanSetter;
import de.vw.mib.asl.internal.system.abtfeatures.ValueSetterFactory;
import de.vw.mib.asl.systemcommon.persistence.AbtFeatures;

class ValueSetterFactory$2
extends BooleanSetter {
    private final /* synthetic */ ValueSetterFactory this$0;

    ValueSetterFactory$2(ValueSetterFactory valueSetterFactory, AbtFeatures abtFeatures) {
        this.this$0 = valueSetterFactory;
        super(abtFeatures);
    }

    @Override
    protected void apply(AbtFeatures abtFeatures, boolean bl) {
        abtFeatures.setHapticFeedback(bl);
    }
}

