/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.travelguide.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.travelguide.DSITravelGuide;
import de.esolutions.fw.comm.dsi.travelguide.DSITravelGuideC;
import de.esolutions.fw.comm.dsi.travelguide.DSITravelGuideReply;
import de.esolutions.fw.comm.dsi.travelguide.impl.DSITravelGuideProxy$1;
import de.esolutions.fw.comm.dsi.travelguide.impl.DSITravelGuideReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.ResourceLocator;

public class DSITravelGuideProxy
implements DSITravelGuide,
DSITravelGuideC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.travelguide.DSITravelGuide");
    private Proxy proxy;

    public DSITravelGuideProxy(int n, DSITravelGuideReply dSITravelGuideReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("375a0462-7d36-50c5-89ae-91e39a81851f", n, "cc5c2ccc-acd7-501a-a3c3-4347cd1c5255", "dsi.travelguide.DSITravelGuide");
        DSITravelGuideReplyService dSITravelGuideReplyService = new DSITravelGuideReplyService(dSITravelGuideReply);
        this.proxy = new Proxy(serviceInstanceID, dSITravelGuideReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void importTravelGuide(ResourceLocator resourceLocator) {
        DSITravelGuideProxy$1 dSITravelGuideProxy$1 = new DSITravelGuideProxy$1(this, resourceLocator);
        this.proxy.remoteCallMethod((short)6, dSITravelGuideProxy$1);
    }

    @Override
    public void deleteTravelGuide(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void setNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    @Override
    public void setNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)8, null);
    }

    @Override
    public void clearNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)2, genericSerializable);
    }

    @Override
    public void clearNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)1, null);
    }

    @Override
    public void yySet(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }
}

