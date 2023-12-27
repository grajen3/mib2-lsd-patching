/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephone.ServiceCodeTypeStruct;

public class ServiceCodeTypeStructSerializer {
    public static void putOptionalServiceCodeTypeStruct(ISerializer iSerializer, ServiceCodeTypeStruct serviceCodeTypeStruct) {
        boolean bl = serviceCodeTypeStruct == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = serviceCodeTypeStruct.getTelDialNumberType();
            iSerializer.putInt32(n);
            String string = serviceCodeTypeStruct.getTelServiceCode();
            iSerializer.putOptionalString(string);
            int n2 = serviceCodeTypeStruct.getTelServiceCodeRequestType();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalServiceCodeTypeStructVarArray(ISerializer iSerializer, ServiceCodeTypeStruct[] serviceCodeTypeStructArray) {
        boolean bl = serviceCodeTypeStructArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(serviceCodeTypeStructArray.length);
            for (int i2 = 0; i2 < serviceCodeTypeStructArray.length; ++i2) {
                ServiceCodeTypeStructSerializer.putOptionalServiceCodeTypeStruct(iSerializer, serviceCodeTypeStructArray[i2]);
            }
        }
    }

    public static ServiceCodeTypeStruct getOptionalServiceCodeTypeStruct(IDeserializer iDeserializer) {
        ServiceCodeTypeStruct serviceCodeTypeStruct = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            int n2;
            serviceCodeTypeStruct = new ServiceCodeTypeStruct();
            serviceCodeTypeStruct.telDialNumberType = n2 = iDeserializer.getInt32();
            serviceCodeTypeStruct.telServiceCode = string = iDeserializer.getOptionalString();
            serviceCodeTypeStruct.telServiceCodeRequestType = n = iDeserializer.getInt32();
        }
        return serviceCodeTypeStruct;
    }

    public static ServiceCodeTypeStruct[] getOptionalServiceCodeTypeStructVarArray(IDeserializer iDeserializer) {
        ServiceCodeTypeStruct[] serviceCodeTypeStructArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            serviceCodeTypeStructArray = new ServiceCodeTypeStruct[n];
            for (int i2 = 0; i2 < n; ++i2) {
                serviceCodeTypeStructArray[i2] = ServiceCodeTypeStructSerializer.getOptionalServiceCodeTypeStruct(iDeserializer);
            }
        }
        return serviceCodeTypeStructArray;
    }
}

