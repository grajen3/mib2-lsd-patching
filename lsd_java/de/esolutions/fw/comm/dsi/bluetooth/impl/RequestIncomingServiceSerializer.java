/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.bluetooth.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.bluetooth.RequestIncomingService;

public class RequestIncomingServiceSerializer {
    public static void putOptionalRequestIncomingService(ISerializer iSerializer, RequestIncomingService requestIncomingService) {
        boolean bl = requestIncomingService == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = requestIncomingService.getBtDeviceName();
            iSerializer.putOptionalString(string);
            String string2 = requestIncomingService.getBtDeviceAddress();
            iSerializer.putOptionalString(string2);
            int n = requestIncomingService.getBtServiceType();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalRequestIncomingServiceVarArray(ISerializer iSerializer, RequestIncomingService[] requestIncomingServiceArray) {
        boolean bl = requestIncomingServiceArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(requestIncomingServiceArray.length);
            for (int i2 = 0; i2 < requestIncomingServiceArray.length; ++i2) {
                RequestIncomingServiceSerializer.putOptionalRequestIncomingService(iSerializer, requestIncomingServiceArray[i2]);
            }
        }
    }

    public static RequestIncomingService getOptionalRequestIncomingService(IDeserializer iDeserializer) {
        RequestIncomingService requestIncomingService = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            String string2;
            requestIncomingService = new RequestIncomingService();
            requestIncomingService.btDeviceName = string2 = iDeserializer.getOptionalString();
            requestIncomingService.btDeviceAddress = string = iDeserializer.getOptionalString();
            requestIncomingService.btServiceType = n = iDeserializer.getInt32();
        }
        return requestIncomingService;
    }

    public static RequestIncomingService[] getOptionalRequestIncomingServiceVarArray(IDeserializer iDeserializer) {
        RequestIncomingService[] requestIncomingServiceArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            requestIncomingServiceArray = new RequestIncomingService[n];
            for (int i2 = 0; i2 < n; ++i2) {
                requestIncomingServiceArray[i2] = RequestIncomingServiceSerializer.getOptionalRequestIncomingService(iDeserializer);
            }
        }
        return requestIncomingServiceArray;
    }
}

