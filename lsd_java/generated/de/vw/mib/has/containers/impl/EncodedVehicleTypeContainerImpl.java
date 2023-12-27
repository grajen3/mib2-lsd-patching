/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.EncodedVehicleTypeContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class EncodedVehicleTypeContainerImpl
extends AbstractContainer
implements EncodedVehicleTypeContainer {
    private static final byte ELEMENT_TYPE;
    private static final byte ELEMENT_STICKER_BITS;
    private String attrType;
    private int attrStickerBits;

    @Override
    public int getContainerId() {
        return 53;
    }

    @Override
    public boolean isValid() {
        return this.isTypeSet();
    }

    @Override
    public String getType() {
        return this.attrType;
    }

    @Override
    public int getStickerBits() {
        return this.attrStickerBits;
    }

    @Override
    public boolean isTypeSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isStickerBitsSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public void setType(String string) {
        this.attrType = string;
        this._setElement((byte)0, null != string);
    }

    @Override
    public void setStickerBits(int n) {
        this.attrStickerBits = n;
        this._setElement((byte)1, true);
    }

    @Override
    public void unsetType() {
        this.attrType = null;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetStickerBits() {
        this.attrStickerBits = 0;
        this._setElement((byte)1, false);
    }
}

