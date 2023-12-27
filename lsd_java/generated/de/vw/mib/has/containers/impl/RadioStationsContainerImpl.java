/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.RadioStationInfoContainer;
import generated.de.vw.mib.has.containers.RadioStationsContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class RadioStationsContainerImpl
extends AbstractContainer
implements RadioStationsContainer {
    private static final byte ELEMENT_STATIONS;
    private RadioStationInfoContainer[] attrStations;

    @Override
    public int getContainerId() {
        return 39;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public RadioStationInfoContainer[] getStations() {
        return this.attrStations;
    }

    @Override
    public boolean isStationsSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public void setStations(RadioStationInfoContainer[] radioStationInfoContainerArray) {
        this.attrStations = radioStationInfoContainerArray;
        this._setElement((byte)0, null != radioStationInfoContainerArray);
        if (null != radioStationInfoContainerArray) {
            int n = radioStationInfoContainerArray.length;
            while (--n >= 0) {
                if (null == radioStationInfoContainerArray[n]) continue;
                radioStationInfoContainerArray[n].setElementId(88);
            }
        }
    }

    @Override
    public void unsetStations() {
        this.attrStations = null;
        this._setElement((byte)0, false);
    }
}

