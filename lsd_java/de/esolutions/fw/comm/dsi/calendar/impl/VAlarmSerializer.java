/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.calendar.VAlarm;

public class VAlarmSerializer {
    public static void putOptionalVAlarm(ISerializer iSerializer, VAlarm vAlarm) {
        boolean bl = vAlarm == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = vAlarm.getAction();
            iSerializer.putOptionalString(string);
            String string2 = vAlarm.getDescription();
            iSerializer.putOptionalString(string2);
            String string3 = vAlarm.getTrigger();
            iSerializer.putOptionalString(string3);
        }
    }

    public static void putOptionalVAlarmVarArray(ISerializer iSerializer, VAlarm[] vAlarmArray) {
        boolean bl = vAlarmArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(vAlarmArray.length);
            for (int i2 = 0; i2 < vAlarmArray.length; ++i2) {
                VAlarmSerializer.putOptionalVAlarm(iSerializer, vAlarmArray[i2]);
            }
        }
    }

    public static VAlarm getOptionalVAlarm(IDeserializer iDeserializer) {
        VAlarm vAlarm = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            vAlarm = new VAlarm();
            vAlarm.action = string3 = iDeserializer.getOptionalString();
            vAlarm.description = string2 = iDeserializer.getOptionalString();
            vAlarm.trigger = string = iDeserializer.getOptionalString();
        }
        return vAlarm;
    }

    public static VAlarm[] getOptionalVAlarmVarArray(IDeserializer iDeserializer) {
        VAlarm[] vAlarmArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            vAlarmArray = new VAlarm[n];
            for (int i2 = 0; i2 < n; ++i2) {
                vAlarmArray[i2] = VAlarmSerializer.getOptionalVAlarm(iDeserializer);
            }
        }
        return vAlarmArray;
    }
}

