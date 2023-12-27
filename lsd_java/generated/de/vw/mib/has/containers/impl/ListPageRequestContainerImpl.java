/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.ListPageRequestContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class ListPageRequestContainerImpl
extends AbstractContainer
implements ListPageRequestContainer {
    private static final byte ELEMENT_OFFSET;
    private int attrOffset;

    @Override
    public int getContainerId() {
        return 0x3000001;
    }

    @Override
    public boolean isValid() {
        return this.isOffsetSet();
    }

    @Override
    public int getOffset() {
        return this.attrOffset;
    }

    @Override
    public boolean isOffsetSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public void setOffset(int n) {
        this.attrOffset = n;
        this._setElement((byte)0, true);
    }

    @Override
    public void unsetOffset() {
        this.attrOffset = 0;
        this._setElement((byte)0, false);
    }
}

