/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio.impl;

import de.esolutions.fw.comm.asi.hmisync.radio.ASIHMISyncRadioReply;
import de.esolutions.fw.comm.asi.hmisync.radio.ASIHMISyncRadioS;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.ASIHMISyncRadioReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncRadioService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.radio.ASIHMISyncRadio");
    private ASIHMISyncRadioS p_ASIHMISyncRadio;

    public ASIHMISyncRadioService(int n, ASIHMISyncRadioS aSIHMISyncRadioS) {
        super(new ServiceInstanceID("3a42bf26-0f99-40c8-bc3a-452fc046e0ca", n, "33f94559-8b21-58d2-8753-54f393719e53", "asi.hmisync.radio.ASIHMISyncRadio"));
        this.p_ASIHMISyncRadio = aSIHMISyncRadioS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new ASIHMISyncRadioReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 6: {
                    long l = iDeserializer.getInt64();
                    this.p_ASIHMISyncRadio.selectStation(l, (ASIHMISyncRadioReplyProxy)iProxyFrontend);
                    break;
                }
                case 5: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncRadio.selectBand(n, (ASIHMISyncRadioReplyProxy)iProxyFrontend);
                    break;
                }
                case 4: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncRadio.seekStation(n, (ASIHMISyncRadioReplyProxy)iProxyFrontend);
                    break;
                }
                case 3: {
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncRadio.enableStationDetails(bl, (ASIHMISyncRadioReplyProxy)iProxyFrontend);
                    break;
                }
                case 7: {
                    this.p_ASIHMISyncRadio.setNotification((ASIHMISyncRadioReplyProxy)iProxyFrontend);
                    break;
                }
                case 9: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncRadio.setNotification(l, (ASIHMISyncRadioReply)((ASIHMISyncRadioReplyProxy)iProxyFrontend));
                    break;
                }
                case 8: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncRadio.setNotification(lArray, (ASIHMISyncRadioReply)((ASIHMISyncRadioReplyProxy)iProxyFrontend));
                    break;
                }
                case 0: {
                    this.p_ASIHMISyncRadio.clearNotification((ASIHMISyncRadioReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncRadio.clearNotification(l, (ASIHMISyncRadioReply)((ASIHMISyncRadioReplyProxy)iProxyFrontend));
                    break;
                }
                case 1: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncRadio.clearNotification(lArray, (ASIHMISyncRadioReply)((ASIHMISyncRadioReplyProxy)iProxyFrontend));
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

