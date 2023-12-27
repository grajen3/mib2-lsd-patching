/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import generated.de.vw.mib.has.containers.ListPageDataContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class ListPageDataContainerImpl
extends AbstractContainer
implements ListPageDataContainer {
    private static final byte ELEMENT_MOD_COUNT;
    private static final byte ELEMENT_OFFSET;
    private static final byte ELEMENT_PAGE_DATA;
    private int attrModCount;
    private int attrOffset;
    private HASContainer[] attrPageData;

    @Override
    public int getContainerId() {
        return 0x4000001;
    }

    @Override
    public boolean isValid() {
        return this.isModCountSet() && this.isOffsetSet();
    }

    @Override
    public int getModCount() {
        return this.attrModCount;
    }

    @Override
    public int getOffset() {
        return this.attrOffset;
    }

    @Override
    public HASContainer[] getPageData() {
        return this.attrPageData;
    }

    @Override
    public boolean isModCountSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isOffsetSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public boolean isPageDataSet() {
        return this._isElementSet((byte)2);
    }

    @Override
    public void setModCount(int n) {
        this.attrModCount = n;
        this._setElement((byte)0, true);
    }

    @Override
    public void setOffset(int n) {
        this.attrOffset = n;
        this._setElement((byte)1, true);
    }

    @Override
    public void setPageData(HASContainer[] hASContainerArray) {
        this.attrPageData = hASContainerArray;
        this._setElement((byte)2, null != hASContainerArray);
        if (null != hASContainerArray) {
            int n = hASContainerArray.length;
            while (--n >= 0) {
                if (null == hASContainerArray[n]) continue;
                hASContainerArray[n].setElementId(0xC000001);
            }
        }
    }

    @Override
    public void unsetModCount() {
        this.attrModCount = 0;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetOffset() {
        this.attrOffset = 0;
        this._setElement((byte)1, false);
    }

    @Override
    public void unsetPageData() {
        this.attrPageData = null;
        this._setElement((byte)2, false);
    }
}

