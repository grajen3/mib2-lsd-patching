/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv.impl;

import de.esolutions.fw.comm.asi.hmisync.tv.ASIHMISyncTVReply;
import de.esolutions.fw.comm.asi.hmisync.tv.ASIHMISyncTVS;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncTVService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.tv.ASIHMISyncTV");
    private ASIHMISyncTVS p_ASIHMISyncTV;

    public ASIHMISyncTVService(int n, ASIHMISyncTVS aSIHMISyncTVS) {
        super(new ServiceInstanceID("3b9b7c34-a5a9-4acd-a935-dde0b43bf263", n, "625d5dc3-8ed0-5a34-9759-b22cba16e480", "asi.hmisync.tv.ASIHMISyncTV"));
        this.p_ASIHMISyncTV = aSIHMISyncTVS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new ASIHMISyncTVReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 7: {
                    long l = iDeserializer.getInt64();
                    this.p_ASIHMISyncTV.setActiveStation(l, (ASIHMISyncTVReplyProxy)iProxyFrontend);
                    break;
                }
                case 4: {
                    this.p_ASIHMISyncTV.logonToTV((ASIHMISyncTVReplyProxy)iProxyFrontend);
                    break;
                }
                case 3: {
                    this.p_ASIHMISyncTV.logoffFromTV((ASIHMISyncTVReplyProxy)iProxyFrontend);
                    break;
                }
                case 6: {
                    byte by = iDeserializer.getInt8();
                    this.p_ASIHMISyncTV.sendPressedPanelKey(by, (ASIHMISyncTVReplyProxy)iProxyFrontend);
                    break;
                }
                case 5: {
                    byte by = iDeserializer.getInt8();
                    this.p_ASIHMISyncTV.searchChannel(by, (ASIHMISyncTVReplyProxy)iProxyFrontend);
                    break;
                }
                case 11: {
                    byte by = iDeserializer.getInt8();
                    this.p_ASIHMISyncTV.setTerminalMode(by, (ASIHMISyncTVReplyProxy)iProxyFrontend);
                    break;
                }
                case 8: {
                    this.p_ASIHMISyncTV.setNotification((ASIHMISyncTVReplyProxy)iProxyFrontend);
                    break;
                }
                case 10: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncTV.setNotification(l, (ASIHMISyncTVReply)((ASIHMISyncTVReplyProxy)iProxyFrontend));
                    break;
                }
                case 9: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncTV.setNotification(lArray, (ASIHMISyncTVReply)((ASIHMISyncTVReplyProxy)iProxyFrontend));
                    break;
                }
                case 0: {
                    this.p_ASIHMISyncTV.clearNotification((ASIHMISyncTVReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncTV.clearNotification(l, (ASIHMISyncTVReply)((ASIHMISyncTVReplyProxy)iProxyFrontend));
                    break;
                }
                case 1: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncTV.clearNotification(lArray, (ASIHMISyncTVReply)((ASIHMISyncTVReplyProxy)iProxyFrontend));
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

