/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode;

import de.vw.mib.asl.framework.api.persistence2.GlobalProfileChangeListener;
import de.vw.mib.asl.internal.testmode.TargetETM;

class TargetETM$1
implements GlobalProfileChangeListener {
    private final /* synthetic */ TargetETM this$0;

    TargetETM$1(TargetETM targetETM) {
        this.this$0 = targetETM;
    }

    @Override
    public void onProfileChangeStarted() {
    }

    @Override
    public void onProfileChangeCompleted() {
        this.this$0.updateProfileList();
    }
}

