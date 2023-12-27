/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.displaymanagement.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.displaymanagement.DisplayContext;

public class DisplayContextSerializer {
    public static void putOptionalDisplayContext(ISerializer iSerializer, DisplayContext displayContext) {
        boolean bl = displayContext == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = displayContext.getId();
            iSerializer.putInt32(n);
            int[] nArray = displayContext.getDisplayableList();
            iSerializer.putOptionalInt32VarArray(nArray);
        }
    }

    public static void putOptionalDisplayContextVarArray(ISerializer iSerializer, DisplayContext[] displayContextArray) {
        boolean bl = displayContextArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(displayContextArray.length);
            for (int i2 = 0; i2 < displayContextArray.length; ++i2) {
                DisplayContextSerializer.putOptionalDisplayContext(iSerializer, displayContextArray[i2]);
            }
        }
    }

    public static DisplayContext getOptionalDisplayContext(IDeserializer iDeserializer) {
        DisplayContext displayContext = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            displayContext = new DisplayContext();
            displayContext.id = n = iDeserializer.getInt32();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            displayContext.displayableList = nArray;
        }
        return displayContext;
    }

    public static DisplayContext[] getOptionalDisplayContextVarArray(IDeserializer iDeserializer) {
        DisplayContext[] displayContextArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            displayContextArray = new DisplayContext[n];
            for (int i2 = 0; i2 < n; ++i2) {
                displayContextArray[i2] = DisplayContextSerializer.getOptionalDisplayContext(iDeserializer);
            }
        }
        return displayContextArray;
    }
}

