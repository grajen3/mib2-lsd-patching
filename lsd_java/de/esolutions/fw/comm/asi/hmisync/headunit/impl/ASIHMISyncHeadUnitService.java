/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.headunit.impl;

import de.esolutions.fw.comm.asi.hmisync.headunit.ASIHMISyncHeadUnitReply;
import de.esolutions.fw.comm.asi.hmisync.headunit.ASIHMISyncHeadUnitS;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncHeadUnitService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.headunit.ASIHMISyncHeadUnit");
    private ASIHMISyncHeadUnitS p_ASIHMISyncHeadUnit;

    public ASIHMISyncHeadUnitService(int n, ASIHMISyncHeadUnitS aSIHMISyncHeadUnitS) {
        super(new ServiceInstanceID("036f2d17-c35a-4f85-8d0c-e89fd5461382", n, "c3516fb7-905b-55cc-97e2-b7c3dc5be53b", "asi.hmisync.headunit.ASIHMISyncHeadUnit"));
        this.p_ASIHMISyncHeadUnit = aSIHMISyncHeadUnitS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new ASIHMISyncHeadUnitReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 4: {
                    this.p_ASIHMISyncHeadUnit.setNotification((ASIHMISyncHeadUnitReplyProxy)iProxyFrontend);
                    break;
                }
                case 6: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncHeadUnit.setNotification(l, (ASIHMISyncHeadUnitReply)((ASIHMISyncHeadUnitReplyProxy)iProxyFrontend));
                    break;
                }
                case 5: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncHeadUnit.setNotification(lArray, (ASIHMISyncHeadUnitReply)((ASIHMISyncHeadUnitReplyProxy)iProxyFrontend));
                    break;
                }
                case 0: {
                    this.p_ASIHMISyncHeadUnit.clearNotification((ASIHMISyncHeadUnitReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncHeadUnit.clearNotification(l, (ASIHMISyncHeadUnitReply)((ASIHMISyncHeadUnitReplyProxy)iProxyFrontend));
                    break;
                }
                case 1: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncHeadUnit.clearNotification(lArray, (ASIHMISyncHeadUnitReply)((ASIHMISyncHeadUnitReplyProxy)iProxyFrontend));
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

