/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.browser.cover;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.browser.MediaBrowserState;
import de.vw.mib.asl.internal.media.clients.browser.AbstractGenericAslListHandler;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.global.ResourceLocator;

public class CoverBrowserListHandler
extends AbstractGenericAslListHandler {
    private static boolean mCoverFlowEnabled = false;
    private static final ExtendedListEntry TEMP_COVER = new ExtendedListEntry();
    private static final GenericASLList COVER_FLOW_LIST = ListManager.getGenericASLList(2350);
    private int mListSize = 0;
    private static ResourceLocator mActiveTrackCover = null;
    private static long mActiveTrackAlbumId = -1L;
    private ExtendedListEntry mFocusedAlbum = null;
    private int mFocusedAlbumIndex;
    private static boolean mScrollToAlbumOnNextListUpdate = false;
    private boolean mBrowserLoading = false;

    public CoverBrowserListHandler() {
        this.registerList(COVER_FLOW_LIST, false);
        this.enableCoverFlow(false);
    }

    @Override
    public GenericASLList getList() {
        return COVER_FLOW_LIST;
    }

    public void onBrowserStateChanged(int n, int n2, boolean bl) {
        boolean bl2;
        boolean bl3 = n == 0;
        boolean bl4 = bl2 = n == 2 && bl;
        if (mCoverFlowEnabled != bl2 || !this.mBrowserLoading && bl3) {
            this.enableCoverFlow(bl2);
        }
        this.mBrowserLoading = bl3;
    }

    private void enableCoverFlow(boolean bl) {
        mCoverFlowEnabled = bl;
        if (bl) {
            this.refresh(this.mListSize);
            mScrollToAlbumOnNextListUpdate = true;
        } else {
            if (COVER_FLOW_LIST.getSize() > 0) {
                COVER_FLOW_LIST.setSize(1);
            }
            CoverBrowserListHandler.TEMP_COVER.isActive = true;
            TEMP_COVER.setOriginalCover(null);
            TEMP_COVER.setVisibleCover(mActiveTrackCover);
            COVER_FLOW_LIST.updateListItem(0, TEMP_COVER);
            this.setAlbumIndex(0, "enableCoverFlow(false), focus temp cover");
        }
    }

    @Override
    protected void onFolderPathChanged(MediaBrowserState mediaBrowserState) {
        if (mCoverFlowEnabled) {
            COVER_FLOW_LIST.clear();
        }
    }

    @Override
    public void updateListSize(int n) {
        this.mListSize = n;
        if (mCoverFlowEnabled) {
            super.updateListSize(n);
        }
    }

    @Override
    public void updateListData(ExtendedListEntry[] extendedListEntryArray, int n) {
        if (mCoverFlowEnabled) {
            super.updateListData(extendedListEntryArray, n);
            if (mScrollToAlbumOnNextListUpdate && this.mFocusedAlbum != null) {
                this.setAlbumIndex(this.mFocusedAlbum.listIndex, "enableCoverFlow(true), focus last reported cover");
                mScrollToAlbumOnNextListUpdate = false;
            }
        }
    }

    public void focusAlbum(ExtendedListEntry extendedListEntry, String string) {
        this.mFocusedAlbum = extendedListEntry;
        if (mCoverFlowEnabled && extendedListEntry != null) {
            this.setAlbumIndex(extendedListEntry.listIndex, string);
        }
    }

    public void onActiveTrackCoverChanged(long l, ResourceLocator resourceLocator) {
        if (!MediaBrowserHelper.isSameResourceLocator(mActiveTrackCover, resourceLocator) || mActiveTrackAlbumId != l) {
            mActiveTrackCover = resourceLocator;
            mActiveTrackAlbumId = l;
            this.updateListCache();
        }
    }

    @Override
    protected boolean isEntryActive(ExtendedListEntry extendedListEntry) {
        return extendedListEntry != null && (extendedListEntry.getEntryID() == mActiveTrackAlbumId || extendedListEntry == TEMP_COVER);
    }

    @Override
    public void onActiveEntryChangedInFolder(ExtendedListEntry extendedListEntry, String string) {
        if (mCoverFlowEnabled && extendedListEntry != null) {
            this.setAlbumIndex(extendedListEntry.listIndex, string);
        }
    }

    @Override
    protected void onActiveEntryChangedInCache(ExtendedListEntry extendedListEntry, String string) {
    }

    @Override
    protected boolean updateEntry(ExtendedListEntry extendedListEntry, boolean bl) {
        boolean bl2 = false;
        if (extendedListEntry != null) {
            ResourceLocator resourceLocator;
            if (extendedListEntry.isActive != bl) {
                extendedListEntry.isActive = bl;
                bl2 = true;
            }
            ResourceLocator resourceLocator2 = resourceLocator = bl ? mActiveTrackCover : extendedListEntry.getOriginalCover();
            if (!MediaBrowserHelper.isSameResourceLocator(extendedListEntry.getVisibleCover(), resourceLocator)) {
                extendedListEntry.setVisibleCover(resourceLocator);
                bl2 = true;
            }
        }
        return bl2;
    }

    private void setAlbumIndex(int n, String string) {
        this.mFocusedAlbumIndex = n;
        DATA_POOL.valueChangedInteger(2349, n);
        COVER_FLOW_LIST.setActiveIndex(n);
        this.traceCurrentState(new StringBuffer().append("setAlbumIndex(").append(n).append(") [").append(string).append("]").toString());
    }

    private void traceCurrentState(String string) {
        Logger logger = ServiceManager.logger;
        logger.trace(1024, "COVER FLOW ~");
        logger.trace(1024, new StringBuffer().append("COVER FLOW ~ update             : ").append(string).toString());
        Object object = COVER_FLOW_LIST.getRowItemCacheOnly(this.mFocusedAlbumIndex);
        ExtendedListEntry extendedListEntry = COVER_FLOW_LIST.isValidItem(object) ? (ExtendedListEntry)object : null;
        logger.trace(1024, new StringBuffer().append("COVER FLOW ~ coverFlow          : enabled=").append(mCoverFlowEnabled).append(", listSize=").append(COVER_FLOW_LIST.getSize()).toString());
        logger.trace(1024, new StringBuffer().append("COVER FLOW ~ coverFlow_focused  : ").append(this.getAlbumEntryStr(extendedListEntry)).toString());
        logger.trace(1024, new StringBuffer().append("COVER FLOW ~       asl_focused  : ").append(this.getAlbumEntryStr(this.mFocusedAlbum)).toString());
        logger.trace(1024, new StringBuffer().append("COVER FLOW ~        trackCover  : albumId=").append(mActiveTrackAlbumId).append(", cover=").append(this.getCoverStr(mActiveTrackCover)).toString());
        logger.trace(1024, "COVER FLOW ~");
    }

    private String getAlbumEntryStr(ExtendedListEntry extendedListEntry) {
        String string = "";
        if (extendedListEntry != null) {
            long l = extendedListEntry.getEntryID();
            String string2 = this.getCoverStr(extendedListEntry.getVisibleCover());
            String string3 = this.getCoverStr(extendedListEntry.getOriginalCover());
            if (extendedListEntry != TEMP_COVER) {
                string = new StringBuffer().append(string).append("albumId=").append(l).toString();
                string = string2.equals(string3) ? new StringBuffer().append(string).append(", cover=").append(string2).toString() : new StringBuffer().append(string).append(", cover=").append(string2).append(", original=").append(string3).toString();
                string = new StringBuffer().append(string).append(", index=").append(extendedListEntry.listIndex).toString();
            } else {
                string = new StringBuffer().append(string).append("TEMP_COVER[").append(string2).append("]").toString();
            }
        } else {
            string = "null";
        }
        return string;
    }

    private String getCoverStr(ResourceLocator resourceLocator) {
        int n;
        String string = "null";
        if (resourceLocator != null && !Util.isNullOrEmpty(string = resourceLocator.getUrl()) && (n = string.lastIndexOf("/")) > 0 && n < string.length() - 1) {
            string = string.substring(n + 1);
        }
        return string;
    }
}

