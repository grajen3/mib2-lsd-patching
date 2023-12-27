/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.RadioBandContainer;
import generated.de.vw.mib.has.containers.RadioBandsContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class RadioBandsContainerImpl
extends AbstractContainer
implements RadioBandsContainer {
    private static final byte ELEMENT_BANDS;
    private RadioBandContainer[] attrBands;

    @Override
    public int getContainerId() {
        return 35;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public RadioBandContainer[] getBands() {
        return this.attrBands;
    }

    @Override
    public boolean isBandsSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public void setBands(RadioBandContainer[] radioBandContainerArray) {
        this.attrBands = radioBandContainerArray;
        this._setElement((byte)0, null != radioBandContainerArray);
        if (null != radioBandContainerArray) {
            int n = radioBandContainerArray.length;
            while (--n >= 0) {
                if (null == radioBandContainerArray[n]) continue;
                radioBandContainerArray[n].setElementId(73);
            }
        }
    }

    @Override
    public void unsetBands() {
        this.attrBands = null;
        this._setElement((byte)0, false);
    }
}

