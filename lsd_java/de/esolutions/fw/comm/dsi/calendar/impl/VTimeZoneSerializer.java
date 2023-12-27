/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar.impl;

import de.esolutions.fw.comm.dsi.calendar.impl.VTimeZoneStandardSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.calendar.VTimeZone;
import org.dsi.ifc.calendar.VTimeZoneStandard;

public class VTimeZoneSerializer {
    public static void putOptionalVTimeZone(ISerializer iSerializer, VTimeZone vTimeZone) {
        boolean bl = vTimeZone == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = vTimeZone.getTzID();
            iSerializer.putOptionalString(string);
            VTimeZoneStandard[] vTimeZoneStandardArray = vTimeZone.getDaylight();
            VTimeZoneStandardSerializer.putOptionalVTimeZoneStandardVarArray(iSerializer, vTimeZoneStandardArray);
            VTimeZoneStandard[] vTimeZoneStandardArray2 = vTimeZone.getStandard();
            VTimeZoneStandardSerializer.putOptionalVTimeZoneStandardVarArray(iSerializer, vTimeZoneStandardArray2);
        }
    }

    public static void putOptionalVTimeZoneVarArray(ISerializer iSerializer, VTimeZone[] vTimeZoneArray) {
        boolean bl = vTimeZoneArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(vTimeZoneArray.length);
            for (int i2 = 0; i2 < vTimeZoneArray.length; ++i2) {
                VTimeZoneSerializer.putOptionalVTimeZone(iSerializer, vTimeZoneArray[i2]);
            }
        }
    }

    public static VTimeZone getOptionalVTimeZone(IDeserializer iDeserializer) {
        VTimeZone vTimeZone = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            vTimeZone = new VTimeZone();
            vTimeZone.tzID = string = iDeserializer.getOptionalString();
            VTimeZoneStandard[] vTimeZoneStandardArray = VTimeZoneStandardSerializer.getOptionalVTimeZoneStandardVarArray(iDeserializer);
            vTimeZone.daylight = vTimeZoneStandardArray;
            VTimeZoneStandard[] vTimeZoneStandardArray2 = VTimeZoneStandardSerializer.getOptionalVTimeZoneStandardVarArray(iDeserializer);
            vTimeZone.standard = vTimeZoneStandardArray2;
        }
        return vTimeZone;
    }

    public static VTimeZone[] getOptionalVTimeZoneVarArray(IDeserializer iDeserializer) {
        VTimeZone[] vTimeZoneArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            vTimeZoneArray = new VTimeZone[n];
            for (int i2 = 0; i2 < n; ++i2) {
                vTimeZoneArray[i2] = VTimeZoneSerializer.getOptionalVTimeZone(iDeserializer);
            }
        }
        return vTimeZoneArray;
    }
}

