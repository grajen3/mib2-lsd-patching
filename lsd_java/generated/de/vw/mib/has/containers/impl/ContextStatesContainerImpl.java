/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.ContextStateContainer;
import generated.de.vw.mib.has.containers.ContextStatesContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class ContextStatesContainerImpl
extends AbstractContainer
implements ContextStatesContainer {
    private static final byte ELEMENT_STATES;
    private ContextStateContainer[] attrStates;

    @Override
    public int getContainerId() {
        return 0x1000001;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public ContextStateContainer[] getStates() {
        return this.attrStates;
    }

    @Override
    public boolean isStatesSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public void setStates(ContextStateContainer[] contextStateContainerArray) {
        this.attrStates = contextStateContainerArray;
        this._setElement((byte)0, null != contextStateContainerArray);
        if (null != contextStateContainerArray) {
            int n = contextStateContainerArray.length;
            while (--n >= 0) {
                if (null == contextStateContainerArray[n]) continue;
                contextStateContainerArray[n].setElementId(0x2000001);
            }
        }
    }

    @Override
    public void unsetStates() {
        this.attrStates = null;
        this._setElement((byte)0, false);
    }
}

