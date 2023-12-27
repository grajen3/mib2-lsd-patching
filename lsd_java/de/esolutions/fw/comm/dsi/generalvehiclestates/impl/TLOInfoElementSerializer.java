/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.generalvehiclestates.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.generalvehiclestates.TLOInfoElement;

public class TLOInfoElementSerializer {
    public static void putOptionalTLOInfoElement(ISerializer iSerializer, TLOInfoElement tLOInfoElement) {
        boolean bl = tLOInfoElement == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = tLOInfoElement.getCounter();
            iSerializer.putInt32(n);
            int n2 = tLOInfoElement.getTime1CF();
            iSerializer.putInt32(n2);
            float f2 = tLOInfoElement.getTime1Pred();
            iSerializer.putFloat(f2);
            int n3 = tLOInfoElement.getTime1State();
            iSerializer.putInt32(n3);
            int n4 = tLOInfoElement.getTime2CF();
            iSerializer.putInt32(n4);
            float f3 = tLOInfoElement.getTime2Pred();
            iSerializer.putFloat(f3);
            int n5 = tLOInfoElement.getTime2State();
            iSerializer.putInt32(n5);
            int n6 = tLOInfoElement.getPsdSegId();
            iSerializer.putInt32(n6);
            int n7 = tLOInfoElement.getPsdSegOffset();
            iSerializer.putInt32(n7);
        }
    }

    public static void putOptionalTLOInfoElementVarArray(ISerializer iSerializer, TLOInfoElement[] tLOInfoElementArray) {
        boolean bl = tLOInfoElementArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tLOInfoElementArray.length);
            for (int i2 = 0; i2 < tLOInfoElementArray.length; ++i2) {
                TLOInfoElementSerializer.putOptionalTLOInfoElement(iSerializer, tLOInfoElementArray[i2]);
            }
        }
    }

    public static TLOInfoElement getOptionalTLOInfoElement(IDeserializer iDeserializer) {
        TLOInfoElement tLOInfoElement = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            float f2;
            int n4;
            int n5;
            float f3;
            int n6;
            int n7;
            tLOInfoElement = new TLOInfoElement();
            tLOInfoElement.counter = n7 = iDeserializer.getInt32();
            tLOInfoElement.time1CF = n6 = iDeserializer.getInt32();
            tLOInfoElement.time1Pred = f3 = iDeserializer.getFloat();
            tLOInfoElement.time1State = n5 = iDeserializer.getInt32();
            tLOInfoElement.time2CF = n4 = iDeserializer.getInt32();
            tLOInfoElement.time2Pred = f2 = iDeserializer.getFloat();
            tLOInfoElement.time2State = n3 = iDeserializer.getInt32();
            tLOInfoElement.psdSegId = n2 = iDeserializer.getInt32();
            tLOInfoElement.psdSegOffset = n = iDeserializer.getInt32();
        }
        return tLOInfoElement;
    }

    public static TLOInfoElement[] getOptionalTLOInfoElementVarArray(IDeserializer iDeserializer) {
        TLOInfoElement[] tLOInfoElementArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tLOInfoElementArray = new TLOInfoElement[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tLOInfoElementArray[i2] = TLOInfoElementSerializer.getOptionalTLOInfoElement(iDeserializer);
            }
        }
        return tLOInfoElementArray;
    }
}

