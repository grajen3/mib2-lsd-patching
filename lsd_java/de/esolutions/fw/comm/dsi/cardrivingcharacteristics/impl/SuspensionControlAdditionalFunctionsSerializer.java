/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlAdditionalFunctions;

public class SuspensionControlAdditionalFunctionsSerializer {
    public static void putOptionalSuspensionControlAdditionalFunctions(ISerializer iSerializer, SuspensionControlAdditionalFunctions suspensionControlAdditionalFunctions) {
        boolean bl = suspensionControlAdditionalFunctions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = suspensionControlAdditionalFunctions.isActualNiveau();
            iSerializer.putBool(bl2);
            boolean bl3 = suspensionControlAdditionalFunctions.isTargetNiveau();
            iSerializer.putBool(bl3);
            boolean bl4 = suspensionControlAdditionalFunctions.isVehicleStatus();
            iSerializer.putBool(bl4);
            boolean bl5 = suspensionControlAdditionalFunctions.isVehicleStateControl();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalSuspensionControlAdditionalFunctionsVarArray(ISerializer iSerializer, SuspensionControlAdditionalFunctions[] suspensionControlAdditionalFunctionsArray) {
        boolean bl = suspensionControlAdditionalFunctionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(suspensionControlAdditionalFunctionsArray.length);
            for (int i2 = 0; i2 < suspensionControlAdditionalFunctionsArray.length; ++i2) {
                SuspensionControlAdditionalFunctionsSerializer.putOptionalSuspensionControlAdditionalFunctions(iSerializer, suspensionControlAdditionalFunctionsArray[i2]);
            }
        }
    }

    public static SuspensionControlAdditionalFunctions getOptionalSuspensionControlAdditionalFunctions(IDeserializer iDeserializer) {
        SuspensionControlAdditionalFunctions suspensionControlAdditionalFunctions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            suspensionControlAdditionalFunctions = new SuspensionControlAdditionalFunctions();
            suspensionControlAdditionalFunctions.actualNiveau = bl5 = iDeserializer.getBool();
            suspensionControlAdditionalFunctions.targetNiveau = bl4 = iDeserializer.getBool();
            suspensionControlAdditionalFunctions.vehicleStatus = bl3 = iDeserializer.getBool();
            suspensionControlAdditionalFunctions.vehicleStateControl = bl2 = iDeserializer.getBool();
        }
        return suspensionControlAdditionalFunctions;
    }

    public static SuspensionControlAdditionalFunctions[] getOptionalSuspensionControlAdditionalFunctionsVarArray(IDeserializer iDeserializer) {
        SuspensionControlAdditionalFunctions[] suspensionControlAdditionalFunctionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            suspensionControlAdditionalFunctionsArray = new SuspensionControlAdditionalFunctions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                suspensionControlAdditionalFunctionsArray[i2] = SuspensionControlAdditionalFunctionsSerializer.getOptionalSuspensionControlAdditionalFunctions(iDeserializer);
            }
        }
        return suspensionControlAdditionalFunctionsArray;
    }
}

