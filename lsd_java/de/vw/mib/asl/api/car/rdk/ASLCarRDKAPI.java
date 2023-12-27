/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.rdk;

import de.vw.mib.asl.api.car.rdk.RDKService;
import de.vw.mib.asl.api.car.rdk.RDKServiceListener;

public interface ASLCarRDKAPI {
    default public RDKService getRDKService() {
    }

    default public void addRDKServiceListener(RDKServiceListener rDKServiceListener) {
    }

    default public void removeRDKServiceListener(RDKServiceListener rDKServiceListener) {
    }
}

