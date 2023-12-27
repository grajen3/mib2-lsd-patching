/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.messaging.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.messaging.ExtractedItem;

public class ExtractedItemSerializer {
    public static void putOptionalExtractedItem(ISerializer iSerializer, ExtractedItem extractedItem) {
        boolean bl = extractedItem == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = extractedItem.getType();
            iSerializer.putInt32(n);
            String string = extractedItem.getValue();
            iSerializer.putOptionalString(string);
            int n2 = extractedItem.getOffset();
            iSerializer.putInt32(n2);
            int n3 = extractedItem.getLength();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalExtractedItemVarArray(ISerializer iSerializer, ExtractedItem[] extractedItemArray) {
        boolean bl = extractedItemArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(extractedItemArray.length);
            for (int i2 = 0; i2 < extractedItemArray.length; ++i2) {
                ExtractedItemSerializer.putOptionalExtractedItem(iSerializer, extractedItemArray[i2]);
            }
        }
    }

    public static ExtractedItem getOptionalExtractedItem(IDeserializer iDeserializer) {
        ExtractedItem extractedItem = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            String string;
            int n3;
            extractedItem = new ExtractedItem();
            extractedItem.type = n3 = iDeserializer.getInt32();
            extractedItem.value = string = iDeserializer.getOptionalString();
            extractedItem.offset = n2 = iDeserializer.getInt32();
            extractedItem.length = n = iDeserializer.getInt32();
        }
        return extractedItem;
    }

    public static ExtractedItem[] getOptionalExtractedItemVarArray(IDeserializer iDeserializer) {
        ExtractedItem[] extractedItemArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            extractedItemArray = new ExtractedItem[n];
            for (int i2 = 0; i2 < n; ++i2) {
                extractedItemArray[i2] = ExtractedItemSerializer.getOptionalExtractedItem(iDeserializer);
            }
        }
        return extractedItemArray;
    }
}

