/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mirrorlink.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.mirrorlink.DisplayCapabilities;

public class DisplayCapabilitiesSerializer {
    public static void putOptionalDisplayCapabilities(ISerializer iSerializer, DisplayCapabilities displayCapabilities) {
        boolean bl = displayCapabilities == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = displayCapabilities.getScreenWidthInPx();
            iSerializer.putInt32(n);
            int n2 = displayCapabilities.getScreenHeightInPx();
            iSerializer.putInt32(n2);
            int n3 = displayCapabilities.getScreenWidthInMm();
            iSerializer.putInt32(n3);
            int n4 = displayCapabilities.getScreenHeightInMm();
            iSerializer.putInt32(n4);
            int n5 = displayCapabilities.getScreenPositionX();
            iSerializer.putInt32(n5);
            int n6 = displayCapabilities.getScreenPositionY();
            iSerializer.putInt32(n6);
            int n7 = displayCapabilities.getDisplayDistanceToUser();
            iSerializer.putInt32(n7);
        }
    }

    public static void putOptionalDisplayCapabilitiesVarArray(ISerializer iSerializer, DisplayCapabilities[] displayCapabilitiesArray) {
        boolean bl = displayCapabilitiesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(displayCapabilitiesArray.length);
            for (int i2 = 0; i2 < displayCapabilitiesArray.length; ++i2) {
                DisplayCapabilitiesSerializer.putOptionalDisplayCapabilities(iSerializer, displayCapabilitiesArray[i2]);
            }
        }
    }

    public static DisplayCapabilities getOptionalDisplayCapabilities(IDeserializer iDeserializer) {
        DisplayCapabilities displayCapabilities = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            displayCapabilities = new DisplayCapabilities();
            displayCapabilities.screenWidthInPx = n7 = iDeserializer.getInt32();
            displayCapabilities.screenHeightInPx = n6 = iDeserializer.getInt32();
            displayCapabilities.screenWidthInMm = n5 = iDeserializer.getInt32();
            displayCapabilities.screenHeightInMm = n4 = iDeserializer.getInt32();
            displayCapabilities.screenPositionX = n3 = iDeserializer.getInt32();
            displayCapabilities.screenPositionY = n2 = iDeserializer.getInt32();
            displayCapabilities.displayDistanceToUser = n = iDeserializer.getInt32();
        }
        return displayCapabilities;
    }

    public static DisplayCapabilities[] getOptionalDisplayCapabilitiesVarArray(IDeserializer iDeserializer) {
        DisplayCapabilities[] displayCapabilitiesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            displayCapabilitiesArray = new DisplayCapabilities[n];
            for (int i2 = 0; i2 < n; ++i2) {
                displayCapabilitiesArray[i2] = DisplayCapabilitiesSerializer.getOptionalDisplayCapabilities(iDeserializer);
            }
        }
        return displayCapabilitiesArray;
    }
}

