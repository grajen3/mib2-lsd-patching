/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.instance.impl;

import de.esolutions.fw.comm.asi.hmisync.instance.ASIHMISyncInstanceReply;
import de.esolutions.fw.comm.asi.hmisync.instance.ASIHMISyncInstanceS;
import de.esolutions.fw.comm.asi.hmisync.instance.impl.ASIHMISyncInstanceReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncInstanceService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.instance.ASIHMISyncInstance");
    private ASIHMISyncInstanceS p_ASIHMISyncInstance;

    public ASIHMISyncInstanceService(int n, ASIHMISyncInstanceS aSIHMISyncInstanceS) {
        super(new ServiceInstanceID("ec3859ab-0660-4557-8339-69dc874fe86b", n, "b0085475-d550-520a-8dc6-1d1e3293432f", "asi.hmisync.instance.ASIHMISyncInstance"));
        this.p_ASIHMISyncInstance = aSIHMISyncInstanceS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new ASIHMISyncInstanceReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 3: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_ASIHMISyncInstance.requestInstanceId(string, string2, (ASIHMISyncInstanceReplyProxy)iProxyFrontend);
                    break;
                }
                case 5: {
                    this.p_ASIHMISyncInstance.setNotification((ASIHMISyncInstanceReplyProxy)iProxyFrontend);
                    break;
                }
                case 7: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncInstance.setNotification(l, (ASIHMISyncInstanceReply)((ASIHMISyncInstanceReplyProxy)iProxyFrontend));
                    break;
                }
                case 6: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncInstance.setNotification(lArray, (ASIHMISyncInstanceReply)((ASIHMISyncInstanceReplyProxy)iProxyFrontend));
                    break;
                }
                case 0: {
                    this.p_ASIHMISyncInstance.clearNotification((ASIHMISyncInstanceReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncInstance.clearNotification(l, (ASIHMISyncInstanceReply)((ASIHMISyncInstanceReplyProxy)iProxyFrontend));
                    break;
                }
                case 1: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncInstance.clearNotification(lArray, (ASIHMISyncInstanceReply)((ASIHMISyncInstanceReplyProxy)iProxyFrontend));
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

