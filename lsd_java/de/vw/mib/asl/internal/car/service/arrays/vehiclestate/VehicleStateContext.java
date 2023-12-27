/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.service.arrays.vehiclestate;

import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.internal.car.service.arrays.vehiclestate.VehicleStateController;
import org.dsi.ifc.carkombi.DSICarKombi;

public interface VehicleStateContext {
    default public CarLogger getCarLogger() {
    }

    default public DSICarKombi getDsiVehicleState() {
    }

    default public VehicleStateController getVehicleStateController() {
    }
}

