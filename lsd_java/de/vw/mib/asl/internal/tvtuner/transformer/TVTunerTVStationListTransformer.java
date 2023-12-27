/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.transformer;

import de.vw.mib.asl.internal.tvtuner.collector.TVStationListCollector;
import generated.de.vw.mib.asl.internal.tvtuner.transformer.AbstractTVTunerTVStationListTransformer;

public class TVTunerTVStationListTransformer
extends AbstractTVTunerTVStationListTransformer {
    @Override
    public String getString(int n, Object object) {
        if (n == 1) {
            return ((TVStationListCollector)object).getStationName();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        if (n == 0) {
            return ((TVStationListCollector)object).getPresetNumber();
        }
        if (n == 2) {
            return ((TVStationListCollector)object).getServiceType();
        }
        if (n == 5) {
            return ((TVStationListCollector)object).getServicePID();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public long getLong(int n, Object object) {
        if (n == 3) {
            return ((TVStationListCollector)object).getNamePID();
        }
        throw new IllegalArgumentException();
    }
}

