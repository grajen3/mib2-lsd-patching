/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.calendar.VTimeZoneStandard;

public class VTimeZoneStandardSerializer {
    public static void putOptionalVTimeZoneStandard(ISerializer iSerializer, VTimeZoneStandard vTimeZoneStandard) {
        boolean bl = vTimeZoneStandard == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = vTimeZoneStandard.getDtStart();
            iSerializer.putOptionalString(string);
            String string2 = vTimeZoneStandard.getRdate();
            iSerializer.putOptionalString(string2);
            String string3 = vTimeZoneStandard.getRrule();
            iSerializer.putOptionalString(string3);
            String string4 = vTimeZoneStandard.getTzName();
            iSerializer.putOptionalString(string4);
            String string5 = vTimeZoneStandard.getEntryTyp();
            iSerializer.putOptionalString(string5);
            String string6 = vTimeZoneStandard.getTzOffsetFrom();
            iSerializer.putOptionalString(string6);
            String string7 = vTimeZoneStandard.getTzOffsetTo();
            iSerializer.putOptionalString(string7);
            String string8 = vTimeZoneStandard.getDue();
            iSerializer.putOptionalString(string8);
            String string9 = vTimeZoneStandard.getExdate();
            iSerializer.putOptionalString(string9);
        }
    }

    public static void putOptionalVTimeZoneStandardVarArray(ISerializer iSerializer, VTimeZoneStandard[] vTimeZoneStandardArray) {
        boolean bl = vTimeZoneStandardArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(vTimeZoneStandardArray.length);
            for (int i2 = 0; i2 < vTimeZoneStandardArray.length; ++i2) {
                VTimeZoneStandardSerializer.putOptionalVTimeZoneStandard(iSerializer, vTimeZoneStandardArray[i2]);
            }
        }
    }

    public static VTimeZoneStandard getOptionalVTimeZoneStandard(IDeserializer iDeserializer) {
        VTimeZoneStandard vTimeZoneStandard = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            String string7;
            String string8;
            String string9;
            vTimeZoneStandard = new VTimeZoneStandard();
            vTimeZoneStandard.dtStart = string9 = iDeserializer.getOptionalString();
            vTimeZoneStandard.rdate = string8 = iDeserializer.getOptionalString();
            vTimeZoneStandard.rrule = string7 = iDeserializer.getOptionalString();
            vTimeZoneStandard.tzName = string6 = iDeserializer.getOptionalString();
            vTimeZoneStandard.entryTyp = string5 = iDeserializer.getOptionalString();
            vTimeZoneStandard.tzOffsetFrom = string4 = iDeserializer.getOptionalString();
            vTimeZoneStandard.tzOffsetTo = string3 = iDeserializer.getOptionalString();
            vTimeZoneStandard.due = string2 = iDeserializer.getOptionalString();
            vTimeZoneStandard.exdate = string = iDeserializer.getOptionalString();
        }
        return vTimeZoneStandard;
    }

    public static VTimeZoneStandard[] getOptionalVTimeZoneStandardVarArray(IDeserializer iDeserializer) {
        VTimeZoneStandard[] vTimeZoneStandardArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            vTimeZoneStandardArray = new VTimeZoneStandard[n];
            for (int i2 = 0; i2 < n; ++i2) {
                vTimeZoneStandardArray[i2] = VTimeZoneStandardSerializer.getOptionalVTimeZoneStandard(iDeserializer);
            }
        }
        return vTimeZoneStandardArray;
    }
}

