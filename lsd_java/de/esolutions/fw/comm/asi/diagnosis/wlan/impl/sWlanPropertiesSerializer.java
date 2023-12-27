/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.wlan.impl;

import de.esolutions.fw.comm.asi.diagnosis.wlan.sWlanProperties;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sWlanPropertiesSerializer {
    public static void putOptionalsWlanProperties(ISerializer iSerializer, sWlanProperties sWlanProperties2) {
        boolean bl = sWlanProperties2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sWlanProperties2.getMsg_id();
            iSerializer.putUInt32(l);
            long l2 = sWlanProperties2.getMac_AP();
            iSerializer.putUInt64(l2);
            long l3 = sWlanProperties2.getMac_Tethering();
            iSerializer.putUInt64(l3);
            int n = sWlanProperties2.getIpProtocolVersion();
            iSerializer.putEnum(n);
            long l4 = sWlanProperties2.getIpV4();
            iSerializer.putUInt32(l4);
            long l5 = sWlanProperties2.getSubnetmaskV4();
            iSerializer.putUInt32(l5);
            String string = sWlanProperties2.getIpV6();
            iSerializer.putOptionalString(string);
            String string2 = sWlanProperties2.getSubnetmaskV6();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalsWlanPropertiesVarArray(ISerializer iSerializer, sWlanProperties[] sWlanPropertiesArray) {
        boolean bl = sWlanPropertiesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sWlanPropertiesArray.length);
            for (int i2 = 0; i2 < sWlanPropertiesArray.length; ++i2) {
                sWlanPropertiesSerializer.putOptionalsWlanProperties(iSerializer, sWlanPropertiesArray[i2]);
            }
        }
    }

    public static sWlanProperties getOptionalsWlanProperties(IDeserializer iDeserializer) {
        sWlanProperties sWlanProperties2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            long l;
            long l2;
            int n;
            long l3;
            long l4;
            long l5;
            sWlanProperties2 = new sWlanProperties();
            sWlanProperties2.msg_id = l5 = iDeserializer.getUInt32();
            sWlanProperties2.mac_AP = l4 = iDeserializer.getUInt64();
            sWlanProperties2.mac_Tethering = l3 = iDeserializer.getUInt64();
            sWlanProperties2.ipProtocolVersion = n = iDeserializer.getEnum();
            sWlanProperties2.ipV4 = l2 = iDeserializer.getUInt32();
            sWlanProperties2.subnetmaskV4 = l = iDeserializer.getUInt32();
            sWlanProperties2.ipV6 = string2 = iDeserializer.getOptionalString();
            sWlanProperties2.subnetmaskV6 = string = iDeserializer.getOptionalString();
        }
        return sWlanProperties2;
    }

    public static sWlanProperties[] getOptionalsWlanPropertiesVarArray(IDeserializer iDeserializer) {
        sWlanProperties[] sWlanPropertiesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sWlanPropertiesArray = new sWlanProperties[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sWlanPropertiesArray[i2] = sWlanPropertiesSerializer.getOptionalsWlanProperties(iDeserializer);
            }
        }
        return sWlanPropertiesArray;
    }
}

