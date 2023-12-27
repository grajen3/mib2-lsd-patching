/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.StartGuidanceResultContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class StartGuidanceResultContainerImpl
extends AbstractContainer
implements StartGuidanceResultContainer {
    private static final byte ELEMENT_RESULT;
    private int attrResult;

    @Override
    public int getContainerId() {
        return 67;
    }

    @Override
    public boolean isValid() {
        return this.isResultSet();
    }

    @Override
    public int getResult() {
        return this.attrResult;
    }

    @Override
    public boolean isResultSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public void setResult(int n) {
        this.attrResult = n;
        this._setElement((byte)0, true);
    }

    @Override
    public void unsetResult() {
        this.attrResult = 0;
        this._setElement((byte)0, false);
    }
}

