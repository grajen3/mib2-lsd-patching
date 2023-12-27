/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar.impl;

import de.esolutions.fw.comm.dsi.calendar.impl.VEventSerializer;
import de.esolutions.fw.comm.dsi.calendar.impl.VTimeZoneSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.calendar.VCalendar;
import org.dsi.ifc.calendar.VEvent;
import org.dsi.ifc.calendar.VTimeZone;

public class VCalendarSerializer {
    public static void putOptionalVCalendar(ISerializer iSerializer, VCalendar vCalendar) {
        boolean bl = vCalendar == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = vCalendar.getCategories();
            iSerializer.putOptionalString(string);
            String string2 = vCalendar.getClassType();
            iSerializer.putOptionalString(string2);
            String string3 = vCalendar.getDescription();
            iSerializer.putOptionalString(string3);
            String string4 = vCalendar.getDtEnd();
            iSerializer.putOptionalString(string4);
            String string5 = vCalendar.getDtStamp();
            iSerializer.putOptionalString(string5);
            String string6 = vCalendar.getDtStart();
            iSerializer.putOptionalString(string6);
            String string7 = vCalendar.getMethod();
            iSerializer.putOptionalString(string7);
            String string8 = vCalendar.getSummary();
            iSerializer.putOptionalString(string8);
            VTimeZone[] vTimeZoneArray = vCalendar.getTimeZone();
            VTimeZoneSerializer.putOptionalVTimeZoneVarArray(iSerializer, vTimeZoneArray);
            String string9 = vCalendar.getTzID();
            iSerializer.putOptionalString(string9);
            String string10 = vCalendar.getUid();
            iSerializer.putOptionalString(string10);
            String string11 = vCalendar.getVersion();
            iSerializer.putOptionalString(string11);
            VEvent[] vEventArray = vCalendar.getVevent();
            VEventSerializer.putOptionalVEventVarArray(iSerializer, vEventArray);
        }
    }

    public static void putOptionalVCalendarVarArray(ISerializer iSerializer, VCalendar[] vCalendarArray) {
        boolean bl = vCalendarArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(vCalendarArray.length);
            for (int i2 = 0; i2 < vCalendarArray.length; ++i2) {
                VCalendarSerializer.putOptionalVCalendar(iSerializer, vCalendarArray[i2]);
            }
        }
    }

    public static VCalendar getOptionalVCalendar(IDeserializer iDeserializer) {
        VCalendar vCalendar = null;
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
            String string10;
            String string11;
            vCalendar = new VCalendar();
            vCalendar.categories = string11 = iDeserializer.getOptionalString();
            vCalendar.classType = string10 = iDeserializer.getOptionalString();
            vCalendar.description = string9 = iDeserializer.getOptionalString();
            vCalendar.dtEnd = string8 = iDeserializer.getOptionalString();
            vCalendar.dtStamp = string7 = iDeserializer.getOptionalString();
            vCalendar.dtStart = string6 = iDeserializer.getOptionalString();
            vCalendar.method = string5 = iDeserializer.getOptionalString();
            vCalendar.summary = string4 = iDeserializer.getOptionalString();
            VTimeZone[] vTimeZoneArray = VTimeZoneSerializer.getOptionalVTimeZoneVarArray(iDeserializer);
            vCalendar.timeZone = vTimeZoneArray;
            vCalendar.tzID = string3 = iDeserializer.getOptionalString();
            vCalendar.uid = string2 = iDeserializer.getOptionalString();
            vCalendar.version = string = iDeserializer.getOptionalString();
            VEvent[] vEventArray = VEventSerializer.getOptionalVEventVarArray(iDeserializer);
            vCalendar.vevent = vEventArray;
        }
        return vCalendar;
    }

    public static VCalendar[] getOptionalVCalendarVarArray(IDeserializer iDeserializer) {
        VCalendar[] vCalendarArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            vCalendarArray = new VCalendar[n];
            for (int i2 = 0; i2 < n; ++i2) {
                vCalendarArray[i2] = VCalendarSerializer.getOptionalVCalendar(iDeserializer);
            }
        }
        return vCalendarArray;
    }
}

