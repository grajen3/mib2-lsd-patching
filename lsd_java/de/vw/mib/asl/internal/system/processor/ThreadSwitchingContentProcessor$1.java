/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor;

import de.vw.mib.app.desktop.ContentProcessor;
import de.vw.mib.asl.internal.system.processor.ThreadSwitchingContentProcessor;

class ThreadSwitchingContentProcessor$1
implements Runnable {
    private final /* synthetic */ ContentProcessor val$internalDelegate;
    private final /* synthetic */ String val$screenArea;
    private final /* synthetic */ String val$content;
    private final /* synthetic */ ThreadSwitchingContentProcessor this$0;

    ThreadSwitchingContentProcessor$1(ThreadSwitchingContentProcessor threadSwitchingContentProcessor, ContentProcessor contentProcessor, String string, String string2) {
        this.this$0 = threadSwitchingContentProcessor;
        this.val$internalDelegate = contentProcessor;
        this.val$screenArea = string;
        this.val$content = string2;
    }

    @Override
    public void run() {
        this.val$internalDelegate.requestContent(this.val$screenArea, this.val$content);
    }
}

