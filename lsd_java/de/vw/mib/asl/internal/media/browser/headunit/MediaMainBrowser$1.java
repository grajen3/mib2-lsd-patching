/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.browser.headunit;

import de.vw.mib.asl.internal.media.browser.MediaBrowserSearchHandler$MediaSearchElementFetcher;
import de.vw.mib.asl.internal.media.browser.headunit.MediaMainBrowser;

class MediaMainBrowser$1
implements MediaBrowserSearchHandler$MediaSearchElementFetcher {
    private final /* synthetic */ MediaMainBrowser this$0;

    MediaMainBrowser$1(MediaMainBrowser mediaMainBrowser) {
        this.this$0 = mediaMainBrowser;
    }

    @Override
    public void fetchSearchItems(long l, int n, int n2) {
        this.this$0.getDSI().requestSearchListExt(l, 0, n2);
    }

    @Override
    public void fetchSearchItems(int n, int n2) {
        this.this$0.getDSI().requestSearchListExt(0L, n, n2);
    }
}

