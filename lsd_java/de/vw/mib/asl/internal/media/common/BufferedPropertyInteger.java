/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.common;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public final class BufferedPropertyInteger {
    private final int listenerConstant;
    private int value = -1;

    public BufferedPropertyInteger(int n) {
        this.listenerConstant = n;
    }

    public void set(int n) {
        if (this.value != n) {
            this.value = n;
            this.submit();
        }
    }

    public void force(int n) {
        this.value = n;
        this.submit();
    }

    private void submit() {
        ServiceManager.aslPropertyManager.valueChangedInteger(this.listenerConstant, this.value);
    }
}

