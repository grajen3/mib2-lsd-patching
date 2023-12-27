/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.transformer;

import de.vw.mib.asl.internal.testmode.helper.trace.LogSubClassifier;
import generated.de.vw.mib.asl.internal.testmode.transformer.AbstractTestmodeTracesHMISubTransformer;

public class TestmodeTracesHMISubTransformer
extends AbstractTestmodeTracesHMISubTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return ((LogSubClassifier)object).isActive();
    }

    @Override
    public String getString(int n, Object object) {
        return ((LogSubClassifier)object).getName();
    }
}

