/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.radio.speech.dab;

import de.vw.mib.asl.api.radio.dab.DabService;
import de.vw.mib.asl.api.radio.speech.TuningResponseListener;
import de.vw.mib.asl.api.radio.speech.dab.DabServiceListListener;

public interface AslRadioDabFacade {
    default public void tuneDabService(DabService dabService, TuningResponseListener tuningResponseListener) {
    }

    default public DabService[] registerForDabServiceList(DabServiceListListener dabServiceListListener) {
    }
}

