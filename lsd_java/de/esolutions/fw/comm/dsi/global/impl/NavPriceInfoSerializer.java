/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.global.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavPriceInfo;

public class NavPriceInfoSerializer {
    public static void putOptionalNavPriceInfo(ISerializer iSerializer, NavPriceInfo navPriceInfo) {
        boolean bl = navPriceInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = navPriceInfo.getCurrency();
            iSerializer.putInt32(n);
            int n2 = navPriceInfo.getAmount();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalNavPriceInfoVarArray(ISerializer iSerializer, NavPriceInfo[] navPriceInfoArray) {
        boolean bl = navPriceInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(navPriceInfoArray.length);
            for (int i2 = 0; i2 < navPriceInfoArray.length; ++i2) {
                NavPriceInfoSerializer.putOptionalNavPriceInfo(iSerializer, navPriceInfoArray[i2]);
            }
        }
    }

    public static NavPriceInfo getOptionalNavPriceInfo(IDeserializer iDeserializer) {
        NavPriceInfo navPriceInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            navPriceInfo = new NavPriceInfo();
            navPriceInfo.currency = n2 = iDeserializer.getInt32();
            navPriceInfo.amount = n = iDeserializer.getInt32();
        }
        return navPriceInfo;
    }

    public static NavPriceInfo[] getOptionalNavPriceInfoVarArray(IDeserializer iDeserializer) {
        NavPriceInfo[] navPriceInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            navPriceInfoArray = new NavPriceInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                navPriceInfoArray[i2] = NavPriceInfoSerializer.getOptionalNavPriceInfo(iDeserializer);
            }
        }
        return navPriceInfoArray;
    }
}

