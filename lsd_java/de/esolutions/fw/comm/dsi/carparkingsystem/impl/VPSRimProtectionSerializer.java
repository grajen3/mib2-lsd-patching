/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.VPSRimProtection;

public class VPSRimProtectionSerializer {
    public static void putOptionalVPSRimProtection(ISerializer iSerializer, VPSRimProtection vPSRimProtection) {
        boolean bl = vPSRimProtection == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = vPSRimProtection.getTireAngle();
            iSerializer.putInt32(n);
            int n2 = vPSRimProtection.getTireStateFrontLeft();
            iSerializer.putInt32(n2);
            int n3 = vPSRimProtection.getTireStateFrontRight();
            iSerializer.putInt32(n3);
            int n4 = vPSRimProtection.getTireStateRearLeft();
            iSerializer.putInt32(n4);
            int n5 = vPSRimProtection.getTireStateRearRight();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalVPSRimProtectionVarArray(ISerializer iSerializer, VPSRimProtection[] vPSRimProtectionArray) {
        boolean bl = vPSRimProtectionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(vPSRimProtectionArray.length);
            for (int i2 = 0; i2 < vPSRimProtectionArray.length; ++i2) {
                VPSRimProtectionSerializer.putOptionalVPSRimProtection(iSerializer, vPSRimProtectionArray[i2]);
            }
        }
    }

    public static VPSRimProtection getOptionalVPSRimProtection(IDeserializer iDeserializer) {
        VPSRimProtection vPSRimProtection = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            vPSRimProtection = new VPSRimProtection();
            vPSRimProtection.tireAngle = n5 = iDeserializer.getInt32();
            vPSRimProtection.tireStateFrontLeft = n4 = iDeserializer.getInt32();
            vPSRimProtection.tireStateFrontRight = n3 = iDeserializer.getInt32();
            vPSRimProtection.tireStateRearLeft = n2 = iDeserializer.getInt32();
            vPSRimProtection.tireStateRearRight = n = iDeserializer.getInt32();
        }
        return vPSRimProtection;
    }

    public static VPSRimProtection[] getOptionalVPSRimProtectionVarArray(IDeserializer iDeserializer) {
        VPSRimProtection[] vPSRimProtectionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            vPSRimProtectionArray = new VPSRimProtection[n];
            for (int i2 = 0; i2 < n; ++i2) {
                vPSRimProtectionArray[i2] = VPSRimProtectionSerializer.getOptionalVPSRimProtection(iDeserializer);
            }
        }
        return vPSRimProtectionArray;
    }
}

