/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync2.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync2.DisplayStatusFlags;

public class DisplayStatusFlagsSerializer {
    public static void putOptionalDisplayStatusFlags(ISerializer iSerializer, DisplayStatusFlags displayStatusFlags) {
        boolean bl = displayStatusFlags == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = displayStatusFlags.getStatusFlags();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalDisplayStatusFlagsVarArray(ISerializer iSerializer, DisplayStatusFlags[] displayStatusFlagsArray) {
        boolean bl = displayStatusFlagsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(displayStatusFlagsArray.length);
            for (int i2 = 0; i2 < displayStatusFlagsArray.length; ++i2) {
                DisplayStatusFlagsSerializer.putOptionalDisplayStatusFlags(iSerializer, displayStatusFlagsArray[i2]);
            }
        }
    }

    public static DisplayStatusFlags getOptionalDisplayStatusFlags(IDeserializer iDeserializer) {
        DisplayStatusFlags displayStatusFlags = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            displayStatusFlags = new DisplayStatusFlags();
            displayStatusFlags.statusFlags = n = iDeserializer.getInt32();
        }
        return displayStatusFlags;
    }

    public static DisplayStatusFlags[] getOptionalDisplayStatusFlagsVarArray(IDeserializer iDeserializer) {
        DisplayStatusFlags[] displayStatusFlagsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            displayStatusFlagsArray = new DisplayStatusFlags[n];
            for (int i2 = 0; i2 < n; ++i2) {
                displayStatusFlagsArray[i2] = DisplayStatusFlagsSerializer.getOptionalDisplayStatusFlags(iDeserializer);
            }
        }
        return displayStatusFlagsArray;
    }
}

