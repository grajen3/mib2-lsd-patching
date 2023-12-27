/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.prioritizer;

import de.vw.mib.asl.framework.internal.startupv7r.api.impl.InternalStartupStateAdapter;
import de.vw.mib.asl.framework.internal.startupv7r.prioritizer.LastUserModePrioritizer;

class LastUserModePrioritizer$1
extends InternalStartupStateAdapter {
    private final /* synthetic */ LastUserModePrioritizer this$0;

    LastUserModePrioritizer$1(LastUserModePrioritizer lastUserModePrioritizer) {
        this.this$0 = lastUserModePrioritizer;
    }

    @Override
    public void onLastUserModeAvailable() {
        this.this$0.prioritizeLastUserMode();
    }
}

