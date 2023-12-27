/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.SoundVolumeRangeContainer;
import generated.de.vw.mib.has.containers.SoundVolumeRangesContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class SoundVolumeRangesContainerImpl
extends AbstractContainer
implements SoundVolumeRangesContainer {
    private static final byte ELEMENT_VOLUME_RANGES;
    private SoundVolumeRangeContainer[] attrVolumeRanges;

    @Override
    public int getContainerId() {
        return 29;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public SoundVolumeRangeContainer[] getVolumeRanges() {
        return this.attrVolumeRanges;
    }

    @Override
    public boolean isVolumeRangesSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public void setVolumeRanges(SoundVolumeRangeContainer[] soundVolumeRangeContainerArray) {
        this.attrVolumeRanges = soundVolumeRangeContainerArray;
        this._setElement((byte)0, null != soundVolumeRangeContainerArray);
        if (null != soundVolumeRangeContainerArray) {
            int n = soundVolumeRangeContainerArray.length;
            while (--n >= 0) {
                if (null == soundVolumeRangeContainerArray[n]) continue;
                soundVolumeRangeContainerArray[n].setElementId(62);
            }
        }
    }

    @Override
    public void unsetVolumeRanges() {
        this.attrVolumeRanges = null;
        this._setElement((byte)0, false);
    }
}

