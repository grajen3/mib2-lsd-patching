/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor;

import de.vw.mib.app.desktop.ContentManager;
import de.vw.mib.asl.internal.system.processor.ContentProcessorManagerImpl$1;

class ContentProcessorManagerImpl$1$1
implements Runnable {
    private final /* synthetic */ ContentManager val$manager;
    private final /* synthetic */ ContentProcessorManagerImpl$1 this$1;

    ContentProcessorManagerImpl$1$1(ContentProcessorManagerImpl$1 contentProcessorManagerImpl$1, ContentManager contentManager) {
        this.this$1 = contentProcessorManagerImpl$1;
        this.val$manager = contentManager;
    }

    @Override
    public void run() {
        ContentProcessorManagerImpl$1.access$000(this.this$1).onContentManagerAdded(this.val$manager);
    }
}

