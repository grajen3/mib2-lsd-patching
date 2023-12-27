/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.androidauto.Resource;

public class ResourceSerializer {
    public static void putOptionalResource(ISerializer iSerializer, Resource resource) {
        boolean bl = resource == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = resource.getResourceID();
            iSerializer.putInt32(n);
            int n2 = resource.getOwner();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalResourceVarArray(ISerializer iSerializer, Resource[] resourceArray) {
        boolean bl = resourceArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(resourceArray.length);
            for (int i2 = 0; i2 < resourceArray.length; ++i2) {
                ResourceSerializer.putOptionalResource(iSerializer, resourceArray[i2]);
            }
        }
    }

    public static Resource getOptionalResource(IDeserializer iDeserializer) {
        Resource resource = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            resource = new Resource();
            resource.resourceID = n2 = iDeserializer.getInt32();
            resource.owner = n = iDeserializer.getInt32();
        }
        return resource;
    }

    public static Resource[] getOptionalResourceVarArray(IDeserializer iDeserializer) {
        Resource[] resourceArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            resourceArray = new Resource[n];
            for (int i2 = 0; i2 < n; ++i2) {
                resourceArray[i2] = ResourceSerializer.getOptionalResource(iDeserializer);
            }
        }
        return resourceArray;
    }
}

