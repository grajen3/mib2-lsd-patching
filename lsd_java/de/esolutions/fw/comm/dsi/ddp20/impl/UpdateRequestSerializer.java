/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.ddp20.impl;

import de.esolutions.fw.comm.dsi.ddp20.impl.FrameUpdateSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.ddp20.FrameUpdate;
import org.dsi.ifc.ddp20.UpdateRequest;

public class UpdateRequestSerializer {
    public static void putOptionalUpdateRequest(ISerializer iSerializer, UpdateRequest updateRequest) {
        boolean bl = updateRequest == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = updateRequest.getNumFrames();
            iSerializer.putInt32(n);
            FrameUpdate[] frameUpdateArray = updateRequest.getFrameUpdate();
            FrameUpdateSerializer.putOptionalFrameUpdateVarArray(iSerializer, frameUpdateArray);
        }
    }

    public static void putOptionalUpdateRequestVarArray(ISerializer iSerializer, UpdateRequest[] updateRequestArray) {
        boolean bl = updateRequestArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(updateRequestArray.length);
            for (int i2 = 0; i2 < updateRequestArray.length; ++i2) {
                UpdateRequestSerializer.putOptionalUpdateRequest(iSerializer, updateRequestArray[i2]);
            }
        }
    }

    public static UpdateRequest getOptionalUpdateRequest(IDeserializer iDeserializer) {
        UpdateRequest updateRequest = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            updateRequest = new UpdateRequest();
            updateRequest.numFrames = n = iDeserializer.getInt32();
            FrameUpdate[] frameUpdateArray = FrameUpdateSerializer.getOptionalFrameUpdateVarArray(iDeserializer);
            updateRequest.frameUpdate = frameUpdateArray;
        }
        return updateRequest;
    }

    public static UpdateRequest[] getOptionalUpdateRequestVarArray(IDeserializer iDeserializer) {
        UpdateRequest[] updateRequestArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            updateRequestArray = new UpdateRequest[n];
            for (int i2 = 0; i2 < n; ++i2) {
                updateRequestArray[i2] = UpdateRequestSerializer.getOptionalUpdateRequest(iDeserializer);
            }
        }
        return updateRequestArray;
    }
}

