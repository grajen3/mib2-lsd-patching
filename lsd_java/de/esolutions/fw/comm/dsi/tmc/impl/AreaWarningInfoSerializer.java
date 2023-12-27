/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tmc.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.tmc.AreaWarningInfo;

public class AreaWarningInfoSerializer {
    public static void putOptionalAreaWarningInfo(ISerializer iSerializer, AreaWarningInfo areaWarningInfo) {
        boolean bl = areaWarningInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = areaWarningInfo.getType();
            iSerializer.putInt32(n);
            int n2 = areaWarningInfo.getReserved();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalAreaWarningInfoVarArray(ISerializer iSerializer, AreaWarningInfo[] areaWarningInfoArray) {
        boolean bl = areaWarningInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(areaWarningInfoArray.length);
            for (int i2 = 0; i2 < areaWarningInfoArray.length; ++i2) {
                AreaWarningInfoSerializer.putOptionalAreaWarningInfo(iSerializer, areaWarningInfoArray[i2]);
            }
        }
    }

    public static AreaWarningInfo getOptionalAreaWarningInfo(IDeserializer iDeserializer) {
        AreaWarningInfo areaWarningInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            areaWarningInfo = new AreaWarningInfo();
            areaWarningInfo.type = n2 = iDeserializer.getInt32();
            areaWarningInfo.reserved = n = iDeserializer.getInt32();
        }
        return areaWarningInfo;
    }

    public static AreaWarningInfo[] getOptionalAreaWarningInfoVarArray(IDeserializer iDeserializer) {
        AreaWarningInfo[] areaWarningInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            areaWarningInfoArray = new AreaWarningInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                areaWarningInfoArray[i2] = AreaWarningInfoSerializer.getOptionalAreaWarningInfo(iDeserializer);
            }
        }
        return areaWarningInfoArray;
    }
}

