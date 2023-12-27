/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.media.MediaCapabilities;

public class MediaCapabilitiesSerializer {
    public static void putOptionalMediaCapabilities(ISerializer iSerializer, MediaCapabilities mediaCapabilities) {
        boolean bl = mediaCapabilities == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = mediaCapabilities.isCoverArt();
            iSerializer.putBool(bl2);
            boolean bl3 = mediaCapabilities.isPlayerCoverArt();
            iSerializer.putBool(bl3);
            boolean bl4 = mediaCapabilities.isBrowserCoverArt();
            iSerializer.putBool(bl4);
            boolean bl5 = mediaCapabilities.isAlbumBrowser();
            iSerializer.putBool(bl5);
            boolean bl6 = mediaCapabilities.isSearchEntries();
            iSerializer.putBool(bl6);
            boolean bl7 = mediaCapabilities.isImportData();
            iSerializer.putBool(bl7);
            boolean bl8 = mediaCapabilities.isRawBrowser();
            iSerializer.putBool(bl8);
            boolean bl9 = mediaCapabilities.isFavorites();
            iSerializer.putBool(bl9);
            boolean bl10 = mediaCapabilities.isPlaybackModes();
            iSerializer.putBool(bl10);
            boolean bl11 = mediaCapabilities.isContentBrowser();
            iSerializer.putBool(bl11);
            boolean bl12 = mediaCapabilities.isVideoSupport();
            iSerializer.putBool(bl12);
            boolean bl13 = mediaCapabilities.isRemoteApps();
            iSerializer.putBool(bl13);
        }
    }

    public static void putOptionalMediaCapabilitiesVarArray(ISerializer iSerializer, MediaCapabilities[] mediaCapabilitiesArray) {
        boolean bl = mediaCapabilitiesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(mediaCapabilitiesArray.length);
            for (int i2 = 0; i2 < mediaCapabilitiesArray.length; ++i2) {
                MediaCapabilitiesSerializer.putOptionalMediaCapabilities(iSerializer, mediaCapabilitiesArray[i2]);
            }
        }
    }

    public static MediaCapabilities getOptionalMediaCapabilities(IDeserializer iDeserializer) {
        MediaCapabilities mediaCapabilities = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            boolean bl9;
            boolean bl10;
            boolean bl11;
            boolean bl12;
            boolean bl13;
            mediaCapabilities = new MediaCapabilities();
            mediaCapabilities.coverArt = bl13 = iDeserializer.getBool();
            mediaCapabilities.playerCoverArt = bl12 = iDeserializer.getBool();
            mediaCapabilities.browserCoverArt = bl11 = iDeserializer.getBool();
            mediaCapabilities.albumBrowser = bl10 = iDeserializer.getBool();
            mediaCapabilities.searchEntries = bl9 = iDeserializer.getBool();
            mediaCapabilities.importData = bl8 = iDeserializer.getBool();
            mediaCapabilities.rawBrowser = bl7 = iDeserializer.getBool();
            mediaCapabilities.favorites = bl6 = iDeserializer.getBool();
            mediaCapabilities.playbackModes = bl5 = iDeserializer.getBool();
            mediaCapabilities.contentBrowser = bl4 = iDeserializer.getBool();
            mediaCapabilities.videoSupport = bl3 = iDeserializer.getBool();
            mediaCapabilities.remoteApps = bl2 = iDeserializer.getBool();
        }
        return mediaCapabilities;
    }

    public static MediaCapabilities[] getOptionalMediaCapabilitiesVarArray(IDeserializer iDeserializer) {
        MediaCapabilities[] mediaCapabilitiesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            mediaCapabilitiesArray = new MediaCapabilities[n];
            for (int i2 = 0; i2 < n; ++i2) {
                mediaCapabilitiesArray[i2] = MediaCapabilitiesSerializer.getOptionalMediaCapabilities(iDeserializer);
            }
        }
        return mediaCapabilitiesArray;
    }
}

