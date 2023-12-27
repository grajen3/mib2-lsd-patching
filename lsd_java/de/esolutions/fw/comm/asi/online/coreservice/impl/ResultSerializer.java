/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.Result;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class ResultSerializer {
    public static void putOptionalResult(ISerializer iSerializer, Result result) {
        boolean bl = result == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = result.getResult();
            iSerializer.putEnum(n);
            int n2 = result.getHttpStatus();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalResultVarArray(ISerializer iSerializer, Result[] resultArray) {
        boolean bl = resultArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(resultArray.length);
            for (int i2 = 0; i2 < resultArray.length; ++i2) {
                ResultSerializer.putOptionalResult(iSerializer, resultArray[i2]);
            }
        }
    }

    public static Result getOptionalResult(IDeserializer iDeserializer) {
        Result result = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            result = new Result();
            result.result = n2 = iDeserializer.getEnum();
            result.httpStatus = n = iDeserializer.getInt32();
        }
        return result;
    }

    public static Result[] getOptionalResultVarArray(IDeserializer iDeserializer) {
        Result[] resultArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            resultArray = new Result[n];
            for (int i2 = 0; i2 < n; ++i2) {
                resultArray[i2] = ResultSerializer.getOptionalResult(iDeserializer);
            }
        }
        return resultArray;
    }
}

