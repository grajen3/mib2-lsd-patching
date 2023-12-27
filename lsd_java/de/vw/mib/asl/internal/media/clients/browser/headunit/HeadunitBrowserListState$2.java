/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.browser.headunit;

import de.vw.mib.asl.internal.media.clients.browser.headunit.HeadunitBrowserListState;

final class HeadunitBrowserListState$2
implements Runnable {
    HeadunitBrowserListState$2() {
    }

    @Override
    public void run() {
        HeadunitBrowserListState.unlockLoadingAnimation();
    }
}

