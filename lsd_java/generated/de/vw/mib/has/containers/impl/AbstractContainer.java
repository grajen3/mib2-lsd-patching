/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;

abstract class AbstractContainer
implements HASContainer {
    private long _setElements;
    private int _elementId = -1;

    AbstractContainer() {
    }

    @Override
    public int getElementId() {
        return this._elementId;
    }

    @Override
    public void setElementId(int n) {
        this._elementId = n;
    }

    protected boolean _isElementSet(byte by) {
        return 0L != (this._setElements & 1L << by);
    }

    protected void _setElement(byte by, boolean bl) {
        long l = 1L << by;
        this._setElements = bl ? (this._setElements |= l) : (this._setElements &= l ^ 0xFFFFFFFFFFFFFFFFL);
    }
}

