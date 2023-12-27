/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi;

import de.vw.mib.asi.ASIProperties;
import java.util.BitSet;

public class ASIPropertiesImpl
implements ASIProperties {
    private final BitSet attrs = new BitSet();
    private boolean allSet;

    @Override
    public void clearNotification() {
        this.attrs.clear();
        this.allSet = false;
    }

    @Override
    public void clearNotification(int n) {
        this.attrs.set(n, this.allSet);
    }

    @Override
    public void clearNotification(int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.attrs.set(nArray[i2], this.allSet);
        }
    }

    @Override
    public void setNotification() {
        this.attrs.clear();
        this.allSet = true;
    }

    @Override
    public void setNotification(int n) {
        this.attrs.set(n, !this.allSet);
    }

    @Override
    public void setNotification(int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.attrs.set(nArray[i2], !this.allSet);
        }
    }

    public boolean isSubscribed(int n) {
        return this.attrs.get(n) ^ this.allSet;
    }
}

