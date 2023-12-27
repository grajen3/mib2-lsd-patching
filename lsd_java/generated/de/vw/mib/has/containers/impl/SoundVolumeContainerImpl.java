/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.SoundVolumeContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class SoundVolumeContainerImpl
extends AbstractContainer
implements SoundVolumeContainer {
    private static final byte ELEMENT_SOURCE;
    private static final byte ELEMENT_VOLUME;
    private static final byte ELEMENT_ENTERTAINMENT_MUTED;
    private int attrSource;
    private int attrVolume;
    private boolean attrEntertainmentMuted;

    @Override
    public int getContainerId() {
        return 27;
    }

    @Override
    public boolean isValid() {
        return this.isSourceSet() && this.isVolumeSet() && this.isEntertainmentMutedSet();
    }

    @Override
    public int getSource() {
        return this.attrSource;
    }

    @Override
    public int getVolume() {
        return this.attrVolume;
    }

    @Override
    public boolean getEntertainmentMuted() {
        return this.attrEntertainmentMuted;
    }

    @Override
    public boolean isSourceSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isVolumeSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public boolean isEntertainmentMutedSet() {
        return this._isElementSet((byte)2);
    }

    @Override
    public void setSource(int n) {
        this.attrSource = n;
        this._setElement((byte)0, true);
    }

    @Override
    public void setVolume(int n) {
        this.attrVolume = n;
        this._setElement((byte)1, true);
    }

    @Override
    public void setEntertainmentMuted(boolean bl) {
        this.attrEntertainmentMuted = bl;
        this._setElement((byte)2, true);
    }

    @Override
    public void unsetSource() {
        this.attrSource = 0;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetVolume() {
        this.attrVolume = 0;
        this._setElement((byte)1, false);
    }

    @Override
    public void unsetEntertainmentMuted() {
        this.attrEntertainmentMuted = false;
        this._setElement((byte)2, false);
    }
}

