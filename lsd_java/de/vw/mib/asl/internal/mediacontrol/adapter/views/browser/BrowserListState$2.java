/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.adapter.views.browser;

import de.vw.mib.asl.internal.mediacontrol.adapter.views.browser.BrowserListState;

class BrowserListState$2
implements Runnable {
    private final /* synthetic */ BrowserListState this$0;

    BrowserListState$2(BrowserListState browserListState) {
        this.this$0 = browserListState;
    }

    @Override
    public void run() {
        this.this$0.unlockLoadingAnimation();
    }
}

