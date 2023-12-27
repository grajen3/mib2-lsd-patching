/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.dynamic;

import de.vw.mib.asl.framework.api.startupv7r.dynamic.DynamicWorkUnitStarterCallback;
import de.vw.mib.asl.framework.internal.startupv7r.dynamic.DynamicWorkUnitStarterImpl;

class DynamicWorkUnitStarterImpl$1
implements Runnable {
    private final /* synthetic */ DynamicWorkUnitStarterCallback val$callback;
    private final /* synthetic */ DynamicWorkUnitStarterImpl this$0;

    DynamicWorkUnitStarterImpl$1(DynamicWorkUnitStarterImpl dynamicWorkUnitStarterImpl, DynamicWorkUnitStarterCallback dynamicWorkUnitStarterCallback) {
        this.this$0 = dynamicWorkUnitStarterImpl;
        this.val$callback = dynamicWorkUnitStarterCallback;
    }

    @Override
    public void run() {
        this.val$callback.onFinish();
    }
}

