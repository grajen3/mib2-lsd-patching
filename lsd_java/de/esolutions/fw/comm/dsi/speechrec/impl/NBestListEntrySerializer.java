/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.speechrec.impl;

import de.esolutions.fw.comm.dsi.speechrec.impl.NBestSlotSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.speechrec.NBestListEntry;
import org.dsi.ifc.speechrec.NBestSlot;

public class NBestListEntrySerializer {
    public static void putOptionalNBestListEntry(ISerializer iSerializer, NBestListEntry nBestListEntry) {
        boolean bl = nBestListEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = nBestListEntry.getGrammarId();
            iSerializer.putInt32(n);
            String string = nBestListEntry.getRecognizedString();
            iSerializer.putOptionalString(string);
            String string2 = nBestListEntry.getRecognizedTag();
            iSerializer.putOptionalString(string2);
            int n2 = nBestListEntry.getConfidence();
            iSerializer.putInt32(n2);
            int n3 = nBestListEntry.getCommandHierarchie();
            iSerializer.putInt32(n3);
            int n4 = nBestListEntry.getGrammarType();
            iSerializer.putInt32(n4);
            int n5 = nBestListEntry.getGraphemicGroupIndex();
            iSerializer.putInt32(n5);
            NBestSlot[] nBestSlotArray = nBestListEntry.getSlots();
            NBestSlotSerializer.putOptionalNBestSlotVarArray(iSerializer, nBestSlotArray);
        }
    }

    public static void putOptionalNBestListEntryVarArray(ISerializer iSerializer, NBestListEntry[] nBestListEntryArray) {
        boolean bl = nBestListEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(nBestListEntryArray.length);
            for (int i2 = 0; i2 < nBestListEntryArray.length; ++i2) {
                NBestListEntrySerializer.putOptionalNBestListEntry(iSerializer, nBestListEntryArray[i2]);
            }
        }
    }

    public static NBestListEntry getOptionalNBestListEntry(IDeserializer iDeserializer) {
        NBestListEntry nBestListEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            String string;
            String string2;
            int n5;
            nBestListEntry = new NBestListEntry();
            nBestListEntry.grammarId = n5 = iDeserializer.getInt32();
            nBestListEntry.recognizedString = string2 = iDeserializer.getOptionalString();
            nBestListEntry.recognizedTag = string = iDeserializer.getOptionalString();
            nBestListEntry.confidence = n4 = iDeserializer.getInt32();
            nBestListEntry.commandHierarchie = n3 = iDeserializer.getInt32();
            nBestListEntry.grammarType = n2 = iDeserializer.getInt32();
            nBestListEntry.graphemicGroupIndex = n = iDeserializer.getInt32();
            NBestSlot[] nBestSlotArray = NBestSlotSerializer.getOptionalNBestSlotVarArray(iDeserializer);
            nBestListEntry.slots = nBestSlotArray;
        }
        return nBestListEntry;
    }

    public static NBestListEntry[] getOptionalNBestListEntryVarArray(IDeserializer iDeserializer) {
        NBestListEntry[] nBestListEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            nBestListEntryArray = new NBestListEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                nBestListEntryArray[i2] = NBestListEntrySerializer.getOptionalNBestListEntry(iDeserializer);
            }
        }
        return nBestListEntryArray;
    }
}

