/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation.impl;

import de.esolutions.fw.comm.asi.hmisync.navigation.ASIHMISyncNavigation;
import de.esolutions.fw.comm.asi.hmisync.navigation.ASIHMISyncNavigationC;
import de.esolutions.fw.comm.asi.hmisync.navigation.ASIHMISyncNavigationReply;
import de.esolutions.fw.comm.asi.hmisync.navigation.DestinationInfo;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationProxy$1;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncNavigationProxy
implements ASIHMISyncNavigation,
ASIHMISyncNavigationC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.navigation.ASIHMISyncNavigation");
    private Proxy proxy;

    public ASIHMISyncNavigationProxy(int n, ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("43ddd4bf-1185-405b-ad9d-d74c07925b2a", n, "59fbcec2-b8b2-5f69-a9e5-b65f2d9a124c", "asi.hmisync.navigation.ASIHMISyncNavigation");
        ASIHMISyncNavigationReplyService aSIHMISyncNavigationReplyService = new ASIHMISyncNavigationReplyService(aSIHMISyncNavigationReply);
        this.proxy = new Proxy(serviceInstanceID, aSIHMISyncNavigationReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void startGuidanceToDestinations(DestinationInfo[] destinationInfoArray) {
        ASIHMISyncNavigationProxy$1 aSIHMISyncNavigationProxy$1 = new ASIHMISyncNavigationProxy$1(this, destinationInfoArray);
        this.proxy.remoteCallMethod((short)8, aSIHMISyncNavigationProxy$1);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)5, null);
    }

    @Override
    public void setNotification(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void setNotification(long[] lArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalUInt32VarArray(lArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)0, null);
    }

    @Override
    public void clearNotification(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)2, genericSerializable);
    }

    @Override
    public void clearNotification(long[] lArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalUInt32VarArray(lArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)1, genericSerializable);
    }
}

