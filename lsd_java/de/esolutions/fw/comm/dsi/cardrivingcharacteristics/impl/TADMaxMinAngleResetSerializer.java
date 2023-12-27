/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.TADMaxMinAngleReset;

public class TADMaxMinAngleResetSerializer {
    public static void putOptionalTADMaxMinAngleReset(ISerializer iSerializer, TADMaxMinAngleReset tADMaxMinAngleReset) {
        boolean bl = tADMaxMinAngleReset == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = tADMaxMinAngleReset.isRollAngle();
            iSerializer.putBool(bl2);
            boolean bl3 = tADMaxMinAngleReset.isPitchAngle();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalTADMaxMinAngleResetVarArray(ISerializer iSerializer, TADMaxMinAngleReset[] tADMaxMinAngleResetArray) {
        boolean bl = tADMaxMinAngleResetArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tADMaxMinAngleResetArray.length);
            for (int i2 = 0; i2 < tADMaxMinAngleResetArray.length; ++i2) {
                TADMaxMinAngleResetSerializer.putOptionalTADMaxMinAngleReset(iSerializer, tADMaxMinAngleResetArray[i2]);
            }
        }
    }

    public static TADMaxMinAngleReset getOptionalTADMaxMinAngleReset(IDeserializer iDeserializer) {
        TADMaxMinAngleReset tADMaxMinAngleReset = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            tADMaxMinAngleReset = new TADMaxMinAngleReset();
            tADMaxMinAngleReset.rollAngle = bl3 = iDeserializer.getBool();
            tADMaxMinAngleReset.pitchAngle = bl2 = iDeserializer.getBool();
        }
        return tADMaxMinAngleReset;
    }

    public static TADMaxMinAngleReset[] getOptionalTADMaxMinAngleResetVarArray(IDeserializer iDeserializer) {
        TADMaxMinAngleReset[] tADMaxMinAngleResetArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tADMaxMinAngleResetArray = new TADMaxMinAngleReset[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tADMaxMinAngleResetArray[i2] = TADMaxMinAngleResetSerializer.getOptionalTADMaxMinAngleReset(iDeserializer);
            }
        }
        return tADMaxMinAngleResetArray;
    }
}

