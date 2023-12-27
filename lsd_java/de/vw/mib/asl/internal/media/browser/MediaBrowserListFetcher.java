/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.browser;

import de.vw.mib.asl.internal.media.browser.AbstractMediaBrowser;
import de.vw.mib.asl.internal.media.browser.MediaBrowserListHandler$MediaListElementFetcher;
import de.vw.mib.asl.internal.media.controller.commands.Command;
import de.vw.mib.asl.internal.media.controller.commands.CommandQueue;
import de.vw.mib.asl.internal.media.controller.commands.browsing.CmdRequestList;

public class MediaBrowserListFetcher
implements MediaBrowserListHandler$MediaListElementFetcher {
    private final CommandQueue mCommandQueue;
    private final AbstractMediaBrowser mBrowser;

    public MediaBrowserListFetcher(AbstractMediaBrowser abstractMediaBrowser, CommandQueue commandQueue) {
        this.mBrowser = abstractMediaBrowser;
        this.mCommandQueue = commandQueue;
    }

    @Override
    public void fetchItems(long l, int n, int n2) {
        Command command = CmdRequestList.createListRequestById(this.mBrowser, l, n, n2);
        this.mCommandQueue.addCommand(command);
    }

    @Override
    public void fetchItems(int n, int n2) {
        Command command = CmdRequestList.createListRequestByIndex(this.mBrowser, n, n2);
        this.mCommandQueue.addCommand(command);
    }
}

