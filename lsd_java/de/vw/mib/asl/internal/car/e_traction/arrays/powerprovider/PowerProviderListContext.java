/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction.arrays.powerprovider;

import de.vw.mib.asl.api.car.logger.CarLogger;
import org.dsi.ifc.carhybrid.DSICarHybrid;

public interface PowerProviderListContext {
    default public CarLogger getCarLogger() {
    }

    default public DSICarHybrid getCarHybrid() {
    }

    default public void powerProviderListLoadedState(boolean bl) {
    }

    default public void powerProviderListUpdated() {
    }
}

