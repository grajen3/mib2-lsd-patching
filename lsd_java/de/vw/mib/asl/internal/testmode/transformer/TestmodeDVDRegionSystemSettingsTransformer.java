/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.transformer;

import de.vw.mib.asl.internal.list.ItemTransformer;
import generated.de.vw.mib.asl.internal.testmode.transformer.AbstractTestmodeDVDRegionSystemSettingsTransformer;

public final class TestmodeDVDRegionSystemSettingsTransformer
extends AbstractTestmodeDVDRegionSystemSettingsTransformer
implements ItemTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        if (!(object instanceof Boolean)) {
            throw new IllegalArgumentException();
        }
        return (Boolean)object;
    }
}

