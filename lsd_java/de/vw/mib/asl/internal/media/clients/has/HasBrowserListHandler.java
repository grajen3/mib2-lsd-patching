/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.has;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.list.IndexIterator;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.browser.MediaBrowserListHandler;
import de.vw.mib.asl.internal.media.browser.MediaBrowserListHandler$MediaListElementFetcher;
import de.vw.mib.asl.internal.media.browser.MediaBrowserState;
import de.vw.mib.asl.internal.media.clients.has.HASPlayerUpdater;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.has.HAS;
import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASDynamicList;
import de.vw.mib.has.HASEngineAPI;
import de.vw.mib.has.HASFactory;
import de.vw.mib.has.HASListFetcher;
import de.vw.mib.util.Util;
import generated.de.vw.mib.has.containers.MediaBrowserEntryContainer;
import generated.de.vw.mib.has.containers.TrackInfoContainer;
import generated.de.vw.mib.has.contexts.media.MediaProperties;
import org.dsi.ifc.global.CharacterInfo;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.ListEntryExt;

public class HasBrowserListHandler
implements MediaBrowserListHandler,
HASListFetcher {
    public static final boolean WORKAROUND_BT_IPOD_HIGHLIGHTING;
    private static final int HAS_LIST_WINDOW_SIZE;
    private static final HASFactory HAS_FACTORY;
    private final HASDynamicList mHasList;
    private MediaBrowserListHandler$MediaListElementFetcher mConnectedFetcher = null;
    private MediaPlayerState mPlayerState;
    private MediaBrowserState mBrowserState;

    public HasBrowserListHandler() {
        HASEngineAPI hASEngineAPI = HAS.getInstance().getEngine();
        HASContext hASContext = hASEngineAPI.getRegistry().getContextByName("Media");
        MediaProperties mediaProperties = (MediaProperties)hASContext.getPropertiesImpl();
        this.mHasList = mediaProperties.getMediaBrowserList().enableFetching(this, 20);
    }

    @Override
    public void setFetcher(MediaBrowserListHandler$MediaListElementFetcher mediaBrowserListHandler$MediaListElementFetcher) {
        this.mConnectedFetcher = mediaBrowserListHandler$MediaListElementFetcher;
    }

    @Override
    public void fetchItems(HASDynamicList hASDynamicList, int n, int n2) {
        if (this.mConnectedFetcher != null) {
            this.mConnectedFetcher.fetchItems(n, n2);
        }
    }

    public void onPlaybackEntryChanged(MediaPlayerState mediaPlayerState) {
        this.mPlayerState = mediaPlayerState;
        if (this.useTitleStringComparison(mediaPlayerState)) {
            this.updateListCache();
        }
    }

    private boolean useTitleStringComparison(MediaPlayerState mediaPlayerState) {
        MediaCollector mediaCollector;
        return mediaPlayerState != null && (mediaCollector = mediaPlayerState.getActiveMedia()) != null && (mediaCollector.isBT() || mediaPlayerState.isIPodMixMode());
    }

    @Override
    public void updateFolderPath(MediaBrowserState mediaBrowserState) {
        this.mBrowserState = mediaBrowserState;
        if (this.mHasList != null) {
            this.mHasList.clear();
        }
    }

    @Override
    public void refetch() {
        int n;
        if (this.mHasList != null && (n = this.mHasList.getSize()) > 1) {
            this.mHasList.refresh(0, n);
        }
    }

    @Override
    public void refresh(int n) {
        if (this.mHasList != null && n > 1) {
            this.mHasList.refresh(0, n);
        }
    }

    @Override
    public void updateListSize(int n) {
        if (this.mHasList != null) {
            int n2 = this.mHasList.getSize();
            if (n != 0 && n2 > 0) {
                this.mHasList.refresh(0, n2);
            }
            this.mHasList.setSize(n);
        }
    }

    private boolean isValidCDDATrackName(String string) {
        return !Util.isNullOrEmpty(string) && string.trim().length() > 0 && !string.startsWith("cdda.track");
    }

    @Override
    public void updateListData(ExtendedListEntry[] extendedListEntryArray, int n) {
        HASDynamicList hASDynamicList = this.mHasList;
        int n2 = 1;
        boolean bl = false;
        if (this.mBrowserState != null) {
            n2 = this.mBrowserState.getBrowseMode();
            bl = this.mBrowserState.getBrowseMedia().isCDDA();
        }
        if (hASDynamicList != null) {
            Object[] objectArray = new MediaBrowserEntryContainer[extendedListEntryArray.length];
            ExtendedListEntry extendedListEntry = null;
            boolean bl2 = this.useTitleStringComparison(this.mPlayerState);
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                objectArray[i2] = HasBrowserListHandler.getEntryContainer(extendedListEntryArray[i2]);
                if (n2 == 0) {
                    if (bl) {
                        objectArray[i2].setDisplayText(this.isValidCDDATrackName(extendedListEntryArray[i2].getTitle()) ? extendedListEntryArray[i2].getTitle() : "");
                    } else {
                        objectArray[i2].setDisplayText(extendedListEntryArray[i2].getFilename() != null ? extendedListEntryArray[i2].getFilename() : extendedListEntryArray[i2].getTitle());
                    }
                } else {
                    objectArray[i2].setDisplayText(extendedListEntryArray[i2].getFilename() != null ? extendedListEntryArray[i2].getFilename() : extendedListEntryArray[i2].getTitle());
                }
                if (!bl2 || !MediaBrowserHelper.isActive(this.mPlayerState, this.mBrowserState, extendedListEntryArray[i2])) continue;
                if (extendedListEntry == null) {
                    extendedListEntry = extendedListEntryArray[i2];
                    continue;
                }
                ServiceManager.logger.warn(1024, "Multiple tracks recognized active in passed window.");
                extendedListEntry = null;
            }
            if (!Util.isNullOrEmpty(objectArray)) {
                hASDynamicList.update(n, (HASContainer[])objectArray);
            }
            if (extendedListEntry != null) {
                HASPlayerUpdater.updateEntryId(extendedListEntry.entryID);
            }
        }
    }

    private void updateListCache() {
        IndexIterator indexIterator = this.mHasList.indexIterator();
        ListEntry listEntry = null;
        while (indexIterator.hasNext()) {
            ListEntry listEntry2 = HasBrowserListHandler.getListEntry((MediaBrowserEntryContainer)indexIterator.next());
            if (listEntry2 == null || !MediaBrowserHelper.isActive(this.mPlayerState, this.mBrowserState, listEntry2)) continue;
            if (listEntry == null) {
                listEntry = listEntry2;
                continue;
            }
            ServiceManager.logger.warn(1024, "Multiple tracks recognized active in passed window.");
            listEntry = null;
        }
        if (listEntry != null) {
            HASPlayerUpdater.updateEntryId(listEntry.entryID);
        }
    }

    @Override
    public void updateListData(CharacterInfo[] characterInfoArray) {
    }

    @Override
    public ExtendedListEntry getListEntryById(long l, int n) {
        return null;
    }

    @Override
    public ExtendedListEntry getListEntryByTitle(String string) {
        return null;
    }

    @Override
    public ExtendedListEntry getListEntryByIndex(int n) {
        return null;
    }

    @Override
    public void showErrorInformation(ListEntry listEntry) {
    }

    public static MediaBrowserEntryContainer getEntryContainer(ListEntry listEntry) {
        MediaBrowserEntryContainer mediaBrowserEntryContainer = null;
        if (listEntry != null) {
            long l = listEntry.getEntryID();
            int n = listEntry.getContentType();
            String string = listEntry.getFilename();
            String string2 = listEntry.getTitle();
            int n2 = listEntry.getSecLength();
            int n3 = listEntry.flags;
            String string3 = "";
            String string4 = "";
            ResourceLocator resourceLocator = null;
            ListEntryExt listEntryExt = listEntry.getExtInfo();
            if (listEntryExt != null) {
                string3 = listEntryExt.getAlbum();
                string4 = listEntryExt.getArtist();
                resourceLocator = listEntryExt.coverArtResource;
            }
            mediaBrowserEntryContainer = (MediaBrowserEntryContainer)HAS_FACTORY.createContainer(21);
            mediaBrowserEntryContainer.setFilename(string);
            mediaBrowserEntryContainer.setEntryId(l);
            mediaBrowserEntryContainer.setEntryType(HasBrowserListHandler.getEntryType(n));
            mediaBrowserEntryContainer.setNotPlayableReason(HasBrowserListHandler.getNotPlayableReason(n3));
            if (Util.isAnyBitSet(2958, n3)) {
                mediaBrowserEntryContainer.setEntryType(0);
            }
            TrackInfoContainer trackInfoContainer = (TrackInfoContainer)HAS_FACTORY.createContainer(22);
            trackInfoContainer.setTitle(string2);
            trackInfoContainer.setAlbum(string3);
            trackInfoContainer.setArtist(string4);
            trackInfoContainer.setCover(resourceLocator);
            trackInfoContainer.setLength(n2);
            mediaBrowserEntryContainer.setTrackInfo(trackInfoContainer);
        }
        return mediaBrowserEntryContainer;
    }

    private static int getNotPlayableReason(int n) {
        int n2 = 0;
        if (Util.isBitSet(2, n)) {
            n2 = 1;
        } else if (Util.isBitSet(8, n)) {
            n2 = 3;
        } else if (Util.isAnyBitSet(2944, n)) {
            n2 = 4;
        } else if (Util.isBitSet(4, n)) {
            n2 = 2;
        }
        return n2;
    }

    public static ListEntry getListEntry(MediaBrowserEntryContainer mediaBrowserEntryContainer) {
        ListEntry listEntry = null;
        if (mediaBrowserEntryContainer != null) {
            long l = mediaBrowserEntryContainer.getEntryId();
            int n = HasBrowserListHandler.getContentType(mediaBrowserEntryContainer.getEntryType());
            String string = mediaBrowserEntryContainer.getFilename();
            String string2 = "";
            int n2 = 0;
            TrackInfoContainer trackInfoContainer = mediaBrowserEntryContainer.getTrackInfo();
            if (trackInfoContainer != null) {
                string2 = trackInfoContainer.getTitle();
                n2 = trackInfoContainer.getLength();
            }
            if (Util.isNullOrEmpty(string)) {
                string = string2;
            }
            listEntry = new ListEntry(l, string, string2, n, n2, 0, null);
        }
        return listEntry;
    }

    private static int getContentType(int n) {
        switch (n) {
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
            case 5: {
                return 5;
            }
            case 6: {
                return 6;
            }
            case 7: {
                return 7;
            }
            case 8: {
                return 8;
            }
            case 9: {
                return 9;
            }
            case 13: {
                return 13;
            }
            case 14: {
                return 14;
            }
            case 15: {
                return 15;
            }
            case 16: {
                return 16;
            }
            case 20: {
                return 10;
            }
        }
        return 0;
    }

    private static int getEntryType(int n) {
        switch (n) {
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
            case 5: {
                return 5;
            }
            case 10: {
                return 20;
            }
            case 6: {
                return 6;
            }
            case 7: {
                return 7;
            }
            case 8: {
                return 8;
            }
            case 9: {
                return 9;
            }
            case 13: {
                return 13;
            }
            case 14: {
                return 14;
            }
            case 15: {
                return 15;
            }
            case 16: {
                return 16;
            }
            case 20: {
                return 20;
            }
        }
        return 0;
    }

    static {
        HAS_FACTORY = HAS.getInstance().getFactory();
    }
}

