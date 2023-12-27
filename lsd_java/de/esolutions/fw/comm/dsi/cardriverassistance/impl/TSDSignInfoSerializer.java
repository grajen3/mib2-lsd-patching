/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.TSDSignInfo;

public class TSDSignInfoSerializer {
    public static void putOptionalTSDSignInfo(ISerializer iSerializer, TSDSignInfo tSDSignInfo) {
        boolean bl = tSDSignInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = tSDSignInfo.isRoadWorkSign();
            iSerializer.putBool(bl2);
            boolean bl3 = tSDSignInfo.isSourceIsCamera();
            iSerializer.putBool(bl3);
            boolean bl4 = tSDSignInfo.isSignWarning();
            iSerializer.putBool(bl4);
            boolean bl5 = tSDSignInfo.isMph();
            iSerializer.putBool(bl5);
            boolean bl6 = tSDSignInfo.isSourceIsDatabase();
            iSerializer.putBool(bl6);
            boolean bl7 = tSDSignInfo.isSourceIsFusion();
            iSerializer.putBool(bl7);
            boolean bl8 = tSDSignInfo.isStartUrbanArea();
            iSerializer.putBool(bl8);
            boolean bl9 = tSDSignInfo.isEndUrbanArea();
            iSerializer.putBool(bl9);
            boolean bl10 = tSDSignInfo.isStartTrafficCalmedArea();
            iSerializer.putBool(bl10);
            boolean bl11 = tSDSignInfo.isEndTrafficCalmedArea();
            iSerializer.putBool(bl11);
            boolean bl12 = tSDSignInfo.isSignEffective();
            iSerializer.putBool(bl12);
            boolean bl13 = tSDSignInfo.isAcousticWarning();
            iSerializer.putBool(bl13);
        }
    }

    public static void putOptionalTSDSignInfoVarArray(ISerializer iSerializer, TSDSignInfo[] tSDSignInfoArray) {
        boolean bl = tSDSignInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tSDSignInfoArray.length);
            for (int i2 = 0; i2 < tSDSignInfoArray.length; ++i2) {
                TSDSignInfoSerializer.putOptionalTSDSignInfo(iSerializer, tSDSignInfoArray[i2]);
            }
        }
    }

    public static TSDSignInfo getOptionalTSDSignInfo(IDeserializer iDeserializer) {
        TSDSignInfo tSDSignInfo = null;
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
            tSDSignInfo = new TSDSignInfo();
            tSDSignInfo.roadWorkSign = bl13 = iDeserializer.getBool();
            tSDSignInfo.sourceIsCamera = bl12 = iDeserializer.getBool();
            tSDSignInfo.signWarning = bl11 = iDeserializer.getBool();
            tSDSignInfo.mph = bl10 = iDeserializer.getBool();
            tSDSignInfo.sourceIsDatabase = bl9 = iDeserializer.getBool();
            tSDSignInfo.sourceIsFusion = bl8 = iDeserializer.getBool();
            tSDSignInfo.startUrbanArea = bl7 = iDeserializer.getBool();
            tSDSignInfo.endUrbanArea = bl6 = iDeserializer.getBool();
            tSDSignInfo.startTrafficCalmedArea = bl5 = iDeserializer.getBool();
            tSDSignInfo.endTrafficCalmedArea = bl4 = iDeserializer.getBool();
            tSDSignInfo.signEffective = bl3 = iDeserializer.getBool();
            tSDSignInfo.acousticWarning = bl2 = iDeserializer.getBool();
        }
        return tSDSignInfo;
    }

    public static TSDSignInfo[] getOptionalTSDSignInfoVarArray(IDeserializer iDeserializer) {
        TSDSignInfo[] tSDSignInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tSDSignInfoArray = new TSDSignInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tSDSignInfoArray[i2] = TSDSignInfoSerializer.getOptionalTSDSignInfo(iDeserializer);
            }
        }
        return tSDSignInfoArray;
    }
}

