/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.abtfeatures;

import de.vw.mib.asl.internal.system.abtfeatures.IntegerValueParser;
import de.vw.mib.asl.internal.system.abtfeatures.ValueSetter;
import de.vw.mib.asl.systemcommon.persistence.AbtFeatures;

public abstract class IntegerSetter
implements ValueSetter {
    private final IntegerValueParser parser;
    private final AbtFeatures abtFeatures;

    protected IntegerSetter(AbtFeatures abtFeatures) {
        this.abtFeatures = abtFeatures;
        this.parser = new IntegerValueParser();
    }

    protected IntegerSetter(AbtFeatures abtFeatures, short s) {
        this.abtFeatures = abtFeatures;
        this.parser = new IntegerValueParser(s);
    }

    @Override
    public void parse(byte[] byArray) {
        int n = this.parser.parse(byArray);
        this.apply(this.abtFeatures, n);
    }

    protected abstract void apply(AbtFeatures abtFeatures, int n) {
    }
}

