/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor.stage;

import de.vw.mib.asl.framework.api.persistence2.GlobalProfileChangeListener;
import de.vw.mib.asl.internal.system.processor.stage.StageContentProcessor;

class StageContentProcessor$1
implements GlobalProfileChangeListener {
    private final /* synthetic */ StageContentProcessor this$0;

    StageContentProcessor$1(StageContentProcessor stageContentProcessor) {
        this.this$0 = stageContentProcessor;
    }

    @Override
    public void onProfileChangeStarted() {
    }

    @Override
    public void onProfileChangeCompleted() {
        this.this$0.onProfileChangeCompleted();
    }
}

