/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigation.impl;

import de.esolutions.fw.comm.asi.diagnosis.navigation.sPSD;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sPSDSerializer {
    public static void putOptionalsPSD(ISerializer iSerializer, sPSD sPSD2) {
        boolean bl = sPSD2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sPSD2.getMsg_id();
            iSerializer.putUInt32(l);
            int n = sPSD2.getCustomerExperience();
            iSerializer.putEnum(n);
            short s = sPSD2.getPsdNavInfo();
            iSerializer.putUInt8(s);
        }
    }

    public static void putOptionalsPSDVarArray(ISerializer iSerializer, sPSD[] sPSDArray) {
        boolean bl = sPSDArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sPSDArray.length);
            for (int i2 = 0; i2 < sPSDArray.length; ++i2) {
                sPSDSerializer.putOptionalsPSD(iSerializer, sPSDArray[i2]);
            }
        }
    }

    public static sPSD getOptionalsPSD(IDeserializer iDeserializer) {
        sPSD sPSD2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            int n;
            long l;
            sPSD2 = new sPSD();
            sPSD2.msg_id = l = iDeserializer.getUInt32();
            sPSD2.customerExperience = n = iDeserializer.getEnum();
            sPSD2.psdNavInfo = s = iDeserializer.getUInt8();
        }
        return sPSD2;
    }

    public static sPSD[] getOptionalsPSDVarArray(IDeserializer iDeserializer) {
        sPSD[] sPSDArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sPSDArray = new sPSD[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sPSDArray[i2] = sPSDSerializer.getOptionalsPSD(iDeserializer);
            }
        }
        return sPSDArray;
    }
}

