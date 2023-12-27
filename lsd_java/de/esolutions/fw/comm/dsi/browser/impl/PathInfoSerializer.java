/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.browser.PathInfo;

public class PathInfoSerializer {
    public static void putOptionalPathInfo(ISerializer iSerializer, PathInfo pathInfo) {
        boolean bl = pathInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = pathInfo.getFormat();
            iSerializer.putInt32(n);
            String string = pathInfo.getPath();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalPathInfoVarArray(ISerializer iSerializer, PathInfo[] pathInfoArray) {
        boolean bl = pathInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pathInfoArray.length);
            for (int i2 = 0; i2 < pathInfoArray.length; ++i2) {
                PathInfoSerializer.putOptionalPathInfo(iSerializer, pathInfoArray[i2]);
            }
        }
    }

    public static PathInfo getOptionalPathInfo(IDeserializer iDeserializer) {
        PathInfo pathInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            pathInfo = new PathInfo();
            pathInfo.format = n = iDeserializer.getInt32();
            pathInfo.path = string = iDeserializer.getOptionalString();
        }
        return pathInfo;
    }

    public static PathInfo[] getOptionalPathInfoVarArray(IDeserializer iDeserializer) {
        PathInfo[] pathInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pathInfoArray = new PathInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pathInfoArray[i2] = PathInfoSerializer.getOptionalPathInfo(iDeserializer);
            }
        }
        return pathInfoArray;
    }
}

