/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.browser.headunit;

import de.vw.mib.asl.internal.media.clients.browser.headunit.HeadUnitBrowserListHandler;

class HeadUnitBrowserListHandler$1
implements Runnable {
    private final /* synthetic */ HeadUnitBrowserListHandler this$0;

    HeadUnitBrowserListHandler$1(HeadUnitBrowserListHandler headUnitBrowserListHandler) {
        this.this$0 = headUnitBrowserListHandler;
    }

    @Override
    public void run() {
        HeadUnitBrowserListHandler.mErrorTextIdsToDisplay.clear();
        this.this$0.updateErrorTextFlagInListCache();
    }
}

