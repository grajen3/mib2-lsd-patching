/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.MediaSourceStateContainer;
import generated.de.vw.mib.has.containers.MediaSourcesContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class MediaSourcesContainerImpl
extends AbstractContainer
implements MediaSourcesContainer {
    private static final byte ELEMENT_SOURCES;
    private MediaSourceStateContainer[] attrSources;

    @Override
    public int getContainerId() {
        return 33;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public MediaSourceStateContainer[] getSources() {
        return this.attrSources;
    }

    @Override
    public boolean isSourcesSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public void setSources(MediaSourceStateContainer[] mediaSourceStateContainerArray) {
        this.attrSources = mediaSourceStateContainerArray;
        this._setElement((byte)0, null != mediaSourceStateContainerArray);
        if (null != mediaSourceStateContainerArray) {
            int n = mediaSourceStateContainerArray.length;
            while (--n >= 0) {
                if (null == mediaSourceStateContainerArray[n]) continue;
                mediaSourceStateContainerArray[n].setElementId(71);
            }
        }
    }

    @Override
    public void unsetSources() {
        this.attrSources = null;
        this._setElement((byte)0, false);
    }
}

