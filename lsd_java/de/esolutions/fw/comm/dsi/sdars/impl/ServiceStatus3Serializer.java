/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.sdars.ServiceStatus3;

public class ServiceStatus3Serializer {
    public static void putOptionalServiceStatus3(ISerializer iSerializer, ServiceStatus3 serviceStatus3) {
        boolean bl = serviceStatus3 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = serviceStatus3.getAudioStatus();
            iSerializer.putInt32(n);
            int n2 = serviceStatus3.getAntennaStatus();
            iSerializer.putInt32(n2);
            int n3 = serviceStatus3.getListUpdateStatus();
            iSerializer.putInt32(n3);
            short s = serviceStatus3.getListUpdatePercentage();
            iSerializer.putInt16(s);
            int n4 = serviceStatus3.getDataUpdateStatus();
            iSerializer.putInt32(n4);
            int n5 = serviceStatus3.getDataSubscription();
            iSerializer.putInt32(n5);
            int n6 = serviceStatus3.getSubscriptionUpdateStatus();
            iSerializer.putInt32(n6);
        }
    }

    public static void putOptionalServiceStatus3VarArray(ISerializer iSerializer, ServiceStatus3[] serviceStatus3Array) {
        boolean bl = serviceStatus3Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(serviceStatus3Array.length);
            for (int i2 = 0; i2 < serviceStatus3Array.length; ++i2) {
                ServiceStatus3Serializer.putOptionalServiceStatus3(iSerializer, serviceStatus3Array[i2]);
            }
        }
    }

    public static ServiceStatus3 getOptionalServiceStatus3(IDeserializer iDeserializer) {
        ServiceStatus3 serviceStatus3 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            short s;
            int n4;
            int n5;
            int n6;
            serviceStatus3 = new ServiceStatus3();
            serviceStatus3.audioStatus = n6 = iDeserializer.getInt32();
            serviceStatus3.antennaStatus = n5 = iDeserializer.getInt32();
            serviceStatus3.listUpdateStatus = n4 = iDeserializer.getInt32();
            serviceStatus3.listUpdatePercentage = s = iDeserializer.getInt16();
            serviceStatus3.dataUpdateStatus = n3 = iDeserializer.getInt32();
            serviceStatus3.dataSubscription = n2 = iDeserializer.getInt32();
            serviceStatus3.subscriptionUpdateStatus = n = iDeserializer.getInt32();
        }
        return serviceStatus3;
    }

    public static ServiceStatus3[] getOptionalServiceStatus3VarArray(IDeserializer iDeserializer) {
        ServiceStatus3[] serviceStatus3Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            serviceStatus3Array = new ServiceStatus3[n];
            for (int i2 = 0; i2 < n; ++i2) {
                serviceStatus3Array[i2] = ServiceStatus3Serializer.getOptionalServiceStatus3(iDeserializer);
            }
        }
        return serviceStatus3Array;
    }
}

