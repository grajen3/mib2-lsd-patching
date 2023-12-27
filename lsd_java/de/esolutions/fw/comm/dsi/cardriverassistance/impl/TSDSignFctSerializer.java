/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.comm.dsi.cardriverassistance.impl.TSDSignInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.TSDSignFct;
import org.dsi.ifc.cardriverassistance.TSDSignInfo;

public class TSDSignFctSerializer {
    public static void putOptionalTSDSignFct(ISerializer iSerializer, TSDSignFct tSDSignFct) {
        boolean bl = tSDSignFct == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = tSDSignFct.getSign();
            iSerializer.putInt32(n);
            int n2 = tSDSignFct.getSignDynamicValue();
            iSerializer.putInt32(n2);
            int n3 = tSDSignFct.getAddSign();
            iSerializer.putInt32(n3);
            String string = tSDSignFct.getAddSignDynamicValue();
            iSerializer.putOptionalString(string);
            TSDSignInfo tSDSignInfo = tSDSignFct.getSignInfo();
            TSDSignInfoSerializer.putOptionalTSDSignInfo(iSerializer, tSDSignInfo);
        }
    }

    public static void putOptionalTSDSignFctVarArray(ISerializer iSerializer, TSDSignFct[] tSDSignFctArray) {
        boolean bl = tSDSignFctArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tSDSignFctArray.length);
            for (int i2 = 0; i2 < tSDSignFctArray.length; ++i2) {
                TSDSignFctSerializer.putOptionalTSDSignFct(iSerializer, tSDSignFctArray[i2]);
            }
        }
    }

    public static TSDSignFct getOptionalTSDSignFct(IDeserializer iDeserializer) {
        TSDSignFct tSDSignFct = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            TSDSignInfo tSDSignInfo;
            String string;
            int n;
            int n2;
            int n3;
            tSDSignFct = new TSDSignFct();
            tSDSignFct.sign = n3 = iDeserializer.getInt32();
            tSDSignFct.signDynamicValue = n2 = iDeserializer.getInt32();
            tSDSignFct.addSign = n = iDeserializer.getInt32();
            tSDSignFct.addSignDynamicValue = string = iDeserializer.getOptionalString();
            tSDSignFct.signInfo = tSDSignInfo = TSDSignInfoSerializer.getOptionalTSDSignInfo(iDeserializer);
        }
        return tSDSignFct;
    }

    public static TSDSignFct[] getOptionalTSDSignFctVarArray(IDeserializer iDeserializer) {
        TSDSignFct[] tSDSignFctArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tSDSignFctArray = new TSDSignFct[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tSDSignFctArray[i2] = TSDSignFctSerializer.getOptionalTSDSignFct(iDeserializer);
            }
        }
        return tSDSignFctArray;
    }
}

