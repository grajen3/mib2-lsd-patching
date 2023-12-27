/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.asl.framework.internal.lsc.AslTargetLscTNGBullhorn;

class AslTargetLscTNGBullhorn$1
implements Runnable {
    private final /* synthetic */ AslTargetLscTNGBullhorn this$0;

    AslTargetLscTNGBullhorn$1(AslTargetLscTNGBullhorn aslTargetLscTNGBullhorn) {
        this.this$0 = aslTargetLscTNGBullhorn;
    }

    @Override
    public void run() {
        this.this$0.doInitialLsc();
    }
}

