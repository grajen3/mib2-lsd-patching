/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlAirProfiles;

public class SuspensionControlAirProfilesSerializer {
    public static void putOptionalSuspensionControlAirProfiles(ISerializer iSerializer, SuspensionControlAirProfiles suspensionControlAirProfiles) {
        boolean bl = suspensionControlAirProfiles == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = suspensionControlAirProfiles.isProfile1();
            iSerializer.putBool(bl2);
            boolean bl3 = suspensionControlAirProfiles.isProfile2();
            iSerializer.putBool(bl3);
            boolean bl4 = suspensionControlAirProfiles.isProfile3();
            iSerializer.putBool(bl4);
            boolean bl5 = suspensionControlAirProfiles.isProfile4();
            iSerializer.putBool(bl5);
            boolean bl6 = suspensionControlAirProfiles.isProfile5();
            iSerializer.putBool(bl6);
            boolean bl7 = suspensionControlAirProfiles.isProfile6();
            iSerializer.putBool(bl7);
            boolean bl8 = suspensionControlAirProfiles.isProfile7();
            iSerializer.putBool(bl8);
        }
    }

    public static void putOptionalSuspensionControlAirProfilesVarArray(ISerializer iSerializer, SuspensionControlAirProfiles[] suspensionControlAirProfilesArray) {
        boolean bl = suspensionControlAirProfilesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(suspensionControlAirProfilesArray.length);
            for (int i2 = 0; i2 < suspensionControlAirProfilesArray.length; ++i2) {
                SuspensionControlAirProfilesSerializer.putOptionalSuspensionControlAirProfiles(iSerializer, suspensionControlAirProfilesArray[i2]);
            }
        }
    }

    public static SuspensionControlAirProfiles getOptionalSuspensionControlAirProfiles(IDeserializer iDeserializer) {
        SuspensionControlAirProfiles suspensionControlAirProfiles = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            suspensionControlAirProfiles = new SuspensionControlAirProfiles();
            suspensionControlAirProfiles.profile1 = bl8 = iDeserializer.getBool();
            suspensionControlAirProfiles.profile2 = bl7 = iDeserializer.getBool();
            suspensionControlAirProfiles.profile3 = bl6 = iDeserializer.getBool();
            suspensionControlAirProfiles.profile4 = bl5 = iDeserializer.getBool();
            suspensionControlAirProfiles.profile5 = bl4 = iDeserializer.getBool();
            suspensionControlAirProfiles.profile6 = bl3 = iDeserializer.getBool();
            suspensionControlAirProfiles.profile7 = bl2 = iDeserializer.getBool();
        }
        return suspensionControlAirProfiles;
    }

    public static SuspensionControlAirProfiles[] getOptionalSuspensionControlAirProfilesVarArray(IDeserializer iDeserializer) {
        SuspensionControlAirProfiles[] suspensionControlAirProfilesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            suspensionControlAirProfilesArray = new SuspensionControlAirProfiles[n];
            for (int i2 = 0; i2 < n; ++i2) {
                suspensionControlAirProfilesArray[i2] = SuspensionControlAirProfilesSerializer.getOptionalSuspensionControlAirProfiles(iDeserializer);
            }
        }
        return suspensionControlAirProfilesArray;
    }
}

