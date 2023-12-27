/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.ddp20.impl;

import de.esolutions.fw.comm.dsi.ddp20.impl.FrameInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.ddp20.DisplayStatus;
import org.dsi.ifc.ddp20.FrameInfo;

public class DisplayStatusSerializer {
    public static void putOptionalDisplayStatus(ISerializer iSerializer, DisplayStatus displayStatus) {
        boolean bl = displayStatus == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = displayStatus.getContextID();
            iSerializer.putInt32(n);
            int n2 = displayStatus.getReason();
            iSerializer.putInt32(n2);
            int n3 = displayStatus.getNumVisible();
            iSerializer.putInt32(n3);
            FrameInfo[] frameInfoArray = displayStatus.getFrameInfo();
            FrameInfoSerializer.putOptionalFrameInfoVarArray(iSerializer, frameInfoArray);
        }
    }

    public static void putOptionalDisplayStatusVarArray(ISerializer iSerializer, DisplayStatus[] displayStatusArray) {
        boolean bl = displayStatusArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(displayStatusArray.length);
            for (int i2 = 0; i2 < displayStatusArray.length; ++i2) {
                DisplayStatusSerializer.putOptionalDisplayStatus(iSerializer, displayStatusArray[i2]);
            }
        }
    }

    public static DisplayStatus getOptionalDisplayStatus(IDeserializer iDeserializer) {
        DisplayStatus displayStatus = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            displayStatus = new DisplayStatus();
            displayStatus.contextID = n3 = iDeserializer.getInt32();
            displayStatus.reason = n2 = iDeserializer.getInt32();
            displayStatus.numVisible = n = iDeserializer.getInt32();
            FrameInfo[] frameInfoArray = FrameInfoSerializer.getOptionalFrameInfoVarArray(iDeserializer);
            displayStatus.frameInfo = frameInfoArray;
        }
        return displayStatus;
    }

    public static DisplayStatus[] getOptionalDisplayStatusVarArray(IDeserializer iDeserializer) {
        DisplayStatus[] displayStatusArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            displayStatusArray = new DisplayStatus[n];
            for (int i2 = 0; i2 < n; ++i2) {
                displayStatusArray[i2] = DisplayStatusSerializer.getOptionalDisplayStatus(iDeserializer);
            }
        }
        return displayStatusArray;
    }
}

