/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.TrafficAnnouncementContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class TrafficAnnouncementContainerImpl
extends AbstractContainer
implements TrafficAnnouncementContainer {
    private static final byte ELEMENT_ACTIVE;
    private static final byte ELEMENT_STATION_NAME;
    private static final byte ELEMENT_FREQUENCY;
    private boolean attrActive;
    private String attrStationName;
    private long attrFrequency;

    @Override
    public int getContainerId() {
        return 51;
    }

    @Override
    public boolean isValid() {
        return this.isActiveSet();
    }

    @Override
    public boolean getActive() {
        return this.attrActive;
    }

    @Override
    public String getStationName() {
        return this.attrStationName;
    }

    @Override
    public long getFrequency() {
        return this.attrFrequency;
    }

    @Override
    public boolean isActiveSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isStationNameSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public boolean isFrequencySet() {
        return this._isElementSet((byte)2);
    }

    @Override
    public void setActive(boolean bl) {
        this.attrActive = bl;
        this._setElement((byte)0, true);
    }

    @Override
    public void setStationName(String string) {
        this.attrStationName = string;
        this._setElement((byte)1, null != string);
    }

    @Override
    public void setFrequency(long l) {
        this.attrFrequency = l;
        this._setElement((byte)2, true);
    }

    @Override
    public void unsetActive() {
        this.attrActive = false;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetStationName() {
        this.attrStationName = null;
        this._setElement((byte)1, false);
    }

    @Override
    public void unsetFrequency() {
        this.attrFrequency = 0L;
        this._setElement((byte)2, false);
    }
}

