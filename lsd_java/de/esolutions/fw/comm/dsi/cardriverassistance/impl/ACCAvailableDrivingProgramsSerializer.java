/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.ACCAvailableDrivingPrograms;

public class ACCAvailableDrivingProgramsSerializer {
    public static void putOptionalACCAvailableDrivingPrograms(ISerializer iSerializer, ACCAvailableDrivingPrograms aCCAvailableDrivingPrograms) {
        boolean bl = aCCAvailableDrivingPrograms == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = aCCAvailableDrivingPrograms.isDynamic();
            iSerializer.putBool(bl2);
            boolean bl3 = aCCAvailableDrivingPrograms.isComfort();
            iSerializer.putBool(bl3);
            boolean bl4 = aCCAvailableDrivingPrograms.isStandard();
            iSerializer.putBool(bl4);
            boolean bl5 = aCCAvailableDrivingPrograms.isEco();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalACCAvailableDrivingProgramsVarArray(ISerializer iSerializer, ACCAvailableDrivingPrograms[] aCCAvailableDrivingProgramsArray) {
        boolean bl = aCCAvailableDrivingProgramsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(aCCAvailableDrivingProgramsArray.length);
            for (int i2 = 0; i2 < aCCAvailableDrivingProgramsArray.length; ++i2) {
                ACCAvailableDrivingProgramsSerializer.putOptionalACCAvailableDrivingPrograms(iSerializer, aCCAvailableDrivingProgramsArray[i2]);
            }
        }
    }

    public static ACCAvailableDrivingPrograms getOptionalACCAvailableDrivingPrograms(IDeserializer iDeserializer) {
        ACCAvailableDrivingPrograms aCCAvailableDrivingPrograms = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            aCCAvailableDrivingPrograms = new ACCAvailableDrivingPrograms();
            aCCAvailableDrivingPrograms.dynamic = bl5 = iDeserializer.getBool();
            aCCAvailableDrivingPrograms.comfort = bl4 = iDeserializer.getBool();
            aCCAvailableDrivingPrograms.standard = bl3 = iDeserializer.getBool();
            aCCAvailableDrivingPrograms.eco = bl2 = iDeserializer.getBool();
        }
        return aCCAvailableDrivingPrograms;
    }

    public static ACCAvailableDrivingPrograms[] getOptionalACCAvailableDrivingProgramsVarArray(IDeserializer iDeserializer) {
        ACCAvailableDrivingPrograms[] aCCAvailableDrivingProgramsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            aCCAvailableDrivingProgramsArray = new ACCAvailableDrivingPrograms[n];
            for (int i2 = 0; i2 < n; ++i2) {
                aCCAvailableDrivingProgramsArray[i2] = ACCAvailableDrivingProgramsSerializer.getOptionalACCAvailableDrivingPrograms(iDeserializer);
            }
        }
        return aCCAvailableDrivingProgramsArray;
    }
}

