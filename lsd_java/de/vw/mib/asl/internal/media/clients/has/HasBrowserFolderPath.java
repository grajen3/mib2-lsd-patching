/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.has;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.browser.MediaBrowserState;
import de.vw.mib.asl.internal.media.clients.has.HasBrowserListHandler;
import de.vw.mib.asl.internal.media.common.HASUtil;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.has.HAS;
import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASEngineAPI;
import de.vw.mib.has.HASFactory;
import de.vw.mib.util.Util;
import generated.de.vw.mib.has.containers.MediaBrowserEntryContainer;
import generated.de.vw.mib.has.containers.MediaBrowserPathContainer;
import generated.de.vw.mib.has.contexts.media.MediaProperties;
import org.dsi.ifc.media.ListEntry;

public class HasBrowserFolderPath {
    private static MediaProperties mHASProperties;
    private static final HASFactory HAS_FACTORY;
    private static MediaBrowserPathContainer mBrowseFolderPathContainer;
    private static MediaBrowserPathContainer mCurrentTrackPathContainer;

    public static void updateMediaBrowserPath(MediaBrowserState mediaBrowserState) {
        Object[] objectArray;
        MediaCollector mediaCollector = null;
        ListEntry[] listEntryArray = null;
        if (mediaBrowserState != null) {
            mediaCollector = mediaBrowserState.getBrowseMedia();
            listEntryArray = mediaBrowserState.getBrowseFolder();
        }
        if (!Util.isNullOrEmpty(objectArray = HasBrowserFolderPath.getEntryContainerPath(mediaCollector, listEntryArray))) {
            mBrowseFolderPathContainer.setEntries((MediaBrowserEntryContainer[])objectArray);
        } else {
            mBrowseFolderPathContainer.unsetEntries();
        }
        mHASProperties.updateMediaBrowserFolder(mBrowseFolderPathContainer);
    }

    public static void updateMediaPlayerPath(MediaPlayerState mediaPlayerState) {
        Object[] objectArray;
        MediaCollector mediaCollector = null;
        ListEntry[] listEntryArray = null;
        if (mediaPlayerState != null) {
            mediaCollector = mediaPlayerState.getActiveMedia();
            listEntryArray = mediaPlayerState.getPlaybackPath();
        }
        if (!Util.isNullOrEmpty(objectArray = HasBrowserFolderPath.getEntryContainerPath(mediaCollector, listEntryArray))) {
            mCurrentTrackPathContainer.setEntries((MediaBrowserEntryContainer[])objectArray);
        } else {
            mCurrentTrackPathContainer.unsetEntries();
        }
        mHASProperties.updateCurrentTrackPath(mCurrentTrackPathContainer);
    }

    public static MediaBrowserEntryContainer[] getEntryContainerPath(MediaCollector mediaCollector, ListEntry[] listEntryArray) {
        MediaBrowserEntryContainer[] mediaBrowserEntryContainerArray = null;
        if (!Util.isNullOrEmpty(listEntryArray) && mediaCollector != null) {
            mediaBrowserEntryContainerArray = new MediaBrowserEntryContainer[listEntryArray.length + 1];
            mediaBrowserEntryContainerArray[0] = HasBrowserListHandler.getEntryContainer(listEntryArray[0]);
            mediaBrowserEntryContainerArray[0].setEntryId(HASUtil.convertASLDeviceId2HAS(mediaCollector.getAslDeviceID()));
            mediaBrowserEntryContainerArray[0].setDisplayText("//media-info//");
            mediaBrowserEntryContainerArray[0].setFilename("//media-info//");
            if (mediaCollector != null) {
                if (mediaCollector.supportsContentMode()) {
                    if (mediaCollector.isContentModeReadyToUse(false)) {
                        mediaBrowserEntryContainerArray[0].setEntryType(9);
                    } else {
                        mediaBrowserEntryContainerArray[0].setEntryType(3);
                    }
                } else {
                    mediaBrowserEntryContainerArray[0].setEntryType(20);
                }
            }
            String string = mediaCollector != null && mediaCollector.getName() != null && !mediaCollector.getName().startsWith("medium.") ? mediaCollector.getName() : "";
            for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
                mediaBrowserEntryContainerArray[i2 + 1] = HasBrowserListHandler.getEntryContainer(listEntryArray[i2]);
                if (i2 > 0) {
                    mediaBrowserEntryContainerArray[i2 + 1].setDisplayText(listEntryArray[i2].getFilename());
                    continue;
                }
                mediaBrowserEntryContainerArray[i2 + 1].setDisplayText(string);
            }
            mediaBrowserEntryContainerArray[0].setDisplayText(listEntryArray[0].filename);
        }
        return mediaBrowserEntryContainerArray;
    }

    public static ListEntry[] getListEntryPath(MediaBrowserEntryContainer[] mediaBrowserEntryContainerArray) {
        ListEntry[] listEntryArray = null;
        if (mediaBrowserEntryContainerArray != null && mediaBrowserEntryContainerArray.length > 1) {
            listEntryArray = new ListEntry[mediaBrowserEntryContainerArray.length - 1];
            for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
                listEntryArray[i2] = HasBrowserListHandler.getListEntry(mediaBrowserEntryContainerArray[i2 + 1]);
            }
            listEntryArray[0].filename = mediaBrowserEntryContainerArray[0].getDisplayText();
        }
        return listEntryArray;
    }

    public static int getSourceId(MediaBrowserEntryContainer[] mediaBrowserEntryContainerArray) {
        if (!Util.isNullOrEmpty(mediaBrowserEntryContainerArray)) {
            return (int)mediaBrowserEntryContainerArray[0].getEntryId();
        }
        ServiceManager.logger.error(32).append("HasBrowserFolderPath.getSourceId() path is null or empty!").log();
        return -1;
    }

    public static int getPathMode(MediaBrowserEntryContainer[] mediaBrowserEntryContainerArray) {
        if (!Util.isNullOrEmpty(mediaBrowserEntryContainerArray) && mediaBrowserEntryContainerArray[0] != null && mediaBrowserEntryContainerArray[0].getDisplayText() != null) {
            if (mediaBrowserEntryContainerArray[0].getDisplayText().length() == 0) {
                return 1;
            }
            return 0;
        }
        ServiceManager.logger.error(32).append("HasBrowserFolderPath.getPathMode() path is null or empty!").log();
        return 0;
    }

    static {
        HAS_FACTORY = HAS.getInstance().getFactory();
        HASEngineAPI hASEngineAPI = HAS.getInstance().getEngine();
        HASContext hASContext = hASEngineAPI.getRegistry().getContextByName("Media");
        mHASProperties = (MediaProperties)hASContext.getPropertiesImpl();
        mBrowseFolderPathContainer = (MediaBrowserPathContainer)HAS_FACTORY.createContainer(50);
        mCurrentTrackPathContainer = (MediaBrowserPathContainer)HAS_FACTORY.createContainer(50);
    }
}

