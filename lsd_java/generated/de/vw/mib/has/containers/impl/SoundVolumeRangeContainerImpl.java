/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.SoundVolumeRangeContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class SoundVolumeRangeContainerImpl
extends AbstractContainer
implements SoundVolumeRangeContainer {
    private static final byte ELEMENT_SOURCE;
    private static final byte ELEMENT_MIN_VOLUME;
    private static final byte ELEMENT_MAX_VOLUME;
    private int attrSource;
    private int attrMinVolume;
    private int attrMaxVolume;

    @Override
    public int getContainerId() {
        return 28;
    }

    @Override
    public boolean isValid() {
        return this.isSourceSet() && this.isMinVolumeSet() && this.isMaxVolumeSet();
    }

    @Override
    public int getSource() {
        return this.attrSource;
    }

    @Override
    public int getMinVolume() {
        return this.attrMinVolume;
    }

    @Override
    public int getMaxVolume() {
        return this.attrMaxVolume;
    }

    @Override
    public boolean isSourceSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isMinVolumeSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public boolean isMaxVolumeSet() {
        return this._isElementSet((byte)2);
    }

    @Override
    public void setSource(int n) {
        this.attrSource = n;
        this._setElement((byte)0, true);
    }

    @Override
    public void setMinVolume(int n) {
        this.attrMinVolume = n;
        this._setElement((byte)1, true);
    }

    @Override
    public void setMaxVolume(int n) {
        this.attrMaxVolume = n;
        this._setElement((byte)2, true);
    }

    @Override
    public void unsetSource() {
        this.attrSource = 0;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetMinVolume() {
        this.attrMinVolume = 0;
        this._setElement((byte)1, false);
    }

    @Override
    public void unsetMaxVolume() {
        this.attrMaxVolume = 0;
        this._setElement((byte)2, false);
    }
}

