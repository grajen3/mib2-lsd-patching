/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.ImportGPXResultContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class ImportGPXResultContainerImpl
extends AbstractContainer
implements ImportGPXResultContainer {
    private static final byte ELEMENT_NAME;
    private static final byte ELEMENT_RESULT;
    private String attrName;
    private int attrResult;

    @Override
    public int getContainerId() {
        return 60;
    }

    @Override
    public boolean isValid() {
        return this.isNameSet() && this.isResultSet();
    }

    @Override
    public String getName() {
        return this.attrName;
    }

    @Override
    public int getResult() {
        return this.attrResult;
    }

    @Override
    public boolean isNameSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isResultSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public void setName(String string) {
        this.attrName = string;
        this._setElement((byte)0, null != string);
    }

    @Override
    public void setResult(int n) {
        this.attrResult = n;
        this._setElement((byte)1, true);
    }

    @Override
    public void unsetName() {
        this.attrName = null;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetResult() {
        this.attrResult = 0;
        this._setElement((byte)1, false);
    }
}

