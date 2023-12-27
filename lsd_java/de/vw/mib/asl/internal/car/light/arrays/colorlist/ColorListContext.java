/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.light.arrays.colorlist;

import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.internal.car.light.arrays.colorlist.ColorListController;
import org.dsi.ifc.carlight.DSICarLight;

public interface ColorListContext {
    default public CarLogger getCarLogger() {
    }

    default public DSICarLight getDsiCarLight() {
    }

    default public ColorListController getColorListController() {
    }
}

