/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.RadioBandContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class RadioBandContainerImpl
extends AbstractContainer
implements RadioBandContainer {
    private static final byte ELEMENT_BAND;
    private int attrBand;

    @Override
    public int getContainerId() {
        return 30;
    }

    @Override
    public boolean isValid() {
        return this.isBandSet();
    }

    @Override
    public int getBand() {
        return this.attrBand;
    }

    @Override
    public boolean isBandSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public void setBand(int n) {
        this.attrBand = n;
        this._setElement((byte)0, true);
    }

    @Override
    public void unsetBand() {
        this.attrBand = 0;
        this._setElement((byte)0, false);
    }
}

