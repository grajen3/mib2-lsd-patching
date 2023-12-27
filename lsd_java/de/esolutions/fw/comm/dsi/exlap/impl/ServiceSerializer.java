/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.exlap.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.exlap.Service;

public class ServiceSerializer {
    public static void putOptionalService(ISerializer iSerializer, Service service) {
        boolean bl = service == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = service.getId();
            iSerializer.putInt32(n);
            int n2 = service.getStatus();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalServiceVarArray(ISerializer iSerializer, Service[] serviceArray) {
        boolean bl = serviceArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(serviceArray.length);
            for (int i2 = 0; i2 < serviceArray.length; ++i2) {
                ServiceSerializer.putOptionalService(iSerializer, serviceArray[i2]);
            }
        }
    }

    public static Service getOptionalService(IDeserializer iDeserializer) {
        Service service = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            service = new Service();
            service.id = n2 = iDeserializer.getInt32();
            service.status = n = iDeserializer.getInt32();
        }
        return service;
    }

    public static Service[] getOptionalServiceVarArray(IDeserializer iDeserializer) {
        Service[] serviceArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            serviceArray = new Service[n];
            for (int i2 = 0; i2 < n; ++i2) {
                serviceArray[i2] = ServiceSerializer.getOptionalService(iDeserializer);
            }
        }
        return serviceArray;
    }
}

