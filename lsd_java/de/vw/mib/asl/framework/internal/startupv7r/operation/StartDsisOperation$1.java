/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation;

import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListenerAdapter;
import de.vw.mib.asl.framework.internal.startupv7r.operation.StartDsisOperation;

class StartDsisOperation$1
extends DSIServiceStateListenerAdapter {
    private final /* synthetic */ StartDsisOperation this$0;

    StartDsisOperation$1(StartDsisOperation startDsisOperation) {
        this.this$0 = startDsisOperation;
    }

    @Override
    public void registered(String string, int n) {
        this.this$0.onDSIRegistration(string, n);
    }
}

