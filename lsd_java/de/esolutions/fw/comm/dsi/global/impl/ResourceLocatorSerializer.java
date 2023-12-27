/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.global.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

public class ResourceLocatorSerializer {
    public static void putOptionalResourceLocator(ISerializer iSerializer, ResourceLocator resourceLocator) {
        boolean bl = resourceLocator == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = resourceLocator.getId();
            iSerializer.putInt32(n);
            String string = resourceLocator.getUrl();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalResourceLocatorVarArray(ISerializer iSerializer, ResourceLocator[] resourceLocatorArray) {
        boolean bl = resourceLocatorArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(resourceLocatorArray.length);
            for (int i2 = 0; i2 < resourceLocatorArray.length; ++i2) {
                ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocatorArray[i2]);
            }
        }
    }

    public static ResourceLocator getOptionalResourceLocator(IDeserializer iDeserializer) {
        ResourceLocator resourceLocator = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            resourceLocator = new ResourceLocator();
            resourceLocator.id = n = iDeserializer.getInt32();
            resourceLocator.url = string = iDeserializer.getOptionalString();
        }
        return resourceLocator;
    }

    public static ResourceLocator[] getOptionalResourceLocatorVarArray(IDeserializer iDeserializer) {
        ResourceLocator[] resourceLocatorArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            resourceLocatorArray = new ResourceLocator[n];
            for (int i2 = 0; i2 < n; ++i2) {
                resourceLocatorArray[i2] = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
            }
        }
        return resourceLocatorArray;
    }
}

