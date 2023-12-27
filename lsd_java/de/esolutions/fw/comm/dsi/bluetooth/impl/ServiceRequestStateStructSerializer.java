/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.bluetooth.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.bluetooth.ServiceRequestStateStruct;

public class ServiceRequestStateStructSerializer {
    public static void putOptionalServiceRequestStateStruct(ISerializer iSerializer, ServiceRequestStateStruct serviceRequestStateStruct) {
        boolean bl = serviceRequestStateStruct == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = serviceRequestStateStruct.getBtServiceRequestState();
            iSerializer.putInt32(n);
            String string = serviceRequestStateStruct.getBtDeviceAddress();
            iSerializer.putOptionalString(string);
            String string2 = serviceRequestStateStruct.getBtDeviceName();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalServiceRequestStateStructVarArray(ISerializer iSerializer, ServiceRequestStateStruct[] serviceRequestStateStructArray) {
        boolean bl = serviceRequestStateStructArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(serviceRequestStateStructArray.length);
            for (int i2 = 0; i2 < serviceRequestStateStructArray.length; ++i2) {
                ServiceRequestStateStructSerializer.putOptionalServiceRequestStateStruct(iSerializer, serviceRequestStateStructArray[i2]);
            }
        }
    }

    public static ServiceRequestStateStruct getOptionalServiceRequestStateStruct(IDeserializer iDeserializer) {
        ServiceRequestStateStruct serviceRequestStateStruct = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            int n;
            serviceRequestStateStruct = new ServiceRequestStateStruct();
            serviceRequestStateStruct.btServiceRequestState = n = iDeserializer.getInt32();
            serviceRequestStateStruct.btDeviceAddress = string2 = iDeserializer.getOptionalString();
            serviceRequestStateStruct.btDeviceName = string = iDeserializer.getOptionalString();
        }
        return serviceRequestStateStruct;
    }

    public static ServiceRequestStateStruct[] getOptionalServiceRequestStateStructVarArray(IDeserializer iDeserializer) {
        ServiceRequestStateStruct[] serviceRequestStateStructArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            serviceRequestStateStructArray = new ServiceRequestStateStruct[n];
            for (int i2 = 0; i2 < n; ++i2) {
                serviceRequestStateStructArray[i2] = ServiceRequestStateStructSerializer.getOptionalServiceRequestStateStruct(iDeserializer);
            }
        }
        return serviceRequestStateStructArray;
    }
}

