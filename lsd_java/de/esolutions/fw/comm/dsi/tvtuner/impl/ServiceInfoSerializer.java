/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tvtuner.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class ServiceInfoSerializer {
    public static void putOptionalServiceInfo(ISerializer iSerializer, ServiceInfo serviceInfo) {
        boolean bl = serviceInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = serviceInfo.getNamePID();
            iSerializer.putInt64(l);
            int n = serviceInfo.getServicePID();
            iSerializer.putInt32(n);
            String string = serviceInfo.getName();
            iSerializer.putOptionalString(string);
            int n2 = serviceInfo.getSType();
            iSerializer.putInt32(n2);
            int n3 = serviceInfo.getContentGroup();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalServiceInfoVarArray(ISerializer iSerializer, ServiceInfo[] serviceInfoArray) {
        boolean bl = serviceInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(serviceInfoArray.length);
            for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
                ServiceInfoSerializer.putOptionalServiceInfo(iSerializer, serviceInfoArray[i2]);
            }
        }
    }

    public static ServiceInfo getOptionalServiceInfo(IDeserializer iDeserializer) {
        ServiceInfo serviceInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            String string;
            int n3;
            long l;
            serviceInfo = new ServiceInfo();
            serviceInfo.namePID = l = iDeserializer.getInt64();
            serviceInfo.servicePID = n3 = iDeserializer.getInt32();
            serviceInfo.name = string = iDeserializer.getOptionalString();
            serviceInfo.sType = n2 = iDeserializer.getInt32();
            serviceInfo.contentGroup = n = iDeserializer.getInt32();
        }
        return serviceInfo;
    }

    public static ServiceInfo[] getOptionalServiceInfoVarArray(IDeserializer iDeserializer) {
        ServiceInfo[] serviceInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            serviceInfoArray = new ServiceInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                serviceInfoArray[i2] = ServiceInfoSerializer.getOptionalServiceInfo(iDeserializer);
            }
        }
        return serviceInfoArray;
    }
}

