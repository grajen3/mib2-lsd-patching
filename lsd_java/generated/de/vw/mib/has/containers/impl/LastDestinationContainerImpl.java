/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.LastDestinationContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class LastDestinationContainerImpl
extends AbstractContainer
implements LastDestinationContainer {
    private static final byte ELEMENT_DESCRIPTOR;
    private static final byte ELEMENT_ID;
    private String attrDescriptor;
    private int attrId;

    @Override
    public int getContainerId() {
        return 36;
    }

    @Override
    public boolean isValid() {
        return this.isDescriptorSet() && this.isIdSet();
    }

    @Override
    public String getDescriptor() {
        return this.attrDescriptor;
    }

    @Override
    public int getId() {
        return this.attrId;
    }

    @Override
    public boolean isDescriptorSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isIdSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public void setDescriptor(String string) {
        this.attrDescriptor = string;
        this._setElement((byte)0, null != string);
    }

    @Override
    public void setId(int n) {
        this.attrId = n;
        this._setElement((byte)1, true);
    }

    @Override
    public void unsetDescriptor() {
        this.attrDescriptor = null;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetId() {
        this.attrId = 0;
        this._setElement((byte)1, false);
    }
}

