/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.ListStateContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class ListStateContainerImpl
extends AbstractContainer
implements ListStateContainer {
    private static final byte ELEMENT_PAGE_SIZE;
    private static final byte ELEMENT_LIST_SIZE;
    private static final byte ELEMENT_MOD_COUNT;
    private static final byte ELEMENT_STATE;
    private int attrPageSize;
    private int attrListSize;
    private int attrModCount;
    private int attrState;

    @Override
    public int getContainerId() {
        return 0x2000001;
    }

    @Override
    public boolean isValid() {
        return this.isPageSizeSet() && this.isListSizeSet() && this.isModCountSet() && this.isStateSet();
    }

    @Override
    public int getPageSize() {
        return this.attrPageSize;
    }

    @Override
    public int getListSize() {
        return this.attrListSize;
    }

    @Override
    public int getModCount() {
        return this.attrModCount;
    }

    @Override
    public int getState() {
        return this.attrState;
    }

    @Override
    public boolean isPageSizeSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isListSizeSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public boolean isModCountSet() {
        return this._isElementSet((byte)2);
    }

    @Override
    public boolean isStateSet() {
        return this._isElementSet((byte)3);
    }

    @Override
    public void setPageSize(int n) {
        this.attrPageSize = n;
        this._setElement((byte)0, true);
    }

    @Override
    public void setListSize(int n) {
        this.attrListSize = n;
        this._setElement((byte)1, true);
    }

    @Override
    public void setModCount(int n) {
        this.attrModCount = n;
        this._setElement((byte)2, true);
    }

    @Override
    public void setState(int n) {
        this.attrState = n;
        this._setElement((byte)3, true);
    }

    @Override
    public void unsetPageSize() {
        this.attrPageSize = 0;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetListSize() {
        this.attrListSize = 0;
        this._setElement((byte)1, false);
    }

    @Override
    public void unsetModCount() {
        this.attrModCount = 0;
        this._setElement((byte)2, false);
    }

    @Override
    public void unsetState() {
        this.attrState = 0;
        this._setElement((byte)3, false);
    }
}

