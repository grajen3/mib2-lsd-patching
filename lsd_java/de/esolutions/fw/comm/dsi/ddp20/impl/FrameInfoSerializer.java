/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.ddp20.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.ddp20.FrameInfo;

public class FrameInfoSerializer {
    public static void putOptionalFrameInfo(ISerializer iSerializer, FrameInfo frameInfo) {
        boolean bl = frameInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = frameInfo.getFrameID();
            iSerializer.putInt32(n);
            int n2 = frameInfo.getEventFocus();
            iSerializer.putInt32(n2);
            int n3 = frameInfo.getOffset();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalFrameInfoVarArray(ISerializer iSerializer, FrameInfo[] frameInfoArray) {
        boolean bl = frameInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(frameInfoArray.length);
            for (int i2 = 0; i2 < frameInfoArray.length; ++i2) {
                FrameInfoSerializer.putOptionalFrameInfo(iSerializer, frameInfoArray[i2]);
            }
        }
    }

    public static FrameInfo getOptionalFrameInfo(IDeserializer iDeserializer) {
        FrameInfo frameInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            frameInfo = new FrameInfo();
            frameInfo.frameID = n3 = iDeserializer.getInt32();
            frameInfo.eventFocus = n2 = iDeserializer.getInt32();
            frameInfo.offset = n = iDeserializer.getInt32();
        }
        return frameInfo;
    }

    public static FrameInfo[] getOptionalFrameInfoVarArray(IDeserializer iDeserializer) {
        FrameInfo[] frameInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            frameInfoArray = new FrameInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                frameInfoArray[i2] = FrameInfoSerializer.getOptionalFrameInfo(iDeserializer);
            }
        }
        return frameInfoArray;
    }
}

