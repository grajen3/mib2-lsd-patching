/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.activators;

import de.vw.mib.asl.framework.internal.startupv7r.activators.ASLBasicActivator;
import de.vw.mib.datapool.ASLDatapool;

class ASLBasicActivator$1
implements Runnable {
    private final /* synthetic */ ASLDatapool val$dataPool;
    private final /* synthetic */ ASLBasicActivator this$0;

    ASLBasicActivator$1(ASLBasicActivator aSLBasicActivator, ASLDatapool aSLDatapool) {
        this.this$0 = aSLBasicActivator;
        this.val$dataPool = aSLDatapool;
    }

    @Override
    public void run() {
        this.this$0.datapoolManager.setDatapool(this.val$dataPool);
    }
}

