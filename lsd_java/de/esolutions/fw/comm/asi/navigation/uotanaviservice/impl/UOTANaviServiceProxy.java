/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.uotanaviservice.impl;

import de.esolutions.fw.comm.asi.navigation.mapregioninfo.ComponentInfo;
import de.esolutions.fw.comm.asi.navigation.uotanaviservice.UOTANaviService;
import de.esolutions.fw.comm.asi.navigation.uotanaviservice.UOTANaviServiceC;
import de.esolutions.fw.comm.asi.navigation.uotanaviservice.UOTANaviServiceReply;
import de.esolutions.fw.comm.asi.navigation.uotanaviservice.impl.UOTANaviServiceProxy$1;
import de.esolutions.fw.comm.asi.navigation.uotanaviservice.impl.UOTANaviServiceReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class UOTANaviServiceProxy
implements UOTANaviService,
UOTANaviServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.navigation.uotanaviservice.UOTANaviService");
    private Proxy proxy;

    public UOTANaviServiceProxy(int n, UOTANaviServiceReply uOTANaviServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("761c5633-4d14-4d62-9410-2cefd2161346", n, "4530e019-1027-5e9c-a559-78a464b914fe", "asi.navigation.uotanaviservice.UOTANaviService");
        UOTANaviServiceReplyService uOTANaviServiceReplyService = new UOTANaviServiceReplyService(uOTANaviServiceReply);
        this.proxy = new Proxy(serviceInstanceID, uOTANaviServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void registerClient(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putEnum(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)1, genericSerializable);
    }

    @Override
    public void respondVersionInfo(short s, ComponentInfo[] componentInfoArray, int n) {
        UOTANaviServiceProxy$1 uOTANaviServiceProxy$1 = new UOTANaviServiceProxy$1(this, s, componentInfoArray, n);
        this.proxy.remoteCallMethod((short)2, uOTANaviServiceProxy$1);
    }
}

