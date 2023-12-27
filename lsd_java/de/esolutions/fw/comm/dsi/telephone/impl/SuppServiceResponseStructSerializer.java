/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone.impl;

import de.esolutions.fw.comm.dsi.telephone.impl.CFResponseDataSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephone.CFResponseData;
import org.dsi.ifc.telephone.SuppServiceResponseStruct;

public class SuppServiceResponseStructSerializer {
    public static void putOptionalSuppServiceResponseStruct(ISerializer iSerializer, SuppServiceResponseStruct suppServiceResponseStruct) {
        boolean bl = suppServiceResponseStruct == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = suppServiceResponseStruct.getTelCWStatus();
            iSerializer.putInt32(n);
            CFResponseData[] cFResponseDataArray = suppServiceResponseStruct.getTelCFResponseData();
            CFResponseDataSerializer.putOptionalCFResponseDataVarArray(iSerializer, cFResponseDataArray);
            boolean bl2 = suppServiceResponseStruct.isSimPINRequired();
            iSerializer.putBool(bl2);
            int n2 = suppServiceResponseStruct.getTelCLIRState();
            iSerializer.putInt32(n2);
            int n3 = suppServiceResponseStruct.getTelCLIRNWState();
            iSerializer.putInt32(n3);
            int n4 = suppServiceResponseStruct.getTelServiceState();
            iSerializer.putInt32(n4);
            String string = suppServiceResponseStruct.getTelResponseText();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalSuppServiceResponseStructVarArray(ISerializer iSerializer, SuppServiceResponseStruct[] suppServiceResponseStructArray) {
        boolean bl = suppServiceResponseStructArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(suppServiceResponseStructArray.length);
            for (int i2 = 0; i2 < suppServiceResponseStructArray.length; ++i2) {
                SuppServiceResponseStructSerializer.putOptionalSuppServiceResponseStruct(iSerializer, suppServiceResponseStructArray[i2]);
            }
        }
    }

    public static SuppServiceResponseStruct getOptionalSuppServiceResponseStruct(IDeserializer iDeserializer) {
        SuppServiceResponseStruct suppServiceResponseStruct = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            int n2;
            int n3;
            boolean bl2;
            int n4;
            suppServiceResponseStruct = new SuppServiceResponseStruct();
            suppServiceResponseStruct.telCWStatus = n4 = iDeserializer.getInt32();
            CFResponseData[] cFResponseDataArray = CFResponseDataSerializer.getOptionalCFResponseDataVarArray(iDeserializer);
            suppServiceResponseStruct.telCFResponseData = cFResponseDataArray;
            suppServiceResponseStruct.simPINRequired = bl2 = iDeserializer.getBool();
            suppServiceResponseStruct.telCLIRState = n3 = iDeserializer.getInt32();
            suppServiceResponseStruct.telCLIRNWState = n2 = iDeserializer.getInt32();
            suppServiceResponseStruct.telServiceState = n = iDeserializer.getInt32();
            suppServiceResponseStruct.telResponseText = string = iDeserializer.getOptionalString();
        }
        return suppServiceResponseStruct;
    }

    public static SuppServiceResponseStruct[] getOptionalSuppServiceResponseStructVarArray(IDeserializer iDeserializer) {
        SuppServiceResponseStruct[] suppServiceResponseStructArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            suppServiceResponseStructArray = new SuppServiceResponseStruct[n];
            for (int i2 = 0; i2 < n; ++i2) {
                suppServiceResponseStructArray[i2] = SuppServiceResponseStructSerializer.getOptionalSuppServiceResponseStruct(iDeserializer);
            }
        }
        return suppServiceResponseStructArray;
    }
}

