/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephoneng.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephoneng.CallInformationExt;

public class CallInformationExtSerializer {
    public static void putOptionalCallInformationExt(ISerializer iSerializer, CallInformationExt callInformationExt) {
        boolean bl = callInformationExt == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short s = callInformationExt.getTelEntryType();
            iSerializer.putInt16(s);
            int n = callInformationExt.getTelDBPhoneNumberIndex();
            iSerializer.putInt32(n);
            int n2 = callInformationExt.getAdbPhoneDataCount();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalCallInformationExtVarArray(ISerializer iSerializer, CallInformationExt[] callInformationExtArray) {
        boolean bl = callInformationExtArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(callInformationExtArray.length);
            for (int i2 = 0; i2 < callInformationExtArray.length; ++i2) {
                CallInformationExtSerializer.putOptionalCallInformationExt(iSerializer, callInformationExtArray[i2]);
            }
        }
    }

    public static CallInformationExt getOptionalCallInformationExt(IDeserializer iDeserializer) {
        CallInformationExt callInformationExt = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            short s;
            callInformationExt = new CallInformationExt();
            callInformationExt.telEntryType = s = iDeserializer.getInt16();
            callInformationExt.telDBPhoneNumberIndex = n2 = iDeserializer.getInt32();
            callInformationExt.adbPhoneDataCount = n = iDeserializer.getInt32();
        }
        return callInformationExt;
    }

    public static CallInformationExt[] getOptionalCallInformationExtVarArray(IDeserializer iDeserializer) {
        CallInformationExt[] callInformationExtArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            callInformationExtArray = new CallInformationExt[n];
            for (int i2 = 0; i2 < n; ++i2) {
                callInformationExtArray[i2] = CallInformationExtSerializer.getOptionalCallInformationExt(iDeserializer);
            }
        }
        return callInformationExtArray;
    }
}

