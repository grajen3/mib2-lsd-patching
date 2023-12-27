/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.swap.transformer;

import de.vw.mib.asl.internal.swap.AslTargetSWaP;
import generated.de.vw.mib.asl.internal.swap.transformer.AbstractSWaPInstalledFECTransformer;
import org.dsi.ifc.swap.SFscStatus;

public class SWaPInstalledFECTransformer
extends AbstractSWaPInstalledFECTransformer {
    @Override
    public int getInt(int n, Object object) {
        if (n == 1) {
            return AslTargetSWaP.convertFscStateFromDSIValues(((SFscStatus)object).state);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            return AslTargetSWaP.getFECCodeString(((SFscStatus)object).swid);
        }
        throw new IllegalArgumentException();
    }
}

