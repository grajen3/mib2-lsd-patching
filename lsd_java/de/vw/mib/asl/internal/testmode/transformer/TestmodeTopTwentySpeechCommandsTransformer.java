/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.transformer;

import generated.de.vw.mib.asl.internal.testmode.transformer.AbstractTestmodeTopTwentySpeechCommandsTransformer;

public class TestmodeTopTwentySpeechCommandsTransformer
extends AbstractTestmodeTopTwentySpeechCommandsTransformer {
    @Override
    public String getString(int n, Object object) {
        Integer n2 = (Integer)object;
        return n2.toString();
    }
}

