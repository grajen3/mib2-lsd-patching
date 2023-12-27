/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.impl;

import de.vw.mib.asl.clientapi.ASLClientAPIServiceInitData;
import de.vw.mib.asl.clientapi.ASLClientAPIStateListener;
import de.vw.mib.asl.clientapi.impl.ASLClientAPIBridge;

public abstract class ASLClientAPIBridge$ServiceInitDataBase
implements ASLClientAPIServiceInitData {
    private final /* synthetic */ ASLClientAPIBridge this$0;

    protected ASLClientAPIBridge$ServiceInitDataBase(ASLClientAPIBridge aSLClientAPIBridge) {
        this.this$0 = aSLClientAPIBridge;
    }

    @Override
    public ASLClientAPIStateListener getStateListener() {
        return this.this$0.getStateListener();
    }
}

