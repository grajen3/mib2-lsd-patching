/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel.lock;

public class KeyState {
    private final int keyPressState;
    private final boolean keyLockState;

    public KeyState(int n, boolean bl) {
        this.keyPressState = n;
        this.keyLockState = bl;
    }

    public int getKeyPressState() {
        return this.keyPressState;
    }

    public boolean islocked() {
        return this.keyLockState;
    }
}

