/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radio.TIMMessage;

public class TIMMessageSerializer {
    public static void putOptionalTIMMessage(ISerializer iSerializer, TIMMessage tIMMessage) {
        boolean bl = tIMMessage == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = tIMMessage.getName();
            iSerializer.putOptionalString(string);
            int n = tIMMessage.getPi();
            iSerializer.putInt32(n);
            long l = tIMMessage.getFrequency();
            iSerializer.putInt64(l);
            int n2 = tIMMessage.getMessageID();
            iSerializer.putInt32(n2);
            int n3 = tIMMessage.getLengthSeconds();
            iSerializer.putInt32(n3);
            int n4 = tIMMessage.getLengthMinutes();
            iSerializer.putInt32(n4);
            int n5 = tIMMessage.getRecordTimeSeconds();
            iSerializer.putInt32(n5);
            int n6 = tIMMessage.getRecordTimeMinutes();
            iSerializer.putInt32(n6);
            int n7 = tIMMessage.getRecordTimeHour();
            iSerializer.putInt32(n7);
            int n8 = tIMMessage.getRecordTimeDay();
            iSerializer.putInt32(n8);
            int n9 = tIMMessage.getRecordTimeMonth();
            iSerializer.putInt32(n9);
            int n10 = tIMMessage.getRecordTimeYear();
            iSerializer.putInt32(n10);
        }
    }

    public static void putOptionalTIMMessageVarArray(ISerializer iSerializer, TIMMessage[] tIMMessageArray) {
        boolean bl = tIMMessageArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tIMMessageArray.length);
            for (int i2 = 0; i2 < tIMMessageArray.length; ++i2) {
                TIMMessageSerializer.putOptionalTIMMessage(iSerializer, tIMMessageArray[i2]);
            }
        }
    }

    public static TIMMessage getOptionalTIMMessage(IDeserializer iDeserializer) {
        TIMMessage tIMMessage = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            long l;
            int n10;
            String string;
            tIMMessage = new TIMMessage();
            tIMMessage.name = string = iDeserializer.getOptionalString();
            tIMMessage.pi = n10 = iDeserializer.getInt32();
            tIMMessage.frequency = l = iDeserializer.getInt64();
            tIMMessage.messageID = n9 = iDeserializer.getInt32();
            tIMMessage.lengthSeconds = n8 = iDeserializer.getInt32();
            tIMMessage.lengthMinutes = n7 = iDeserializer.getInt32();
            tIMMessage.recordTimeSeconds = n6 = iDeserializer.getInt32();
            tIMMessage.recordTimeMinutes = n5 = iDeserializer.getInt32();
            tIMMessage.recordTimeHour = n4 = iDeserializer.getInt32();
            tIMMessage.recordTimeDay = n3 = iDeserializer.getInt32();
            tIMMessage.recordTimeMonth = n2 = iDeserializer.getInt32();
            tIMMessage.recordTimeYear = n = iDeserializer.getInt32();
        }
        return tIMMessage;
    }

    public static TIMMessage[] getOptionalTIMMessageVarArray(IDeserializer iDeserializer) {
        TIMMessage[] tIMMessageArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tIMMessageArray = new TIMMessage[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tIMMessageArray[i2] = TIMMessageSerializer.getOptionalTIMMessage(iDeserializer);
            }
        }
        return tIMMessageArray;
    }
}

