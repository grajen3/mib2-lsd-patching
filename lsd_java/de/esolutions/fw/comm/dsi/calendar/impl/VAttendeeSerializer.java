/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.calendar.VAttendee;

public class VAttendeeSerializer {
    public static void putOptionalVAttendee(ISerializer iSerializer, VAttendee vAttendee) {
        boolean bl = vAttendee == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = vAttendee.getCn();
            iSerializer.putOptionalString(string);
            String string2 = vAttendee.getCutype();
            iSerializer.putOptionalString(string2);
            String string3 = vAttendee.getMailto();
            iSerializer.putOptionalString(string3);
            String string4 = vAttendee.getRole();
            iSerializer.putOptionalString(string4);
            String string5 = vAttendee.getRsvp();
            iSerializer.putOptionalString(string5);
        }
    }

    public static void putOptionalVAttendeeVarArray(ISerializer iSerializer, VAttendee[] vAttendeeArray) {
        boolean bl = vAttendeeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(vAttendeeArray.length);
            for (int i2 = 0; i2 < vAttendeeArray.length; ++i2) {
                VAttendeeSerializer.putOptionalVAttendee(iSerializer, vAttendeeArray[i2]);
            }
        }
    }

    public static VAttendee getOptionalVAttendee(IDeserializer iDeserializer) {
        VAttendee vAttendee = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            vAttendee = new VAttendee();
            vAttendee.cn = string5 = iDeserializer.getOptionalString();
            vAttendee.cutype = string4 = iDeserializer.getOptionalString();
            vAttendee.mailto = string3 = iDeserializer.getOptionalString();
            vAttendee.role = string2 = iDeserializer.getOptionalString();
            vAttendee.rsvp = string = iDeserializer.getOptionalString();
        }
        return vAttendee;
    }

    public static VAttendee[] getOptionalVAttendeeVarArray(IDeserializer iDeserializer) {
        VAttendee[] vAttendeeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            vAttendeeArray = new VAttendee[n];
            for (int i2 = 0; i2 < n; ++i2) {
                vAttendeeArray[i2] = VAttendeeSerializer.getOptionalVAttendee(iDeserializer);
            }
        }
        return vAttendeeArray;
    }
}

