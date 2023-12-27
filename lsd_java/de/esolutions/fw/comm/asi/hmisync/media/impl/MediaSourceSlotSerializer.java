/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class MediaSourceSlotSerializer {
    public static void putOptionalMediaSourceSlot(ISerializer iSerializer, MediaSourceSlot mediaSourceSlot) {
        boolean bl = mediaSourceSlot == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = mediaSourceSlot.getSource();
            iSerializer.putInt32(n);
            int n2 = mediaSourceSlot.getSlotIdx();
            iSerializer.putInt32(n2);
            int n3 = mediaSourceSlot.getMediaType();
            iSerializer.putInt32(n3);
            int n4 = mediaSourceSlot.getDeviceIdx();
            iSerializer.putInt32(n4);
            int n5 = mediaSourceSlot.getState();
            iSerializer.putInt32(n5);
            int n6 = mediaSourceSlot.getFlags();
            iSerializer.putInt32(n6);
            String string = mediaSourceSlot.getName();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalMediaSourceSlotVarArray(ISerializer iSerializer, MediaSourceSlot[] mediaSourceSlotArray) {
        boolean bl = mediaSourceSlotArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(mediaSourceSlotArray.length);
            for (int i2 = 0; i2 < mediaSourceSlotArray.length; ++i2) {
                MediaSourceSlotSerializer.putOptionalMediaSourceSlot(iSerializer, mediaSourceSlotArray[i2]);
            }
        }
    }

    public static MediaSourceSlot getOptionalMediaSourceSlot(IDeserializer iDeserializer) {
        MediaSourceSlot mediaSourceSlot = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            mediaSourceSlot = new MediaSourceSlot();
            mediaSourceSlot.source = n6 = iDeserializer.getInt32();
            mediaSourceSlot.slotIdx = n5 = iDeserializer.getInt32();
            mediaSourceSlot.mediaType = n4 = iDeserializer.getInt32();
            mediaSourceSlot.deviceIdx = n3 = iDeserializer.getInt32();
            mediaSourceSlot.state = n2 = iDeserializer.getInt32();
            mediaSourceSlot.flags = n = iDeserializer.getInt32();
            mediaSourceSlot.name = string = iDeserializer.getOptionalString();
        }
        return mediaSourceSlot;
    }

    public static MediaSourceSlot[] getOptionalMediaSourceSlotVarArray(IDeserializer iDeserializer) {
        MediaSourceSlot[] mediaSourceSlotArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            mediaSourceSlotArray = new MediaSourceSlot[n];
            for (int i2 = 0; i2 < n; ++i2) {
                mediaSourceSlotArray[i2] = MediaSourceSlotSerializer.getOptionalMediaSourceSlot(iDeserializer);
            }
        }
        return mediaSourceSlotArray;
    }
}

