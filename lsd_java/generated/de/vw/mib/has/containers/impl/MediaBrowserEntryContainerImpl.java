/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.MediaBrowserEntryContainer;
import generated.de.vw.mib.has.containers.TrackInfoContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class MediaBrowserEntryContainerImpl
extends AbstractContainer
implements MediaBrowserEntryContainer {
    private static final byte ELEMENT_DISPLAY_TEXT;
    private static final byte ELEMENT_ENTRY_TYPE;
    private static final byte ELEMENT_ENTRY_ID;
    private static final byte ELEMENT_TRACK_INFO;
    private static final byte ELEMENT_FILENAME;
    private static final byte ELEMENT_NOT_PLAYABLE_REASON;
    private String attrDisplayText;
    private int attrEntryType;
    private long attrEntryId;
    private TrackInfoContainer attrTrackInfo;
    private String attrFilename;
    private int attrNotPlayableReason;

    @Override
    public int getContainerId() {
        return 21;
    }

    @Override
    public boolean isValid() {
        return this.isDisplayTextSet() && this.isEntryTypeSet() && this.isEntryIdSet();
    }

    @Override
    public String getDisplayText() {
        return this.attrDisplayText;
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
    public TrackInfoContainer getTrackInfo() {
        return this.attrTrackInfo;
    }

    @Override
    public String getFilename() {
        return this.attrFilename;
    }

    @Override
    public int getNotPlayableReason() {
        return this.attrNotPlayableReason;
    }

    @Override
    public boolean isDisplayTextSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isEntryTypeSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public boolean isEntryIdSet() {
        return this._isElementSet((byte)2);
    }

    @Override
    public boolean isTrackInfoSet() {
        return this._isElementSet((byte)3);
    }

    @Override
    public boolean isFilenameSet() {
        return this._isElementSet((byte)4);
    }

    @Override
    public boolean isNotPlayableReasonSet() {
        return this._isElementSet((byte)5);
    }

    @Override
    public void setDisplayText(String string) {
        this.attrDisplayText = string;
        this._setElement((byte)0, null != string);
    }

    @Override
    public void setEntryType(int n) {
        this.attrEntryType = n;
        this._setElement((byte)1, true);
    }

    @Override
    public void setEntryId(long l) {
        this.attrEntryId = l;
        this._setElement((byte)2, true);
    }

    @Override
    public void setFilename(String string) {
        this.attrFilename = string;
        this._setElement((byte)4, null != string);
    }

    @Override
    public void setNotPlayableReason(int n) {
        this.attrNotPlayableReason = n;
        this._setElement((byte)5, true);
    }

    @Override
    public void setTrackInfo(TrackInfoContainer trackInfoContainer) {
        this.attrTrackInfo = trackInfoContainer;
        this._setElement((byte)3, null != trackInfoContainer);
        if (null != trackInfoContainer) {
            trackInfoContainer.setElementId(38);
        }
    }

    @Override
    public void unsetDisplayText() {
        this.attrDisplayText = null;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetEntryType() {
        this.attrEntryType = 0;
        this._setElement((byte)1, false);
    }

    @Override
    public void unsetEntryId() {
        this.attrEntryId = 0L;
        this._setElement((byte)2, false);
    }

    @Override
    public void unsetTrackInfo() {
        this.attrTrackInfo = null;
        this._setElement((byte)3, false);
    }

    @Override
    public void unsetFilename() {
        this.attrFilename = null;
        this._setElement((byte)4, false);
    }

    @Override
    public void unsetNotPlayableReason() {
        this.attrNotPlayableReason = 0;
        this._setElement((byte)5, false);
    }
}

