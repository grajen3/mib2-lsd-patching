/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.common;

import de.vw.mib.asl.internal.media.common.AbstractComponent;

class AbstractComponent$1
implements Runnable {
    private final /* synthetic */ AbstractComponent this$0;

    AbstractComponent$1(AbstractComponent abstractComponent) {
        this.this$0 = abstractComponent;
    }

    @Override
    public void run() {
        if (this.this$0.isRegisteredForResponse(AbstractComponent.access$000(this.this$0))) {
            this.this$0.fireResponse(true, "request timeout");
        }
    }
}

