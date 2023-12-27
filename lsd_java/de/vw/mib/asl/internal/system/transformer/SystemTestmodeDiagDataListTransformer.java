/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.transformer;

import de.vw.mib.asl.internal.system.diag.DiagDataListCollector;
import generated.de.vw.mib.asl.internal.system.transformer.AbstractSystemTestmodeDiagDataListTransformer;

public class SystemTestmodeDiagDataListTransformer
extends AbstractSystemTestmodeDiagDataListTransformer {
    @Override
    public int getInt(int n, Object object) {
        return 0;
    }

    @Override
    public String getString(int n, Object object) {
        switch (n) {
            case 0: {
                return ((DiagDataListCollector)object).getReqName();
            }
            case 1: {
                return ((DiagDataListCollector)object).getReqDescription();
            }
            case 4: {
                return ((DiagDataListCollector)object).getValue();
            }
            case 3: {
                return ((DiagDataListCollector)object).getValueDescription();
            }
        }
        throw new IllegalArgumentException();
    }
}

