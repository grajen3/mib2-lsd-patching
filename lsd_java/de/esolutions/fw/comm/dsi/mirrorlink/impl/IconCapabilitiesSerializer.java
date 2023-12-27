/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mirrorlink.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.mirrorlink.IconCapabilities;

public class IconCapabilitiesSerializer {
    public static void putOptionalIconCapabilities(ISerializer iSerializer, IconCapabilities iconCapabilities) {
        boolean bl = iconCapabilities == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = iconCapabilities.getIconWidth();
            iSerializer.putInt32(n);
            int n2 = iconCapabilities.getIconHeight();
            iSerializer.putInt32(n2);
            int n3 = iconCapabilities.getColourDepth();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalIconCapabilitiesVarArray(ISerializer iSerializer, IconCapabilities[] iconCapabilitiesArray) {
        boolean bl = iconCapabilitiesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(iconCapabilitiesArray.length);
            for (int i2 = 0; i2 < iconCapabilitiesArray.length; ++i2) {
                IconCapabilitiesSerializer.putOptionalIconCapabilities(iSerializer, iconCapabilitiesArray[i2]);
            }
        }
    }

    public static IconCapabilities getOptionalIconCapabilities(IDeserializer iDeserializer) {
        IconCapabilities iconCapabilities = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            iconCapabilities = new IconCapabilities();
            iconCapabilities.iconWidth = n3 = iDeserializer.getInt32();
            iconCapabilities.iconHeight = n2 = iDeserializer.getInt32();
            iconCapabilities.colourDepth = n = iDeserializer.getInt32();
        }
        return iconCapabilities;
    }

    public static IconCapabilities[] getOptionalIconCapabilitiesVarArray(IDeserializer iDeserializer) {
        IconCapabilities[] iconCapabilitiesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            iconCapabilitiesArray = new IconCapabilities[n];
            for (int i2 = 0; i2 < n; ++i2) {
                iconCapabilitiesArray[i2] = IconCapabilitiesSerializer.getOptionalIconCapabilities(iDeserializer);
            }
        }
        return iconCapabilitiesArray;
    }
}

