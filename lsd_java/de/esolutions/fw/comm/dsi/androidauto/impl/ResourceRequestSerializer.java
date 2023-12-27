/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.androidauto.ResourceRequest;

public class ResourceRequestSerializer {
    public static void putOptionalResourceRequest(ISerializer iSerializer, ResourceRequest resourceRequest) {
        boolean bl = resourceRequest == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = resourceRequest.getResourceID();
            iSerializer.putInt32(n);
            int n2 = resourceRequest.getTransferType();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalResourceRequestVarArray(ISerializer iSerializer, ResourceRequest[] resourceRequestArray) {
        boolean bl = resourceRequestArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(resourceRequestArray.length);
            for (int i2 = 0; i2 < resourceRequestArray.length; ++i2) {
                ResourceRequestSerializer.putOptionalResourceRequest(iSerializer, resourceRequestArray[i2]);
            }
        }
    }

    public static ResourceRequest getOptionalResourceRequest(IDeserializer iDeserializer) {
        ResourceRequest resourceRequest = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            resourceRequest = new ResourceRequest();
            resourceRequest.resourceID = n2 = iDeserializer.getInt32();
            resourceRequest.transferType = n = iDeserializer.getInt32();
        }
        return resourceRequest;
    }

    public static ResourceRequest[] getOptionalResourceRequestVarArray(IDeserializer iDeserializer) {
        ResourceRequest[] resourceRequestArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            resourceRequestArray = new ResourceRequest[n];
            for (int i2 = 0; i2 < n; ++i2) {
                resourceRequestArray[i2] = ResourceRequestSerializer.getOptionalResourceRequest(iDeserializer);
            }
        }
        return resourceRequestArray;
    }
}

