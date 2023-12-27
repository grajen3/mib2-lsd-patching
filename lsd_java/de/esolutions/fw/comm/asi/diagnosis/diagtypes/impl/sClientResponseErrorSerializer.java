/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sClientResponseErrorSerializer {
    public static void putOptionalsClientResponseError(ISerializer iSerializer, sClientResponseError sClientResponseError2) {
        boolean bl = sClientResponseError2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sClientResponseError2.getMsg_id();
            iSerializer.putUInt32(l);
            int n = sClientResponseError2.getClient();
            iSerializer.putEnum(n);
            int n2 = sClientResponseError2.getErr_type();
            iSerializer.putEnum(n2);
        }
    }

    public static void putOptionalsClientResponseErrorVarArray(ISerializer iSerializer, sClientResponseError[] sClientResponseErrorArray) {
        boolean bl = sClientResponseErrorArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sClientResponseErrorArray.length);
            for (int i2 = 0; i2 < sClientResponseErrorArray.length; ++i2) {
                sClientResponseErrorSerializer.putOptionalsClientResponseError(iSerializer, sClientResponseErrorArray[i2]);
            }
        }
    }

    public static sClientResponseError getOptionalsClientResponseError(IDeserializer iDeserializer) {
        sClientResponseError sClientResponseError2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            long l;
            sClientResponseError2 = new sClientResponseError();
            sClientResponseError2.msg_id = l = iDeserializer.getUInt32();
            sClientResponseError2.client = n2 = iDeserializer.getEnum();
            sClientResponseError2.err_type = n = iDeserializer.getEnum();
        }
        return sClientResponseError2;
    }

    public static sClientResponseError[] getOptionalsClientResponseErrorVarArray(IDeserializer iDeserializer) {
        sClientResponseError[] sClientResponseErrorArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sClientResponseErrorArray = new sClientResponseError[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sClientResponseErrorArray[i2] = sClientResponseErrorSerializer.getOptionalsClientResponseError(iDeserializer);
            }
        }
        return sClientResponseErrorArray;
    }
}

