/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.BalanceFaderRangesContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class BalanceFaderRangesContainerImpl
extends AbstractContainer
implements BalanceFaderRangesContainer {
    private static final byte ELEMENT_BALANCE_LEFT;
    private static final byte ELEMENT_BALANCE_RIGHT;
    private static final byte ELEMENT_FADER_REAR;
    private static final byte ELEMENT_FADER_FRONT;
    private int attrBalanceLeft;
    private int attrBalanceRight;
    private int attrFaderRear;
    private int attrFaderFront;

    @Override
    public int getContainerId() {
        return 49;
    }

    @Override
    public boolean isValid() {
        return this.isBalanceLeftSet() && this.isBalanceRightSet() && this.isFaderRearSet() && this.isFaderFrontSet();
    }

    @Override
    public int getBalanceLeft() {
        return this.attrBalanceLeft;
    }

    @Override
    public int getBalanceRight() {
        return this.attrBalanceRight;
    }

    @Override
    public int getFaderRear() {
        return this.attrFaderRear;
    }

    @Override
    public int getFaderFront() {
        return this.attrFaderFront;
    }

    @Override
    public boolean isBalanceLeftSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isBalanceRightSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public boolean isFaderRearSet() {
        return this._isElementSet((byte)2);
    }

    @Override
    public boolean isFaderFrontSet() {
        return this._isElementSet((byte)3);
    }

    @Override
    public void setBalanceLeft(int n) {
        this.attrBalanceLeft = n;
        this._setElement((byte)0, true);
    }

    @Override
    public void setBalanceRight(int n) {
        this.attrBalanceRight = n;
        this._setElement((byte)1, true);
    }

    @Override
    public void setFaderRear(int n) {
        this.attrFaderRear = n;
        this._setElement((byte)2, true);
    }

    @Override
    public void setFaderFront(int n) {
        this.attrFaderFront = n;
        this._setElement((byte)3, true);
    }

    @Override
    public void unsetBalanceLeft() {
        this.attrBalanceLeft = 0;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetBalanceRight() {
        this.attrBalanceRight = 0;
        this._setElement((byte)1, false);
    }

    @Override
    public void unsetFaderRear() {
        this.attrFaderRear = 0;
        this._setElement((byte)2, false);
    }

    @Override
    public void unsetFaderFront() {
        this.attrFaderFront = 0;
        this._setElement((byte)3, false);
    }
}

