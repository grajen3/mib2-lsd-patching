/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.swap.transformer;

import de.vw.mib.asl.internal.swap.transformer.InstallSummaryCollector;
import generated.de.vw.mib.asl.internal.swap.transformer.AbstractSWaPInstallSummaryTransformer;

public class SWaPInstallSummaryTransformer
extends AbstractSWaPInstallSummaryTransformer {
    @Override
    public int getInt(int n, Object object) {
        if (n == 1) {
            return ((InstallSummaryCollector)object).returnCode;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return ((InstallSummaryCollector)object).feature;
        }
        throw new IllegalArgumentException();
    }
}

