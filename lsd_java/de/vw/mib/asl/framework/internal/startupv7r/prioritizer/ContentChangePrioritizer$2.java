/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.prioritizer;

import de.vw.mib.asl.api.system.KeyAdapter;
import de.vw.mib.asl.framework.internal.startupv7r.prioritizer.ContentChangePrioritizer;

class ContentChangePrioritizer$2
extends KeyAdapter {
    private final /* synthetic */ ContentChangePrioritizer this$0;

    ContentChangePrioritizer$2(ContentChangePrioritizer contentChangePrioritizer) {
        this.this$0 = contentChangePrioritizer;
    }

    @Override
    public void onPressed(int n) {
        this.this$0.onKeyPressed(n);
    }
}

