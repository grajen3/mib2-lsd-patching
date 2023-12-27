/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.DisplayDimensionContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class DisplayDimensionContainerImpl
extends AbstractContainer
implements DisplayDimensionContainer {
    private static final byte ELEMENT_HORIZONTAL_RESOLUTION;
    private static final byte ELEMENT_VERTICAL_RESOLUTION;
    private int attrHorizontalResolution;
    private int attrVerticalResolution;

    @Override
    public int getContainerId() {
        return 13;
    }

    @Override
    public boolean isValid() {
        return this.isHorizontalResolutionSet() && this.isVerticalResolutionSet();
    }

    @Override
    public int getHorizontalResolution() {
        return this.attrHorizontalResolution;
    }

    @Override
    public int getVerticalResolution() {
        return this.attrVerticalResolution;
    }

    @Override
    public boolean isHorizontalResolutionSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isVerticalResolutionSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public void setHorizontalResolution(int n) {
        this.attrHorizontalResolution = n;
        this._setElement((byte)0, true);
    }

    @Override
    public void setVerticalResolution(int n) {
        this.attrVerticalResolution = n;
        this._setElement((byte)1, true);
    }

    @Override
    public void unsetHorizontalResolution() {
        this.attrHorizontalResolution = 0;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetVerticalResolution() {
        this.attrVerticalResolution = 0;
        this._setElement((byte)1, false);
    }
}

