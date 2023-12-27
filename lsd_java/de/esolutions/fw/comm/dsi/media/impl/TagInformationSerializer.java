/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.comm.dsi.global.impl.DateTimeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.media.TagInformation;

public class TagInformationSerializer {
    public static void putOptionalTagInformation(ISerializer iSerializer, TagInformation tagInformation) {
        boolean bl = tagInformation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = tagInformation.isAmbiguousTag();
            iSerializer.putBool(bl2);
            boolean bl3 = tagInformation.isButtonPressed();
            iSerializer.putBool(bl3);
            String string = tagInformation.getTitle();
            iSerializer.putOptionalString(string);
            String string2 = tagInformation.getArtist();
            iSerializer.putOptionalString(string2);
            String string3 = tagInformation.getSongID();
            iSerializer.putOptionalString(string3);
            String string4 = tagInformation.getStationFrequency();
            iSerializer.putOptionalString(string4);
            String string5 = tagInformation.getStationCallLetters();
            iSerializer.putOptionalString(string5);
            String string6 = tagInformation.getStationURL();
            iSerializer.putOptionalString(string6);
            DateTime dateTime = tagInformation.getTimeStamp();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime);
            String string7 = tagInformation.getAffiliateID();
            iSerializer.putOptionalString(string7);
            String string8 = tagInformation.getAlbum();
            iSerializer.putOptionalString(string8);
            int n = tagInformation.getITunesFrontID();
            iSerializer.putInt32(n);
            int n2 = tagInformation.getPodcastFeedURL();
            iSerializer.putInt32(n2);
            String string9 = tagInformation.getGenre();
            iSerializer.putOptionalString(string9);
            String string10 = tagInformation.getUnknownData();
            iSerializer.putOptionalString(string10);
            int n3 = tagInformation.getProgramNumber();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalTagInformationVarArray(ISerializer iSerializer, TagInformation[] tagInformationArray) {
        boolean bl = tagInformationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tagInformationArray.length);
            for (int i2 = 0; i2 < tagInformationArray.length; ++i2) {
                TagInformationSerializer.putOptionalTagInformation(iSerializer, tagInformationArray[i2]);
            }
        }
    }

    public static TagInformation getOptionalTagInformation(IDeserializer iDeserializer) {
        TagInformation tagInformation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            String string2;
            int n2;
            int n3;
            String string3;
            String string4;
            DateTime dateTime;
            String string5;
            String string6;
            String string7;
            String string8;
            String string9;
            String string10;
            boolean bl2;
            boolean bl3;
            tagInformation = new TagInformation();
            tagInformation.ambiguousTag = bl3 = iDeserializer.getBool();
            tagInformation.buttonPressed = bl2 = iDeserializer.getBool();
            tagInformation.title = string10 = iDeserializer.getOptionalString();
            tagInformation.artist = string9 = iDeserializer.getOptionalString();
            tagInformation.songID = string8 = iDeserializer.getOptionalString();
            tagInformation.stationFrequency = string7 = iDeserializer.getOptionalString();
            tagInformation.stationCallLetters = string6 = iDeserializer.getOptionalString();
            tagInformation.stationURL = string5 = iDeserializer.getOptionalString();
            tagInformation.timeStamp = dateTime = DateTimeSerializer.getOptionalDateTime(iDeserializer);
            tagInformation.affiliateID = string4 = iDeserializer.getOptionalString();
            tagInformation.album = string3 = iDeserializer.getOptionalString();
            tagInformation.iTunesFrontID = n3 = iDeserializer.getInt32();
            tagInformation.podcastFeedURL = n2 = iDeserializer.getInt32();
            tagInformation.genre = string2 = iDeserializer.getOptionalString();
            tagInformation.unknownData = string = iDeserializer.getOptionalString();
            tagInformation.programNumber = n = iDeserializer.getInt32();
        }
        return tagInformation;
    }

    public static TagInformation[] getOptionalTagInformationVarArray(IDeserializer iDeserializer) {
        TagInformation[] tagInformationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tagInformationArray = new TagInformation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tagInformationArray[i2] = TagInformationSerializer.getOptionalTagInformation(iDeserializer);
            }
        }
        return tagInformationArray;
    }
}

