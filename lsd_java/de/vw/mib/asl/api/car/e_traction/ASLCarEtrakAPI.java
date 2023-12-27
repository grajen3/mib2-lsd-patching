/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.e_traction;

import de.vw.mib.asl.api.car.e_traction.EtrakService;
import de.vw.mib.asl.api.car.e_traction.EtrakServiceListener;

public interface ASLCarEtrakAPI {
    default public EtrakService getService() {
    }

    default public void addServiceListener(EtrakServiceListener etrakServiceListener) {
    }

    default public void removeServiceListener(EtrakServiceListener etrakServiceListener) {
    }
}

