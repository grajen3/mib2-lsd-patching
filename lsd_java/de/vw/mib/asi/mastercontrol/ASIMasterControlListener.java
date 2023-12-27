/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.mastercontrol;

import de.vw.mib.asi.ASIListener;

public interface ASIMasterControlListener
extends ASIListener {
    default public void updateBlockState(int n, boolean bl) {
    }

    default public void updateHUVersion(String string, boolean bl) {
    }

    default public void updateLockState(int n, boolean bl) {
    }

    default public void updateVIN(String string, boolean bl) {
    }
}

