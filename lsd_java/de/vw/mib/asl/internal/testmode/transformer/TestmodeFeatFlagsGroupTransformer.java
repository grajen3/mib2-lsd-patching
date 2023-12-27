/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.transformer;

import de.vw.mib.asl.internal.testmode.transformer.TestmodeGenericNameValueCollector;
import generated.de.vw.mib.asl.internal.testmode.transformer.AbstractTestmodeFeatFlagsGroupTransformer;

public class TestmodeFeatFlagsGroupTransformer
extends AbstractTestmodeFeatFlagsGroupTransformer {
    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return ((TestmodeGenericNameValueCollector)object).getName();
        }
        if (n == 1) {
            return ((TestmodeGenericNameValueCollector)object).getValue();
        }
        throw new IllegalArgumentException();
    }
}

