/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction.arrays.profiles;

import de.vw.mib.asl.api.car.logger.CarLogger;
import org.dsi.ifc.carhybrid.DSICarHybrid;

public interface ProfileListContext {
    default public CarLogger getCarLogger() {
    }

    default public DSICarHybrid getCarHybrid() {
    }

    default public void profileListLoadedState(boolean bl) {
    }

    default public void profileListUpdated() {
    }
}

