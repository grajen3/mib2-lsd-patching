/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.asl.framework.internal.lsc.AslTargetLscTNGBullhorn;
import de.vw.mib.asl.framework.internal.lsc.OsgiServices$ServiceConsumer;
import de.vw.mib.lsctng.LscController;

class AslTargetLscTNGBullhorn$3
implements OsgiServices$ServiceConsumer {
    private final /* synthetic */ AslTargetLscTNGBullhorn this$0;

    AslTargetLscTNGBullhorn$3(AslTargetLscTNGBullhorn aslTargetLscTNGBullhorn) {
        this.this$0 = aslTargetLscTNGBullhorn;
    }

    @Override
    public void onServiceAvailable(Object object) {
        LscController lscController = (LscController)object;
        this.this$0.injectDelegatingLscController(lscController);
        AslTargetLscTNGBullhorn.access$100(this.this$0).markLscControllerIsInitialized();
    }
}

