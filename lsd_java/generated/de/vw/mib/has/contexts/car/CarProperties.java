/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.car;

import de.vw.mib.has.HASContextProperties;
import generated.de.vw.mib.has.containers.ThinkBlueDataContainer;
import generated.de.vw.mib.has.containers.ThinkBlueEventContainer;
import generated.de.vw.mib.has.containers.VehicleStatesContainer;

public interface CarProperties
extends HASContextProperties {
    default public void updateCurrentThinkBlue(ThinkBlueDataContainer thinkBlueDataContainer) {
    }

    default public void updateThinkBlueEvent(ThinkBlueEventContainer thinkBlueEventContainer) {
    }

    default public void updateVehicleStates(VehicleStatesContainer vehicleStatesContainer) {
    }
}

