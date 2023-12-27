/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tollcollect.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.tollcollect.TCCardError;

public class TCCardErrorSerializer {
    public static void putOptionalTCCardError(ISerializer iSerializer, TCCardError tCCardError) {
        boolean bl = tCCardError == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = tCCardError.getCardError();
            iSerializer.putInt32(n);
            String string = tCCardError.getErrorCode();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalTCCardErrorVarArray(ISerializer iSerializer, TCCardError[] tCCardErrorArray) {
        boolean bl = tCCardErrorArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tCCardErrorArray.length);
            for (int i2 = 0; i2 < tCCardErrorArray.length; ++i2) {
                TCCardErrorSerializer.putOptionalTCCardError(iSerializer, tCCardErrorArray[i2]);
            }
        }
    }

    public static TCCardError getOptionalTCCardError(IDeserializer iDeserializer) {
        TCCardError tCCardError = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            tCCardError = new TCCardError();
            tCCardError.cardError = n = iDeserializer.getInt32();
            tCCardError.errorCode = string = iDeserializer.getOptionalString();
        }
        return tCCardError;
    }

    public static TCCardError[] getOptionalTCCardErrorVarArray(IDeserializer iDeserializer) {
        TCCardError[] tCCardErrorArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tCCardErrorArray = new TCCardError[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tCCardErrorArray[i2] = TCCardErrorSerializer.getOptionalTCCardError(iDeserializer);
            }
        }
        return tCCardErrorArray;
    }
}

