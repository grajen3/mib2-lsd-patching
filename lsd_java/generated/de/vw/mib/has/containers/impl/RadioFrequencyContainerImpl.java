/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.RadioFrequencyContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class RadioFrequencyContainerImpl
extends AbstractContainer
implements RadioFrequencyContainer {
    private static final byte ELEMENT_BAND;
    private static final byte ELEMENT_FREQUENCY;
    private static final byte ELEMENT_FREQUENCY_LABEL;
    private int attrBand;
    private long attrFrequency;
    private String attrFrequencyLabel;

    @Override
    public int getContainerId() {
        return 43;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public int getBand() {
        return this.attrBand;
    }

    @Override
    public long getFrequency() {
        return this.attrFrequency;
    }

    @Override
    public String getFrequencyLabel() {
        return this.attrFrequencyLabel;
    }

    @Override
    public boolean isBandSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isFrequencySet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public boolean isFrequencyLabelSet() {
        return this._isElementSet((byte)2);
    }

    @Override
    public void setBand(int n) {
        this.attrBand = n;
        this._setElement((byte)0, true);
    }

    @Override
    public void setFrequency(long l) {
        this.attrFrequency = l;
        this._setElement((byte)1, true);
    }

    @Override
    public void setFrequencyLabel(String string) {
        this.attrFrequencyLabel = string;
        this._setElement((byte)2, null != string);
    }

    @Override
    public void unsetBand() {
        this.attrBand = 0;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetFrequency() {
        this.attrFrequency = 0L;
        this._setElement((byte)1, false);
    }

    @Override
    public void unsetFrequencyLabel() {
        this.attrFrequencyLabel = null;
        this._setElement((byte)2, false);
    }
}

