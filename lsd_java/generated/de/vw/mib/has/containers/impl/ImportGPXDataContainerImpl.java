/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.ImportGPXDataContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;
import org.dsi.ifc.global.ResourceLocator;

public class ImportGPXDataContainerImpl
extends AbstractContainer
implements ImportGPXDataContainer {
    private static final byte ELEMENT_RESOURCE;
    private static final byte ELEMENT_NAME;
    private static final byte ELEMENT_TYPE;
    private ResourceLocator attrResource;
    private String attrName;
    private int attrType;

    @Override
    public int getContainerId() {
        return 59;
    }

    @Override
    public boolean isValid() {
        return this.isResourceSet() && this.isNameSet() && this.isTypeSet();
    }

    @Override
    public ResourceLocator getResource() {
        return this.attrResource;
    }

    @Override
    public String getName() {
        return this.attrName;
    }

    @Override
    public int getType() {
        return this.attrType;
    }

    @Override
    public boolean isResourceSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isNameSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public boolean isTypeSet() {
        return this._isElementSet((byte)2);
    }

    @Override
    public void setResource(ResourceLocator resourceLocator) {
        this.attrResource = resourceLocator;
        this._setElement((byte)0, null != resourceLocator);
    }

    @Override
    public void setName(String string) {
        this.attrName = string;
        this._setElement((byte)1, null != string);
    }

    @Override
    public void setType(int n) {
        this.attrType = n;
        this._setElement((byte)2, true);
    }

    @Override
    public void unsetResource() {
        this.attrResource = null;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetName() {
        this.attrName = null;
        this._setElement((byte)1, false);
    }

    @Override
    public void unsetType() {
        this.attrType = 0;
        this._setElement((byte)2, false);
    }
}

