/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.HdStationInfo;

public class HdStationInfoSerializer {
    public static void putOptionalHdStationInfo(ISerializer iSerializer, HdStationInfo hdStationInfo) {
        boolean bl = hdStationInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = hdStationInfo.getArtistName();
            iSerializer.putOptionalString(string);
            String string2 = hdStationInfo.getAlbumTitle();
            iSerializer.putOptionalString(string2);
            String string3 = hdStationInfo.getSongTitle();
            iSerializer.putOptionalString(string3);
            String string4 = hdStationInfo.getGenre();
            iSerializer.putOptionalString(string4);
            ResourceLocator resourceLocator = hdStationInfo.getStationArt();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
            ResourceLocator resourceLocator2 = hdStationInfo.getCoverArt();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator2);
            String string5 = hdStationInfo.getLanguage();
            iSerializer.putOptionalString(string5);
            String string6 = hdStationInfo.getShortDescription();
            iSerializer.putOptionalString(string6);
            String string7 = hdStationInfo.getContentField();
            iSerializer.putOptionalString(string7);
            String string8 = hdStationInfo.getPrice();
            iSerializer.putOptionalString(string8);
            String string9 = hdStationInfo.getValidUntil();
            iSerializer.putOptionalString(string9);
            String string10 = hdStationInfo.getContactURL();
            iSerializer.putOptionalString(string10);
            short s = hdStationInfo.getReceivedAs();
            iSerializer.putInt16(s);
            String string11 = hdStationInfo.getNameOfSeller();
            iSerializer.putOptionalString(string11);
            String string12 = hdStationInfo.getComrDescription();
            iSerializer.putOptionalString(string12);
            String string13 = hdStationInfo.getMimeType();
            iSerializer.putOptionalString(string13);
            byte[] byArray = hdStationInfo.getBinaryData();
            iSerializer.putOptionalInt8VarArray(byArray);
            String string14 = hdStationInfo.getAffiliateID();
            iSerializer.putOptionalString(string14);
            String string15 = hdStationInfo.getITunesID();
            iSerializer.putOptionalString(string15);
            int n = hdStationInfo.getITunesFrontID();
            iSerializer.putInt32(n);
            int n2 = hdStationInfo.getPodcastFeedURL();
            iSerializer.putInt32(n2);
            String string16 = hdStationInfo.getUnknownData();
            iSerializer.putOptionalString(string16);
            int n3 = hdStationInfo.getFrequency();
            iSerializer.putInt32(n3);
            int n4 = hdStationInfo.getPi();
            iSerializer.putInt32(n4);
            int n5 = hdStationInfo.getServiceId();
            iSerializer.putInt32(n5);
            String string17 = hdStationInfo.getStationURL();
            iSerializer.putOptionalString(string17);
        }
    }

    public static void putOptionalHdStationInfoVarArray(ISerializer iSerializer, HdStationInfo[] hdStationInfoArray) {
        boolean bl = hdStationInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(hdStationInfoArray.length);
            for (int i2 = 0; i2 < hdStationInfoArray.length; ++i2) {
                HdStationInfoSerializer.putOptionalHdStationInfo(iSerializer, hdStationInfoArray[i2]);
            }
        }
    }

    public static HdStationInfo getOptionalHdStationInfo(IDeserializer iDeserializer) {
        HdStationInfo hdStationInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            int n2;
            int n3;
            String string2;
            int n4;
            int n5;
            String string3;
            String string4;
            String string5;
            String string6;
            String string7;
            short s;
            String string8;
            String string9;
            String string10;
            String string11;
            String string12;
            String string13;
            ResourceLocator resourceLocator;
            ResourceLocator resourceLocator2;
            String string14;
            String string15;
            String string16;
            String string17;
            hdStationInfo = new HdStationInfo();
            hdStationInfo.artistName = string17 = iDeserializer.getOptionalString();
            hdStationInfo.albumTitle = string16 = iDeserializer.getOptionalString();
            hdStationInfo.songTitle = string15 = iDeserializer.getOptionalString();
            hdStationInfo.genre = string14 = iDeserializer.getOptionalString();
            hdStationInfo.stationArt = resourceLocator2 = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
            hdStationInfo.coverArt = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
            hdStationInfo.language = string13 = iDeserializer.getOptionalString();
            hdStationInfo.shortDescription = string12 = iDeserializer.getOptionalString();
            hdStationInfo.contentField = string11 = iDeserializer.getOptionalString();
            hdStationInfo.price = string10 = iDeserializer.getOptionalString();
            hdStationInfo.validUntil = string9 = iDeserializer.getOptionalString();
            hdStationInfo.contactURL = string8 = iDeserializer.getOptionalString();
            hdStationInfo.receivedAs = s = iDeserializer.getInt16();
            hdStationInfo.nameOfSeller = string7 = iDeserializer.getOptionalString();
            hdStationInfo.comrDescription = string6 = iDeserializer.getOptionalString();
            hdStationInfo.mimeType = string5 = iDeserializer.getOptionalString();
            byte[] byArray = iDeserializer.getOptionalInt8VarArray();
            hdStationInfo.binaryData = byArray;
            hdStationInfo.affiliateID = string4 = iDeserializer.getOptionalString();
            hdStationInfo.iTunesID = string3 = iDeserializer.getOptionalString();
            hdStationInfo.iTunesFrontID = n5 = iDeserializer.getInt32();
            hdStationInfo.podcastFeedURL = n4 = iDeserializer.getInt32();
            hdStationInfo.unknownData = string2 = iDeserializer.getOptionalString();
            hdStationInfo.frequency = n3 = iDeserializer.getInt32();
            hdStationInfo.pi = n2 = iDeserializer.getInt32();
            hdStationInfo.serviceId = n = iDeserializer.getInt32();
            hdStationInfo.stationURL = string = iDeserializer.getOptionalString();
        }
        return hdStationInfo;
    }

    public static HdStationInfo[] getOptionalHdStationInfoVarArray(IDeserializer iDeserializer) {
        HdStationInfo[] hdStationInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            hdStationInfoArray = new HdStationInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                hdStationInfoArray[i2] = HdStationInfoSerializer.getOptionalHdStationInfo(iDeserializer);
            }
        }
        return hdStationInfoArray;
    }
}

