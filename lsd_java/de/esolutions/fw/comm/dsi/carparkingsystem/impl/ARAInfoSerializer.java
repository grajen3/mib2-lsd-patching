/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.ARAInfo;

public class ARAInfoSerializer {
    public static void putOptionalARAInfo(ISerializer iSerializer, ARAInfo aRAInfo) {
        boolean bl = aRAInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = aRAInfo.getMessage();
            iSerializer.putInt32(n);
            boolean bl2 = aRAInfo.isAutomaticSteering();
            iSerializer.putBool(bl2);
            boolean bl3 = aRAInfo.isDeactivationProhibited();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalARAInfoVarArray(ISerializer iSerializer, ARAInfo[] aRAInfoArray) {
        boolean bl = aRAInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(aRAInfoArray.length);
            for (int i2 = 0; i2 < aRAInfoArray.length; ++i2) {
                ARAInfoSerializer.putOptionalARAInfo(iSerializer, aRAInfoArray[i2]);
            }
        }
    }

    public static ARAInfo getOptionalARAInfo(IDeserializer iDeserializer) {
        ARAInfo aRAInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            int n;
            aRAInfo = new ARAInfo();
            aRAInfo.message = n = iDeserializer.getInt32();
            aRAInfo.automaticSteering = bl3 = iDeserializer.getBool();
            aRAInfo.deactivationProhibited = bl2 = iDeserializer.getBool();
        }
        return aRAInfo;
    }

    public static ARAInfo[] getOptionalARAInfoVarArray(IDeserializer iDeserializer) {
        ARAInfo[] aRAInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            aRAInfoArray = new ARAInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                aRAInfoArray[i2] = ARAInfoSerializer.getOptionalARAInfo(iDeserializer);
            }
        }
        return aRAInfoArray;
    }
}

