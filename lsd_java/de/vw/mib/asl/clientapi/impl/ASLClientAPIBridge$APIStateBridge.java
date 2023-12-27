/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.impl;

import de.vw.mib.asl.clientapi.ASLClientAPIStateListener;
import de.vw.mib.asl.clientapi.impl.ASLClientAPIBridge;

public class ASLClientAPIBridge$APIStateBridge
implements ASLClientAPIStateListener {
    private boolean initialPhase;
    private final /* synthetic */ ASLClientAPIBridge this$0;

    protected ASLClientAPIBridge$APIStateBridge(ASLClientAPIBridge aSLClientAPIBridge) {
        this.this$0 = aSLClientAPIBridge;
    }

    protected void init() {
        this.initialPhase = true;
        this.this$0.updateAPIState(0);
    }

    protected void ready() {
        if (this.initialPhase) {
            this.initialPhase = false;
            this.this$0.updateAPIState(1);
        }
    }

    @Override
    public void updateAPIState(int n) {
        if (this.initialPhase && n != 1) {
            this.this$0.updateAPIState(1);
        }
        this.initialPhase = false;
        this.this$0.updateAPIState(n);
    }
}

