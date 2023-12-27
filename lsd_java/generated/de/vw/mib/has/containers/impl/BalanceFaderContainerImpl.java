/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.BalanceFaderContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class BalanceFaderContainerImpl
extends AbstractContainer
implements BalanceFaderContainer {
    private static final byte ELEMENT_BALANCE;
    private static final byte ELEMENT_FADER;
    private int attrBalance;
    private int attrFader;

    @Override
    public int getContainerId() {
        return 48;
    }

    @Override
    public boolean isValid() {
        return this.isBalanceSet() && this.isFaderSet();
    }

    @Override
    public int getBalance() {
        return this.attrBalance;
    }

    @Override
    public int getFader() {
        return this.attrFader;
    }

    @Override
    public boolean isBalanceSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isFaderSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public void setBalance(int n) {
        this.attrBalance = n;
        this._setElement((byte)0, true);
    }

    @Override
    public void setFader(int n) {
        this.attrFader = n;
        this._setElement((byte)1, true);
    }

    @Override
    public void unsetBalance() {
        this.attrBalance = 0;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetFader() {
        this.attrFader = 0;
        this._setElement((byte)1, false);
    }
}

