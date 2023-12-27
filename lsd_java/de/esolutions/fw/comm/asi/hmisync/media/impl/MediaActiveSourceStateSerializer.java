/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.MediaActiveSourceState;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaSourceSlotSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class MediaActiveSourceStateSerializer {
    public static void putOptionalMediaActiveSourceState(ISerializer iSerializer, MediaActiveSourceState mediaActiveSourceState) {
        boolean bl = mediaActiveSourceState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            MediaSourceSlot mediaSourceSlot = mediaActiveSourceState.getSlot();
            MediaSourceSlotSerializer.putOptionalMediaSourceSlot(iSerializer, mediaSourceSlot);
            int n = mediaActiveSourceState.getState();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalMediaActiveSourceStateVarArray(ISerializer iSerializer, MediaActiveSourceState[] mediaActiveSourceStateArray) {
        boolean bl = mediaActiveSourceStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(mediaActiveSourceStateArray.length);
            for (int i2 = 0; i2 < mediaActiveSourceStateArray.length; ++i2) {
                MediaActiveSourceStateSerializer.putOptionalMediaActiveSourceState(iSerializer, mediaActiveSourceStateArray[i2]);
            }
        }
    }

    public static MediaActiveSourceState getOptionalMediaActiveSourceState(IDeserializer iDeserializer) {
        MediaActiveSourceState mediaActiveSourceState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            MediaSourceSlot mediaSourceSlot;
            mediaActiveSourceState = new MediaActiveSourceState();
            mediaActiveSourceState.slot = mediaSourceSlot = MediaSourceSlotSerializer.getOptionalMediaSourceSlot(iDeserializer);
            mediaActiveSourceState.state = n = iDeserializer.getInt32();
        }
        return mediaActiveSourceState;
    }

    public static MediaActiveSourceState[] getOptionalMediaActiveSourceStateVarArray(IDeserializer iDeserializer) {
        MediaActiveSourceState[] mediaActiveSourceStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            mediaActiveSourceStateArray = new MediaActiveSourceState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                mediaActiveSourceStateArray[i2] = MediaActiveSourceStateSerializer.getOptionalMediaActiveSourceState(iDeserializer);
            }
        }
        return mediaActiveSourceStateArray;
    }
}

