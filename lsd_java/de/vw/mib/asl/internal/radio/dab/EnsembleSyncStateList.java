/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab;

import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import org.dsi.ifc.radio.EnsembleInfo;

public class EnsembleSyncStateList {
    private LongObjectOptHashMap mMapEnsembles = new LongObjectOptHashMap();

    public int getSyncState(EnsembleInfo ensembleInfo) {
        long l = DabTunerState.calcEnsembleId(ensembleInfo.ensID, ensembleInfo.ensECC);
        if (this.mMapEnsembles.containsKey(l)) {
            return (Integer)this.mMapEnsembles.get(l);
        }
        return 4;
    }

    public void setSyncState(EnsembleInfo ensembleInfo, int n) {
        long l = DabTunerState.calcEnsembleId(ensembleInfo.ensID, ensembleInfo.ensECC);
        this.mMapEnsembles.put(l, new Integer(n));
    }
}

