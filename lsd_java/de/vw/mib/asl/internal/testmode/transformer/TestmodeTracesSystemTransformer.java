/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.transformer;

import de.vw.mib.asl.internal.testmode.helper.trace.debugprobe.DebugProbe;
import generated.de.vw.mib.asl.internal.testmode.transformer.AbstractTestmodeTracesSystemTransformer;

public class TestmodeTracesSystemTransformer
extends AbstractTestmodeTracesSystemTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return ((DebugProbe)object).isActive();
    }

    @Override
    public String getString(int n, Object object) {
        return ((DebugProbe)object).getName();
    }
}

