/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationWgs84Serializer;
import de.esolutions.fw.comm.dsi.online.impl.OperatorCallAddressEntrySerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.online.OperatorCallAddressEntry;
import org.dsi.ifc.online.OperatorCallResult;

public class OperatorCallResultSerializer {
    public static void putOptionalOperatorCallResult(ISerializer iSerializer, OperatorCallResult operatorCallResult) {
        boolean bl = operatorCallResult == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = operatorCallResult.getServiceId();
            iSerializer.putOptionalString(string);
            int n = operatorCallResult.getServiceType();
            iSerializer.putInt32(n);
            String string2 = operatorCallResult.getName();
            iSerializer.putOptionalString(string2);
            OperatorCallAddressEntry operatorCallAddressEntry = operatorCallResult.getAddress();
            OperatorCallAddressEntrySerializer.putOptionalOperatorCallAddressEntry(iSerializer, operatorCallAddressEntry);
            NavLocationWgs84 navLocationWgs84 = operatorCallResult.getLocation();
            NavLocationWgs84Serializer.putOptionalNavLocationWgs84(iSerializer, navLocationWgs84);
        }
    }

    public static void putOptionalOperatorCallResultVarArray(ISerializer iSerializer, OperatorCallResult[] operatorCallResultArray) {
        boolean bl = operatorCallResultArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(operatorCallResultArray.length);
            for (int i2 = 0; i2 < operatorCallResultArray.length; ++i2) {
                OperatorCallResultSerializer.putOptionalOperatorCallResult(iSerializer, operatorCallResultArray[i2]);
            }
        }
    }

    public static OperatorCallResult getOptionalOperatorCallResult(IDeserializer iDeserializer) {
        OperatorCallResult operatorCallResult = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            NavLocationWgs84 navLocationWgs84;
            OperatorCallAddressEntry operatorCallAddressEntry;
            String string;
            int n;
            String string2;
            operatorCallResult = new OperatorCallResult();
            operatorCallResult.serviceId = string2 = iDeserializer.getOptionalString();
            operatorCallResult.serviceType = n = iDeserializer.getInt32();
            operatorCallResult.name = string = iDeserializer.getOptionalString();
            operatorCallResult.address = operatorCallAddressEntry = OperatorCallAddressEntrySerializer.getOptionalOperatorCallAddressEntry(iDeserializer);
            operatorCallResult.location = navLocationWgs84 = NavLocationWgs84Serializer.getOptionalNavLocationWgs84(iDeserializer);
        }
        return operatorCallResult;
    }

    public static OperatorCallResult[] getOptionalOperatorCallResultVarArray(IDeserializer iDeserializer) {
        OperatorCallResult[] operatorCallResultArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            operatorCallResultArray = new OperatorCallResult[n];
            for (int i2 = 0; i2 < n; ++i2) {
                operatorCallResultArray[i2] = OperatorCallResultSerializer.getOptionalOperatorCallResult(iDeserializer);
            }
        }
        return operatorCallResultArray;
    }
}

