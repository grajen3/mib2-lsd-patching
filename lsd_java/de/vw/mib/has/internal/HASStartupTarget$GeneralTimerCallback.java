/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.has.internal.HASStartupTarget;

class HASStartupTarget$GeneralTimerCallback
implements Runnable {
    private final /* synthetic */ HASStartupTarget this$0;

    HASStartupTarget$GeneralTimerCallback(HASStartupTarget hASStartupTarget) {
        this.this$0 = hASStartupTarget;
    }

    @Override
    public void run() {
        this.this$0.onGeneralTimer();
    }
}

