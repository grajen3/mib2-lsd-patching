/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;

public class CharismaListUpdateInfoSerializer {
    public static void putOptionalCharismaListUpdateInfo(ISerializer iSerializer, CharismaListUpdateInfo charismaListUpdateInfo) {
        boolean bl = charismaListUpdateInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = charismaListUpdateInfo.getProfileID();
            iSerializer.putInt32(n);
            int n2 = charismaListUpdateInfo.getArrayContent();
            iSerializer.putInt32(n2);
            int n3 = charismaListUpdateInfo.getRecordContent();
            iSerializer.putInt32(n3);
            int n4 = charismaListUpdateInfo.getStartElement();
            iSerializer.putInt32(n4);
            int n5 = charismaListUpdateInfo.getNumOfElements();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalCharismaListUpdateInfoVarArray(ISerializer iSerializer, CharismaListUpdateInfo[] charismaListUpdateInfoArray) {
        boolean bl = charismaListUpdateInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(charismaListUpdateInfoArray.length);
            for (int i2 = 0; i2 < charismaListUpdateInfoArray.length; ++i2) {
                CharismaListUpdateInfoSerializer.putOptionalCharismaListUpdateInfo(iSerializer, charismaListUpdateInfoArray[i2]);
            }
        }
    }

    public static CharismaListUpdateInfo getOptionalCharismaListUpdateInfo(IDeserializer iDeserializer) {
        CharismaListUpdateInfo charismaListUpdateInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            charismaListUpdateInfo = new CharismaListUpdateInfo();
            charismaListUpdateInfo.profileID = n5 = iDeserializer.getInt32();
            charismaListUpdateInfo.arrayContent = n4 = iDeserializer.getInt32();
            charismaListUpdateInfo.recordContent = n3 = iDeserializer.getInt32();
            charismaListUpdateInfo.startElement = n2 = iDeserializer.getInt32();
            charismaListUpdateInfo.numOfElements = n = iDeserializer.getInt32();
        }
        return charismaListUpdateInfo;
    }

    public static CharismaListUpdateInfo[] getOptionalCharismaListUpdateInfoVarArray(IDeserializer iDeserializer) {
        CharismaListUpdateInfo[] charismaListUpdateInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            charismaListUpdateInfoArray = new CharismaListUpdateInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                charismaListUpdateInfoArray[i2] = CharismaListUpdateInfoSerializer.getOptionalCharismaListUpdateInfo(iDeserializer);
            }
        }
        return charismaListUpdateInfoArray;
    }
}

