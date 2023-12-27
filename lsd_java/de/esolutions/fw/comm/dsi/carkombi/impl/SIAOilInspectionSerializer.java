/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.SIAOilInspection;

public class SIAOilInspectionSerializer {
    public static void putOptionalSIAOilInspection(ISerializer iSerializer, SIAOilInspection sIAOilInspection) {
        boolean bl = sIAOilInspection == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = sIAOilInspection.getDistanceStatus();
            iSerializer.putInt32(n);
            int n2 = sIAOilInspection.getDistance();
            iSerializer.putInt32(n2);
            int n3 = sIAOilInspection.getDistanceUnit();
            iSerializer.putInt32(n3);
            int n4 = sIAOilInspection.getTimeStatus();
            iSerializer.putInt32(n4);
            int n5 = sIAOilInspection.getTime();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalSIAOilInspectionVarArray(ISerializer iSerializer, SIAOilInspection[] sIAOilInspectionArray) {
        boolean bl = sIAOilInspectionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sIAOilInspectionArray.length);
            for (int i2 = 0; i2 < sIAOilInspectionArray.length; ++i2) {
                SIAOilInspectionSerializer.putOptionalSIAOilInspection(iSerializer, sIAOilInspectionArray[i2]);
            }
        }
    }

    public static SIAOilInspection getOptionalSIAOilInspection(IDeserializer iDeserializer) {
        SIAOilInspection sIAOilInspection = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            sIAOilInspection = new SIAOilInspection();
            sIAOilInspection.distanceStatus = n5 = iDeserializer.getInt32();
            sIAOilInspection.distance = n4 = iDeserializer.getInt32();
            sIAOilInspection.distanceUnit = n3 = iDeserializer.getInt32();
            sIAOilInspection.timeStatus = n2 = iDeserializer.getInt32();
            sIAOilInspection.time = n = iDeserializer.getInt32();
        }
        return sIAOilInspection;
    }

    public static SIAOilInspection[] getOptionalSIAOilInspectionVarArray(IDeserializer iDeserializer) {
        SIAOilInspection[] sIAOilInspectionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sIAOilInspectionArray = new SIAOilInspection[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sIAOilInspectionArray[i2] = SIAOilInspectionSerializer.getOptionalSIAOilInspection(iDeserializer);
            }
        }
        return sIAOilInspectionArray;
    }
}

