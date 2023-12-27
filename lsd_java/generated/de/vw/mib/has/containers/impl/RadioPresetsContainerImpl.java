/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.RadioPresetContainer;
import generated.de.vw.mib.has.containers.RadioPresetsContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class RadioPresetsContainerImpl
extends AbstractContainer
implements RadioPresetsContainer {
    private static final byte ELEMENT_STATIONS;
    private RadioPresetContainer[] attrStations;

    @Override
    public int getContainerId() {
        return 41;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public RadioPresetContainer[] getStations() {
        return this.attrStations;
    }

    @Override
    public boolean isStationsSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public void setStations(RadioPresetContainer[] radioPresetContainerArray) {
        this.attrStations = radioPresetContainerArray;
        this._setElement((byte)0, null != radioPresetContainerArray);
        if (null != radioPresetContainerArray) {
            int n = radioPresetContainerArray.length;
            while (--n >= 0) {
                if (null == radioPresetContainerArray[n]) continue;
                radioPresetContainerArray[n].setElementId(91);
            }
        }
    }

    @Override
    public void unsetStations() {
        this.attrStations = null;
        this._setElement((byte)0, false);
    }
}

