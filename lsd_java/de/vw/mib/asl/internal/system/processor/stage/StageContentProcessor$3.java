/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor.stage;

import de.vw.mib.asl.api.system.powerstate.PowerStateListener;
import de.vw.mib.asl.internal.system.processor.stage.StageContentProcessor;

class StageContentProcessor$3
implements PowerStateListener {
    private final /* synthetic */ StageContentProcessor this$0;

    StageContentProcessor$3(StageContentProcessor stageContentProcessor) {
        this.this$0 = stageContentProcessor;
    }

    @Override
    public void onNewPowerState(int n) {
        this.this$0.processNewPowerState(n);
    }
}

