/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar.impl;

import de.esolutions.fw.comm.dsi.calendar.impl.VAlarmSerializer;
import de.esolutions.fw.comm.dsi.calendar.impl.VAttendeeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.calendar.VAlarm;
import org.dsi.ifc.calendar.VAttendee;
import org.dsi.ifc.calendar.VEvent;

public class VEventSerializer {
    public static void putOptionalVEvent(ISerializer iSerializer, VEvent vEvent) {
        boolean bl = vEvent == null;
        iSerializer.putBool(bl);
        if (!bl) {
            VAlarm vAlarm = vEvent.getAlarm();
            VAlarmSerializer.putOptionalVAlarm(iSerializer, vAlarm);
            VAttendee[] vAttendeeArray = vEvent.getAttendeeList();
            VAttendeeSerializer.putOptionalVAttendeeVarArray(iSerializer, vAttendeeArray);
            String string = vEvent.getCategories();
            iSerializer.putOptionalString(string);
            String string2 = vEvent.getClassTyp();
            iSerializer.putOptionalString(string2);
            String string3 = vEvent.getCreated();
            iSerializer.putOptionalString(string3);
            String string4 = vEvent.getDescription();
            iSerializer.putOptionalString(string4);
            String string5 = vEvent.getDtEnd();
            iSerializer.putOptionalString(string5);
            String string6 = vEvent.getDtStart();
            iSerializer.putOptionalString(string6);
            String string7 = vEvent.getDtStamp();
            iSerializer.putOptionalString(string7);
            String string8 = vEvent.getDuration();
            iSerializer.putOptionalString(string8);
            String string9 = vEvent.getLastModified();
            iSerializer.putOptionalString(string9);
            String string10 = vEvent.getLocation();
            iSerializer.putOptionalString(string10);
            String string11 = vEvent.getPriority();
            iSerializer.putOptionalString(string11);
            VAttendee vAttendee = vEvent.getOrganizer();
            VAttendeeSerializer.putOptionalVAttendee(iSerializer, vAttendee);
            String string12 = vEvent.getSummary();
            iSerializer.putOptionalString(string12);
            String string13 = vEvent.getUid();
            iSerializer.putOptionalString(string13);
            String string14 = vEvent.getRrule();
            iSerializer.putOptionalString(string14);
            String string15 = vEvent.getSequence();
            iSerializer.putOptionalString(string15);
            String string16 = vEvent.getTransp();
            iSerializer.putOptionalString(string16);
            String string17 = vEvent.getUrl();
            iSerializer.putOptionalString(string17);
            String string18 = vEvent.getEntryType();
            iSerializer.putOptionalString(string18);
        }
    }

    public static void putOptionalVEventVarArray(ISerializer iSerializer, VEvent[] vEventArray) {
        boolean bl = vEventArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(vEventArray.length);
            for (int i2 = 0; i2 < vEventArray.length; ++i2) {
                VEventSerializer.putOptionalVEvent(iSerializer, vEventArray[i2]);
            }
        }
    }

    public static VEvent getOptionalVEvent(IDeserializer iDeserializer) {
        VEvent vEvent = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            String string7;
            VAttendee vAttendee;
            String string8;
            String string9;
            String string10;
            String string11;
            String string12;
            String string13;
            String string14;
            String string15;
            String string16;
            String string17;
            String string18;
            VAlarm vAlarm;
            vEvent = new VEvent();
            vEvent.alarm = vAlarm = VAlarmSerializer.getOptionalVAlarm(iDeserializer);
            VAttendee[] vAttendeeArray = VAttendeeSerializer.getOptionalVAttendeeVarArray(iDeserializer);
            vEvent.attendeeList = vAttendeeArray;
            vEvent.categories = string18 = iDeserializer.getOptionalString();
            vEvent.classTyp = string17 = iDeserializer.getOptionalString();
            vEvent.created = string16 = iDeserializer.getOptionalString();
            vEvent.description = string15 = iDeserializer.getOptionalString();
            vEvent.dtEnd = string14 = iDeserializer.getOptionalString();
            vEvent.dtStart = string13 = iDeserializer.getOptionalString();
            vEvent.dtStamp = string12 = iDeserializer.getOptionalString();
            vEvent.duration = string11 = iDeserializer.getOptionalString();
            vEvent.lastModified = string10 = iDeserializer.getOptionalString();
            vEvent.location = string9 = iDeserializer.getOptionalString();
            vEvent.priority = string8 = iDeserializer.getOptionalString();
            vEvent.organizer = vAttendee = VAttendeeSerializer.getOptionalVAttendee(iDeserializer);
            vEvent.summary = string7 = iDeserializer.getOptionalString();
            vEvent.uid = string6 = iDeserializer.getOptionalString();
            vEvent.rrule = string5 = iDeserializer.getOptionalString();
            vEvent.sequence = string4 = iDeserializer.getOptionalString();
            vEvent.transp = string3 = iDeserializer.getOptionalString();
            vEvent.url = string2 = iDeserializer.getOptionalString();
            vEvent.entryType = string = iDeserializer.getOptionalString();
        }
        return vEvent;
    }

    public static VEvent[] getOptionalVEventVarArray(IDeserializer iDeserializer) {
        VEvent[] vEventArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            vEventArray = new VEvent[n];
            for (int i2 = 0; i2 < n; ++i2) {
                vEventArray[i2] = VEventSerializer.getOptionalVEvent(iDeserializer);
            }
        }
        return vEventArray;
    }
}

