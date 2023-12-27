/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.transformer;

import de.vw.mib.asl.internal.tvtuner.collector.TVPresetStoreAndDeletionListCollector;
import generated.de.vw.mib.asl.internal.tvtuner.transformer.AbstractTVTunerPresetStoreListTransformer;

public class TVTunerPresetStoreListTransformer
extends AbstractTVTunerPresetStoreListTransformer {
    @Override
    public int getInt(int n, Object object) {
        if (n == 0) {
            return ((TVPresetStoreAndDeletionListCollector)object).getPresetNumber();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        if (n == 1) {
            return ((TVPresetStoreAndDeletionListCollector)object).getStationName();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        if (n == 2) {
            return ((TVPresetStoreAndDeletionListCollector)object).getAllocationState();
        }
        throw new IllegalArgumentException();
    }
}

