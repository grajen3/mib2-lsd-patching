/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.NavVersionInfo;

public class NavVersionInfoSerializer {
    public static void putOptionalNavVersionInfo(ISerializer iSerializer, NavVersionInfo navVersionInfo) {
        boolean bl = navVersionInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String[] stringArray = navVersionInfo.getNavVersion();
            iSerializer.putOptionalStringVarArray(stringArray);
        }
    }

    public static void putOptionalNavVersionInfoVarArray(ISerializer iSerializer, NavVersionInfo[] navVersionInfoArray) {
        boolean bl = navVersionInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(navVersionInfoArray.length);
            for (int i2 = 0; i2 < navVersionInfoArray.length; ++i2) {
                NavVersionInfoSerializer.putOptionalNavVersionInfo(iSerializer, navVersionInfoArray[i2]);
            }
        }
    }

    public static NavVersionInfo getOptionalNavVersionInfo(IDeserializer iDeserializer) {
        NavVersionInfo navVersionInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            navVersionInfo = new NavVersionInfo();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            navVersionInfo.navVersion = stringArray;
        }
        return navVersionInfo;
    }

    public static NavVersionInfo[] getOptionalNavVersionInfoVarArray(IDeserializer iDeserializer) {
        NavVersionInfo[] navVersionInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            navVersionInfoArray = new NavVersionInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                navVersionInfoArray[i2] = NavVersionInfoSerializer.getOptionalNavVersionInfo(iDeserializer);
            }
        }
        return navVersionInfoArray;
    }
}

