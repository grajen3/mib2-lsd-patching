/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.services;

import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.CoreServiceUrlHandler;

class CoreServiceUrlHandler$4
implements Runnable {
    private final /* synthetic */ CoreServiceUrlHandler this$0;

    CoreServiceUrlHandler$4(CoreServiceUrlHandler coreServiceUrlHandler) {
        this.this$0 = coreServiceUrlHandler;
    }

    @Override
    public void run() {
        this.this$0.sendbackUrlInfo();
    }
}

