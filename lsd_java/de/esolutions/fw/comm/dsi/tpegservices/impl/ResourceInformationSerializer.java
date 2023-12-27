/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tpegservices.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.tpegservices.ResourceInformation;

public class ResourceInformationSerializer {
    public static void putOptionalResourceInformation(ISerializer iSerializer, ResourceInformation resourceInformation) {
        boolean bl = resourceInformation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            ResourceLocator resourceLocator = resourceInformation.getResourceLocator();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
            String string = resourceInformation.getPhoneticString();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalResourceInformationVarArray(ISerializer iSerializer, ResourceInformation[] resourceInformationArray) {
        boolean bl = resourceInformationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(resourceInformationArray.length);
            for (int i2 = 0; i2 < resourceInformationArray.length; ++i2) {
                ResourceInformationSerializer.putOptionalResourceInformation(iSerializer, resourceInformationArray[i2]);
            }
        }
    }

    public static ResourceInformation getOptionalResourceInformation(IDeserializer iDeserializer) {
        ResourceInformation resourceInformation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            ResourceLocator resourceLocator;
            resourceInformation = new ResourceInformation();
            resourceInformation.resourceLocator = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
            resourceInformation.phoneticString = string = iDeserializer.getOptionalString();
        }
        return resourceInformation;
    }

    public static ResourceInformation[] getOptionalResourceInformationVarArray(IDeserializer iDeserializer) {
        ResourceInformation[] resourceInformationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            resourceInformationArray = new ResourceInformation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                resourceInformationArray[i2] = ResourceInformationSerializer.getOptionalResourceInformation(iDeserializer);
            }
        }
        return resourceInformationArray;
    }
}

