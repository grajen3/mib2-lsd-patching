/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.sdars.SeekEntry;

public class SeekEntrySerializer {
    public static void putOptionalSeekEntry(ISerializer iSerializer, SeekEntry seekEntry) {
        boolean bl = seekEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = seekEntry.getSeekID();
            iSerializer.putInt32(n);
            int n2 = seekEntry.getContentLink();
            iSerializer.putInt32(n2);
            int n3 = seekEntry.getTypeOfContent();
            iSerializer.putInt32(n3);
            String string = seekEntry.getTitle1();
            iSerializer.putOptionalString(string);
            String string2 = seekEntry.getTitle2();
            iSerializer.putOptionalString(string2);
            boolean bl2 = seekEntry.isSeekActive();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalSeekEntryVarArray(ISerializer iSerializer, SeekEntry[] seekEntryArray) {
        boolean bl = seekEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(seekEntryArray.length);
            for (int i2 = 0; i2 < seekEntryArray.length; ++i2) {
                SeekEntrySerializer.putOptionalSeekEntry(iSerializer, seekEntryArray[i2]);
            }
        }
    }

    public static SeekEntry getOptionalSeekEntry(IDeserializer iDeserializer) {
        SeekEntry seekEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            String string;
            String string2;
            int n;
            int n2;
            int n3;
            seekEntry = new SeekEntry();
            seekEntry.seekID = n3 = iDeserializer.getInt32();
            seekEntry.contentLink = n2 = iDeserializer.getInt32();
            seekEntry.typeOfContent = n = iDeserializer.getInt32();
            seekEntry.title1 = string2 = iDeserializer.getOptionalString();
            seekEntry.title2 = string = iDeserializer.getOptionalString();
            seekEntry.seekActive = bl2 = iDeserializer.getBool();
        }
        return seekEntry;
    }

    public static SeekEntry[] getOptionalSeekEntryVarArray(IDeserializer iDeserializer) {
        SeekEntry[] seekEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            seekEntryArray = new SeekEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                seekEntryArray[i2] = SeekEntrySerializer.getOptionalSeekEntry(iDeserializer);
            }
        }
        return seekEntryArray;
    }
}

