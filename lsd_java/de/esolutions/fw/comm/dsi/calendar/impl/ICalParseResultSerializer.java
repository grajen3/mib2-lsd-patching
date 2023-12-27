/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.calendar.ICalParseResult;

public class ICalParseResultSerializer {
    public static void putOptionalICalParseResult(ISerializer iSerializer, ICalParseResult iCalParseResult) {
        boolean bl = iCalParseResult == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = iCalParseResult.getFileAbslPath();
            iSerializer.putOptionalString(string);
            String string2 = iCalParseResult.getErrorText();
            iSerializer.putOptionalString(string2);
            int n = iCalParseResult.getResultCode();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalICalParseResultVarArray(ISerializer iSerializer, ICalParseResult[] iCalParseResultArray) {
        boolean bl = iCalParseResultArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(iCalParseResultArray.length);
            for (int i2 = 0; i2 < iCalParseResultArray.length; ++i2) {
                ICalParseResultSerializer.putOptionalICalParseResult(iSerializer, iCalParseResultArray[i2]);
            }
        }
    }

    public static ICalParseResult getOptionalICalParseResult(IDeserializer iDeserializer) {
        ICalParseResult iCalParseResult = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            String string2;
            iCalParseResult = new ICalParseResult();
            iCalParseResult.fileAbslPath = string2 = iDeserializer.getOptionalString();
            iCalParseResult.errorText = string = iDeserializer.getOptionalString();
            iCalParseResult.resultCode = n = iDeserializer.getInt32();
        }
        return iCalParseResult;
    }

    public static ICalParseResult[] getOptionalICalParseResultVarArray(IDeserializer iDeserializer) {
        ICalParseResult[] iCalParseResultArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            iCalParseResultArray = new ICalParseResult[n];
            for (int i2 = 0; i2 < n; ++i2) {
                iCalParseResultArray[i2] = ICalParseResultSerializer.getOptionalICalParseResult(iDeserializer);
            }
        }
        return iCalParseResultArray;
    }
}

