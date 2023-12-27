/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.bordcomputer;

import de.vw.mib.asl.api.car.bordcomputer.BordComputerService;
import de.vw.mib.asl.api.car.bordcomputer.BordComputerServiceListener;

public interface ASLCarBordComputerAPI {
    default public BordComputerService getService() {
    }

    default public void addServiceListener(BordComputerServiceListener bordComputerServiceListener) {
    }

    default public void removeServiceListener(BordComputerServiceListener bordComputerServiceListener) {
    }
}

