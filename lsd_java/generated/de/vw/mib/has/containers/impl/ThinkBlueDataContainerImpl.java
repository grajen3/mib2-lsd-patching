/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.ThinkBlueDataContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class ThinkBlueDataContainerImpl
extends AbstractContainer
implements ThinkBlueDataContainer {
    private static final byte ELEMENT_AVG_SHORT;
    private static final byte ELEMENT_AVG_TRIP;
    private int attrAvgShort;
    private int attrAvgTrip;

    @Override
    public int getContainerId() {
        return 44;
    }

    @Override
    public boolean isValid() {
        return this.isAvgShortSet() && this.isAvgTripSet();
    }

    @Override
    public int getAvgShort() {
        return this.attrAvgShort;
    }

    @Override
    public int getAvgTrip() {
        return this.attrAvgTrip;
    }

    @Override
    public boolean isAvgShortSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isAvgTripSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public void setAvgShort(int n) {
        this.attrAvgShort = n;
        this._setElement((byte)0, true);
    }

    @Override
    public void setAvgTrip(int n) {
        this.attrAvgTrip = n;
        this._setElement((byte)1, true);
    }

    @Override
    public void unsetAvgShort() {
        this.attrAvgShort = 0;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetAvgTrip() {
        this.attrAvgTrip = 0;
        this._setElement((byte)1, false);
    }
}

