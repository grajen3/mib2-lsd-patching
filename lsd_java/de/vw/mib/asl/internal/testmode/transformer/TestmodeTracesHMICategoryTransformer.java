/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.transformer;

import de.vw.mib.asl.internal.testmode.helper.trace.LogClassifier;
import generated.de.vw.mib.asl.internal.testmode.transformer.AbstractTestmodeTracesHMICategoryTransformer;

public class TestmodeTracesHMICategoryTransformer
extends AbstractTestmodeTracesHMICategoryTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return true;
    }

    @Override
    public String getString(int n, Object object) {
        return ((LogClassifier)object).getName();
    }
}

