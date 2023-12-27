/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.services;

import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.CoreServiceStatusHandling;

class CoreServiceStatusHandling$1
implements Runnable {
    private final /* synthetic */ CoreServiceStatusHandling this$0;

    CoreServiceStatusHandling$1(CoreServiceStatusHandling coreServiceStatusHandling) {
        this.this$0 = coreServiceStatusHandling;
    }

    @Override
    public void run() {
        this.this$0.sendStatus();
    }
}

