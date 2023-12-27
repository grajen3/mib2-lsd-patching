/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlDRCProfiles;

public class SuspensionControlDRCProfilesSerializer {
    public static void putOptionalSuspensionControlDRCProfiles(ISerializer iSerializer, SuspensionControlDRCProfiles suspensionControlDRCProfiles) {
        boolean bl = suspensionControlDRCProfiles == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = suspensionControlDRCProfiles.isProfile1();
            iSerializer.putBool(bl2);
            boolean bl3 = suspensionControlDRCProfiles.isProfile2();
            iSerializer.putBool(bl3);
            boolean bl4 = suspensionControlDRCProfiles.isProfile3();
            iSerializer.putBool(bl4);
            boolean bl5 = suspensionControlDRCProfiles.isProfile4();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalSuspensionControlDRCProfilesVarArray(ISerializer iSerializer, SuspensionControlDRCProfiles[] suspensionControlDRCProfilesArray) {
        boolean bl = suspensionControlDRCProfilesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(suspensionControlDRCProfilesArray.length);
            for (int i2 = 0; i2 < suspensionControlDRCProfilesArray.length; ++i2) {
                SuspensionControlDRCProfilesSerializer.putOptionalSuspensionControlDRCProfiles(iSerializer, suspensionControlDRCProfilesArray[i2]);
            }
        }
    }

    public static SuspensionControlDRCProfiles getOptionalSuspensionControlDRCProfiles(IDeserializer iDeserializer) {
        SuspensionControlDRCProfiles suspensionControlDRCProfiles = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            suspensionControlDRCProfiles = new SuspensionControlDRCProfiles();
            suspensionControlDRCProfiles.profile1 = bl5 = iDeserializer.getBool();
            suspensionControlDRCProfiles.profile2 = bl4 = iDeserializer.getBool();
            suspensionControlDRCProfiles.profile3 = bl3 = iDeserializer.getBool();
            suspensionControlDRCProfiles.profile4 = bl2 = iDeserializer.getBool();
        }
        return suspensionControlDRCProfiles;
    }

    public static SuspensionControlDRCProfiles[] getOptionalSuspensionControlDRCProfilesVarArray(IDeserializer iDeserializer) {
        SuspensionControlDRCProfiles[] suspensionControlDRCProfilesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            suspensionControlDRCProfilesArray = new SuspensionControlDRCProfiles[n];
            for (int i2 = 0; i2 < n; ++i2) {
                suspensionControlDRCProfilesArray[i2] = SuspensionControlDRCProfilesSerializer.getOptionalSuspensionControlDRCProfiles(iDeserializer);
            }
        }
        return suspensionControlDRCProfilesArray;
    }
}

