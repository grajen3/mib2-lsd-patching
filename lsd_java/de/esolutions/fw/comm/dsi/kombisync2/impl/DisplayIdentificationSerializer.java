/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync2.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync2.DisplayIdentification;

public class DisplayIdentificationSerializer {
    public static void putOptionalDisplayIdentification(ISerializer iSerializer, DisplayIdentification displayIdentification) {
        boolean bl = displayIdentification == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = displayIdentification.getDay();
            iSerializer.putInt32(n);
            int n2 = displayIdentification.getMonth();
            iSerializer.putInt32(n2);
            int n3 = displayIdentification.getYear();
            iSerializer.putInt32(n3);
            int n4 = displayIdentification.getHour();
            iSerializer.putInt32(n4);
            int n5 = displayIdentification.getMinute();
            iSerializer.putInt32(n5);
            int n6 = displayIdentification.getSeconds();
            iSerializer.putInt32(n6);
            int n7 = displayIdentification.getVersionMain();
            iSerializer.putInt32(n7);
            int n8 = displayIdentification.getVersionSub();
            iSerializer.putInt32(n8);
        }
    }

    public static void putOptionalDisplayIdentificationVarArray(ISerializer iSerializer, DisplayIdentification[] displayIdentificationArray) {
        boolean bl = displayIdentificationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(displayIdentificationArray.length);
            for (int i2 = 0; i2 < displayIdentificationArray.length; ++i2) {
                DisplayIdentificationSerializer.putOptionalDisplayIdentification(iSerializer, displayIdentificationArray[i2]);
            }
        }
    }

    public static DisplayIdentification getOptionalDisplayIdentification(IDeserializer iDeserializer) {
        DisplayIdentification displayIdentification = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            displayIdentification = new DisplayIdentification();
            displayIdentification.day = n8 = iDeserializer.getInt32();
            displayIdentification.month = n7 = iDeserializer.getInt32();
            displayIdentification.year = n6 = iDeserializer.getInt32();
            displayIdentification.hour = n5 = iDeserializer.getInt32();
            displayIdentification.minute = n4 = iDeserializer.getInt32();
            displayIdentification.seconds = n3 = iDeserializer.getInt32();
            displayIdentification.versionMain = n2 = iDeserializer.getInt32();
            displayIdentification.versionSub = n = iDeserializer.getInt32();
        }
        return displayIdentification;
    }

    public static DisplayIdentification[] getOptionalDisplayIdentificationVarArray(IDeserializer iDeserializer) {
        DisplayIdentification[] displayIdentificationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            displayIdentificationArray = new DisplayIdentification[n];
            for (int i2 = 0; i2 < n; ++i2) {
                displayIdentificationArray[i2] = DisplayIdentificationSerializer.getOptionalDisplayIdentification(iDeserializer);
            }
        }
        return displayIdentificationArray;
    }
}

