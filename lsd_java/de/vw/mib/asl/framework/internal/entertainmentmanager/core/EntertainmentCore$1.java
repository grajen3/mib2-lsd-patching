/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager.core;

import de.vw.mib.asl.framework.internal.entertainmentmanager.core.EntertainmentCore;

class EntertainmentCore$1
implements Runnable {
    private final /* synthetic */ EntertainmentCore this$0;

    EntertainmentCore$1(EntertainmentCore entertainmentCore) {
        this.this$0 = entertainmentCore;
    }

    @Override
    public void run() {
        EntertainmentCore.access$000(this.this$0).stop();
        if (EntertainmentCore.access$100(this.this$0).isTraceEnabled()) {
            EntertainmentCore.access$100(this.this$0).trace().append("got deactivateCallback ").log();
        }
        EntertainmentCore.access$202(this.this$0, false);
        EntertainmentCore.access$300(this.this$0);
    }
}

