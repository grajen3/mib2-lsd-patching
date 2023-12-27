/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephoneng.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephoneng.CFRequestData;

public class CFRequestDataSerializer {
    public static void putOptionalCFRequestData(ISerializer iSerializer, CFRequestData cFRequestData) {
        boolean bl = cFRequestData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = cFRequestData.getTelCFMode();
            iSerializer.putInt32(n);
            int n2 = cFRequestData.getTelCFCondition();
            iSerializer.putInt32(n2);
            String string = cFRequestData.getTelCFNumber();
            iSerializer.putOptionalString(string);
            short s = cFRequestData.getTelClass();
            iSerializer.putInt16(s);
            short s2 = cFRequestData.getTelCFTime();
            iSerializer.putInt16(s2);
        }
    }

    public static void putOptionalCFRequestDataVarArray(ISerializer iSerializer, CFRequestData[] cFRequestDataArray) {
        boolean bl = cFRequestDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(cFRequestDataArray.length);
            for (int i2 = 0; i2 < cFRequestDataArray.length; ++i2) {
                CFRequestDataSerializer.putOptionalCFRequestData(iSerializer, cFRequestDataArray[i2]);
            }
        }
    }

    public static CFRequestData getOptionalCFRequestData(IDeserializer iDeserializer) {
        CFRequestData cFRequestData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            short s2;
            String string;
            int n;
            int n2;
            cFRequestData = new CFRequestData();
            cFRequestData.telCFMode = n2 = iDeserializer.getInt32();
            cFRequestData.telCFCondition = n = iDeserializer.getInt32();
            cFRequestData.telCFNumber = string = iDeserializer.getOptionalString();
            cFRequestData.telClass = s2 = iDeserializer.getInt16();
            cFRequestData.telCFTime = s = iDeserializer.getInt16();
        }
        return cFRequestData;
    }

    public static CFRequestData[] getOptionalCFRequestDataVarArray(IDeserializer iDeserializer) {
        CFRequestData[] cFRequestDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            cFRequestDataArray = new CFRequestData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                cFRequestDataArray[i2] = CFRequestDataSerializer.getOptionalCFRequestData(iDeserializer);
            }
        }
        return cFRequestDataArray;
    }
}

