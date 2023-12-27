/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tvtuner.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.tvtuner.StartUpConfig;

public class StartUpConfigSerializer {
    public static void putOptionalStartUpConfig(ISerializer iSerializer, StartUpConfig startUpConfig) {
        boolean bl = startUpConfig == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = startUpConfig.getSystemID();
            iSerializer.putInt32(n);
            int n2 = startUpConfig.getOemCodingVar();
            iSerializer.putInt32(n2);
            boolean bl2 = startUpConfig.isLinkingAvail();
            iSerializer.putBool(bl2);
            boolean bl3 = startUpConfig.isAvSrcAvail();
            iSerializer.putBool(bl3);
            boolean bl4 = startUpConfig.isTvNormAvail();
            iSerializer.putBool(bl4);
            boolean bl5 = startUpConfig.isAudioChannelAvail();
            iSerializer.putBool(bl5);
            boolean bl6 = startUpConfig.isVideoFormatAvail();
            iSerializer.putBool(bl6);
            boolean bl7 = startUpConfig.isAvNormAvail();
            iSerializer.putBool(bl7);
            boolean bl8 = startUpConfig.isAvFormatAvail();
            iSerializer.putBool(bl8);
            boolean bl9 = startUpConfig.isSubtitleAvail();
            iSerializer.putBool(bl9);
            boolean bl10 = startUpConfig.isEwsAvail();
            iSerializer.putBool(bl10);
            boolean bl11 = startUpConfig.isLogoListAvail();
            iSerializer.putBool(bl11);
            boolean bl12 = startUpConfig.isTpegAvail();
            iSerializer.putBool(bl12);
            boolean bl13 = startUpConfig.isCasAvail();
            iSerializer.putBool(bl13);
            boolean bl14 = startUpConfig.isSkipBehaviourAvail();
            iSerializer.putBool(bl14);
            boolean bl15 = startUpConfig.isVisualAudioAvail();
            iSerializer.putBool(bl15);
            boolean bl16 = startUpConfig.isTmTeletextAvail();
            iSerializer.putBool(bl16);
            boolean bl17 = startUpConfig.isTmDatabroadDVBAvail();
            iSerializer.putBool(bl17);
            boolean bl18 = startUpConfig.isTmDatabroadISDBAvail();
            iSerializer.putBool(bl18);
            boolean bl19 = startUpConfig.isTmDatabroadDTMBAvail();
            iSerializer.putBool(bl19);
            boolean bl20 = startUpConfig.isTmDatabroadDMBAvail();
            iSerializer.putBool(bl20);
            boolean bl21 = startUpConfig.isTmDatabroadATSCAvail();
            iSerializer.putBool(bl21);
            boolean bl22 = startUpConfig.isTmDatabroad1Avail();
            iSerializer.putBool(bl22);
            boolean bl23 = startUpConfig.isTmDatabroad2Avail();
            iSerializer.putBool(bl23);
            boolean bl24 = startUpConfig.isTmBWSAvail();
            iSerializer.putBool(bl24);
            boolean bl25 = startUpConfig.isTmSLSDLSAvail();
            iSerializer.putBool(bl25);
            boolean bl26 = startUpConfig.isTmTXTAvail();
            iSerializer.putBool(bl26);
            boolean bl27 = startUpConfig.isTmCASAvail();
            iSerializer.putBool(bl27);
            boolean bl28 = startUpConfig.isTmEPGAvail();
            iSerializer.putBool(bl28);
            boolean bl29 = startUpConfig.isTmVisualAudioAvail();
            iSerializer.putBool(bl29);
            short[] sArray = startUpConfig.getRequiredKeypanelList();
            iSerializer.putOptionalInt16VarArray(sArray);
            boolean bl30 = startUpConfig.isBrowserListSortAvail();
            iSerializer.putBool(bl30);
            boolean bl31 = startUpConfig.isParentalControlReq();
            iSerializer.putBool(bl31);
        }
    }

    public static void putOptionalStartUpConfigVarArray(ISerializer iSerializer, StartUpConfig[] startUpConfigArray) {
        boolean bl = startUpConfigArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(startUpConfigArray.length);
            for (int i2 = 0; i2 < startUpConfigArray.length; ++i2) {
                StartUpConfigSerializer.putOptionalStartUpConfig(iSerializer, startUpConfigArray[i2]);
            }
        }
    }

    public static StartUpConfig getOptionalStartUpConfig(IDeserializer iDeserializer) {
        StartUpConfig startUpConfig = null;
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
            boolean bl26;
            boolean bl27;
            boolean bl28;
            boolean bl29;
            boolean bl30;
            boolean bl31;
            int n;
            int n2;
            startUpConfig = new StartUpConfig();
            startUpConfig.systemID = n2 = iDeserializer.getInt32();
            startUpConfig.oemCodingVar = n = iDeserializer.getInt32();
            startUpConfig.linkingAvail = bl31 = iDeserializer.getBool();
            startUpConfig.avSrcAvail = bl30 = iDeserializer.getBool();
            startUpConfig.tvNormAvail = bl29 = iDeserializer.getBool();
            startUpConfig.audioChannelAvail = bl28 = iDeserializer.getBool();
            startUpConfig.videoFormatAvail = bl27 = iDeserializer.getBool();
            startUpConfig.avNormAvail = bl26 = iDeserializer.getBool();
            startUpConfig.avFormatAvail = bl25 = iDeserializer.getBool();
            startUpConfig.subtitleAvail = bl24 = iDeserializer.getBool();
            startUpConfig.ewsAvail = bl23 = iDeserializer.getBool();
            startUpConfig.logoListAvail = bl22 = iDeserializer.getBool();
            startUpConfig.tpegAvail = bl21 = iDeserializer.getBool();
            startUpConfig.casAvail = bl20 = iDeserializer.getBool();
            startUpConfig.skipBehaviourAvail = bl19 = iDeserializer.getBool();
            startUpConfig.visualAudioAvail = bl18 = iDeserializer.getBool();
            startUpConfig.tmTeletextAvail = bl17 = iDeserializer.getBool();
            startUpConfig.tmDatabroadDVBAvail = bl16 = iDeserializer.getBool();
            startUpConfig.tmDatabroadISDBAvail = bl15 = iDeserializer.getBool();
            startUpConfig.tmDatabroadDTMBAvail = bl14 = iDeserializer.getBool();
            startUpConfig.tmDatabroadDMBAvail = bl13 = iDeserializer.getBool();
            startUpConfig.tmDatabroadATSCAvail = bl12 = iDeserializer.getBool();
            startUpConfig.tmDatabroad1Avail = bl11 = iDeserializer.getBool();
            startUpConfig.tmDatabroad2Avail = bl10 = iDeserializer.getBool();
            startUpConfig.tmBWSAvail = bl9 = iDeserializer.getBool();
            startUpConfig.tmSLSDLSAvail = bl8 = iDeserializer.getBool();
            startUpConfig.tmTXTAvail = bl7 = iDeserializer.getBool();
            startUpConfig.tmCASAvail = bl6 = iDeserializer.getBool();
            startUpConfig.tmEPGAvail = bl5 = iDeserializer.getBool();
            startUpConfig.tmVisualAudioAvail = bl4 = iDeserializer.getBool();
            short[] sArray = iDeserializer.getOptionalInt16VarArray();
            startUpConfig.requiredKeypanelList = sArray;
            startUpConfig.browserListSortAvail = bl3 = iDeserializer.getBool();
            startUpConfig.parentalControlReq = bl2 = iDeserializer.getBool();
        }
        return startUpConfig;
    }

    public static StartUpConfig[] getOptionalStartUpConfigVarArray(IDeserializer iDeserializer) {
        StartUpConfig[] startUpConfigArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            startUpConfigArray = new StartUpConfig[n];
            for (int i2 = 0; i2 < n; ++i2) {
                startUpConfigArray[i2] = StartUpConfigSerializer.getOptionalStartUpConfig(iDeserializer);
            }
        }
        return startUpConfigArray;
    }
}

