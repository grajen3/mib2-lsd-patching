/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.services;

import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.CoreServiceImageHandler;

class CoreServiceImageHandler$1
implements Runnable {
    private final /* synthetic */ CoreServiceImageHandler this$0;

    CoreServiceImageHandler$1(CoreServiceImageHandler coreServiceImageHandler) {
        this.this$0 = coreServiceImageHandler;
    }

    @Override
    public void run() {
        this.this$0.fireCallback(null);
    }
}

