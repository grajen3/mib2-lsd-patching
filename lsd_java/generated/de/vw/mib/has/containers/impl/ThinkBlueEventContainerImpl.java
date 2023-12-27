/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.ThinkBlueEventContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class ThinkBlueEventContainerImpl
extends AbstractContainer
implements ThinkBlueEventContainer {
    private static final byte ELEMENT_DESCRIPTION;
    private static final byte ELEMENT_TIME_STAMP;
    private String attrDescription;
    private long attrTimeStamp;

    @Override
    public int getContainerId() {
        return 54;
    }

    @Override
    public boolean isValid() {
        return this.isDescriptionSet();
    }

    @Override
    public String getDescription() {
        return this.attrDescription;
    }

    @Override
    public long getTimeStamp() {
        return this.attrTimeStamp;
    }

    @Override
    public boolean isDescriptionSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isTimeStampSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public void setDescription(String string) {
        this.attrDescription = string;
        this._setElement((byte)0, null != string);
    }

    @Override
    public void setTimeStamp(long l) {
        this.attrTimeStamp = l;
        this._setElement((byte)1, true);
    }

    @Override
    public void unsetDescription() {
        this.attrDescription = null;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetTimeStamp() {
        this.attrTimeStamp = 0L;
        this._setElement((byte)1, false);
    }
}

