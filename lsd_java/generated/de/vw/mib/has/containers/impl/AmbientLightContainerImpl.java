/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.AmbientLightContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class AmbientLightContainerImpl
extends AbstractContainer
implements AmbientLightContainer {
    private static final byte ELEMENT_COLOR_SRGB;
    private static final byte ELEMENT_COLOR_HMI;
    private String attrColorSRGB;
    private String attrColorHMI;

    @Override
    public int getContainerId() {
        return 68;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public String getColorSRGB() {
        return this.attrColorSRGB;
    }

    @Override
    public String getColorHMI() {
        return this.attrColorHMI;
    }

    @Override
    public boolean isColorSRGBSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isColorHMISet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public void setColorSRGB(String string) {
        this.attrColorSRGB = string;
        this._setElement((byte)0, null != string);
    }

    @Override
    public void setColorHMI(String string) {
        this.attrColorHMI = string;
        this._setElement((byte)1, null != string);
    }

    @Override
    public void unsetColorSRGB() {
        this.attrColorSRGB = null;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetColorHMI() {
        this.attrColorHMI = null;
        this._setElement((byte)1, false);
    }
}

