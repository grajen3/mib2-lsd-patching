/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.ddp20.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.ddp20.FrameRequest;

public class FrameRequestSerializer {
    public static void putOptionalFrameRequest(ISerializer iSerializer, FrameRequest frameRequest) {
        boolean bl = frameRequest == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = frameRequest.getFrameID();
            iSerializer.putInt32(n);
            int n2 = frameRequest.getRequest();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalFrameRequestVarArray(ISerializer iSerializer, FrameRequest[] frameRequestArray) {
        boolean bl = frameRequestArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(frameRequestArray.length);
            for (int i2 = 0; i2 < frameRequestArray.length; ++i2) {
                FrameRequestSerializer.putOptionalFrameRequest(iSerializer, frameRequestArray[i2]);
            }
        }
    }

    public static FrameRequest getOptionalFrameRequest(IDeserializer iDeserializer) {
        FrameRequest frameRequest = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            frameRequest = new FrameRequest();
            frameRequest.frameID = n2 = iDeserializer.getInt32();
            frameRequest.request = n = iDeserializer.getInt32();
        }
        return frameRequest;
    }

    public static FrameRequest[] getOptionalFrameRequestVarArray(IDeserializer iDeserializer) {
        FrameRequest[] frameRequestArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            frameRequestArray = new FrameRequest[n];
            for (int i2 = 0; i2 < n; ++i2) {
                frameRequestArray[i2] = FrameRequestSerializer.getOptionalFrameRequest(iDeserializer);
            }
        }
        return frameRequestArray;
    }
}

