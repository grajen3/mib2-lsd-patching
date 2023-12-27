/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.RadioPresetIndexContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class RadioPresetIndexContainerImpl
extends AbstractContainer
implements RadioPresetIndexContainer {
    private static final byte ELEMENT_BAND;
    private static final byte ELEMENT_INDEX;
    private int attrBand;
    private int attrIndex;

    @Override
    public int getContainerId() {
        return 45;
    }

    @Override
    public boolean isValid() {
        return this.isBandSet() && this.isIndexSet();
    }

    @Override
    public int getBand() {
        return this.attrBand;
    }

    @Override
    public int getIndex() {
        return this.attrIndex;
    }

    @Override
    public boolean isBandSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isIndexSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public void setBand(int n) {
        this.attrBand = n;
        this._setElement((byte)0, true);
    }

    @Override
    public void setIndex(int n) {
        this.attrIndex = n;
        this._setElement((byte)1, true);
    }

    @Override
    public void unsetBand() {
        this.attrBand = 0;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetIndex() {
        this.attrIndex = 0;
        this._setElement((byte)1, false);
    }
}

