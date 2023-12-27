/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.abtfeatures;

import de.vw.mib.asl.internal.system.abtfeatures.IntegerValueParser;
import de.vw.mib.asl.internal.system.abtfeatures.ValueSetter;
import de.vw.mib.asl.systemcommon.persistence.AbtFeatures;

public abstract class BooleanSetter
implements ValueSetter {
    private AbtFeatures abtFeatures;
    private IntegerValueParser parser;

    protected BooleanSetter(AbtFeatures abtFeatures) {
        this.abtFeatures = abtFeatures;
        this.parser = new IntegerValueParser(1);
    }

    @Override
    public void parse(byte[] byArray) {
        boolean bl = this.parser.parse(byArray) != 0;
        this.apply(this.abtFeatures, bl);
    }

    protected abstract void apply(AbtFeatures abtFeatures, boolean bl) {
    }
}

