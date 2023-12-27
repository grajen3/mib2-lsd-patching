/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor.stage;

import de.vw.mib.asl.framework.api.persistence2.AbstractProfileChangeHandler;
import de.vw.mib.asl.internal.system.processor.stage.StageContentProcessor;

class StageContentProcessor$2
extends AbstractProfileChangeHandler {
    private final /* synthetic */ StageContentProcessor this$0;

    StageContentProcessor$2(StageContentProcessor stageContentProcessor) {
        this.this$0 = stageContentProcessor;
    }

    @Override
    protected void prepareForProfileChange() {
        this.notifyReadyForProfileSwitch();
    }

    @Override
    protected void changeProfile() {
        this.this$0.loadPersistence();
        this.notifyProfileChanged(true);
    }
}

