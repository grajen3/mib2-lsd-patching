/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.transformer;

import generated.de.vw.mib.asl.internal.testmode.transformer.AbstractTestmodeHWRMatchListTransformer;

public class TestmodeHWRMatchListTransformer
extends AbstractTestmodeHWRMatchListTransformer {
    @Override
    public String getString(int n, Object object) {
        switch (n) {
            case 0: {
                return (String)object;
            }
        }
        return "";
    }
}

