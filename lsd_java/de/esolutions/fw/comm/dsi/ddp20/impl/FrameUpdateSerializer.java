/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.ddp20.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.ddp20.FrameUpdate;

public class FrameUpdateSerializer {
    public static void putOptionalFrameUpdate(ISerializer iSerializer, FrameUpdate frameUpdate) {
        boolean bl = frameUpdate == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = frameUpdate.getFrameID();
            iSerializer.putInt32(n);
            int n2 = frameUpdate.getOffset();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalFrameUpdateVarArray(ISerializer iSerializer, FrameUpdate[] frameUpdateArray) {
        boolean bl = frameUpdateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(frameUpdateArray.length);
            for (int i2 = 0; i2 < frameUpdateArray.length; ++i2) {
                FrameUpdateSerializer.putOptionalFrameUpdate(iSerializer, frameUpdateArray[i2]);
            }
        }
    }

    public static FrameUpdate getOptionalFrameUpdate(IDeserializer iDeserializer) {
        FrameUpdate frameUpdate = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            frameUpdate = new FrameUpdate();
            frameUpdate.frameID = n2 = iDeserializer.getInt32();
            frameUpdate.offset = n = iDeserializer.getInt32();
        }
        return frameUpdate;
    }

    public static FrameUpdate[] getOptionalFrameUpdateVarArray(IDeserializer iDeserializer) {
        FrameUpdate[] frameUpdateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            frameUpdateArray = new FrameUpdate[n];
            for (int i2 = 0; i2 < n; ++i2) {
                frameUpdateArray[i2] = FrameUpdateSerializer.getOptionalFrameUpdate(iDeserializer);
            }
        }
        return frameUpdateArray;
    }
}

