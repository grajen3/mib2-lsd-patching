/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.LastDestinationContainer;
import generated.de.vw.mib.has.containers.LastDestinationsContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class LastDestinationsContainerImpl
extends AbstractContainer
implements LastDestinationsContainer {
    private static final byte ELEMENT_DESTINATIONS;
    private LastDestinationContainer[] attrDestinations;

    @Override
    public int getContainerId() {
        return 37;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public LastDestinationContainer[] getDestinations() {
        return this.attrDestinations;
    }

    @Override
    public boolean isDestinationsSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public void setDestinations(LastDestinationContainer[] lastDestinationContainerArray) {
        this.attrDestinations = lastDestinationContainerArray;
        this._setElement((byte)0, null != lastDestinationContainerArray);
        if (null != lastDestinationContainerArray) {
            int n = lastDestinationContainerArray.length;
            while (--n >= 0) {
                if (null == lastDestinationContainerArray[n]) continue;
                lastDestinationContainerArray[n].setElementId(76);
            }
        }
    }

    @Override
    public void unsetDestinations() {
        this.attrDestinations = null;
        this._setElement((byte)0, false);
    }
}

