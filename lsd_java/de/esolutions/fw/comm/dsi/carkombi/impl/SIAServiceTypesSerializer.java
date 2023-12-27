/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.SIAServiceTypes;

public class SIAServiceTypesSerializer {
    public static void putOptionalSIAServiceTypes(ISerializer iSerializer, SIAServiceTypes sIAServiceTypes) {
        boolean bl = sIAServiceTypes == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = sIAServiceTypes.isMaintenanceService();
            iSerializer.putBool(bl2);
            boolean bl3 = sIAServiceTypes.isOilService();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalSIAServiceTypesVarArray(ISerializer iSerializer, SIAServiceTypes[] sIAServiceTypesArray) {
        boolean bl = sIAServiceTypesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sIAServiceTypesArray.length);
            for (int i2 = 0; i2 < sIAServiceTypesArray.length; ++i2) {
                SIAServiceTypesSerializer.putOptionalSIAServiceTypes(iSerializer, sIAServiceTypesArray[i2]);
            }
        }
    }

    public static SIAServiceTypes getOptionalSIAServiceTypes(IDeserializer iDeserializer) {
        SIAServiceTypes sIAServiceTypes = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            sIAServiceTypes = new SIAServiceTypes();
            sIAServiceTypes.maintenanceService = bl3 = iDeserializer.getBool();
            sIAServiceTypes.oilService = bl2 = iDeserializer.getBool();
        }
        return sIAServiceTypes;
    }

    public static SIAServiceTypes[] getOptionalSIAServiceTypesVarArray(IDeserializer iDeserializer) {
        SIAServiceTypes[] sIAServiceTypesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sIAServiceTypesArray = new SIAServiceTypes[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sIAServiceTypesArray[i2] = SIAServiceTypesSerializer.getOptionalSIAServiceTypes(iDeserializer);
            }
        }
        return sIAServiceTypesArray;
    }
}

