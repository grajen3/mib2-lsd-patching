/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation.impl;

import de.esolutions.fw.comm.asi.hmisync.navigation.ASIHMISyncNavigationReply;
import de.esolutions.fw.comm.asi.hmisync.navigation.ASIHMISyncNavigationS;
import de.esolutions.fw.comm.asi.hmisync.navigation.DestinationInfo;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.DestinationInfoSerializer;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncNavigationService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.navigation.ASIHMISyncNavigation");
    private ASIHMISyncNavigationS p_ASIHMISyncNavigation;

    public ASIHMISyncNavigationService(int n, ASIHMISyncNavigationS aSIHMISyncNavigationS) {
        super(new ServiceInstanceID("43ddd4bf-1185-405b-ad9d-d74c07925b2a", n, "59fbcec2-b8b2-5f69-a9e5-b65f2d9a124c", "asi.hmisync.navigation.ASIHMISyncNavigation"));
        this.p_ASIHMISyncNavigation = aSIHMISyncNavigationS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new ASIHMISyncNavigationReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 8: {
                    DestinationInfo[] destinationInfoArray = DestinationInfoSerializer.getOptionalDestinationInfoVarArray(iDeserializer);
                    this.p_ASIHMISyncNavigation.startGuidanceToDestinations(destinationInfoArray, (ASIHMISyncNavigationReplyProxy)iProxyFrontend);
                    break;
                }
                case 5: {
                    this.p_ASIHMISyncNavigation.setNotification((ASIHMISyncNavigationReplyProxy)iProxyFrontend);
                    break;
                }
                case 7: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncNavigation.setNotification(l, (ASIHMISyncNavigationReply)((ASIHMISyncNavigationReplyProxy)iProxyFrontend));
                    break;
                }
                case 6: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncNavigation.setNotification(lArray, (ASIHMISyncNavigationReply)((ASIHMISyncNavigationReplyProxy)iProxyFrontend));
                    break;
                }
                case 0: {
                    this.p_ASIHMISyncNavigation.clearNotification((ASIHMISyncNavigationReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncNavigation.clearNotification(l, (ASIHMISyncNavigationReply)((ASIHMISyncNavigationReplyProxy)iProxyFrontend));
                    break;
                }
                case 1: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncNavigation.clearNotification(lArray, (ASIHMISyncNavigationReply)((ASIHMISyncNavigationReplyProxy)iProxyFrontend));
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

