/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListWindowed;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayObjectId;

final class MediaBrowser$MediaBrowserObjectId
implements FsgArrayObjectId {
    private final long _entryId;
    private final int _contentType;
    private final int _index;

    public MediaBrowser$MediaBrowserObjectId(long l, int n, int n2) {
        this._entryId = l;
        this._contentType = n;
        this._index = n2;
    }

    boolean equalTo(long l, int n) {
        return this._entryId == l && this._contentType == n;
    }

    public boolean equals(Object object) {
        boolean bl;
        if (object != null && object != FsgArrayListWindowed.INVALID_OBJECT_ID) {
            MediaBrowser$MediaBrowserObjectId mediaBrowser$MediaBrowserObjectId = (MediaBrowser$MediaBrowserObjectId)object;
            bl = this.equalTo(mediaBrowser$MediaBrowserObjectId._entryId, mediaBrowser$MediaBrowserObjectId._contentType);
        } else {
            bl = false;
        }
        return bl;
    }

    public int hashCode() {
        return (int)this._entryId;
    }

    @Override
    public int getPosIndex() {
        return this._index;
    }

    @Override
    public long getEntryId() {
        return this._entryId;
    }

    @Override
    public int getInternalUserId() {
        return this._contentType;
    }
}

