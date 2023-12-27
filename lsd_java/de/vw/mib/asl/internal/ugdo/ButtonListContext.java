/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ugdo;

import de.vw.mib.asl.api.car.logger.CarLogger;
import org.dsi.ifc.carcomfort.DSICarComfort;

public interface ButtonListContext {
    default public CarLogger getCarLogger() {
    }

    default public DSICarComfort getCarComfort() {
    }

    default public void buttonListUpdate() {
    }
}

