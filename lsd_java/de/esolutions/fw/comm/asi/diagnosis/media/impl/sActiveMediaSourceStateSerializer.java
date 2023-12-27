/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.media.impl;

import de.esolutions.fw.comm.asi.diagnosis.media.sActiveMediaSourceState;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sActiveMediaSourceStateSerializer {
    public static void putOptionalsActiveMediaSourceState(ISerializer iSerializer, sActiveMediaSourceState sActiveMediaSourceState2) {
        boolean bl = sActiveMediaSourceState2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sActiveMediaSourceState2.getMsg_id();
            iSerializer.putUInt32(l);
            int n = sActiveMediaSourceState2.getTerminalNumber();
            iSerializer.putEnum(n);
            int n2 = sActiveMediaSourceState2.getActiveSource();
            iSerializer.putEnum(n2);
            String string = sActiveMediaSourceState2.getVideoCodec();
            iSerializer.putOptionalString(string);
            int n3 = sActiveMediaSourceState2.getVideoResolutionVertical();
            iSerializer.putUInt16(n3);
            int n4 = sActiveMediaSourceState2.getVideoResolutionHorizontal();
            iSerializer.putUInt16(n4);
            int n5 = sActiveMediaSourceState2.getVideoBitrate();
            iSerializer.putUInt16(n5);
            String string2 = sActiveMediaSourceState2.getAudioCodec();
            iSerializer.putOptionalString(string2);
            int n6 = sActiveMediaSourceState2.getAudioBitrate();
            iSerializer.putUInt16(n6);
            String string3 = sActiveMediaSourceState2.getPictureFormat();
            iSerializer.putOptionalString(string3);
            int n7 = sActiveMediaSourceState2.getPictureResolutionVertical();
            iSerializer.putUInt16(n7);
            int n8 = sActiveMediaSourceState2.getPictureResolutionHorizontal();
            iSerializer.putUInt16(n8);
            int n9 = sActiveMediaSourceState2.getPictureTone();
            iSerializer.putUInt16(n9);
            int n10 = sActiveMediaSourceState2.getDrmState();
            iSerializer.putEnum(n10);
        }
    }

    public static void putOptionalsActiveMediaSourceStateVarArray(ISerializer iSerializer, sActiveMediaSourceState[] sActiveMediaSourceStateArray) {
        boolean bl = sActiveMediaSourceStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sActiveMediaSourceStateArray.length);
            for (int i2 = 0; i2 < sActiveMediaSourceStateArray.length; ++i2) {
                sActiveMediaSourceStateSerializer.putOptionalsActiveMediaSourceState(iSerializer, sActiveMediaSourceStateArray[i2]);
            }
        }
    }

    public static sActiveMediaSourceState getOptionalsActiveMediaSourceState(IDeserializer iDeserializer) {
        sActiveMediaSourceState sActiveMediaSourceState2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            String string;
            int n5;
            String string2;
            int n6;
            int n7;
            int n8;
            String string3;
            int n9;
            int n10;
            long l;
            sActiveMediaSourceState2 = new sActiveMediaSourceState();
            sActiveMediaSourceState2.msg_id = l = iDeserializer.getUInt32();
            sActiveMediaSourceState2.terminalNumber = n10 = iDeserializer.getEnum();
            sActiveMediaSourceState2.activeSource = n9 = iDeserializer.getEnum();
            sActiveMediaSourceState2.videoCodec = string3 = iDeserializer.getOptionalString();
            sActiveMediaSourceState2.videoResolutionVertical = n8 = iDeserializer.getUInt16();
            sActiveMediaSourceState2.videoResolutionHorizontal = n7 = iDeserializer.getUInt16();
            sActiveMediaSourceState2.videoBitrate = n6 = iDeserializer.getUInt16();
            sActiveMediaSourceState2.audioCodec = string2 = iDeserializer.getOptionalString();
            sActiveMediaSourceState2.audioBitrate = n5 = iDeserializer.getUInt16();
            sActiveMediaSourceState2.pictureFormat = string = iDeserializer.getOptionalString();
            sActiveMediaSourceState2.pictureResolutionVertical = n4 = iDeserializer.getUInt16();
            sActiveMediaSourceState2.pictureResolutionHorizontal = n3 = iDeserializer.getUInt16();
            sActiveMediaSourceState2.pictureTone = n2 = iDeserializer.getUInt16();
            sActiveMediaSourceState2.drmState = n = iDeserializer.getEnum();
        }
        return sActiveMediaSourceState2;
    }

    public static sActiveMediaSourceState[] getOptionalsActiveMediaSourceStateVarArray(IDeserializer iDeserializer) {
        sActiveMediaSourceState[] sActiveMediaSourceStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sActiveMediaSourceStateArray = new sActiveMediaSourceState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sActiveMediaSourceStateArray[i2] = sActiveMediaSourceStateSerializer.getOptionalsActiveMediaSourceState(iDeserializer);
            }
        }
        return sActiveMediaSourceStateArray;
    }
}

