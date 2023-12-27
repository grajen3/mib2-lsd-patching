/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.media.Capabilities;

public class CapabilitiesSerializer {
    public static void putOptionalCapabilities(ISerializer iSerializer, Capabilities capabilities) {
        boolean bl = capabilities == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = capabilities.isSkipFwd();
            iSerializer.putBool(bl2);
            boolean bl3 = capabilities.isSkipBwd();
            iSerializer.putBool(bl3);
            boolean bl4 = capabilities.isBrowseWhilePlay();
            iSerializer.putBool(bl4);
            boolean bl5 = capabilities.isFastFwd();
            iSerializer.putBool(bl5);
            boolean bl6 = capabilities.isFastBwd();
            iSerializer.putBool(bl6);
            boolean bl7 = capabilities.isSloMoFwd();
            iSerializer.putBool(bl7);
            boolean bl8 = capabilities.isSloMoBwd();
            iSerializer.putBool(bl8);
            boolean bl9 = capabilities.isStillFwd();
            iSerializer.putBool(bl9);
            boolean bl10 = capabilities.isStillBwd();
            iSerializer.putBool(bl10);
            boolean bl11 = capabilities.isPlay();
            iSerializer.putBool(bl11);
            boolean bl12 = capabilities.isResume();
            iSerializer.putBool(bl12);
            boolean bl13 = capabilities.isPause();
            iSerializer.putBool(bl13);
            boolean bl14 = capabilities.isStop();
            iSerializer.putBool(bl14);
            boolean bl15 = capabilities.isSetEntry();
            iSerializer.putBool(bl15);
            boolean bl16 = capabilities.isSetTimePos();
            iSerializer.putBool(bl16);
            boolean bl17 = capabilities.isPlaybackModes();
            iSerializer.putBool(bl17);
            boolean bl18 = capabilities.isDetailInfos();
            iSerializer.putBool(bl18);
            boolean bl19 = capabilities.isPlayView();
            iSerializer.putBool(bl19);
            boolean bl20 = capabilities.isPlaySimilarEntries();
            iSerializer.putBool(bl20);
            boolean bl21 = capabilities.isTotalPlaytime();
            iSerializer.putBool(bl21);
            boolean bl22 = capabilities.isExtendedPlayView();
            iSerializer.putBool(bl22);
            boolean bl23 = capabilities.isPlayTime();
            iSerializer.putBool(bl23);
            boolean bl24 = capabilities.isPlaybackModeTakeOver();
            iSerializer.putBool(bl24);
            boolean bl25 = capabilities.isPlaybackModeToggle();
            iSerializer.putBool(bl25);
        }
    }

    public static void putOptionalCapabilitiesVarArray(ISerializer iSerializer, Capabilities[] capabilitiesArray) {
        boolean bl = capabilitiesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(capabilitiesArray.length);
            for (int i2 = 0; i2 < capabilitiesArray.length; ++i2) {
                CapabilitiesSerializer.putOptionalCapabilities(iSerializer, capabilitiesArray[i2]);
            }
        }
    }

    public static Capabilities getOptionalCapabilities(IDeserializer iDeserializer) {
        Capabilities capabilities = null;
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
            boolean bl14;
            boolean bl15;
            boolean bl16;
            boolean bl17;
            boolean bl18;
            boolean bl19;
            boolean bl20;
            boolean bl21;
            boolean bl22;
            boolean bl23;
            boolean bl24;
            boolean bl25;
            capabilities = new Capabilities();
            capabilities.skipFwd = bl25 = iDeserializer.getBool();
            capabilities.skipBwd = bl24 = iDeserializer.getBool();
            capabilities.browseWhilePlay = bl23 = iDeserializer.getBool();
            capabilities.fastFwd = bl22 = iDeserializer.getBool();
            capabilities.fastBwd = bl21 = iDeserializer.getBool();
            capabilities.sloMoFwd = bl20 = iDeserializer.getBool();
            capabilities.sloMoBwd = bl19 = iDeserializer.getBool();
            capabilities.stillFwd = bl18 = iDeserializer.getBool();
            capabilities.stillBwd = bl17 = iDeserializer.getBool();
            capabilities.play = bl16 = iDeserializer.getBool();
            capabilities.resume = bl15 = iDeserializer.getBool();
            capabilities.pause = bl14 = iDeserializer.getBool();
            capabilities.stop = bl13 = iDeserializer.getBool();
            capabilities.setEntry = bl12 = iDeserializer.getBool();
            capabilities.setTimePos = bl11 = iDeserializer.getBool();
            capabilities.playbackModes = bl10 = iDeserializer.getBool();
            capabilities.detailInfos = bl9 = iDeserializer.getBool();
            capabilities.playView = bl8 = iDeserializer.getBool();
            capabilities.playSimilarEntries = bl7 = iDeserializer.getBool();
            capabilities.totalPlaytime = bl6 = iDeserializer.getBool();
            capabilities.extendedPlayView = bl5 = iDeserializer.getBool();
            capabilities.playTime = bl4 = iDeserializer.getBool();
            capabilities.playbackModeTakeOver = bl3 = iDeserializer.getBool();
            capabilities.playbackModeToggle = bl2 = iDeserializer.getBool();
        }
        return capabilities;
    }

    public static Capabilities[] getOptionalCapabilitiesVarArray(IDeserializer iDeserializer) {
        Capabilities[] capabilitiesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            capabilitiesArray = new Capabilities[n];
            for (int i2 = 0; i2 < n; ++i2) {
                capabilitiesArray[i2] = CapabilitiesSerializer.getOptionalCapabilities(iDeserializer);
            }
        }
        return capabilitiesArray;
    }
}

