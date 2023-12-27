/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.VehicleStateContainer;
import generated.de.vw.mib.has.containers.VehicleStatesContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class VehicleStatesContainerImpl
extends AbstractContainer
implements VehicleStatesContainer {
    private static final byte ELEMENT_STATES;
    private VehicleStateContainer[] attrStates;

    @Override
    public int getContainerId() {
        return 63;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public VehicleStateContainer[] getStates() {
        return this.attrStates;
    }

    @Override
    public boolean isStatesSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public void setStates(VehicleStateContainer[] vehicleStateContainerArray) {
        this.attrStates = vehicleStateContainerArray;
        this._setElement((byte)0, null != vehicleStateContainerArray);
        if (null != vehicleStateContainerArray) {
            int n = vehicleStateContainerArray.length;
            while (--n >= 0) {
                if (null == vehicleStateContainerArray[n]) continue;
                vehicleStateContainerArray[n].setElementId(144);
            }
        }
    }

    @Override
    public void unsetStates() {
        this.attrStates = null;
        this._setElement((byte)0, false);
    }
}

