/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.komonavinfo.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.komonavinfo.DSIKOMONavInfoReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIKOMONavInfoReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.komonavinfo.DSIKOMONavInfo");
    private static int dynamicHandle = 0;
    private DSIKOMONavInfoReply p_DSIKOMONavInfoReply;

    public DSIKOMONavInfoReplyService(DSIKOMONavInfoReply dSIKOMONavInfoReply) {
        super(new ServiceInstanceID("65a2a4f0-a422-567d-8fee-74f7e2b92299", DSIKOMONavInfoReplyService.nextDynamicHandle(), "7cb05421-362d-5bf6-9822-c67715a04a9b", "dsi.komonavinfo.DSIKOMONavInfo"));
        this.p_DSIKOMONavInfoReply = dSIKOMONavInfoReply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 9: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIKOMONavInfoReply.setCurrentStreetResult(n);
                    break;
                }
                case 24: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIKOMONavInfoReply.setTurnToStreetResult(n);
                    break;
                }
                case 7: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIKOMONavInfoReply.setCityNameResult(n);
                    break;
                }
                case 20: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIKOMONavInfoReply.setSemiDynRouteResult(n);
                    break;
                }
                case 22: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIKOMONavInfoReply.setTrafficOffsetResult(n);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIKOMONavInfoReply.setRgSelectResult(n);
                    break;
                }
                case 5: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIKOMONavInfoReply.setCapabilitiesResult(n);
                    break;
                }
                case 28: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    boolean[] blArray = iDeserializer.getOptionalBoolVarArray();
                    int n3 = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    boolean[] blArray2 = iDeserializer.getOptionalBoolVarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_DSIKOMONavInfoReply.setMapScaleResult(n, n2, blArray, n3, n4, blArray2, bl);
                    break;
                }
                case 27: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    boolean[] blArray = iDeserializer.getOptionalBoolVarArray();
                    int n6 = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIKOMONavInfoReply.setMapScale(n, n5, blArray, n6, n7, n8);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSIKOMONavInfoReply.asyncException(n, string, n9);
                    break;
                }
                case 25: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIKOMONavInfoReply.yyIndication(string, string2);
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

