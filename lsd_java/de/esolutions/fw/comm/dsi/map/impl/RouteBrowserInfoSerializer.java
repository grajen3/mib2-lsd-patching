/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.map.RouteBrowserInfo;

public class RouteBrowserInfoSerializer {
    public static void putOptionalRouteBrowserInfo(ISerializer iSerializer, RouteBrowserInfo routeBrowserInfo) {
        boolean bl = routeBrowserInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = routeBrowserInfo.getLengthOfSelectedSegments();
            iSerializer.putInt64(l);
            String string = routeBrowserInfo.getName();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalRouteBrowserInfoVarArray(ISerializer iSerializer, RouteBrowserInfo[] routeBrowserInfoArray) {
        boolean bl = routeBrowserInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(routeBrowserInfoArray.length);
            for (int i2 = 0; i2 < routeBrowserInfoArray.length; ++i2) {
                RouteBrowserInfoSerializer.putOptionalRouteBrowserInfo(iSerializer, routeBrowserInfoArray[i2]);
            }
        }
    }

    public static RouteBrowserInfo getOptionalRouteBrowserInfo(IDeserializer iDeserializer) {
        RouteBrowserInfo routeBrowserInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            long l;
            routeBrowserInfo = new RouteBrowserInfo();
            routeBrowserInfo.lengthOfSelectedSegments = l = iDeserializer.getInt64();
            routeBrowserInfo.name = string = iDeserializer.getOptionalString();
        }
        return routeBrowserInfo;
    }

    public static RouteBrowserInfo[] getOptionalRouteBrowserInfoVarArray(IDeserializer iDeserializer) {
        RouteBrowserInfo[] routeBrowserInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            routeBrowserInfoArray = new RouteBrowserInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                routeBrowserInfoArray[i2] = RouteBrowserInfoSerializer.getOptionalRouteBrowserInfo(iDeserializer);
            }
        }
        return routeBrowserInfoArray;
    }
}

