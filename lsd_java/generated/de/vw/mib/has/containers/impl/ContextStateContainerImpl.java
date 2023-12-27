/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.ContextStateContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class ContextStateContainerImpl
extends AbstractContainer
implements ContextStateContainer {
    private static final byte ELEMENT_CONTEXT;
    private static final byte ELEMENT_STATE;
    private String attrContext;
    private int attrState;

    @Override
    public int getContainerId() {
        return 1;
    }

    @Override
    public boolean isValid() {
        return this.isContextSet() && this.isStateSet();
    }

    @Override
    public String getContext() {
        return this.attrContext;
    }

    @Override
    public int getState() {
        return this.attrState;
    }

    @Override
    public boolean isContextSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isStateSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public void setContext(String string) {
        this.attrContext = string;
        this._setElement((byte)0, null != string);
    }

    @Override
    public void setState(int n) {
        this.attrState = n;
        this._setElement((byte)1, true);
    }

    @Override
    public void unsetContext() {
        this.attrContext = null;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetState() {
        this.attrState = 0;
        this._setElement((byte)1, false);
    }
}

