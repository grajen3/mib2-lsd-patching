/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.predictivenavigation.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.predictivenavigation.DSIPredictiveNavigationReply;
import de.esolutions.fw.comm.dsi.predictivenavigation.impl.LikelyDestinationSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.predictivenavigation.LikelyDestination;

public class DSIPredictiveNavigationReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.predictivenavigation.DSIPredictiveNavigation");
    private static int dynamicHandle = 0;
    private DSIPredictiveNavigationReply p_DSIPredictiveNavigationReply;

    public DSIPredictiveNavigationReplyService(DSIPredictiveNavigationReply dSIPredictiveNavigationReply) {
        super(new ServiceInstanceID("858fb3eb-f9f4-5578-a0e6-68c88d2c9881", DSIPredictiveNavigationReplyService.nextDynamicHandle(), "430e0b9d-dec1-5286-bf8c-d0b07c687172", "dsi.predictivenavigation.DSIPredictiveNavigation"));
        this.p_DSIPredictiveNavigationReply = dSIPredictiveNavigationReply;
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
                case 13: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIPredictiveNavigationReply.updateOperationMode(n, n2);
                    break;
                }
                case 11: {
                    LikelyDestination[] likelyDestinationArray = LikelyDestinationSerializer.getOptionalLikelyDestinationVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIPredictiveNavigationReply.updateLikelyDestinations(likelyDestinationArray, n);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIPredictiveNavigationReply.updateMaxPredictions(n, n3);
                    break;
                }
                case 2: {
                    this.p_DSIPredictiveNavigationReply.clearCacheResult();
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIPredictiveNavigationReply.asyncException(n, string, n4);
                    break;
                }
                case 14: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIPredictiveNavigationReply.yyIndication(string, string2);
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

