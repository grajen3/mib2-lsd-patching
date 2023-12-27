/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.AppConnectDeviceContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class AppConnectDeviceContainerImpl
extends AbstractContainer
implements AppConnectDeviceContainer {
    private static final byte ELEMENT_AVAILABLE;
    private static final byte ELEMENT_ENTERTAINMENT_ACTIVE;
    private static final byte ELEMENT_TYPE;
    private static final byte ELEMENT_DEVICE_NAME;
    private boolean attrAvailable;
    private boolean attrEntertainmentActive;
    private int attrType;
    private String attrDeviceName;

    @Override
    public int getContainerId() {
        return 64;
    }

    @Override
    public boolean isValid() {
        return this.isAvailableSet();
    }

    @Override
    public boolean getAvailable() {
        return this.attrAvailable;
    }

    @Override
    public boolean getEntertainmentActive() {
        return this.attrEntertainmentActive;
    }

    @Override
    public int getType() {
        return this.attrType;
    }

    @Override
    public String getDeviceName() {
        return this.attrDeviceName;
    }

    @Override
    public boolean isAvailableSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isEntertainmentActiveSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public boolean isTypeSet() {
        return this._isElementSet((byte)2);
    }

    @Override
    public boolean isDeviceNameSet() {
        return this._isElementSet((byte)3);
    }

    @Override
    public void setAvailable(boolean bl) {
        this.attrAvailable = bl;
        this._setElement((byte)0, true);
    }

    @Override
    public void setEntertainmentActive(boolean bl) {
        this.attrEntertainmentActive = bl;
        this._setElement((byte)1, true);
    }

    @Override
    public void setType(int n) {
        this.attrType = n;
        this._setElement((byte)2, true);
    }

    @Override
    public void setDeviceName(String string) {
        this.attrDeviceName = string;
        this._setElement((byte)3, null != string);
    }

    @Override
    public void unsetAvailable() {
        this.attrAvailable = false;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetEntertainmentActive() {
        this.attrEntertainmentActive = false;
        this._setElement((byte)1, false);
    }

    @Override
    public void unsetType() {
        this.attrType = 0;
        this._setElement((byte)2, false);
    }

    @Override
    public void unsetDeviceName() {
        this.attrDeviceName = null;
        this._setElement((byte)3, false);
    }
}

