/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.MediaSourceContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class MediaSourceContainerImpl
extends AbstractContainer
implements MediaSourceContainer {
    private static final byte ELEMENT_SOURCE;
    private int attrSource;

    @Override
    public int getContainerId() {
        return 34;
    }

    @Override
    public boolean isValid() {
        return this.isSourceSet();
    }

    @Override
    public int getSource() {
        return this.attrSource;
    }

    @Override
    public boolean isSourceSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public void setSource(int n) {
        this.attrSource = n;
        this._setElement((byte)0, true);
    }

    @Override
    public void unsetSource() {
        this.attrSource = 0;
        this._setElement((byte)0, false);
    }
}

