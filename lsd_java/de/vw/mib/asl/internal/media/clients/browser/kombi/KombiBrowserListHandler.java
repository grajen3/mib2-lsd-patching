/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.browser.kombi;

import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.browser.MediaBrowserState;
import de.vw.mib.asl.internal.media.clients.browser.AbstractGenericAslListHandler;
import de.vw.mib.asl.internal.media.clients.browser.kombi.BapActiveTrackInfo;
import de.vw.mib.asl.internal.media.clients.browser.kombi.BapBrowsedFolderActiveElement;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import generated.de.vw.mib.asl.internal.ListManager;

public class KombiBrowserListHandler
extends AbstractGenericAslListHandler {
    private static final GenericASLList BAP_LIST = ListManager.getGenericASLList(3829);
    private MediaBrowserState mBrowserState = null;
    private MediaPlayerState mPlayerState = null;
    private final BapBrowsedFolderActiveElement mActiveElement = new BapBrowsedFolderActiveElement();
    private final BapActiveTrackInfo mActiveTrackInfo;
    private int mListSize = 0;
    private boolean mBrowsingAvailable = false;

    public KombiBrowserListHandler(BapActiveTrackInfo bapActiveTrackInfo) {
        this.mActiveTrackInfo = bapActiveTrackInfo;
        this.registerList(BAP_LIST, true);
    }

    @Override
    public GenericASLList getList() {
        return BAP_LIST;
    }

    @Override
    protected void onFolderPathChanged(MediaBrowserState mediaBrowserState) {
        BAP_LIST.clear();
    }

    public void onPlaybackEntryChanged(MediaPlayerState mediaPlayerState, MediaBrowserState mediaBrowserState) {
        this.mPlayerState = mediaPlayerState;
        this.mBrowserState = mediaBrowserState;
        this.updateListCache();
    }

    @Override
    protected boolean updateEntry(ExtendedListEntry extendedListEntry, boolean bl) {
        if (extendedListEntry != null) {
            extendedListEntry.isActive = bl;
        }
        return false;
    }

    @Override
    protected boolean isEntryActive(ExtendedListEntry extendedListEntry) {
        return MediaBrowserHelper.isActive(this.mPlayerState, this.mBrowserState, extendedListEntry);
    }

    @Override
    protected void onActiveEntryChangedInFolder(ExtendedListEntry extendedListEntry, String string) {
    }

    @Override
    protected void onActiveEntryChangedInCache(ExtendedListEntry extendedListEntry, String string) {
        this.mActiveElement.update(extendedListEntry);
        this.mActiveTrackInfo.updateActiveEntry(extendedListEntry);
    }

    public void updateActivationState(MediaPlayerState mediaPlayerState, MediaBrowserState mediaBrowserState) {
        boolean bl = false;
        if (mediaBrowserState != null) {
            int n = mediaBrowserState.getInitState();
            boolean bl2 = bl = n == 2;
        }
        if (this.mBrowsingAvailable != bl) {
            this.mBrowsingAvailable = bl;
            if (bl) {
                super.updateListSize(this.mListSize);
            } else {
                super.updateListSize(0);
            }
        }
    }

    @Override
    public void updateListSize(int n) {
        this.mListSize = n;
        if (this.mBrowsingAvailable) {
            super.updateListSize(n);
        }
    }
}

