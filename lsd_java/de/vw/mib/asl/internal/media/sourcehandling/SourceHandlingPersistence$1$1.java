/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling;

import de.vw.mib.asl.framework.api.persistence2.dsi.DsiAwareProfileChangeListenerCallback;
import de.vw.mib.asl.internal.media.controller.commands.CommandCallback;
import de.vw.mib.asl.internal.media.controller.commands.CommandState;
import de.vw.mib.asl.internal.media.sourcehandling.SourceHandlingPersistence$1;

class SourceHandlingPersistence$1$1
implements CommandCallback {
    private final /* synthetic */ DsiAwareProfileChangeListenerCallback val$callback;
    private final /* synthetic */ SourceHandlingPersistence$1 this$1;

    SourceHandlingPersistence$1$1(SourceHandlingPersistence$1 sourceHandlingPersistence$1, DsiAwareProfileChangeListenerCallback dsiAwareProfileChangeListenerCallback) {
        this.this$1 = sourceHandlingPersistence$1;
        this.val$callback = dsiAwareProfileChangeListenerCallback;
    }

    @Override
    public void onCommandExecutionFinished(CommandState commandState) {
        this.val$callback.notifyTaskDone(true);
    }
}

