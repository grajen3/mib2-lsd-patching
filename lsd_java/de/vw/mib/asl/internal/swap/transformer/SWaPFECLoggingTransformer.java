/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.swap.transformer;

import de.vw.mib.asl.internal.swap.AslTargetSWaP;
import de.vw.mib.asl.internal.swap.transformer.LoggingCollector;
import generated.de.vw.mib.asl.internal.swap.transformer.AbstractSWaPFECLoggingTransformer;

public class SWaPFECLoggingTransformer
extends AbstractSWaPFECLoggingTransformer {
    @Override
    public int getInt(int n, Object object) {
        if (n == 1) {
            return ((LoggingCollector)object).loggingModInteger;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        switch (n) {
            case 0: {
                return AslTargetSWaP.getFECCodeString(((LoggingCollector)object).fec);
            }
            case 2: {
                return ((LoggingCollector)object).illegalReasonString;
            }
        }
        throw new IllegalArgumentException();
    }
}

