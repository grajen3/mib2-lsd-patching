/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.dsi.online.impl.PoiOnlineRecognitionListElementSerializer;
import de.esolutions.fw.comm.dsi.online.impl.PoiOnlineSearchValuelistElementSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.PoiOnlineRecognitionListElement;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public class PoiOnlineSearchValuelistSerializer {
    public static void putOptionalPoiOnlineSearchValuelist(ISerializer iSerializer, PoiOnlineSearchValuelist poiOnlineSearchValuelist) {
        boolean bl = poiOnlineSearchValuelist == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = poiOnlineSearchValuelist.getSourceID();
            iSerializer.putInt32(n);
            String string = poiOnlineSearchValuelist.getSourceName();
            iSerializer.putOptionalString(string);
            int n2 = poiOnlineSearchValuelist.getVoiceRecognizerSourceID();
            iSerializer.putInt32(n2);
            String string2 = poiOnlineSearchValuelist.getVoiceRecognizerSourceName();
            iSerializer.putOptionalString(string2);
            int n3 = poiOnlineSearchValuelist.getVoiceRecognizerAudioFormat();
            iSerializer.putInt32(n3);
            PoiOnlineRecognitionListElement[] poiOnlineRecognitionListElementArray = poiOnlineSearchValuelist.getRecognitionList();
            PoiOnlineRecognitionListElementSerializer.putOptionalPoiOnlineRecognitionListElementVarArray(iSerializer, poiOnlineRecognitionListElementArray);
            String string3 = poiOnlineSearchValuelist.getImageUrl();
            iSerializer.putOptionalString(string3);
            String string4 = poiOnlineSearchValuelist.getImageCheckSum();
            iSerializer.putOptionalString(string4);
            String string5 = poiOnlineSearchValuelist.getImageVoiceUrl();
            iSerializer.putOptionalString(string5);
            String string6 = poiOnlineSearchValuelist.getImageVoiceCheckSum();
            iSerializer.putOptionalString(string6);
            String string7 = poiOnlineSearchValuelist.getImageMapUrl();
            iSerializer.putOptionalString(string7);
            String string8 = poiOnlineSearchValuelist.getImageMapCheckSum();
            iSerializer.putOptionalString(string8);
            int n4 = poiOnlineSearchValuelist.getSortKey();
            iSerializer.putInt32(n4);
            PoiOnlineSearchValuelistElement[] poiOnlineSearchValuelistElementArray = poiOnlineSearchValuelist.getList();
            PoiOnlineSearchValuelistElementSerializer.putOptionalPoiOnlineSearchValuelistElementVarArray(iSerializer, poiOnlineSearchValuelistElementArray);
        }
    }

    public static void putOptionalPoiOnlineSearchValuelistVarArray(ISerializer iSerializer, PoiOnlineSearchValuelist[] poiOnlineSearchValuelistArray) {
        boolean bl = poiOnlineSearchValuelistArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(poiOnlineSearchValuelistArray.length);
            for (int i2 = 0; i2 < poiOnlineSearchValuelistArray.length; ++i2) {
                PoiOnlineSearchValuelistSerializer.putOptionalPoiOnlineSearchValuelist(iSerializer, poiOnlineSearchValuelistArray[i2]);
            }
        }
    }

    public static PoiOnlineSearchValuelist getOptionalPoiOnlineSearchValuelist(IDeserializer iDeserializer) {
        PoiOnlineSearchValuelist poiOnlineSearchValuelist = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            int n2;
            String string7;
            int n3;
            String string8;
            int n4;
            poiOnlineSearchValuelist = new PoiOnlineSearchValuelist();
            poiOnlineSearchValuelist.sourceID = n4 = iDeserializer.getInt32();
            poiOnlineSearchValuelist.sourceName = string8 = iDeserializer.getOptionalString();
            poiOnlineSearchValuelist.voiceRecognizerSourceID = n3 = iDeserializer.getInt32();
            poiOnlineSearchValuelist.voiceRecognizerSourceName = string7 = iDeserializer.getOptionalString();
            poiOnlineSearchValuelist.voiceRecognizerAudioFormat = n2 = iDeserializer.getInt32();
            PoiOnlineRecognitionListElement[] poiOnlineRecognitionListElementArray = PoiOnlineRecognitionListElementSerializer.getOptionalPoiOnlineRecognitionListElementVarArray(iDeserializer);
            poiOnlineSearchValuelist.recognitionList = poiOnlineRecognitionListElementArray;
            poiOnlineSearchValuelist.imageUrl = string6 = iDeserializer.getOptionalString();
            poiOnlineSearchValuelist.imageCheckSum = string5 = iDeserializer.getOptionalString();
            poiOnlineSearchValuelist.imageVoiceUrl = string4 = iDeserializer.getOptionalString();
            poiOnlineSearchValuelist.imageVoiceCheckSum = string3 = iDeserializer.getOptionalString();
            poiOnlineSearchValuelist.imageMapUrl = string2 = iDeserializer.getOptionalString();
            poiOnlineSearchValuelist.imageMapCheckSum = string = iDeserializer.getOptionalString();
            poiOnlineSearchValuelist.sortKey = n = iDeserializer.getInt32();
            PoiOnlineSearchValuelistElement[] poiOnlineSearchValuelistElementArray = PoiOnlineSearchValuelistElementSerializer.getOptionalPoiOnlineSearchValuelistElementVarArray(iDeserializer);
            poiOnlineSearchValuelist.list = poiOnlineSearchValuelistElementArray;
        }
        return poiOnlineSearchValuelist;
    }

    public static PoiOnlineSearchValuelist[] getOptionalPoiOnlineSearchValuelistVarArray(IDeserializer iDeserializer) {
        PoiOnlineSearchValuelist[] poiOnlineSearchValuelistArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            poiOnlineSearchValuelistArray = new PoiOnlineSearchValuelist[n];
            for (int i2 = 0; i2 < n; ++i2) {
                poiOnlineSearchValuelistArray[i2] = PoiOnlineSearchValuelistSerializer.getOptionalPoiOnlineSearchValuelist(iDeserializer);
            }
        }
        return poiOnlineSearchValuelistArray;
    }
}

