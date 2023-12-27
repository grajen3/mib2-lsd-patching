/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r;

import de.vw.mib.asl.framework.internal.startupv7r.AbstractTimedStartupTask;

class AbstractTimedStartupTask$1
implements Runnable {
    private final /* synthetic */ AbstractTimedStartupTask this$0;

    AbstractTimedStartupTask$1(AbstractTimedStartupTask abstractTimedStartupTask) {
        this.this$0 = abstractTimedStartupTask;
    }

    @Override
    public void run() {
        this.this$0.handleTimeout();
        this.this$0.finish();
    }
}

