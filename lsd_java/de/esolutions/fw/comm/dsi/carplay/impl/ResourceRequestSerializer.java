/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carplay.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carplay.ResourceRequest;

public class ResourceRequestSerializer {
    public static void putOptionalResourceRequest(ISerializer iSerializer, ResourceRequest resourceRequest) {
        boolean bl = resourceRequest == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = resourceRequest.getResourceID();
            iSerializer.putInt32(n);
            int n2 = resourceRequest.getTransferType();
            iSerializer.putInt32(n2);
            int n3 = resourceRequest.getTransferPriority();
            iSerializer.putInt32(n3);
            int n4 = resourceRequest.getTakeConstraint();
            iSerializer.putInt32(n4);
            int n5 = resourceRequest.getBorrowConstraint();
            iSerializer.putInt32(n5);
            int n6 = resourceRequest.getUnborrowConstraint();
            iSerializer.putInt32(n6);
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
            int n3;
            int n4;
            int n5;
            int n6;
            resourceRequest = new ResourceRequest();
            resourceRequest.resourceID = n6 = iDeserializer.getInt32();
            resourceRequest.transferType = n5 = iDeserializer.getInt32();
            resourceRequest.transferPriority = n4 = iDeserializer.getInt32();
            resourceRequest.takeConstraint = n3 = iDeserializer.getInt32();
            resourceRequest.borrowConstraint = n2 = iDeserializer.getInt32();
            resourceRequest.unborrowConstraint = n = iDeserializer.getInt32();
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

