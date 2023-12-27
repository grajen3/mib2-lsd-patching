/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl;

import de.esolutions.fw.comm.asi.hmisync.mastercontrol.ASIHMISyncMasterControlReply;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.ASIHMISyncMasterControlS;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl.ASIHMISyncMasterControlReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncMasterControlService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.mastercontrol.ASIHMISyncMasterControl");
    private ASIHMISyncMasterControlS p_ASIHMISyncMasterControl;

    public ASIHMISyncMasterControlService(int n, ASIHMISyncMasterControlS aSIHMISyncMasterControlS) {
        super(new ServiceInstanceID("bacc7eeb-475f-4a14-ad22-d3b237ca4c1b", n, "5e04952b-b55c-5075-a09b-d930bfab035a", "asi.hmisync.mastercontrol.ASIHMISyncMasterControl"));
        this.p_ASIHMISyncMasterControl = aSIHMISyncMasterControlS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new ASIHMISyncMasterControlReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 5: {
                    this.p_ASIHMISyncMasterControl.setNotification((ASIHMISyncMasterControlReplyProxy)iProxyFrontend);
                    break;
                }
                case 7: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncMasterControl.setNotification(l, (ASIHMISyncMasterControlReply)((ASIHMISyncMasterControlReplyProxy)iProxyFrontend));
                    break;
                }
                case 6: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncMasterControl.setNotification(lArray, (ASIHMISyncMasterControlReply)((ASIHMISyncMasterControlReplyProxy)iProxyFrontend));
                    break;
                }
                case 0: {
                    this.p_ASIHMISyncMasterControl.clearNotification((ASIHMISyncMasterControlReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncMasterControl.clearNotification(l, (ASIHMISyncMasterControlReply)((ASIHMISyncMasterControlReplyProxy)iProxyFrontend));
                    break;
                }
                case 1: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncMasterControl.clearNotification(lArray, (ASIHMISyncMasterControlReply)((ASIHMISyncMasterControlReplyProxy)iProxyFrontend));
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}

