/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.MediaPlayInfoContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class MediaPlayInfoContainerImpl
extends AbstractContainer
implements MediaPlayInfoContainer {
    private static final byte ELEMENT_STATE;
    private static final byte ELEMENT_TRACK_POSITION;
    private static final byte ELEMENT_ENTRY_TYPE;
    private static final byte ELEMENT_ENTRY_ID;
    private int attrState;
    private int attrTrackPosition;
    private int attrEntryType;
    private long attrEntryId;

    @Override
    public int getContainerId() {
        return 23;
    }

    @Override
    public boolean isValid() {
        return this.isStateSet();
    }

    @Override
    public int getState() {
        return this.attrState;
    }

    @Override
    public int getTrackPosition() {
        return this.attrTrackPosition;
    }

    @Override
    public int getEntryType() {
        return this.attrEntryType;
    }

    @Override
    public long getEntryId() {
        return this.attrEntryId;
    }

    @Override
    public boolean isStateSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isTrackPositionSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public boolean isEntryTypeSet() {
        return this._isElementSet((byte)2);
    }

    @Override
    public boolean isEntryIdSet() {
        return this._isElementSet((byte)3);
    }

    @Override
    public void setState(int n) {
        this.attrState = n;
        this._setElement((byte)0, true);
    }

    @Override
    public void setTrackPosition(int n) {
        this.attrTrackPosition = n;
        this._setElement((byte)1, true);
    }

    @Override
    public void setEntryType(int n) {
        this.attrEntryType = n;
        this._setElement((byte)2, true);
    }

    @Override
    public void setEntryId(long l) {
        this.attrEntryId = l;
        this._setElement((byte)3, true);
    }

    @Override
    public void unsetState() {
        this.attrState = 0;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetTrackPosition() {
        this.attrTrackPosition = 0;
        this._setElement((byte)1, false);
    }

    @Override
    public void unsetEntryType() {
        this.attrEntryType = 0;
        this._setElement((byte)2, false);
    }

    @Override
    public void unsetEntryId() {
        this.attrEntryId = 0L;
        this._setElement((byte)3, false);
    }
}

