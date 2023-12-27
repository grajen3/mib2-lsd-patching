/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.media;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.media.AudioRoute;
import org.dsi.ifc.media.AudioStream;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.ChapterInfo;
import org.dsi.ifc.media.CoverartInfo;
import org.dsi.ifc.media.DatabaseSpace;
import org.dsi.ifc.media.DeviceInfo;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.ListEntryExt;
import org.dsi.ifc.media.MediaCapabilities;
import org.dsi.ifc.media.MediaInfo;
import org.dsi.ifc.media.PickListEntry;
import org.dsi.ifc.media.PlaybackMode;
import org.dsi.ifc.media.SearchListEntry;
import org.dsi.ifc.media.SearchListEntryExt;
import org.dsi.ifc.media.TagInformation;

public final class DSIMediaTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_AUDIOROUTE;
    private static final int ID_AUDIOSTREAM;
    private static final int ID_CAPABILITIES;
    private static final int ID_CHAPTERINFO;
    private static final int ID_COVERARTINFO;
    private static final int ID_DATABASESPACE;
    private static final int ID_DEVICEINFO;
    private static final int ID_ENTRYINFO;
    private static final int ID_LISTENTRY;
    private static final int ID_LISTENTRYEXT;
    private static final int ID_MEDIACAPABILITIES;
    private static final int ID_MEDIAINFO;
    private static final int ID_PICKLISTENTRY;
    private static final int ID_PLAYBACKMODE;
    private static final int ID_SEARCHLISTENTRY;
    private static final int ID_SEARCHLISTENTRYEXT;
    private static final int ID_TAGINFORMATION;
    static /* synthetic */ Class class$org$dsi$ifc$media$AudioRoute;
    static /* synthetic */ Class class$org$dsi$ifc$media$AudioStream;
    static /* synthetic */ Class class$org$dsi$ifc$media$Capabilities;
    static /* synthetic */ Class class$org$dsi$ifc$media$ChapterInfo;
    static /* synthetic */ Class class$org$dsi$ifc$media$CoverartInfo;
    static /* synthetic */ Class class$org$dsi$ifc$media$DatabaseSpace;
    static /* synthetic */ Class class$org$dsi$ifc$media$DeviceInfo;
    static /* synthetic */ Class class$org$dsi$ifc$media$EntryInfo;
    static /* synthetic */ Class class$org$dsi$ifc$media$ListEntry;
    static /* synthetic */ Class class$org$dsi$ifc$media$ListEntryExt;
    static /* synthetic */ Class class$org$dsi$ifc$media$MediaCapabilities;
    static /* synthetic */ Class class$org$dsi$ifc$media$MediaInfo;
    static /* synthetic */ Class class$org$dsi$ifc$media$PickListEntry;
    static /* synthetic */ Class class$org$dsi$ifc$media$PlaybackMode;
    static /* synthetic */ Class class$org$dsi$ifc$media$SearchListEntry;
    static /* synthetic */ Class class$org$dsi$ifc$media$SearchListEntryExt;
    static /* synthetic */ Class class$org$dsi$ifc$media$TagInformation;

    public DSIMediaTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$media$AudioRoute == null ? (class$org$dsi$ifc$media$AudioRoute = DSIMediaTracer.class$("org.dsi.ifc.media.AudioRoute")) : class$org$dsi$ifc$media$AudioRoute, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$media$AudioStream == null ? (class$org$dsi$ifc$media$AudioStream = DSIMediaTracer.class$("org.dsi.ifc.media.AudioStream")) : class$org$dsi$ifc$media$AudioStream, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$media$Capabilities == null ? (class$org$dsi$ifc$media$Capabilities = DSIMediaTracer.class$("org.dsi.ifc.media.Capabilities")) : class$org$dsi$ifc$media$Capabilities, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$media$ChapterInfo == null ? (class$org$dsi$ifc$media$ChapterInfo = DSIMediaTracer.class$("org.dsi.ifc.media.ChapterInfo")) : class$org$dsi$ifc$media$ChapterInfo, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$media$CoverartInfo == null ? (class$org$dsi$ifc$media$CoverartInfo = DSIMediaTracer.class$("org.dsi.ifc.media.CoverartInfo")) : class$org$dsi$ifc$media$CoverartInfo, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$media$DatabaseSpace == null ? (class$org$dsi$ifc$media$DatabaseSpace = DSIMediaTracer.class$("org.dsi.ifc.media.DatabaseSpace")) : class$org$dsi$ifc$media$DatabaseSpace, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$media$DeviceInfo == null ? (class$org$dsi$ifc$media$DeviceInfo = DSIMediaTracer.class$("org.dsi.ifc.media.DeviceInfo")) : class$org$dsi$ifc$media$DeviceInfo, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$media$EntryInfo == null ? (class$org$dsi$ifc$media$EntryInfo = DSIMediaTracer.class$("org.dsi.ifc.media.EntryInfo")) : class$org$dsi$ifc$media$EntryInfo, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$media$ListEntry == null ? (class$org$dsi$ifc$media$ListEntry = DSIMediaTracer.class$("org.dsi.ifc.media.ListEntry")) : class$org$dsi$ifc$media$ListEntry, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$media$ListEntryExt == null ? (class$org$dsi$ifc$media$ListEntryExt = DSIMediaTracer.class$("org.dsi.ifc.media.ListEntryExt")) : class$org$dsi$ifc$media$ListEntryExt, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$media$MediaCapabilities == null ? (class$org$dsi$ifc$media$MediaCapabilities = DSIMediaTracer.class$("org.dsi.ifc.media.MediaCapabilities")) : class$org$dsi$ifc$media$MediaCapabilities, 11);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$media$MediaInfo == null ? (class$org$dsi$ifc$media$MediaInfo = DSIMediaTracer.class$("org.dsi.ifc.media.MediaInfo")) : class$org$dsi$ifc$media$MediaInfo, 12);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$media$PickListEntry == null ? (class$org$dsi$ifc$media$PickListEntry = DSIMediaTracer.class$("org.dsi.ifc.media.PickListEntry")) : class$org$dsi$ifc$media$PickListEntry, 13);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$media$PlaybackMode == null ? (class$org$dsi$ifc$media$PlaybackMode = DSIMediaTracer.class$("org.dsi.ifc.media.PlaybackMode")) : class$org$dsi$ifc$media$PlaybackMode, 14);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$media$SearchListEntry == null ? (class$org$dsi$ifc$media$SearchListEntry = DSIMediaTracer.class$("org.dsi.ifc.media.SearchListEntry")) : class$org$dsi$ifc$media$SearchListEntry, 15);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$media$SearchListEntryExt == null ? (class$org$dsi$ifc$media$SearchListEntryExt = DSIMediaTracer.class$("org.dsi.ifc.media.SearchListEntryExt")) : class$org$dsi$ifc$media$SearchListEntryExt, 16);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$media$TagInformation == null ? (class$org$dsi$ifc$media$TagInformation = DSIMediaTracer.class$("org.dsi.ifc.media.TagInformation")) : class$org$dsi$ifc$media$TagInformation, 17);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceAudioRoute(printWriter, (AudioRoute)object);
                break;
            }
            case 2: {
                this.traceAudioStream(printWriter, (AudioStream)object);
                break;
            }
            case 3: {
                this.traceCapabilities(printWriter, (Capabilities)object);
                break;
            }
            case 4: {
                this.traceChapterInfo(printWriter, (ChapterInfo)object);
                break;
            }
            case 5: {
                this.traceCoverartInfo(printWriter, (CoverartInfo)object);
                break;
            }
            case 6: {
                this.traceDatabaseSpace(printWriter, (DatabaseSpace)object);
                break;
            }
            case 7: {
                this.traceDeviceInfo(printWriter, (DeviceInfo)object);
                break;
            }
            case 8: {
                this.traceEntryInfo(printWriter, (EntryInfo)object);
                break;
            }
            case 9: {
                this.traceListEntry(printWriter, (ListEntry)object);
                break;
            }
            case 10: {
                this.traceListEntryExt(printWriter, (ListEntryExt)object);
                break;
            }
            case 11: {
                this.traceMediaCapabilities(printWriter, (MediaCapabilities)object);
                break;
            }
            case 12: {
                this.traceMediaInfo(printWriter, (MediaInfo)object);
                break;
            }
            case 13: {
                this.tracePickListEntry(printWriter, (PickListEntry)object);
                break;
            }
            case 14: {
                this.tracePlaybackMode(printWriter, (PlaybackMode)object);
                break;
            }
            case 15: {
                this.traceSearchListEntry(printWriter, (SearchListEntry)object);
                break;
            }
            case 16: {
                this.traceSearchListEntryExt(printWriter, (SearchListEntryExt)object);
                break;
            }
            case 17: {
                this.traceTagInformation(printWriter, (TagInformation)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceAudioRoute(PrintWriter printWriter, AudioRoute audioRoute) {
        if (audioRoute == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(audioRoute.routingInput);
        printWriter.print(audioRoute.routingOutput);
        printWriter.print(audioRoute.routeStatus);
    }

    private void traceAudioStream(PrintWriter printWriter, AudioStream audioStream) {
        if (audioStream == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(audioStream.languageCode);
        printWriter.print(audioStream.numChannels);
        printWriter.print(audioStream.audioCoding);
        printWriter.print(audioStream.samplingRate);
        printWriter.print(audioStream.audioLanguageExtension);
    }

    private void traceCapabilities(PrintWriter printWriter, Capabilities capabilities) {
        if (capabilities == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(capabilities.skipFwd);
        printWriter.print(capabilities.skipBwd);
        printWriter.print(capabilities.browseWhilePlay);
        printWriter.print(capabilities.fastFwd);
        printWriter.print(capabilities.fastBwd);
        printWriter.print(capabilities.sloMoFwd);
        printWriter.print(capabilities.sloMoBwd);
        printWriter.print(capabilities.stillFwd);
        printWriter.print(capabilities.stillBwd);
        printWriter.print(capabilities.play);
        printWriter.print(capabilities.resume);
        printWriter.print(capabilities.pause);
        printWriter.print(capabilities.stop);
        printWriter.print(capabilities.setEntry);
        printWriter.print(capabilities.setTimePos);
        printWriter.print(capabilities.playbackModes);
        printWriter.print(capabilities.detailInfos);
        printWriter.print(capabilities.playView);
        printWriter.print(capabilities.playSimilarEntries);
        printWriter.print(capabilities.totalPlaytime);
        printWriter.print(capabilities.extendedPlayView);
        printWriter.print(capabilities.playTime);
        printWriter.print(capabilities.playbackModeTakeOver);
        printWriter.print(capabilities.playbackModeToggle);
    }

    private void traceChapterInfo(PrintWriter printWriter, ChapterInfo chapterInfo) {
        if (chapterInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(chapterInfo.activeChapter);
        printWriter.print(chapterInfo.numChapters);
        printWriter.print(chapterInfo.activeChapterFirstTimePos);
        printWriter.print(chapterInfo.activeChapterLastTimePos);
    }

    private void traceCoverartInfo(PrintWriter printWriter, CoverartInfo coverartInfo) {
        if (coverartInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(coverartInfo.artist);
        printWriter.print(coverartInfo.album);
        printWriter.print(coverartInfo.title);
    }

    private void traceDatabaseSpace(PrintWriter printWriter, DatabaseSpace databaseSpace) {
        if (databaseSpace == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(databaseSpace.size);
        printWriter.print(databaseSpace.sizeAvail);
        printWriter.print(databaseSpace.maxEntries);
        printWriter.print(databaseSpace.numEntries);
    }

    private void traceDeviceInfo(PrintWriter printWriter, DeviceInfo deviceInfo) {
        if (deviceInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(deviceInfo.deviceID);
        printWriter.print(deviceInfo.deviceType);
        printWriter.print(deviceInfo.numSlots);
        printWriter.print(deviceInfo.flags);
    }

    private void traceEntryInfo(PrintWriter printWriter, EntryInfo entryInfo) {
        if (entryInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(entryInfo.entryID);
        printWriter.print(entryInfo.filename);
        printWriter.print(entryInfo.contentType);
        printWriter.print(entryInfo.title);
        printWriter.print(entryInfo.trackNo);
        printWriter.print(entryInfo.numTracks);
        printWriter.print(entryInfo.albumID);
        printWriter.print(entryInfo.artistID);
        printWriter.print(entryInfo.genreID);
        printWriter.print(entryInfo.album);
        printWriter.print(entryInfo.artist);
        printWriter.print(entryInfo.genre);
        printWriter.print(entryInfo.year);
        printWriter.print(entryInfo.comments);
        printWriter.print(entryInfo.avgBitrate);
        printWriter.print(entryInfo.samplingrate);
        printWriter.print(entryInfo.rating);
        printWriter.print(entryInfo.flags);
        this.trace(printWriter, entryInfo.chapterInfo);
    }

    private void traceListEntry(PrintWriter printWriter, ListEntry listEntry) {
        if (listEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(listEntry.entryID);
        printWriter.print(listEntry.filename);
        printWriter.print(listEntry.title);
        printWriter.print(listEntry.contentType);
        printWriter.print(listEntry.secLength);
        printWriter.print(listEntry.flags);
        this.trace(printWriter, listEntry.extInfo);
    }

    private void traceListEntryExt(PrintWriter printWriter, ListEntryExt listEntryExt) {
        if (listEntryExt == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(listEntryExt.album);
        printWriter.print(listEntryExt.albumID);
        printWriter.print(listEntryExt.artist);
        printWriter.print(listEntryExt.artistID);
        this.trace(printWriter, listEntryExt.coverArtResource);
        printWriter.print(listEntryExt.titleID);
        printWriter.print(listEntryExt.fileCount);
        printWriter.print(listEntryExt.folderCount);
        printWriter.print(listEntryExt.playlistCount);
    }

    private void traceMediaCapabilities(PrintWriter printWriter, MediaCapabilities mediaCapabilities) {
        if (mediaCapabilities == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(mediaCapabilities.coverArt);
        printWriter.print(mediaCapabilities.playerCoverArt);
        printWriter.print(mediaCapabilities.browserCoverArt);
        printWriter.print(mediaCapabilities.albumBrowser);
        printWriter.print(mediaCapabilities.searchEntries);
        printWriter.print(mediaCapabilities.importData);
        printWriter.print(mediaCapabilities.rawBrowser);
        printWriter.print(mediaCapabilities.favorites);
        printWriter.print(mediaCapabilities.playbackModes);
        printWriter.print(mediaCapabilities.contentBrowser);
        printWriter.print(mediaCapabilities.videoSupport);
        printWriter.print(mediaCapabilities.remoteApps);
    }

    private void traceMediaInfo(PrintWriter printWriter, MediaInfo mediaInfo) {
        if (mediaInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(mediaInfo.deviceID);
        printWriter.print(mediaInfo.mediaID);
        printWriter.print(mediaInfo.mediaType);
        printWriter.print(mediaInfo.uniqueMediaID);
        printWriter.print(mediaInfo.name);
        printWriter.print(mediaInfo.mountPoint);
        printWriter.print(mediaInfo.flags);
        this.trace(printWriter, mediaInfo.mediaCaps);
    }

    private void tracePickListEntry(PrintWriter printWriter, PickListEntry pickListEntry) {
        if (pickListEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pickListEntry.entryID);
        printWriter.print(pickListEntry.name);
        printWriter.print(pickListEntry.additionalInfo);
        printWriter.print(pickListEntry.additionalInfoEntryFlags);
    }

    private void tracePlaybackMode(PrintWriter printWriter, PlaybackMode playbackMode) {
        if (playbackMode == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(playbackMode.modeID);
        printWriter.print(playbackMode.scope);
        printWriter.print(playbackMode.modeFlag);
    }

    private void traceSearchListEntry(PrintWriter printWriter, SearchListEntry searchListEntry) {
        if (searchListEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(searchListEntry.searchID);
        printWriter.print(searchListEntry.entryID);
        printWriter.print(searchListEntry.description);
        printWriter.print(searchListEntry.tagType);
        printWriter.print(searchListEntry.flags);
    }

    private void traceSearchListEntryExt(PrintWriter printWriter, SearchListEntryExt searchListEntryExt) {
        if (searchListEntryExt == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(searchListEntryExt.searchID);
        printWriter.print(searchListEntryExt.entryID);
        printWriter.print(searchListEntryExt.description);
        printWriter.print(searchListEntryExt.tagType);
        printWriter.print(searchListEntryExt.artistID);
        printWriter.print(searchListEntryExt.artist);
        printWriter.print(searchListEntryExt.albumID);
        printWriter.print(searchListEntryExt.album);
        printWriter.print(searchListEntryExt.flags);
        this.trace(printWriter, searchListEntryExt.coverArtResource);
    }

    private void traceTagInformation(PrintWriter printWriter, TagInformation tagInformation) {
        if (tagInformation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tagInformation.ambiguousTag);
        printWriter.print(tagInformation.buttonPressed);
        printWriter.print(tagInformation.title);
        printWriter.print(tagInformation.artist);
        printWriter.print(tagInformation.songID);
        printWriter.print(tagInformation.stationFrequency);
        printWriter.print(tagInformation.stationCallLetters);
        printWriter.print(tagInformation.stationURL);
        this.trace(printWriter, tagInformation.timeStamp);
        printWriter.print(tagInformation.affiliateID);
        printWriter.print(tagInformation.album);
        printWriter.print(tagInformation.iTunesFrontID);
        printWriter.print(tagInformation.podcastFeedURL);
        printWriter.print(tagInformation.genre);
        printWriter.print(tagInformation.unknownData);
        printWriter.print(tagInformation.programNumber);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

