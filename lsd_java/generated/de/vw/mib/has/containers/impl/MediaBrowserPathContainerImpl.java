/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.MediaBrowserEntryContainer;
import generated.de.vw.mib.has.containers.MediaBrowserPathContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class MediaBrowserPathContainerImpl
extends AbstractContainer
implements MediaBrowserPathContainer {
    private static final byte ELEMENT_ENTRIES;
    private MediaBrowserEntryContainer[] attrEntries;

    @Override
    public int getContainerId() {
        return 50;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public MediaBrowserEntryContainer[] getEntries() {
        return this.attrEntries;
    }

    @Override
    public boolean isEntriesSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public void setEntries(MediaBrowserEntryContainer[] mediaBrowserEntryContainerArray) {
        this.attrEntries = mediaBrowserEntryContainerArray;
        this._setElement((byte)0, null != mediaBrowserEntryContainerArray);
        if (null != mediaBrowserEntryContainerArray) {
            int n = mediaBrowserEntryContainerArray.length;
            while (--n >= 0) {
                if (null == mediaBrowserEntryContainerArray[n]) continue;
                mediaBrowserEntryContainerArray[n].setElementId(110);
            }
        }
    }

    @Override
    public void unsetEntries() {
        this.attrEntries = null;
        this._setElement((byte)0, false);
    }
}

