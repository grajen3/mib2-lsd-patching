/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.RequestDescriptor;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class RequestDescriptorSerializer {
    public static void putOptionalRequestDescriptor(ISerializer iSerializer, RequestDescriptor requestDescriptor) {
        boolean bl = requestDescriptor == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = requestDescriptor.getAppID();
            iSerializer.putOptionalString(string);
            String string2 = requestDescriptor.getServiceID();
            iSerializer.putOptionalString(string2);
            String string3 = requestDescriptor.getUrl();
            iSerializer.putOptionalString(string3);
            int n = requestDescriptor.getMethod();
            iSerializer.putEnum(n);
            int n2 = requestDescriptor.getEncoding();
            iSerializer.putEnum(n2);
            int n3 = requestDescriptor.getConnectTimeout();
            iSerializer.putInt32(n3);
            int n4 = requestDescriptor.getFinalTimeout();
            iSerializer.putInt32(n4);
            String string4 = requestDescriptor.getAddURLTemplate();
            iSerializer.putOptionalString(string4);
        }
    }

    public static void putOptionalRequestDescriptorVarArray(ISerializer iSerializer, RequestDescriptor[] requestDescriptorArray) {
        boolean bl = requestDescriptorArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(requestDescriptorArray.length);
            for (int i2 = 0; i2 < requestDescriptorArray.length; ++i2) {
                RequestDescriptorSerializer.putOptionalRequestDescriptor(iSerializer, requestDescriptorArray[i2]);
            }
        }
    }

    public static RequestDescriptor getOptionalRequestDescriptor(IDeserializer iDeserializer) {
        RequestDescriptor requestDescriptor = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            int n2;
            int n3;
            int n4;
            String string2;
            String string3;
            String string4;
            requestDescriptor = new RequestDescriptor();
            requestDescriptor.appID = string4 = iDeserializer.getOptionalString();
            requestDescriptor.serviceID = string3 = iDeserializer.getOptionalString();
            requestDescriptor.url = string2 = iDeserializer.getOptionalString();
            requestDescriptor.method = n4 = iDeserializer.getEnum();
            requestDescriptor.encoding = n3 = iDeserializer.getEnum();
            requestDescriptor.connectTimeout = n2 = iDeserializer.getInt32();
            requestDescriptor.finalTimeout = n = iDeserializer.getInt32();
            requestDescriptor.addURLTemplate = string = iDeserializer.getOptionalString();
        }
        return requestDescriptor;
    }

    public static RequestDescriptor[] getOptionalRequestDescriptorVarArray(IDeserializer iDeserializer) {
        RequestDescriptor[] requestDescriptorArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            requestDescriptorArray = new RequestDescriptor[n];
            for (int i2 = 0; i2 < n; ++i2) {
                requestDescriptorArray[i2] = RequestDescriptorSerializer.getOptionalRequestDescriptor(iDeserializer);
            }
        }
        return requestDescriptorArray;
    }
}

