/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.transformer;

import de.vw.mib.asl.internal.tvtuner.collector.PresetListCollector;
import generated.de.vw.mib.asl.internal.tvtuner.transformer.AbstractTVTunerPresetListTransformer;

public class TVTunerPresetListTransformer
extends AbstractTVTunerPresetListTransformer {
    @Override
    public String getString(int n, Object object) {
        if (n == 1) {
            return ((PresetListCollector)object).getStationName();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        if (n == 0) {
            return ((PresetListCollector)object).getPresetNumber();
        }
        if (n == 2) {
            return ((PresetListCollector)object).getServiceType();
        }
        throw new IllegalArgumentException();
    }
}

