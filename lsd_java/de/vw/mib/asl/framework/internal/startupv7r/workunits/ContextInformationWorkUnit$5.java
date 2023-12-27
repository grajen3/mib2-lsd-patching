/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.workunits;

import de.vw.mib.asl.framework.internal.startupv7r.workunits.ContextInformationWorkUnit;

class ContextInformationWorkUnit$5
implements Runnable {
    private final /* synthetic */ ContextInformationWorkUnit this$0;

    ContextInformationWorkUnit$5(ContextInformationWorkUnit contextInformationWorkUnit) {
        this.this$0 = contextInformationWorkUnit;
    }

    @Override
    public void run() {
        this.this$0.doNextWorkStepAfterDSICallback();
    }
}

