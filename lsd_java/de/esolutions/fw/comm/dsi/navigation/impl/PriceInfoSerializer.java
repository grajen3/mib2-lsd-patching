/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.PriceInfo;

public class PriceInfoSerializer {
    public static void putOptionalPriceInfo(ISerializer iSerializer, PriceInfo priceInfo) {
        boolean bl = priceInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = priceInfo.getCurrency();
            iSerializer.putInt32(n);
            int n2 = priceInfo.getAmount();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalPriceInfoVarArray(ISerializer iSerializer, PriceInfo[] priceInfoArray) {
        boolean bl = priceInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(priceInfoArray.length);
            for (int i2 = 0; i2 < priceInfoArray.length; ++i2) {
                PriceInfoSerializer.putOptionalPriceInfo(iSerializer, priceInfoArray[i2]);
            }
        }
    }

    public static PriceInfo getOptionalPriceInfo(IDeserializer iDeserializer) {
        PriceInfo priceInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            priceInfo = new PriceInfo();
            priceInfo.currency = n2 = iDeserializer.getInt32();
            priceInfo.amount = n = iDeserializer.getInt32();
        }
        return priceInfo;
    }

    public static PriceInfo[] getOptionalPriceInfoVarArray(IDeserializer iDeserializer) {
        PriceInfo[] priceInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            priceInfoArray = new PriceInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                priceInfoArray[i2] = PriceInfoSerializer.getOptionalPriceInfo(iDeserializer);
            }
        }
        return priceInfoArray;
    }
}

