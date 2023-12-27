/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor;

import de.vw.mib.app.desktop.ContentProcessor;
import de.vw.mib.asl.internal.system.processor.ThreadSwitchingContentProcessor$1;
import de.vw.mib.genericevents.ThreadSwitchingTarget;

public class ThreadSwitchingContentProcessor
implements ContentProcessor {
    private final ThreadSwitchingTarget threadSwitchingTarget;
    private final ContentProcessor delegate;

    public ThreadSwitchingContentProcessor(ThreadSwitchingTarget threadSwitchingTarget, ContentProcessor contentProcessor) {
        this.threadSwitchingTarget = threadSwitchingTarget;
        this.delegate = contentProcessor;
    }

    @Override
    public boolean requestContent(String string, String string2) {
        ContentProcessor contentProcessor = this.delegate;
        this.threadSwitchingTarget.enqueue(new ThreadSwitchingContentProcessor$1(this, contentProcessor, string, string2));
        return true;
    }
}

