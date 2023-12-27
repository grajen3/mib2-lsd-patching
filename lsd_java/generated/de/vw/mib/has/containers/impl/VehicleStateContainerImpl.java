/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.VehicleStateContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class VehicleStateContainerImpl
extends AbstractContainer
implements VehicleStateContainer {
    private static final byte ELEMENT_WARN_ID;
    private static final byte ELEMENT_DYNAMIC_VALUE;
    private int attrWarnId;
    private String attrDynamicValue;

    @Override
    public int getContainerId() {
        return 62;
    }

    @Override
    public boolean isValid() {
        return this.isWarnIdSet();
    }

    @Override
    public int getWarnId() {
        return this.attrWarnId;
    }

    @Override
    public String getDynamicValue() {
        return this.attrDynamicValue;
    }

    @Override
    public boolean isWarnIdSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isDynamicValueSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public void setWarnId(int n) {
        this.attrWarnId = n;
        this._setElement((byte)0, true);
    }

    @Override
    public void setDynamicValue(String string) {
        this.attrDynamicValue = string;
        this._setElement((byte)1, null != string);
    }

    @Override
    public void unsetWarnId() {
        this.attrWarnId = 0;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetDynamicValue() {
        this.attrDynamicValue = null;
        this._setElement((byte)1, false);
    }
}

