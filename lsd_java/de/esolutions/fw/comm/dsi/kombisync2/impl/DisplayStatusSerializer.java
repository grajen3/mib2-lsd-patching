/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync2.impl;

import de.esolutions.fw.comm.dsi.kombisync2.impl.DisplayStatusFlagsSerializer;
import de.esolutions.fw.comm.dsi.kombisync2.impl.MenuContextSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync2.DisplayStatus;
import org.dsi.ifc.kombisync2.DisplayStatusFlags;
import org.dsi.ifc.kombisync2.MenuContext;

public class DisplayStatusSerializer {
    public static void putOptionalDisplayStatus(ISerializer iSerializer, DisplayStatus displayStatus) {
        boolean bl = displayStatus == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = displayStatus.getInternalState();
            iSerializer.putInt32(n);
            int n2 = displayStatus.getMainContext();
            iSerializer.putInt32(n2);
            int n3 = displayStatus.getScreenFormat();
            iSerializer.putInt32(n3);
            int n4 = displayStatus.getFocus();
            iSerializer.putInt32(n4);
            MenuContext menuContext = displayStatus.getMenuContext();
            MenuContextSerializer.putOptionalMenuContext(iSerializer, menuContext);
            int n5 = displayStatus.getStyle();
            iSerializer.putInt32(n5);
            DisplayStatusFlags displayStatusFlags = displayStatus.getStatusFlags();
            DisplayStatusFlagsSerializer.putOptionalDisplayStatusFlags(iSerializer, displayStatusFlags);
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
            DisplayStatusFlags displayStatusFlags;
            int n;
            MenuContext menuContext;
            int n2;
            int n3;
            int n4;
            int n5;
            displayStatus = new DisplayStatus();
            displayStatus.internalState = n5 = iDeserializer.getInt32();
            displayStatus.mainContext = n4 = iDeserializer.getInt32();
            displayStatus.screenFormat = n3 = iDeserializer.getInt32();
            displayStatus.focus = n2 = iDeserializer.getInt32();
            displayStatus.menuContext = menuContext = MenuContextSerializer.getOptionalMenuContext(iDeserializer);
            displayStatus.style = n = iDeserializer.getInt32();
            displayStatus.statusFlags = displayStatusFlags = DisplayStatusFlagsSerializer.getOptionalDisplayStatusFlags(iDeserializer);
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

