/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system;

import de.vw.mib.asl.api.system.DoublePressKeyAdapter;

class DoublePressKeyAdapter$1
implements Runnable {
    private final /* synthetic */ int val$keyId;
    private final /* synthetic */ DoublePressKeyAdapter this$0;

    DoublePressKeyAdapter$1(DoublePressKeyAdapter doublePressKeyAdapter, int n) {
        this.this$0 = doublePressKeyAdapter;
        this.val$keyId = n;
    }

    @Override
    public void run() {
        this.this$0.onDoublePressTimeout(this.val$keyId);
    }
}

