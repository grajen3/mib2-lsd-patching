/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.RadioFrequencyRangesContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class RadioFrequencyRangesContainerImpl
extends AbstractContainer
implements RadioFrequencyRangesContainer {
    private static final byte ELEMENT_AM_RANGE;
    private static final byte ELEMENT_FM_RANGE;
    private int attrAMRange;
    private int attrFMRange;

    @Override
    public int getContainerId() {
        return 42;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public int getAMRange() {
        return this.attrAMRange;
    }

    @Override
    public int getFMRange() {
        return this.attrFMRange;
    }

    @Override
    public boolean isAMRangeSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isFMRangeSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public void setAMRange(int n) {
        this.attrAMRange = n;
        this._setElement((byte)0, true);
    }

    @Override
    public void setFMRange(int n) {
        this.attrFMRange = n;
        this._setElement((byte)1, true);
    }

    @Override
    public void unsetAMRange() {
        this.attrAMRange = 0;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetFMRange() {
        this.attrFMRange = 0;
        this._setElement((byte)1, false);
    }
}

