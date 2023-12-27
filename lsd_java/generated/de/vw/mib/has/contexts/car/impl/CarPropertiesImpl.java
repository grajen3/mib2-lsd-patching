/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.car.impl;

import de.vw.mib.has.HASBaseContainerFactory;
import de.vw.mib.has.HASDatapool;
import generated.de.vw.mib.has.containers.ThinkBlueDataContainer;
import generated.de.vw.mib.has.containers.ThinkBlueEventContainer;
import generated.de.vw.mib.has.containers.VehicleStatesContainer;
import generated.de.vw.mib.has.contexts.car.CarProperties;
import generated.de.vw.mib.has.contexts.impl.AbstractContextProperties;

public class CarPropertiesImpl
extends AbstractContextProperties
implements CarProperties {
    public CarPropertiesImpl(HASDatapool hASDatapool, HASBaseContainerFactory hASBaseContainerFactory) {
        super(hASDatapool, hASBaseContainerFactory);
    }

    @Override
    public void updateCurrentThinkBlue(ThinkBlueDataContainer thinkBlueDataContainer) {
        this.updateProperty(42, thinkBlueDataContainer);
    }

    @Override
    public void updateThinkBlueEvent(ThinkBlueEventContainer thinkBlueEventContainer) {
        this.updateProperty(52, thinkBlueEventContainer);
    }

    @Override
    public void updateVehicleStates(VehicleStatesContainer vehicleStatesContainer) {
        this.updateProperty(56, vehicleStatesContainer);
    }
}

