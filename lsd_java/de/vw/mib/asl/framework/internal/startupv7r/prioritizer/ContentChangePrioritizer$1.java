/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.prioritizer;

import de.vw.mib.asl.framework.internal.startupv7r.api.impl.InternalStartupStateAdapter;
import de.vw.mib.asl.framework.internal.startupv7r.prioritizer.ContentChangePrioritizer;

class ContentChangePrioritizer$1
extends InternalStartupStateAdapter {
    private final /* synthetic */ ContentChangePrioritizer this$0;

    ContentChangePrioritizer$1(ContentChangePrioritizer contentChangePrioritizer) {
        this.this$0 = contentChangePrioritizer;
    }

    @Override
    public void onLastUserModeReady() {
        this.this$0.onLastUserModeReady();
    }

    @Override
    public void onStartupStateChanged(int n) {
        this.this$0.onStartupStateChanged(n);
    }
}

