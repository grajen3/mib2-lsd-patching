/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radio.ServiceInfo;

public class ServiceInfoSerializer {
    public static void putOptionalServiceInfo(ISerializer iSerializer, ServiceInfo serviceInfo) {
        boolean bl = serviceInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = serviceInfo.getEnsID();
            iSerializer.putInt32(n);
            int n2 = serviceInfo.getEnsECC();
            iSerializer.putInt32(n2);
            long l = serviceInfo.getSID();
            iSerializer.putInt64(l);
            String string = serviceInfo.getShortName();
            iSerializer.putOptionalString(string);
            String string2 = serviceInfo.getFullName();
            iSerializer.putOptionalString(string2);
            byte[] byArray = serviceInfo.getPtyCodes();
            iSerializer.putOptionalInt8VarArray(byArray);
            boolean bl2 = serviceInfo.isTp();
            iSerializer.putBool(bl2);
            boolean bl3 = serviceInfo.isRadiotext();
            iSerializer.putBool(bl3);
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
            boolean bl2;
            boolean bl3;
            String string;
            String string2;
            long l;
            int n;
            int n2;
            serviceInfo = new ServiceInfo();
            serviceInfo.ensID = n2 = iDeserializer.getInt32();
            serviceInfo.ensECC = n = iDeserializer.getInt32();
            serviceInfo.sID = l = iDeserializer.getInt64();
            serviceInfo.shortName = string2 = iDeserializer.getOptionalString();
            serviceInfo.fullName = string = iDeserializer.getOptionalString();
            byte[] byArray = iDeserializer.getOptionalInt8VarArray();
            serviceInfo.ptyCodes = byArray;
            serviceInfo.tp = bl3 = iDeserializer.getBool();
            serviceInfo.radiotext = bl2 = iDeserializer.getBool();
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

