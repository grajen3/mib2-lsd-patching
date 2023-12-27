/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi;

import de.vw.mib.asl.framework.api.persistence2.ProfileChangeCallback;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.AbstractDsiAwareProfileChangeListenerCallback;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DsiAwareProfileChangeListenerAdapter;
import de.vw.mib.log4mib.Logger;

class DsiAwareProfileChangeListenerAdapter$3
extends AbstractDsiAwareProfileChangeListenerCallback {
    private final /* synthetic */ String val$stepId;
    private final /* synthetic */ ProfileChangeCallback val$callback;
    private final /* synthetic */ DsiAwareProfileChangeListenerAdapter this$0;

    DsiAwareProfileChangeListenerAdapter$3(DsiAwareProfileChangeListenerAdapter dsiAwareProfileChangeListenerAdapter, Logger logger, String string, String string2, ProfileChangeCallback profileChangeCallback) {
        this.this$0 = dsiAwareProfileChangeListenerAdapter;
        this.val$stepId = string2;
        this.val$callback = profileChangeCallback;
        super(logger, string);
    }

    @Override
    protected void processCallbackTask(boolean bl) {
        if (!bl) {
            this.this$0.logWarning().append(new StringBuffer().append(this.val$stepId).append(" was not successful.").toString()).log();
        }
        this.val$callback.notifyReadyForProfileChange();
    }
}

