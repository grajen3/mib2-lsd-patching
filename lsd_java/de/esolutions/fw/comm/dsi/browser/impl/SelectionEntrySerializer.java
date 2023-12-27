/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.browser.SelectionEntry;

public class SelectionEntrySerializer {
    public static void putOptionalSelectionEntry(ISerializer iSerializer, SelectionEntry selectionEntry) {
        boolean bl = selectionEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = selectionEntry.getEntryIdentifier();
            iSerializer.putInt32(n);
            String string = selectionEntry.getText();
            iSerializer.putOptionalString(string);
            String string2 = selectionEntry.getValue();
            iSerializer.putOptionalString(string2);
            boolean bl2 = selectionEntry.isSelected();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalSelectionEntryVarArray(ISerializer iSerializer, SelectionEntry[] selectionEntryArray) {
        boolean bl = selectionEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(selectionEntryArray.length);
            for (int i2 = 0; i2 < selectionEntryArray.length; ++i2) {
                SelectionEntrySerializer.putOptionalSelectionEntry(iSerializer, selectionEntryArray[i2]);
            }
        }
    }

    public static SelectionEntry getOptionalSelectionEntry(IDeserializer iDeserializer) {
        SelectionEntry selectionEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            String string;
            String string2;
            int n;
            selectionEntry = new SelectionEntry();
            selectionEntry.entryIdentifier = n = iDeserializer.getInt32();
            selectionEntry.text = string2 = iDeserializer.getOptionalString();
            selectionEntry.value = string = iDeserializer.getOptionalString();
            selectionEntry.selected = bl2 = iDeserializer.getBool();
        }
        return selectionEntry;
    }

    public static SelectionEntry[] getOptionalSelectionEntryVarArray(IDeserializer iDeserializer) {
        SelectionEntry[] selectionEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            selectionEntryArray = new SelectionEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                selectionEntryArray[i2] = SelectionEntrySerializer.getOptionalSelectionEntry(iDeserializer);
            }
        }
        return selectionEntryArray;
    }
}

