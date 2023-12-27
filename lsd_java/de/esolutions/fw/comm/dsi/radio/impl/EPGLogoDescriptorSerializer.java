/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.EPGLogoDescriptor;

public class EPGLogoDescriptorSerializer {
    public static void putOptionalEPGLogoDescriptor(ISerializer iSerializer, EPGLogoDescriptor ePGLogoDescriptor) {
        boolean bl = ePGLogoDescriptor == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = ePGLogoDescriptor.getLogoType();
            iSerializer.putOptionalString(string);
            String string2 = ePGLogoDescriptor.getMimeType();
            iSerializer.putOptionalString(string2);
            int n = ePGLogoDescriptor.getWidthX();
            iSerializer.putInt32(n);
            int n2 = ePGLogoDescriptor.getHeightY();
            iSerializer.putInt32(n2);
            ResourceLocator resourceLocator = ePGLogoDescriptor.getPicture();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
        }
    }

    public static void putOptionalEPGLogoDescriptorVarArray(ISerializer iSerializer, EPGLogoDescriptor[] ePGLogoDescriptorArray) {
        boolean bl = ePGLogoDescriptorArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(ePGLogoDescriptorArray.length);
            for (int i2 = 0; i2 < ePGLogoDescriptorArray.length; ++i2) {
                EPGLogoDescriptorSerializer.putOptionalEPGLogoDescriptor(iSerializer, ePGLogoDescriptorArray[i2]);
            }
        }
    }

    public static EPGLogoDescriptor getOptionalEPGLogoDescriptor(IDeserializer iDeserializer) {
        EPGLogoDescriptor ePGLogoDescriptor = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            ResourceLocator resourceLocator;
            int n;
            int n2;
            String string;
            String string2;
            ePGLogoDescriptor = new EPGLogoDescriptor();
            ePGLogoDescriptor.logoType = string2 = iDeserializer.getOptionalString();
            ePGLogoDescriptor.mimeType = string = iDeserializer.getOptionalString();
            ePGLogoDescriptor.widthX = n2 = iDeserializer.getInt32();
            ePGLogoDescriptor.heightY = n = iDeserializer.getInt32();
            ePGLogoDescriptor.picture = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
        }
        return ePGLogoDescriptor;
    }

    public static EPGLogoDescriptor[] getOptionalEPGLogoDescriptorVarArray(IDeserializer iDeserializer) {
        EPGLogoDescriptor[] ePGLogoDescriptorArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            ePGLogoDescriptorArray = new EPGLogoDescriptor[n];
            for (int i2 = 0; i2 < n; ++i2) {
                ePGLogoDescriptorArray[i2] = EPGLogoDescriptorSerializer.getOptionalEPGLogoDescriptor(iDeserializer);
            }
        }
        return ePGLogoDescriptorArray;
    }
}

