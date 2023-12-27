/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.organizer.EntryMeter;

public class EntryMeterSerializer {
    public static void putOptionalEntryMeter(ISerializer iSerializer, EntryMeter entryMeter) {
        boolean bl = entryMeter == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = entryMeter.getProfile();
            iSerializer.putInt32(n);
            int n2 = entryMeter.getLocalEntries();
            iSerializer.putInt32(n2);
            int n3 = entryMeter.getMeEntries();
            iSerializer.putInt32(n3);
            int n4 = entryMeter.getSimEntries();
            iSerializer.putInt32(n4);
            int n5 = entryMeter.getOppEntries();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalEntryMeterVarArray(ISerializer iSerializer, EntryMeter[] entryMeterArray) {
        boolean bl = entryMeterArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(entryMeterArray.length);
            for (int i2 = 0; i2 < entryMeterArray.length; ++i2) {
                EntryMeterSerializer.putOptionalEntryMeter(iSerializer, entryMeterArray[i2]);
            }
        }
    }

    public static EntryMeter getOptionalEntryMeter(IDeserializer iDeserializer) {
        EntryMeter entryMeter = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            entryMeter = new EntryMeter();
            entryMeter.profile = n5 = iDeserializer.getInt32();
            entryMeter.localEntries = n4 = iDeserializer.getInt32();
            entryMeter.meEntries = n3 = iDeserializer.getInt32();
            entryMeter.simEntries = n2 = iDeserializer.getInt32();
            entryMeter.oppEntries = n = iDeserializer.getInt32();
        }
        return entryMeter;
    }

    public static EntryMeter[] getOptionalEntryMeterVarArray(IDeserializer iDeserializer) {
        EntryMeter[] entryMeterArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            entryMeterArray = new EntryMeter[n];
            for (int i2 = 0; i2 < n; ++i2) {
                entryMeterArray[i2] = EntryMeterSerializer.getOptionalEntryMeter(iDeserializer);
            }
        }
        return entryMeterArray;
    }
}

