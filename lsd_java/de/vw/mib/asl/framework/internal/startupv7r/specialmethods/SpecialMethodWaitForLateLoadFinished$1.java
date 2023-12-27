/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.specialmethods;

import de.vw.mib.asl.framework.internal.startupv7r.api.impl.InternalStartupStateAdapter;
import de.vw.mib.asl.framework.internal.startupv7r.specialmethods.SpecialMethodWaitForLateLoadFinished;

class SpecialMethodWaitForLateLoadFinished$1
extends InternalStartupStateAdapter {
    private final /* synthetic */ SpecialMethodWaitForLateLoadFinished this$0;

    SpecialMethodWaitForLateLoadFinished$1(SpecialMethodWaitForLateLoadFinished specialMethodWaitForLateLoadFinished) {
        this.this$0 = specialMethodWaitForLateLoadFinished;
    }

    @Override
    public void onBundleLateLoadDone() {
        SpecialMethodWaitForLateLoadFinished.access$000(this.this$0);
    }
}

