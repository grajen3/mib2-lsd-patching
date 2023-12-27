/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.MediaPlayModeContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class MediaPlayModeContainerImpl
extends AbstractContainer
implements MediaPlayModeContainer {
    private static final byte ELEMENT_REPEAT_MODE;
    private static final byte ELEMENT_MIX_MODE;
    private static final byte ELEMENT_PMLT_MODE;
    private int attrRepeatMode;
    private boolean attrMixMode;
    private boolean attrPMLTMode;

    @Override
    public int getContainerId() {
        return 24;
    }

    @Override
    public boolean isValid() {
        return this.isRepeatModeSet() && this.isMixModeSet() && this.isPMLTModeSet();
    }

    @Override
    public int getRepeatMode() {
        return this.attrRepeatMode;
    }

    @Override
    public boolean getMixMode() {
        return this.attrMixMode;
    }

    @Override
    public boolean getPMLTMode() {
        return this.attrPMLTMode;
    }

    @Override
    public boolean isRepeatModeSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isMixModeSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public boolean isPMLTModeSet() {
        return this._isElementSet((byte)2);
    }

    @Override
    public void setRepeatMode(int n) {
        this.attrRepeatMode = n;
        this._setElement((byte)0, true);
    }

    @Override
    public void setMixMode(boolean bl) {
        this.attrMixMode = bl;
        this._setElement((byte)1, true);
    }

    @Override
    public void setPMLTMode(boolean bl) {
        this.attrPMLTMode = bl;
        this._setElement((byte)2, true);
    }

    @Override
    public void unsetRepeatMode() {
        this.attrRepeatMode = 0;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetMixMode() {
        this.attrMixMode = false;
        this._setElement((byte)1, false);
    }

    @Override
    public void unsetPMLTMode() {
        this.attrPMLTMode = false;
        this._setElement((byte)2, false);
    }
}

