/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.ACCDistanceWarning;

public class ACCDistanceWarningSerializer {
    public static void putOptionalACCDistanceWarning(ISerializer iSerializer, ACCDistanceWarning aCCDistanceWarning) {
        boolean bl = aCCDistanceWarning == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = aCCDistanceWarning.isSystemState();
            iSerializer.putBool(bl2);
            short s = aCCDistanceWarning.getTimeGap();
            iSerializer.putInt16(s);
        }
    }

    public static void putOptionalACCDistanceWarningVarArray(ISerializer iSerializer, ACCDistanceWarning[] aCCDistanceWarningArray) {
        boolean bl = aCCDistanceWarningArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(aCCDistanceWarningArray.length);
            for (int i2 = 0; i2 < aCCDistanceWarningArray.length; ++i2) {
                ACCDistanceWarningSerializer.putOptionalACCDistanceWarning(iSerializer, aCCDistanceWarningArray[i2]);
            }
        }
    }

    public static ACCDistanceWarning getOptionalACCDistanceWarning(IDeserializer iDeserializer) {
        ACCDistanceWarning aCCDistanceWarning = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            boolean bl2;
            aCCDistanceWarning = new ACCDistanceWarning();
            aCCDistanceWarning.systemState = bl2 = iDeserializer.getBool();
            aCCDistanceWarning.timeGap = s = iDeserializer.getInt16();
        }
        return aCCDistanceWarning;
    }

    public static ACCDistanceWarning[] getOptionalACCDistanceWarningVarArray(IDeserializer iDeserializer) {
        ACCDistanceWarning[] aCCDistanceWarningArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            aCCDistanceWarningArray = new ACCDistanceWarning[n];
            for (int i2 = 0; i2 < n; ++i2) {
                aCCDistanceWarningArray[i2] = ACCDistanceWarningSerializer.getOptionalACCDistanceWarning(iDeserializer);
            }
        }
        return aCCDistanceWarningArray;
    }
}

