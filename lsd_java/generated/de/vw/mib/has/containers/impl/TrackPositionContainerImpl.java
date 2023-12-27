/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.TrackPositionContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class TrackPositionContainerImpl
extends AbstractContainer
implements TrackPositionContainer {
    private static final byte ELEMENT_POSITION;
    private int attrPosition;

    @Override
    public int getContainerId() {
        return 31;
    }

    @Override
    public boolean isValid() {
        return this.isPositionSet();
    }

    @Override
    public int getPosition() {
        return this.attrPosition;
    }

    @Override
    public boolean isPositionSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public void setPosition(int n) {
        this.attrPosition = n;
        this._setElement((byte)0, true);
    }

    @Override
    public void unsetPosition() {
        this.attrPosition = 0;
        this._setElement((byte)0, false);
    }
}

